
package net.mcreator.tnunlimited.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;

import net.mcreator.tnunlimited.entity.CoffeePotBug1Entity;
import net.mcreator.tnunlimited.client.model.ModelCoffeePotBug1;

public class CoffeePotBug1Renderer extends MobRenderer<CoffeePotBug1Entity, ModelCoffeePotBug1<CoffeePotBug1Entity>> {
	public CoffeePotBug1Renderer(EntityRendererProvider.Context context) {
		super(context, new ModelCoffeePotBug1(context.bakeLayer(ModelCoffeePotBug1.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(CoffeePotBug1Entity entity) {
		return new ResourceLocation("tnunlimited:textures/entities/coffeepotbug1.png");
	}
}
