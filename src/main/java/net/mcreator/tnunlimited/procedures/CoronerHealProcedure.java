package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.entity.TheDeceasedEntity;
import net.mcreator.tnunlimited.entity.CoronerEntity;

import java.util.Comparator;

public class CoronerHealProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.getEntitiesOfClass(TheDeceasedEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).isEmpty() && (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 10) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.CORONER_FIRE.get()), x, (y + 1), z, 10, 1, 2, 1, 0);
			if (entity instanceof CoronerEntity) {
				((CoronerEntity) entity).setAnimation("animation.the_coroner.heal");
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.HOSTILE, 1, 0);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.scream")), SoundSource.HOSTILE, 1, 0, false);
				}
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.FROSTBURN.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.FROSTBURN.get()).getAmplifier() : 0) <= 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) Math.min(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1, (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + 20));
			}
			((Entity) world.getEntitiesOfClass(TheDeceasedEntity.class, AABB.ofSize(new Vec3(x, y, z), 32, 32, 32), e -> true).stream().sorted(new Object() {
				Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
					return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
				}
			}.compareDistOf(x, y, z)).findFirst().orElse(null)).hurt(DamageSource.GENERIC, 5000);
		}
	}
}
