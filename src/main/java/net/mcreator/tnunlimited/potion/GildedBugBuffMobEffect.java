
package net.mcreator.tnunlimited.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.tnunlimited.procedures.GildedBugSummoningProcedure;

public class GildedBugBuffMobEffect extends MobEffect {
	public GildedBugBuffMobEffect() {
		super(MobEffectCategory.BENEFICIAL, 16777215);
	}

	@Override
	public String getDescriptionId() {
		return "effect.tnunlimited.gilded_bug_buff";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		GildedBugSummoningProcedure.execute(entity.level, entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
