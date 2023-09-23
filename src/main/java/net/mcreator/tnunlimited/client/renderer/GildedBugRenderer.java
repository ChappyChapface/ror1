
package net.mcreator.tnunlimited.client.renderer;

public class GildedBugRenderer extends MobRenderer<GildedBugEntity, ModelGildedBug<GildedBugEntity>> {

	public GildedBugRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGildedBug(context.bakeLayer(ModelGildedBug.LAYER_LOCATION)), 0.1f);

	}

	@Override
	public ResourceLocation getTextureLocation(GildedBugEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/gildedbug.png");
	}

}
