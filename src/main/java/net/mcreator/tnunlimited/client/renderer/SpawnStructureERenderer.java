
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.tnunlimited.entity.SpawnStructureEEntity;
import net.mcreator.tnunlimited.client.model.ModelBirthdayBlockBoy;

public class SpawnStructureERenderer extends MobRenderer<SpawnStructureEEntity, ModelBirthdayBlockBoy<SpawnStructureEEntity>> {
	public SpawnStructureERenderer(EntityRendererProvider.Context context) {
		super(context, new ModelBirthdayBlockBoy(context.bakeLayer(ModelBirthdayBlockBoy.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<SpawnStructureEEntity, ModelBirthdayBlockBoy<SpawnStructureEEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("tnunlimited:textures/entities/birthdayblockboy.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(SpawnStructureEEntity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/birthdayblockboy.png");
	}
}
