
package net.mcreator.tnunlimited.client.renderer;

public class DuneSpiderRenderer extends MobRenderer<DuneSpiderEntity, ModelDuneSpider<DuneSpiderEntity>> {

	public DuneSpiderRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelDuneSpider(context.bakeLayer(ModelDuneSpider.LAYER_LOCATION)), 0.6f);

		this.addLayer(new EyesLayer<DuneSpiderEntity, ModelDuneSpider<DuneSpiderEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/dunespider_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(DuneSpiderEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/dunespider.png");
	}

}
