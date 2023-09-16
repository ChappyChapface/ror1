package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.Difficulty;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModGameRules;
import net.mcreator.tnunlimited.entity.CoffeePotBug1Entity;

import javax.annotation.Nullable;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class OnEntityTickProcedure {
	@SubscribeEvent
	public static void onEntityTick(LivingEvent.LivingTickEvent event) {
		execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double randResult = 0;
		double randResult2 = 0;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("tnunlimited:sinner_loot"))).isDone())
				&& ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.JAR_OF_INFINITE_JELLYBEANS.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.SLOTHS_PILLOW.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.CONTRACT.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.BLOODY_RAPIER.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.WRATHS_DEATH_CRY.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.DARK_WARHAMMER.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.CROWN_OF_PRIDE.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.BITTER_DESIRE.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.SLOTHS_FORMULA.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.GLUTTONYS_CLEAVER.get())) : false))) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("tnunlimited:sinner_loot"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		} else if (!(entity instanceof ServerPlayer _plr12 && _plr12.level instanceof ServerLevel && _plr12.getAdvancements().getOrStartProgress(_plr12.server.getAdvancements().getAdvancement(new ResourceLocation("tnunlimited:all_sins"))).isDone())
				&& ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.JAR_OF_INFINITE_JELLYBEANS.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.GLUTTONYS_CLEAVER.get())) : false))
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.CONTRACT.get())) : false)
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.BITTER_DESIRE.get())) : false)
				&& ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.WRATHS_DEATH_CRY.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.DARK_WARHAMMER.get())) : false))
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.CROWN_OF_PRIDE.get())) : false)
				&& (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.BLOODY_RAPIER.get())) : false)
				&& ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.SLOTHS_PILLOW.get())) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.SLOTHS_FORMULA.get())) : false))) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("tnunlimited:all_sins"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					Iterator _iterator = _ap.getRemainingCriteria().iterator();
					while (_iterator.hasNext())
						_player.getAdvancements().award(_adv, (String) _iterator.next());
				}
			}
		}
		if (entity instanceof WitherBoss && !entity.getPersistentData().getBoolean("prophetsSpawned") && (world.getDifficulty() == Difficulty.HARD || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE))) {
			if (Math.abs(entity.getYRot()) >= 45 && Math.abs(entity.getYRot()) <= 135) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ASH, x, y, (z + 2), 30, 0, 0, 0, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ASH, x, y, (z - 2), 30, 0, 0, 0, 1);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new WitherSkeleton(EntityType.WITHER_SKELETON, _level);
					entityToSpawn.moveTo(x, y, (z + 2), entity.getYRot(), 0);
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new WitherSkeleton(EntityType.WITHER_SKELETON, _level);
					entityToSpawn.moveTo(x, y, (z - 2), entity.getYRot(), 0);
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ASH, (x + 2), y, z, 30, 0, 0, 0, 1);
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ASH, (x - 2), y, z, 30, 0, 0, 0, 1);
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new WitherSkeleton(EntityType.WITHER_SKELETON, _level);
					entityToSpawn.moveTo((x + 2), y, z, entity.getYRot(), 0);
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = new WitherSkeleton(EntityType.WITHER_SKELETON, _level);
					entityToSpawn.moveTo((x - 2), y, z, entity.getYRot(), 0);
					entityToSpawn.setYBodyRot(entity.getYRot());
					entityToSpawn.setYHeadRot(entity.getYRot());
					entityToSpawn.setDeltaMovement(0, 0, 0);
					if (entityToSpawn instanceof Mob _mobToSpawn)
						_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
					world.addFreshEntity(entityToSpawn);
				}
			}
			entity.getPersistentData().putBoolean("prophetsSpawned", true);
		}
		if (entity.isPassenger() && entity instanceof CoffeePotBug1Entity) {
			entity.getPersistentData().putDouble("bugDamage", (entity.getPersistentData().getDouble("bugDamage") - 1));
			if (entity.getPersistentData().getDouble("bugDamage") <= 0) {
				if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
					if ((entity.getVehicle()) instanceof LivingEntity _entity)
						_entity.hurt(new DamageSource("parasite").bypassArmor(), 2);
					entity.getPersistentData().putDouble("bugDamage", 100);
				}
			}
		}
		if (entity.getPersistentData().getDouble("potatoCooldown") > 0) {
			entity.getPersistentData().putDouble("potatoCooldown", (entity.getPersistentData().getDouble("potatoCooldown") - 1));
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.HOT_POTATO_EFFECT.get()) : false) {
			if (20 >= (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.HOT_POTATO_EFFECT.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.HOT_POTATO_EFFECT.get()).getDuration() : 0)) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("potato").bypassArmor(), 15);
				if (world instanceof Level _level && !_level.isClientSide())
					_level.explode(null, x, y, z, 1, Explosion.BlockInteraction.NONE);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(TnunlimitedModMobEffects.HOT_POTATO_EFFECT.get());
			}
		}
	}
}
