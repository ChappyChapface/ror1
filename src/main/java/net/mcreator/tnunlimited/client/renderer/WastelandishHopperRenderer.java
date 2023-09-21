
package net.mcreator.tnunlimited.client.renderer;

public class WastelandishHopperRenderer extends MobRenderer<WastelandishHopperEntity, ModelWastelandish_Hopper<WastelandishHopperEntity>> {

	public WastelandishHopperRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWastelandish_Hopper(context.bakeLayer(ModelWastelandish_Hopper.LAYER_LOCATION)), 0.2f);

	}

	@Override
	public ResourceLocation getTextureLocation(WastelandishHopperEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/wastelandish_hopper.png");
	}

}
