package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class FrostSpikeDamageSpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FrostSpikeEnityEntity) {
			((FrostSpikeEnityEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FrostSpikeEnityEntity) {
			((FrostSpikeEnityEntity) entity).setAnimation("animation.model.new");
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "/data merge entity @s {Invulnerable:1b,NoAI:1b}");
			}
		}
		entity.getPersistentData().putDouble("hitbox_scale", 0.1);
		TnunlimitedMod.queueServerWork(84, () -> {
			if (!entity.level.isClientSide())
				entity.discard();
		});
	}
}
