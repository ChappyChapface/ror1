package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.network.chat.Component;

import net.mcreator.tnunlimited.network.TnunlimitedModVariables;

public class KysEntityHitProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 0) {
			entity.hurt(DamageSource.GENERIC, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type GENERIC"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 1) {
			entity.hurt(DamageSource.IN_FIRE, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type IN_FIRE"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 2) {
			entity.hurt(DamageSource.LIGHTNING_BOLT, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type LIGHTNING_BOLT"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 3) {
			entity.hurt(DamageSource.ON_FIRE, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type ON_FIRE"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 4) {
			entity.hurt(DamageSource.LAVA, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type LAVA"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 5) {
			entity.hurt(DamageSource.HOT_FLOOR, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type HOT_FLOOR"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 6) {
			entity.hurt(DamageSource.IN_WALL, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type IN_WALL"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 7) {
			entity.hurt(DamageSource.CRAMMING, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type CRAMMING"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 8) {
			entity.hurt(DamageSource.DROWN, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type DROWN"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 9) {
			entity.hurt(DamageSource.STARVE, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type STARVE"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 10) {
			entity.hurt(DamageSource.CACTUS, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type CACTUS"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 11) {
			entity.hurt(DamageSource.FALL, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type FALL"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 12) {
			entity.hurt(DamageSource.FLY_INTO_WALL, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type FLY_INTO_WALL"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 13) {
			entity.hurt(DamageSource.OUT_OF_WORLD, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type OUT_OF_WORLD"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 14) {
			entity.hurt(DamageSource.MAGIC, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type MAGIC"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 15) {
			entity.hurt(DamageSource.WITHER, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type WITHER"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 16) {
			entity.hurt(DamageSource.ANVIL, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type ANVIL"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 17) {
			entity.hurt(DamageSource.FALLING_BLOCK, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type FALLING_BLOCK"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 18) {
			entity.hurt(DamageSource.DRAGON_BREATH, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type DRAGON_BREATH"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 19) {
			entity.hurt(DamageSource.DRY_OUT, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type DRYOUT"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 20) {
			entity.hurt(DamageSource.SWEET_BERRY_BUSH, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type SWEET_BERRY_BUSH"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 21) {
			entity.hurt(DamageSource.FREEZE, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type FREEZE"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 22) {
			entity.hurt(DamageSource.FALLING_STALACTITE, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type FALLING_STALACTITE"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 23) {
			entity.hurt(DamageSource.STALAGMITE, 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type STALAGMITE"), false);
		} else if ((sourceentity.getCapability(TnunlimitedModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new TnunlimitedModVariables.PlayerVariables())).damegetype == 24) {
			if (entity instanceof LivingEntity _entity)
				_entity.hurt(new DamageSource("custom").bypassArmor(), 6);
			if (!world.isClientSide() && world.getServer() != null)
				world.getServer().getPlayerList().broadcastSystemMessage(Component.literal("Dealt 6 damage of type custom"), false);
		}
	}
}
