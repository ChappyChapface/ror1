
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.CakemonsterEntity;
import net.mcreator.tnunlimited.client.model.Modelcustom_model;

public class CakemonsterRenderer extends MobRenderer<CakemonsterEntity, Modelcustom_model<CakemonsterEntity>> {
	public CakemonsterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 2.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CakemonsterEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/pixil-frame-0_29.png");
	}
}
