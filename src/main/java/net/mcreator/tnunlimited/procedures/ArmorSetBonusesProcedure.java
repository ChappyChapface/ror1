package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;
import net.mcreator.tnunlimited.init.TnunlimitedModMobEffects;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ArmorSetBonusesProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NIGHT_VISION_HELMET_HELMET.get()) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 999999, 0, true, false));
			entity.getPersistentData().putBoolean("nightVisionHelmet", true);
		} else if (entity.getPersistentData().getBoolean("nightVisionHelmet")) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.NIGHT_VISION);
			entity.getPersistentData().putBoolean("nightVisionHelmet", false);
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DESERT_ROACH_ARMOR_HELMET.get()
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DESERT_ROACH_ARMOR_CHESTPLATE.get()
				&& ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DESERT_ROACH_ARMOR_LEGGINGS.get()
						|| (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.FANCY_PANTS_LEGGINGS.get())
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DESERT_ROACH_ARMOR_BOOTS.get()) {
			if (TnunlimitedModVariables.MapVariables.get(world).SessionLength >= 300 && !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.GILDED_BUG_BUFF.get()) : false)) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.GILDED_BUG_BUFF.get(), 999999, 0, false, false));
			}
		} else {
			if (TnunlimitedModVariables.MapVariables.get(world).SessionLength >= 300 && (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.GILDED_BUG_BUFF.get()) : false)) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"effect clear @p tnunlimited:gilded_bug_buff");
			}
		}
		if (((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc00).getItem() == TnunlimitedModItems.THICK_HORSESHOE.get()
				|| ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc01).getItem() == TnunlimitedModItems.THICK_HORSESHOE.get()
				|| ((entity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).Acc02).getItem() == TnunlimitedModItems.THICK_HORSESHOE.get()) {
			entity.maxUpStep = (float) 1.1;
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) <= 4 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)
				&& !(entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.BEDTIME_ELIXIR.get()) : false)) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.PARANOIA.get(), 2400, 0, false, false));
		}
		if (entity.getPersistentData().getDouble("timeWithoutRest") >= 48000 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
			if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(TnunlimitedModMobEffects.DROWSY.get(), 4, (int) Math.floor((entity.getPersistentData().getDouble("timeWithoutRest") - 48000) / 24000), false, false));
			if (entity.getPersistentData().getDouble("timeWithoutRest") >= 120000 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 4, 0, false, false));
			}
			if (entity.getPersistentData().getDouble("timeWithoutRest") >= 144000 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 4, 0, false, false));
			}
			if (entity.getPersistentData().getDouble("timeWithoutRest") >= 168000 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
				if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 4, 0, false, false));
			}
			if (entity.getPersistentData().getDouble("timeWithoutRest") >= 169000 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("nosleep").bypassArmor(), 2);
			}
		}
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.PARANOIA.get()) : false) && (entity instanceof LivingEntity _livEnt ? _livEnt.isSleeping() : false)) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("fear").bypassArmor(),
						(float) ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.PARANOIA.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.PARANOIA.get()).getAmplifier() : 0) + 1));
		}
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(TnunlimitedModMobEffects.PARASITE.get()) : false) {
			entity.getPersistentData().putDouble("bugDamage", (entity.getPersistentData().getDouble("bugDamage") - 1));
			if (entity.getPersistentData().getDouble("bugDamage") <= 0) {
				if (entity instanceof LivingEntity _entity)
					_entity.hurt(new DamageSource("parasite").bypassArmor(),
							(float) (2 * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.PARASITE.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.PARASITE.get()).getAmplifier() : 0) + 1)));
				entity.getPersistentData().putDouble("bugDamage",
						Math.round(100 / ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TnunlimitedModMobEffects.PARASITE.get()) ? _livEnt.getEffect(TnunlimitedModMobEffects.PARASITE.get()).getAmplifier() : 0) + 1)));
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("There's something on you"), true);
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
			entity.getPersistentData().putDouble("timeWithoutRest", (entity.getPersistentData().getDouble("timeWithoutRest") + 1));
		}
	}
}
