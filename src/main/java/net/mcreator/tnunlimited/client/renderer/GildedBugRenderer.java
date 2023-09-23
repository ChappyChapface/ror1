
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.GildedBugEntity;
import net.mcreator.tnunlimited.client.model.ModelGildedBug;

public class GildedBugRenderer extends MobRenderer<GildedBugEntity, ModelGildedBug<GildedBugEntity>> {
	public GildedBugRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelGildedBug(context.bakeLayer(ModelGildedBug.LAYER_LOCATION)), 0.1f);
	}

	@Override
	public ResourceLocation getTextureLocation(GildedBugEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/gildedbug.png");
	}
}
