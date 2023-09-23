
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.WastelandishHopperEntity;
import net.mcreator.tnunlimited.client.model.ModelWastelandish_Hopper;

public class WastelandishHopperRenderer extends MobRenderer<WastelandishHopperEntity, ModelWastelandish_Hopper<WastelandishHopperEntity>> {
	public WastelandishHopperRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelWastelandish_Hopper(context.bakeLayer(ModelWastelandish_Hopper.LAYER_LOCATION)), 0.2f);
	}

	@Override
	public ResourceLocation getTextureLocation(WastelandishHopperEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/wastelandish_hopper.png");
	}
}
