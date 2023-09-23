
package net.mcreator.tnunlimited.client.renderer;

public class LadyBugEntityRenderer extends MobRenderer<LadyBugEntityEntity, ModelLadybugmodele<LadyBugEntityEntity>> {

	public LadyBugEntityRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLadybugmodele(context.bakeLayer(ModelLadybugmodele.LAYER_LOCATION)), 0.2f);

	}

	@Override
	public ResourceLocation getTextureLocation(LadyBugEntityEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/ladybuytec.png");
	}

}
