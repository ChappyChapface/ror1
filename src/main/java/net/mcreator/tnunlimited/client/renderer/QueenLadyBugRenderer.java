
package net.mcreator.tnunlimited.client.renderer;

public class QueenLadyBugRenderer extends MobRenderer<QueenLadyBugEntity, ModelQueenLadyBugModel<QueenLadyBugEntity>> {

	public QueenLadyBugRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelQueenLadyBugModel(context.bakeLayer(ModelQueenLadyBugModel.LAYER_LOCATION)), 0.8f);

	}

	@Override
	public ResourceLocation getTextureLocation(QueenLadyBugEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/ladybugqueentex.png");
	}

}
