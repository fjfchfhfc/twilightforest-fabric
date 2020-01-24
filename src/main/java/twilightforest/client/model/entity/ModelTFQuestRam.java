// Date: 5/18/2012 11:45:03 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package twilightforest.client.model.entity;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.DyeColor;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.passive.EntityTFQuestRam;

public class ModelTFQuestRam<T extends EntityTFQuestRam> extends EntityModel<T> {
	//fields
	ModelRenderer frontbody;
	ModelRenderer rearbody;
	ModelRenderer leg1;
	ModelRenderer haunch1;
	ModelRenderer leg2;
	ModelRenderer haunch2;
	ModelRenderer leg3;
	ModelRenderer haunch3;
	ModelRenderer leg4;
	ModelRenderer haunch4;
	ModelRenderer neck;
	ModelRenderer nose;
	public ModelRenderer head;

	ModelRenderer[] segments;
	boolean[] segmentEnabled;

	int[] colorOrder = new int[]{0, 8, 7, 15, 14, 1, 4, 5, 13, 3, 9, 11, 10, 2, 6, 12};

	public ModelTFQuestRam() {
		textureWidth = 128;
		textureHeight = 128;
		setTextureOffset("head.head", 0, 70);
		setTextureOffset("head.horn1a", 0, 94);
		setTextureOffset("head.horn1b", 20, 96);
		setTextureOffset("head.horn1c", 34, 95);
		setTextureOffset("head.horn1d", 46, 98);
		setTextureOffset("head.horn1e", 58, 95);
		setTextureOffset("head.horn1f", 76, 95);
		setTextureOffset("head.horn1g", 88, 97);
		setTextureOffset("head.horn1a", 0, 94);
		setTextureOffset("head.horn1b", 20, 96);
		setTextureOffset("head.horn1c", 34, 95);
		setTextureOffset("head.horn1d", 46, 98);
		setTextureOffset("head.horn1e", 58, 95);
		setTextureOffset("head.horn1f", 76, 95);
		setTextureOffset("head.horn1g", 88, 97);

		frontbody = new ModelRenderer(this, 0, 0);
		frontbody.addCuboid(-9F, -7.5F, -15F, 18, 15, 15);
		frontbody.setRotationPoint(0F, -1F, 2F);

		rearbody = new ModelRenderer(this, 0, 30);
		rearbody.addCuboid(-9F, -7.5F, 0F, 18, 15, 15);
		rearbody.setRotationPoint(0F, -1F, 4F);


		leg1 = new ModelRenderer(this, 66, 0);
		leg1.addCuboid(-3F, 10F, -3F, 6, 12, 6);
		leg1.setRotationPoint(-6F, 2F, 13F);

		haunch1 = new ModelRenderer(this, 90, 0);
		haunch1.addCuboid(-3.5F, 0F, -6F, 7, 10, 10);
		haunch1.setRotationPoint(-6F, 2F, 13F);

		leg2 = new ModelRenderer(this, 66, 0);
		leg2.addCuboid(-3F, 10F, -3F, 6, 12, 6);
		leg2.setRotationPoint(6F, 2F, 13F);

		haunch2 = new ModelRenderer(this, 90, 0);
		haunch2.addCuboid(-3.5F, 0F, -6F, 7, 10, 10);
		haunch2.setRotationPoint(6F, 2F, 13F);

		leg3 = new ModelRenderer(this, 66, 18);
		leg3.addCuboid(-3F, 10F, -3F, 6, 13, 6);
		leg3.setRotationPoint(-6F, 1F, -8F);

		haunch3 = new ModelRenderer(this, 90, 20);
		haunch3.addCuboid(-3.5F, 0F, -4F, 7, 10, 7);
		haunch3.setRotationPoint(-6F, 1F, -8F);

		leg4 = new ModelRenderer(this, 66, 18);
		leg4.addCuboid(-3F, 10F, -3F, 6, 13, 6);
		leg4.setRotationPoint(6F, 1F, -8F);

		haunch4 = new ModelRenderer(this, 90, 20);
		haunch4.addCuboid(-3.5F, 0F, -4F, 7, 10, 7);
		haunch4.setRotationPoint(6F, 1F, -8F);

		neck = new ModelRenderer(this, 66, 37);
		neck.addCuboid(-5.5F, -8F, -8F, 11, 14, 12);
		neck.setRotationPoint(0F, -8F, -7F);

		setRotation(neck, 0.2617994F, 0F, 0F);

		head = new ModelRenderer(this, "head");
		head.setRotationPoint(0F, -13F, -5F);

		head.addCuboid("head", -6F, -4.5F, -15F, 12, 9, 15);
		head.addCuboid("horn1a", 5F, -9F, -7F, 4, 4, 6);
		head.addCuboid("horn1b", 7F, -8F, -2F, 3, 4, 4);
		head.addCuboid("horn1c", 8F, -6F, 0F, 3, 6, 3);
		head.addCuboid("horn1d", 9.5F, -2F, -2F, 3, 3, 3);
		head.addCuboid("horn1e", 11F, 0F, -7F, 3, 3, 6);
		head.addCuboid("horn1f", 12F, -4F, -9F, 3, 6, 3);
		head.addCuboid("horn1g", 13F, -6F, -7F, 3, 3, 4);
		head.addCuboid("horn1a", -9F, -9F, -7F, 4, 4, 6);
		head.addCuboid("horn1b", -10F, -8F, -2F, 3, 4, 4);
		head.addCuboid("horn1c", -11F, -6F, 0F, 3, 6, 3);
		head.addCuboid("horn1d", -12.5F, -2F, -2F, 3, 3, 3);
		head.addCuboid("horn1e", -14F, 0F, -7F, 3, 3, 6);
		head.addCuboid("horn1f", -15F, -4F, -9F, 3, 6, 3);
		head.addCuboid("horn1g", -16F, -6F, -7F, 3, 3, 4);

		nose = new ModelRenderer(this, 54, 73);
		nose.addCuboid(-5.5F, -5F, -13F, 11, 9, 12);
		nose.setRotationPoint(0F, -7F, -1F);
		nose.setTextureSize(128, 128);
		setRotation(nose, 0.5235988F, 0F, 0F);
		head.addChild(nose);

		segments = new ModelRenderer[16];
		segmentEnabled = new boolean[16];
		for (int i = 0; i < 16; i++) {
			segments[i] = new ModelRenderer(this, 0, 104);
			segments[i].addCuboid(-9F, -7.5F, 0F, 18, 15, 2);
			segments[i].setRotationPoint(0F, -1F, 2F);

			segmentEnabled[i] = false;
		}
	}

	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		frontbody.render(scale);
		rearbody.render(scale);
		leg1.render(scale);
		haunch1.render(scale);
		leg2.render(scale);
		haunch2.render(scale);
		leg3.render(scale);
		haunch3.render(scale);
		leg4.render(scale);
		haunch4.render(scale);
		neck.render(scale);
		//nose.render(scale);
		head.render(scale);

		for (int i = 0; i < 16; i++) {
			if (segmentEnabled[i]) {
				float var4 = 1.0F;
				final float[] dyeRgb = SheepEntity.getDyeRgb(DyeColor.byId(i));

				GlStateManager.color3f(var4 * dyeRgb[0], var4 * dyeRgb[1], var4 * dyeRgb[2]);
				segments[i].render(scale);

			}
		}
		GlStateManager.color3f(1.0F, 1.0F, 1.0F);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	/**
	 * Sets the models various rotation angles.
	 */
	@Override
	public void setRotationAngles(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor) {
		this.head.rotateAngleX = headPitch / (180F / (float) Math.PI);
		this.head.rotateAngleY = netHeadYaw / (180F / (float) Math.PI);

		this.neck.rotateAngleY = this.head.rotateAngleY;

		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
		this.haunch1.rotateAngleX = this.leg1.rotateAngleX;
		this.haunch2.rotateAngleX = this.leg2.rotateAngleX;
		this.haunch3.rotateAngleX = this.leg3.rotateAngleX;
		this.haunch4.rotateAngleX = this.leg4.rotateAngleX;
	}

	/**
	 * Used for easily adding entity-dependent animations. The second and third float params here are the same second
	 * and third as in the setRotationAngles method.
	 */
	@Override
	public void setLivingAnimations(T entity, float limbSwing, float limbSwingAmount, float partialTicks) {

		// how many colors should we display?
		int count = entity.countColorsSet();

		this.rearbody.rotationPointZ = 2 + 2 * count;
		this.leg1.rotationPointZ = 11 + 2 * count;
		this.leg2.rotationPointZ = 11 + 2 * count;
		this.haunch1.rotationPointZ = 11 + 2 * count;
		this.haunch2.rotationPointZ = 11 + 2 * count;

		// set up the colors displayed in color order
		int segmentOffset = 2;
		for (int color : colorOrder) {
			if (entity.isColorPresent(DyeColor.byId(color))) {
				segmentEnabled[color] = true;
				segments[color].rotationPointZ = segmentOffset;

				segmentOffset += 2;
			} else {
				segmentEnabled[color] = false;
			}
		}
	}
}
