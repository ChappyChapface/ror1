
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.TheDeceasedEntity;
import net.mcreator.tnunlimited.client.model.Modeldeceased;

public class TheDeceasedRenderer extends MobRenderer<TheDeceasedEntity, Modeldeceased<TheDeceasedEntity>> {
	public TheDeceasedRenderer(EntityRendererProvider.Context context) {
		super(context, new Modeldeceased(context.bakeLayer(Modeldeceased.LAYER_LOCATION)), 0f);
		this.addLayer(new EyesLayer<TheDeceasedEntity, Modeldeceased<TheDeceasedEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/deceased.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(TheDeceasedEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/deceased.png");
	}
}
