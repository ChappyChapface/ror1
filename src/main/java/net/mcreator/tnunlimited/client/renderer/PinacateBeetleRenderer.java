
package net.mcreator.tnunlimited.client.renderer;

public class PinacateBeetleRenderer extends MobRenderer<PinacateBeetleEntity, ModelPinacateBeetle<PinacateBeetleEntity>> {

	public PinacateBeetleRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPinacateBeetle(context.bakeLayer(ModelPinacateBeetle.LAYER_LOCATION)), 0.8f);

		this.addLayer(new EyesLayer<PinacateBeetleEntity, ModelPinacateBeetle<PinacateBeetleEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/pinacatebeetle_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PinacateBeetleEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/pinacatebeetle.png");
	}

}
