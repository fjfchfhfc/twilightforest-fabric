package twilightforest.client.model.block.giantblock;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import io.github.fabricators_of_create.porting_lib.mixin.client.accessor.BlockModelAccessor;
import io.github.fabricators_of_create.porting_lib.model.geometry.IGeometryLoader;
import net.fabricmc.fabric.api.client.model.ModelProviderContext;
import net.fabricmc.fabric.api.client.model.ModelProviderException;
import net.fabricmc.fabric.api.client.model.ModelResourceProvider;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import org.jetbrains.annotations.Nullable;
import twilightforest.TwilightForestMod;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class GiantBlockModelLoader implements ModelResourceProvider {

	public static final GiantBlockModelLoader INSTANCE = new GiantBlockModelLoader();

	private final Map<ResourceLocation, Map<Direction, ResourceLocation>> textures = new HashMap<>();

	static BufferedReader getModelJson(ResourceLocation location) {
		ResourceLocation file = new ResourceLocation(location.getNamespace(), "models/" + location.getPath() + ".json");
		Optional<Resource> resource = null;
		resource = Minecraft.getInstance().getResourceManager().getResource(file);
		try {
			return resource.get().openAsReader();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public UnbakedGiantBlockModel read(JsonObject object) throws JsonParseException {
		ResourceLocation parent = ResourceLocation.tryParse(object.get("parent_block").getAsString());

		if (object.has("textures")) {
			JsonObject textures = object.get("textures").getAsJsonObject();
			Map<Direction, ResourceLocation> rawTextures = new HashMap<>();
			for (Direction direction : Direction.values()) {
				if (!textures.has(direction.getName().toLowerCase(Locale.ROOT)))
					throw new JsonParseException("Giant block model is missing a texture for side " + direction.getName().toLowerCase(Locale.ROOT));

				rawTextures.put(direction, new ResourceLocation(textures.get(direction.getName().toLowerCase(Locale.ROOT)).getAsString()));
			}

			this.textures.put(parent, rawTextures);
		}

		String rendertype = "solid";

		if (object.has("render_type")) {
			rendertype = object.get("render_type").getAsString();
		}

		return new UnbakedGiantBlockModel(this.textures, rendertype, parent);
	}

	@Override
	public @Nullable UnbakedModel loadModelResource(ResourceLocation resourceId, ModelProviderContext context) throws ModelProviderException {
		if(!resourceId.getNamespace().equals(TwilightForestMod.ID))
			return null;
		JsonObject object = BlockModelAccessor.port_lib$GSON().fromJson(getModelJson(resourceId), JsonObject.class);
		if(object.has("loader")) {
			if (!object.get("loader").getAsString().equals("twilightforest:giant_block"))
				return null;

			return read(object);
		}
		return null;
	}
}
