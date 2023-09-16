
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.RedstoneTreadlingEntity;
import net.mcreator.tnunlimited.client.model.ModelRedstoneTreadling;

public class RedstoneTreadlingRenderer extends MobRenderer<RedstoneTreadlingEntity, ModelRedstoneTreadling<RedstoneTreadlingEntity>> {
	public RedstoneTreadlingRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelRedstoneTreadling(context.bakeLayer(ModelRedstoneTreadling.LAYER_LOCATION)), 0.75f);
		this.addLayer(new EyesLayer<RedstoneTreadlingEntity, ModelRedstoneTreadling<RedstoneTreadlingEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/redstonetreadling_glow.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(RedstoneTreadlingEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/redstonetreadling.png");
	}
}
