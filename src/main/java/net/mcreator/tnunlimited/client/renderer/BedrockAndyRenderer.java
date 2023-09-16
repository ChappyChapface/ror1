
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.BedrockAndyEntity;
import net.mcreator.tnunlimited.client.model.ModelBedrockAndy;

public class BedrockAndyRenderer extends MobRenderer<BedrockAndyEntity, ModelBedrockAndy<BedrockAndyEntity>> {
	public BedrockAndyRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBedrockAndy(context.bakeLayer(ModelBedrockAndy.LAYER_LOCATION)), 0.6f);
	}

	@Override
	public ResourceLocation getTextureLocation(BedrockAndyEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/bedrockandy.png");
	}
}
