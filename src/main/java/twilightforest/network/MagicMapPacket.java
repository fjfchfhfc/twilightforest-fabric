package twilightforest.network;

import me.pepperbell.simplenetworking.S2CPacket;
import me.pepperbell.simplenetworking.SimpleChannel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.MapRenderer;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import twilightforest.TFMagicMapData;
import twilightforest.item.MagicMapItem;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;

// Rewraps vanilla SPacketMaps to properly expose our custom decorations
public class MagicMapPacket implements S2CPacket {
	private final byte[] featureData;
	private final ClientboundMapItemDataPacket inner;

	public MagicMapPacket(TFMagicMapData mapData, ClientboundMapItemDataPacket inner) {
		this.featureData = mapData.serializeFeatures();
		this.inner = inner;
	}

	public MagicMapPacket(FriendlyByteBuf buf) {
		featureData = buf.readByteArray();
		inner = new ClientboundMapItemDataPacket(buf);
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeByteArray(featureData);
		inner.write(buf);
	}

	@Override
	public void handle(Minecraft client, ClientPacketListener handler, SimpleChannel.ResponseTarget responseTarget) {
		Handler.onMessage(this, client);
	}

	public static class Handler {
		public static boolean onMessage(MagicMapPacket message, Executor ctx) {
			ctx.execute(new Runnable() {
				@Override
				public void run() {
					// [VanillaCopy] ClientPlayNetHandler#handleMaps with our own mapdatas
					MapRenderer mapitemrenderer = Minecraft.getInstance().gameRenderer.getMapRenderer();
					String s = MagicMapItem.getMapName(message.inner.getMapId());
					TFMagicMapData mapdata = TFMagicMapData.getMagicMapData(Minecraft.getInstance().level, s);
					if (mapdata == null) {
						mapdata = new TFMagicMapData(0, 0, message.inner.getScale(), false, false, message.inner.isLocked(), Minecraft.getInstance().level.dimension());
						//if (mapitemrenderer.getMapInstanceIfExists(s) != null) {
						//	MapItemSavedData mapdata1 = mapitemrenderer.getData(mapitemrenderer.getMapInstanceIfExists(s));
						//	if (mapdata1 instanceof TFMagicMapData) {
						//		mapdata = (TFMagicMapData) mapdata1;
						//	}
						//}

						TFMagicMapData.registerMagicMapData(Minecraft.getInstance().level, mapdata, s);
					}

					message.inner.applyToMap(mapdata);

					// TF - handle custom decorations
					{
						mapdata.deserializeFeatures(message.featureData);

						// Cheat and put tfDecorations into main collection so they are called by renderer
						// However, ensure they come before vanilla's markers, so player markers go above feature markers.
						Map<String, MapDecoration> saveVanilla = new LinkedHashMap<>(mapdata.decorations);
						mapdata.decorations.clear();

						for (TFMagicMapData.TFMapDecoration tfDecor : mapdata.tfDecorations) {
							mapdata.decorations.put(tfDecor.toString(), tfDecor);
						}

						mapdata.decorations.putAll(saveVanilla);
					}

					mapitemrenderer.update(message.inner.getMapId(), mapdata);
				}
			});

			return true;
		}
	}

}
