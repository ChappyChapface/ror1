
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.LapisTreadlingEntity;
import net.mcreator.tnunlimited.client.model.ModelLapisTreadling;

public class LapisTreadlingRenderer extends MobRenderer<LapisTreadlingEntity, ModelLapisTreadling<LapisTreadlingEntity>> {
	public LapisTreadlingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLapisTreadling(context.bakeLayer(ModelLapisTreadling.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(LapisTreadlingEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/lapistreadling.png");
	}
}
