
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.PiranhaEntity;
import net.mcreator.tnunlimited.client.model.ModelPiranha;

public class PiranhaRenderer extends MobRenderer<PiranhaEntity, ModelPiranha<PiranhaEntity>> {
	public PiranhaRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPiranha(context.bakeLayer(ModelPiranha.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(PiranhaEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/piranhatex.png");
	}
}
