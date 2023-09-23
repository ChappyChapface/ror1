
package net.mcreator.tnunlimited.client.renderer;

public class CakemonsterRenderer extends MobRenderer<CakemonsterEntity, Modelcustom_model<CakemonsterEntity>> {

	public CakemonsterRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 2.5f);

	}

	@Override
	public ResourceLocation getTextureLocation(CakemonsterEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/pixil-frame-0_29.png");
	}

}
