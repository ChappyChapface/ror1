
package net.mcreator.tnunlimited.client.renderer;

public class PiranhaRenderer extends MobRenderer<PiranhaEntity, ModelPiranha<PiranhaEntity>> {

	public PiranhaRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPiranha(context.bakeLayer(ModelPiranha.LAYER_LOCATION)), 0.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(PiranhaEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/piranhatex.png");
	}

}
