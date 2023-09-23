
package net.mcreator.tnunlimited.client.renderer;

public class RedstoneTreadlingRenderer extends MobRenderer<RedstoneTreadlingEntity, ModelRedstoneTreadling<RedstoneTreadlingEntity>> {

	public RedstoneTreadlingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRedstoneTreadling(context.bakeLayer(ModelRedstoneTreadling.LAYER_LOCATION)), 0.75f);

		this.addLayer(new EyesLayer<RedstoneTreadlingEntity, ModelRedstoneTreadling<RedstoneTreadlingEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/redstonetreadling_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(RedstoneTreadlingEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/redstonetreadling.png");
	}

}
