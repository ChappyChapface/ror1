
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.LadyBugEntityEntity;
import net.mcreator.tnunlimited.client.model.ModelLadybugmodele;

public class LadyBugEntityRenderer extends MobRenderer<LadyBugEntityEntity, ModelLadybugmodele<LadyBugEntityEntity>> {
	public LadyBugEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLadybugmodele(context.bakeLayer(ModelLadybugmodele.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(LadyBugEntityEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/ladybuytec.png");
	}
}
