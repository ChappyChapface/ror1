
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.TwoLayerHelmetLayer2Entity;
import net.mcreator.tnunlimited.client.model.ModelJermaHelmetLayer2;

public class TwoLayerHelmetLayer2Renderer extends MobRenderer<TwoLayerHelmetLayer2Entity, ModelJermaHelmetLayer2<TwoLayerHelmetLayer2Entity>> {
	public TwoLayerHelmetLayer2Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelJermaHelmetLayer2(context.bakeLayer(ModelJermaHelmetLayer2.LAYER_LOCATION)), 0f);
		this.addLayer(new EyesLayer<TwoLayerHelmetLayer2Entity, ModelJermaHelmetLayer2<TwoLayerHelmetLayer2Entity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/jermahelmete.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(TwoLayerHelmetLayer2Entity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/jermahelmete.png");
	}
}
