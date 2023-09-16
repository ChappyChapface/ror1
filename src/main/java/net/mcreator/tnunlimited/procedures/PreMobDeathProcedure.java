package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;

import net.mcreator.tnunlimited.init.TnunlimitedModGameRules;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class PreMobDeathProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.ANTIFARM)) {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(GameRules.RULE_DOENTITYDROPS).set(true, _level.getServer());
		}
	}
}
