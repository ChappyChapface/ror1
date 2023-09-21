
package net.mcreator.tnunlimited.client.renderer;

public class CoalTreadlingRenderer extends MobRenderer<CoalTreadlingEntity, ModelCoalTreadling<CoalTreadlingEntity>> {

	public CoalTreadlingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelCoalTreadling(context.bakeLayer(ModelCoalTreadling.LAYER_LOCATION)), 0.75f);

	}

	@Override
	public ResourceLocation getTextureLocation(CoalTreadlingEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/coaltreadling.png");
	}

}
