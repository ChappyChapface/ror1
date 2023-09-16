package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionHand;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;

public class DashTimerGoBrrProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double d = 0;
		double n = 0;
		double pitch = 0;
		double yaw = 0;
		if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get()).getAmplifier() : 0) == 1) {
			{
				Entity _ent = entity;
				_ent.setYRot((float) (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerYaw);
				_ent.setXRot((float) (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerPitch);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			entity.fallDistance = 0;
			entity.setDeltaMovement(new Vec3(
					(0.99 * Math.sin((90 - (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerPitch) * (3.14159265 / 180))
							* Math.sin((90 - ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerYaw + 90)) * (3.14159265 / 180))),
					0.001, (0.99 * Math.sin((90 - (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerPitch) * (3.14159265 / 180))
							* Math.sin(((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerYaw + 90) * (3.14159265 / 180)))));
		} else {
			entity.setDeltaMovement(new Vec3(
					(0.33 * Math.sin((90 - (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerPitch) * (3.14159265 / 180))
							* Math.sin((90 - ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerYaw + 90)) * (3.14159265 / 180))),
					(entity.getDeltaMovement().y()), (0.33 * Math.sin((90 - (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerPitch) * (3.14159265 / 180))
							* Math.sin(((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).playerYaw + 90) * (3.14159265 / 180)))));
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.OVERCHARGED_CLEAVER.get()
				|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.OVERCHARGED_CLEAVER.get()) {
			if (entity.isShiftKeyDown()) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TnunlimitedModMobEffects.OVERCHARGED_CLEAVER_DASH_EFFECT.get());
				if (entity instanceof LivingEntity _entity)
					_entity.swing(InteractionHand.MAIN_HAND, true);
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 15, 4));
				entity.setDeltaMovement(new Vec3(0, 0, 0));
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
							.collect(Collectors.toList());
					for (Entity entityiterator : _entfound) {
						if (!(entity == entityiterator)) {
							entityiterator.hurt(DamageSource.GENERIC, (float) (12 * (1 + (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).OmniStrengthIncrease
									+ (entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).slashStrengthIncrease)));
						}
					}
				}
			}
		}
	}
}
