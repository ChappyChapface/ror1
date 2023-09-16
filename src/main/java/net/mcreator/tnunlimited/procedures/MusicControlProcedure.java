package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.boss.enderdragon.EnderDragon;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.entity.PirateCaptainEntity;
import net.mcreator.tnunlimited.entity.KkoreulEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class MusicControlProcedure {
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
		if (entity instanceof WitherBoss) {
			if (entity.getPersistentData().getDouble("introDuration") == 0) {
				entity.getPersistentData().putDouble("introDuration", (entity.getPersistentData().getDouble("introDuration") + 1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a music");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"playsound tnunlimited:witherthemeintro music @a[distance=0..100] ~ ~ ~ 1 1");
			} else if (entity.getPersistentData().getDouble("introDuration") <= 220) {
				entity.getPersistentData().putDouble("introDuration", (entity.getPersistentData().getDouble("introDuration") + 1));
			} else if (entity.getPersistentData().getDouble("loopDuration") == 0) {
				entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a music");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"playsound tnunlimited:witherthemeloop music @a[distance=0..100] ~ ~ ~ 1 1");
			} else if (entity.getPersistentData().getDouble("loopDuration") <= 2399) {
				entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
			} else {
				entity.getPersistentData().putDouble("loopDuration", 0);
			}
		} else if (entity instanceof EnderDragon) {
			if (entity.getPersistentData().getDouble("introDuration") == 0) {
				entity.getPersistentData().putDouble("introDuration", (entity.getPersistentData().getDouble("introDuration") + 1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a music");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"playsound tnunlimited:tdgta-intro music @a[distance=0..200] ~ ~ ~ 1 1");
			} else if (entity.getPersistentData().getDouble("introDuration") <= 320) {
				entity.getPersistentData().putDouble("introDuration", (entity.getPersistentData().getDouble("introDuration") + 1));
			} else if (entity.getPersistentData().getDouble("loopDuration") == 0) {
				entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a music");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"playsound tnunlimited:tdgta-loop music @a[distance=0..200] ~ ~ ~ 1 1");
			} else if (entity.getPersistentData().getDouble("loopDuration") <= 1439) {
				entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
			} else {
				entity.getPersistentData().putDouble("loopDuration", 0);
			}
		} else if (entity instanceof PirateCaptainEntity) {
			if (entity.getPersistentData().getDouble("loopDuration") == 0) {
				entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"stopsound @a music");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"playsound tnunlimited:plunder_n_blunderbuss-loop music @a[distance=0..50] ~ ~ ~ 1 1");
			} else if (entity.getPersistentData().getDouble("loopDuration") <= 1446) {
				entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
			} else {
				entity.getPersistentData().putDouble("loopDuration", 0);
			}
		} else if (entity instanceof KkoreulEntity) {
			if (("" + (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null)).equals("null")) {
				if (entity.getPersistentData().getDouble("loopDuration") == 0) {
					entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"stopsound @a music");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"playsound tnunlimited:dryout music @a[distance=0..50] ~ ~ ~ 1 1");
				} else if (entity.getPersistentData().getDouble("loopDuration") <= 736) {
					entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
				} else {
					entity.getPersistentData().putDouble("loopDuration", 0);
				}
			} else {
				if (entity.getPersistentData().getDouble("introDuration") == 0) {
					entity.getPersistentData().putDouble("loopDuration", 0);
					entity.getPersistentData().putDouble("introDuration", (entity.getPersistentData().getDouble("introDuration") + 1));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"stopsound @a music");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"playsound tnunlimited:ocean_waste-intro music @a[distance=0..50] ~ ~ ~ 1 1");
				} else if (entity.getPersistentData().getDouble("introDuration") <= 60) {
					entity.getPersistentData().putDouble("introDuration", (entity.getPersistentData().getDouble("introDuration") + 1));
				} else if (entity.getPersistentData().getDouble("loopDuration") == 0) {
					entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"stopsound @a music");
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"playsound tnunlimited:ocean_waste-loop music @a[distance=0..50] ~ ~ ~ 1 1");
				} else if (entity.getPersistentData().getDouble("loopDuration") <= 1800) {
					entity.getPersistentData().putDouble("loopDuration", (entity.getPersistentData().getDouble("loopDuration") + 1));
				} else {
					entity.getPersistentData().putDouble("loopDuration", 0);
				}
			}
		}
	}
}
