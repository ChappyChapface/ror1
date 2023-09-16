package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.Registry;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;
import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FrostAntQueen2ParryProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		execute(null, world, x, y, z, entity, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity, double amount) {
		if (entity == null || sourceentity == null)
			return;
		double Minions = 0;
		double nearbyminions = 0;
		double d = 0;
		double n = 0;
		if (entity instanceof FrostAntQueenPhase2Entity) {
			if ((entity.getPersistentData().getString("AttackType")).equals("Meditate")) {
				if (!sourceentity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:frost_ants")))) {
					if (entity instanceof Mob _entity && sourceentity instanceof LivingEntity _ent)
						_entity.setTarget(_ent);
					n = 1;
					d = n * Math.sin((90 - entity.getXRot()) * (3.14159265 / 180));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.PARRY.get()), (entity.getX() + d * Math.sin((90 - (entity.getYRot() + 90)) * (3.14159265 / 180))),
								(entity.getY() + 1.5 + n * Math.sin((entity.getXRot() + 180) * (3.14159265 / 180))), (entity.getZ() + d * Math.sin((entity.getYRot() + 90) * (3.14159265 / 180))), 1, 0, 0, 0, 0);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.pling")), SoundSource.HOSTILE, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.pling")), SoundSource.HOSTILE, 1, 1, false);
						}
					}
					n = 1;
					d = n * Math.sin((90 - sourceentity.getXRot()) * (3.14159265 / 180));
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.SLASH.get()), (sourceentity.getX() + d * Math.sin((90 - (sourceentity.getYRot() + 90)) * (3.14159265 / 180))),
								(sourceentity.getY() + 1.5 + n * Math.sin((sourceentity.getXRot() + 180) * (3.14159265 / 180))), (sourceentity.getZ() + d * Math.sin((sourceentity.getYRot() + 90) * (3.14159265 / 180))), 1, 0, 0, 0, 0);
					sourceentity.hurt(DamageSource.GENERIC, 8);
				}
				if (event != null && event.isCancelable()) {
					event.setCanceled(true);
				}
			}
		} else if (entity instanceof Player || entity instanceof ServerPlayer) {
			if (entity.getPersistentData().getDouble("parry") > 0) {
				n = 1;
				d = n * Math.sin((90 - entity.getXRot()) * (3.14159265 / 180));
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.PARRY.get()), (entity.getX() + d * Math.sin((90 - (entity.getYRot() + 90)) * (3.14159265 / 180))),
							(entity.getY() + 1.5 + n * Math.sin((entity.getXRot() + 180) * (3.14159265 / 180))), (entity.getZ() + d * Math.sin((entity.getYRot() + 90) * (3.14159265 / 180))), 1, 0, 0, 0, 0);
				if (amount <= 8) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.pling")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(TnunlimitedModItems.VAMBRACE.get(), 2);
					entity.getPersistentData().putDouble("parry", 0);
					if (event != null && event.isCancelable()) {
						event.setCanceled(true);
					}
					if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.RECOIL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
							|| EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.RECOIL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)) != 0) {
						if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 1));
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.iron_golem.damage")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
					entity.getPersistentData().putDouble("parry", 0);
				}
			}
		}
	}
}
