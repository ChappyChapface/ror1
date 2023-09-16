package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CooldownNBTTimersProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		entity.getPersistentData().putDouble("heartcoreCooldown", (entity.getPersistentData().getDouble("heartcoreCooldown") - 1));
		entity.getPersistentData().putDouble("holyRelicCooldown", (entity.getPersistentData().getDouble("holyRelicCooldown") - 1));
		entity.getPersistentData().putDouble("potatoCooldown", (entity.getPersistentData().getDouble("potatoCooldown") - 1));
		entity.getPersistentData().putDouble("snagCooldown", (entity.getPersistentData().getDouble("snagCooldown") - 1));
	}
}
