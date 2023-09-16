package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;

public class SmoothieEffectProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("e1") == 1 || itemstack.getOrCreateTag().getDouble("e2") == 1) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WITHER, 240, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 2 || itemstack.getOrCreateTag().getDouble("e2") == 2) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 3 || itemstack.getOrCreateTag().getDouble("e2") == 3) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.MANA_REGENERATION.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 4 || itemstack.getOrCreateTag().getDouble("e2") == 4) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_MANA_EFFECT.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 5 || itemstack.getOrCreateTag().getDouble("e2") == 5) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 6 || itemstack.getOrCreateTag().getDouble("e2") == 6) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HARM, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 7 || itemstack.getOrCreateTag().getDouble("e2") == 7) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 8 || itemstack.getOrCreateTag().getDouble("e2") == 8) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_DEPLETING.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 9 || itemstack.getOrCreateTag().getDouble("e2") == 9) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.FLURRY.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 10 || itemstack.getOrCreateTag().getDouble("e2") == 10) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BLUNT_INCREASE.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 11 || itemstack.getOrCreateTag().getDouble("e2") == 11) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.INSTANT_MANA_EFFECT.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 12 || itemstack.getOrCreateTag().getDouble("e2") == 12) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.DROWSY.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 13 || itemstack.getOrCreateTag().getDouble("e2") == 13) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.FROSTBURN.get(), 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 14 || itemstack.getOrCreateTag().getDouble("e2") == 14) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 240, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 15 || itemstack.getOrCreateTag().getDouble("e2") == 15) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 16 || itemstack.getOrCreateTag().getDouble("e2") == 16) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.STURDY.get(), 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 17 || itemstack.getOrCreateTag().getDouble("e2") == 17) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 18 || itemstack.getOrCreateTag().getDouble("e2") == 18) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HEAL, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 19 || itemstack.getOrCreateTag().getDouble("e2") == 19) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 20 || itemstack.getOrCreateTag().getDouble("e2") == 20) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 21 || itemstack.getOrCreateTag().getDouble("e2") == 21) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 22 || itemstack.getOrCreateTag().getDouble("e2") == 22) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 23 || itemstack.getOrCreateTag().getDouble("e2") == 23) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 24 || itemstack.getOrCreateTag().getDouble("e2") == 24) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 25 || itemstack.getOrCreateTag().getDouble("e2") == 25) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 26 || itemstack.getOrCreateTag().getDouble("e2") == 26) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 1200, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 27 || itemstack.getOrCreateTag().getDouble("e2") == 27) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 28 || itemstack.getOrCreateTag().getDouble("e2") == 28) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 29 || itemstack.getOrCreateTag().getDouble("e2") == 29) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 30 || itemstack.getOrCreateTag().getDouble("e2") == 30) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 31 || itemstack.getOrCreateTag().getDouble("e2") == 31) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 32 || itemstack.getOrCreateTag().getDouble("e2") == 32) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2400, 0));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 33 || itemstack.getOrCreateTag().getDouble("e2") == 33) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
		if (itemstack.getOrCreateTag().getDouble("e1") == 34 || itemstack.getOrCreateTag().getDouble("e2") == 34) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 2400, (int) itemstack.getOrCreateTag().getDouble("e3")));
		}
	}
}
