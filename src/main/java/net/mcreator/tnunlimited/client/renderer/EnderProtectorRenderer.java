
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.EnderProtectorEntity;
import net.mcreator.tnunlimited.client.model.Modelender_protector;

public class EnderProtectorRenderer extends MobRenderer<EnderProtectorEntity, Modelender_protector<EnderProtectorEntity>> {
	public EnderProtectorRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelender_protector(context.bakeLayer(Modelender_protector.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<EnderProtectorEntity, Modelender_protector<EnderProtectorEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/ender_protector_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(EnderProtectorEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/ender_protector.png");
	}
}
