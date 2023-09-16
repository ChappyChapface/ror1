
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.PinacateBeetleEntity;
import net.mcreator.tnunlimited.client.model.ModelPinacateBeetle;

public class PinacateBeetleRenderer extends MobRenderer<PinacateBeetleEntity, ModelPinacateBeetle<PinacateBeetleEntity>> {
	public PinacateBeetleRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelPinacateBeetle(context.bakeLayer(ModelPinacateBeetle.LAYER_LOCATION)), 0.8f);
		this.addLayer(new EyesLayer<PinacateBeetleEntity, ModelPinacateBeetle<PinacateBeetleEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/pinacatebeetle_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(PinacateBeetleEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/pinacatebeetle.png");
	}
}
