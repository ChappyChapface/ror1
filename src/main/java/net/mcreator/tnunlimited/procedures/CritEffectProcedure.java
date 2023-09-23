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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CritEffectProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.CRITICAL_SWORD.get()) {
			if (Mth.nextInt(RandomSource.create(), 1, 5) <= (sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).LuckIncrease + 1) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.ENCHANTED_HIT, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 1, 1, 1, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.PLAYERS, 1, 2);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.PLAYERS, 1, 2, false);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.KNIGHTS_BLADE.get()) {
			if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(MobEffects.GLOWING) : false) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.GLOW, (entity.getX()), (entity.getY()), (entity.getZ()), 20, 1, 1, 1, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.hit")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.amethyst_block.hit")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
		if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.CHARGING.get()) : false)
				&& (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:blunt_weapon")))) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BLOOD_DRIP.get()), (entity.getX()), (entity.getY()), (entity.getZ()), 30, 1, 1, 1, 1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.zombie.break_wooden_door")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (sourceentity instanceof LivingEntity _entity)
				_entity.removeEffect(TnunlimitedModMobEffects.CHARGING.get());
			sourceentity.getPersistentData().putDouble("bluntCharge", 0);
		}
		if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.BUTCHERING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.BLEEDING.get(),
						(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.BUTCHERING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 30),
						(int) Math.floor((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.BUTCHERING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) - 1) / 2)));
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.FROSTBURN.get(),
						(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.BUTCHERING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) * 30), 0, true, false));
		}
		if (((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc00).getItem() == TnunlimitedModItems.BAND_OF_BEATDOWN.get()
				|| ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc01).getItem() == TnunlimitedModItems.BAND_OF_BEATDOWN.get()
				|| ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc02).getItem() == TnunlimitedModItems.BAND_OF_BEATDOWN.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.STUNNED.get(), (int) Math.ceil((entity instanceof LivingEntity _livEnt ? _livEnt.getArmorValue() : 0) / 2), 0, true, false));
		}
	}
}
