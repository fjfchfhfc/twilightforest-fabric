// Date: 4/28/2012 9:36:32 AM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX

package twilightforest.client.model.entity;

import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import twilightforest.entity.passive.EntityTFBunny;


public class ModelTFBunny<T extends EntityTFBunny> extends EntityModel<T> {
	//fields
	ModelRenderer tail;
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer head;

	public ModelTFBunny() {
		textureWidth = 32;
		textureHeight = 32;
		setTextureOffset("head.head", 0, 0);
		setTextureOffset("head.ear2", 16, 0);
		setTextureOffset("head.ear1", 16, 0);

		tail = new ModelRenderer(this, 0, 18);
		tail.addCuboid(-1F, -1F, 0F, 2, 2, 2);
		tail.setRotationPoint(0F, 20F, 3F);
		tail.setTextureSize(32, 32);
		tail.mirror = true;
		setRotation(tail, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 8);
		body.addCuboid(-2F, -1F, -2F, 4, 3, 5);
		body.setRotationPoint(0F, 21F, 0F);
		body.setTextureSize(32, 32);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		leg1 = new ModelRenderer(this, 0, 16);
		leg1.addCuboid(0F, 0F, 0F, 1, 1, 1);
		leg1.setRotationPoint(-2F, 23F, 2F);
		leg1.setTextureSize(32, 32);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 16);
		leg2.addCuboid(0F, 0F, 0F, 1, 1, 1);
		leg2.setRotationPoint(1F, 23F, 2F);
		leg2.setTextureSize(32, 32);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 16);
		leg3.addCuboid(0F, 0F, 0F, 1, 1, 1);
		leg3.setRotationPoint(-2F, 23F, -2F);
		leg3.setTextureSize(32, 32);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 16);
		leg4.addCuboid(0F, 0F, 0F, 1, 1, 1);
		leg4.setRotationPoint(1F, 23F, -2F);
		leg4.setTextureSize(32, 32);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		head = new ModelRenderer(this, "head");
		head.setRotationPoint(0F, 22F, -1F);
		setRotation(head, 0F, 0F, 0F);
		head.mirror = true;
		//head.addCuboid("head", -2F, -4F, -3F, 4, 4, 4);
		//head.addCuboid("ear2", -2.5F, -8F, -0.5F, 2, 4, 1);
		//head.addCuboid("ear1", 0.5F, -8F, -0.5F, 2, 4, 1);
		head.addCuboid(-2F, -4F, -3F, 4, 4, 4);
		head.addCuboid(-2.5F, -8F, -0.5F, 2, 4, 1);
		head.addCuboid(0.5F, -8F, -0.5F, 2, 4, 1);
	}

	@Override
	public void render(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		tail.render(scale);
		body.render(scale);
		leg1.render(scale);
		leg2.render(scale);
		leg3.render(scale);
		leg4.render(scale);
		head.render(scale);
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
		this.leg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.leg2.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg3.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
		this.leg4.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

	}

}
