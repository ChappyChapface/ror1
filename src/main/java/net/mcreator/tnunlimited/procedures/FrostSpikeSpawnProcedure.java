package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.PlayerFrostSpikeEntityEntity;
import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;
import net.mcreator.tnunlimited.entity.FrostSpikeDamageEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

public class FrostSpikeSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FrostSpikeEnityEntity) {
			((FrostSpikeEnityEntity) entity).setAnimation("empty");
		}
		if (entity instanceof FrostSpikeEnityEntity) {
			((FrostSpikeEnityEntity) entity).setAnimation("animation.model.new");
		}
		if (entity instanceof PlayerFrostSpikeEntityEntity) {
			((PlayerFrostSpikeEntityEntity) entity).setAnimation("empty");
		}
		if (entity instanceof PlayerFrostSpikeEntityEntity) {
			((PlayerFrostSpikeEntityEntity) entity).setAnimation("animation.model.new");
		}
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
						_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), "/data merge entity @s {Invulnerable:1b,NoAI:1b}");
			}
		}
		entity.getPersistentData().putDouble("hitbox_scale", 0.1);
		TnunlimitedMod.queueServerWork(19, () -> {
			entity.getPersistentData().putDouble("hitbox_scale", 0.2);
			TnunlimitedMod.queueServerWork(1, () -> {
				entity.getPersistentData().putDouble("hitbox_scale", 0.4);
				TnunlimitedMod.queueServerWork(1, () -> {
					entity.getPersistentData().putDouble("hitbox_scale", 0.6);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = new FrostSpikeDamageEntity(TnunlimitedModEntities.FROST_SPIKE_DAMAGE.get(), _level);
						entityToSpawn.moveTo(x, y, z, 0, 0);
						entityToSpawn.setYBodyRot(0);
						entityToSpawn.setYHeadRot(0);
						if (entityToSpawn instanceof Mob _mobToSpawn)
							_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
						world.addFreshEntity(entityToSpawn);
					}
					TnunlimitedMod.queueServerWork(1, () -> {
						entity.getPersistentData().putDouble("hitbox_scale", 0.8);
						TnunlimitedMod.queueServerWork(1, () -> {
							entity.getPersistentData().putDouble("hitbox_scale", 1);
						});
					});
				});
			});
		});
		TnunlimitedMod.queueServerWork(84, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.ICE_SHARDS.get()), x, (y + 1.25), z, 20, 0.5, 1.25, 0.5, 0.1);
			if (!entity.level.isClientSide())
				entity.discard();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.HOSTILE, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.glass.break")), SoundSource.HOSTILE, 1, 1, false);
				}
			}
		});
	}
}
