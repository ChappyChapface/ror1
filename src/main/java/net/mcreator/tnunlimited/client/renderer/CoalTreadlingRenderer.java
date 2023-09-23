
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.CoalTreadlingEntity;
import net.mcreator.tnunlimited.client.model.ModelCoalTreadling;

public class CoalTreadlingRenderer extends MobRenderer<CoalTreadlingEntity, ModelCoalTreadling<CoalTreadlingEntity>> {
	public CoalTreadlingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCoalTreadling(context.bakeLayer(ModelCoalTreadling.LAYER_LOCATION)), 0.75f);
	}

	@Override
	public ResourceLocation getTextureLocation(CoalTreadlingEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/coaltreadling.png");
	}
}
