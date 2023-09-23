
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.DuneSpiderEntity;
import net.mcreator.tnunlimited.client.model.ModelDuneSpider;

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
