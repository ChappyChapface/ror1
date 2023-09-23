
package net.mcreator.tnunlimited.client.renderer;

public class LapisTreadlingRenderer extends MobRenderer<LapisTreadlingEntity, ModelLapisTreadling<LapisTreadlingEntity>> {

	public LapisTreadlingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelLapisTreadling(context.bakeLayer(ModelLapisTreadling.LAYER_LOCATION)), 0.75f);

	}

	@Override
	public ResourceLocation getTextureLocation(LapisTreadlingEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/lapistreadling.png");
	}

}
