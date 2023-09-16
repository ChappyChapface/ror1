
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TnunlimitedModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> MOBPOTIONSPAWNS = GameRules.register("mobPotionSpawns", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> INCREASEDMOBARMORRATES = GameRules.register("increasedMobArmorRates", GameRules.Category.MOBS, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> PURGATORYMODE = GameRules.register("purgatoryMode", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> ANTIFARM = GameRules.register("antiFarm", GameRules.Category.DROPS, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> NERF_SHIELD = GameRules.register("nerfShield", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> NERF_MILK = GameRules.register("nerfMilk", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> NERF_PROTECTION = GameRules.register("nerfProtection", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> NERF_BOWS = GameRules.register("nerfBows", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
	public static final GameRules.Key<GameRules.BooleanValue> NERF_CROSSBOW = GameRules.register("nerfCrossbow", GameRules.Category.PLAYER, GameRules.BooleanValue.create(false));
}
