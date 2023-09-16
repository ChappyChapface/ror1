package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.FrostAntQueenPhase2Entity;
import net.mcreator.tnunlimited.entity.FrostAntQueenEntity;
import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.Comparator;

public class FrostAntQueenPhase1EndProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double num = 0;
		num = 0;
		TnunlimitedMod.queueServerWork(36, () -> {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new FrostAntQueenPhase2Entity(TnunlimitedModEntities.FROST_ANT_QUEEN_PHASE_2.get(), _level);
				entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			TnunlimitedMod.queueServerWork(1, () -> {
				if (((Entity) world.getEntitiesOfClass(FrostAntQueenPhase2Entity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof Mob _entity && (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof LivingEntity _ent)
					_entity.setTarget(_ent);
				if (!((entity.getDisplayName().getString()).equals((world instanceof Level _level ? new FrostAntQueenEntity(TnunlimitedModEntities.FROST_ANT_QUEEN.get(), _level) : null).getDisplayName().getString()))) {
					((Entity) world.getEntitiesOfClass(FrostAntQueenPhase2Entity.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)).setCustomName(Component.literal((entity.getDisplayName().getString())));
				}
			});
		});
		for (int index0 = 0; index0 < 65; index0++) {
			TnunlimitedMod.queueServerWork((int) num, () -> {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.ICE_SHARDS.get()), x, (y + 0.75), z, 10, 1.72, 0.75, 1.72, 0.1);
			});
			num = num + 1;
		}
		TnunlimitedMod.queueServerWork(65, () -> {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.ICE_SHARDS.get()), x, (y + 0.75), z, 50, 1.72, 0.75, 1.72, 1);
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
