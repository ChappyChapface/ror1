
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.TwoLayerHelmetLayer1Entity;
import net.mcreator.tnunlimited.client.model.ModelJermaHelmetLayer1;

public class TwoLayerHelmetLayer1Renderer extends MobRenderer<TwoLayerHelmetLayer1Entity, ModelJermaHelmetLayer1<TwoLayerHelmetLayer1Entity>> {
	public TwoLayerHelmetLayer1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelJermaHelmetLayer1(context.bakeLayer(ModelJermaHelmetLayer1.LAYER_LOCATION)), 0f);
		this.addLayer(new EyesLayer<TwoLayerHelmetLayer1Entity, ModelJermaHelmetLayer1<TwoLayerHelmetLayer1Entity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/jermahelmete.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(TwoLayerHelmetLayer1Entity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/jermahelmete.png");
	}
}
