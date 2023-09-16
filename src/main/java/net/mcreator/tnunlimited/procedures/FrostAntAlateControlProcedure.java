package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.entity.FrostSpikeEnityEntity;

public class FrostAntAlateControlProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > 0) {
			if (!(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) + " entity").equals("null entity"))) {
				if (entity.getPersistentData().getDouble("AttackTime") == 2) {
					if (!((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:frost_ants"))))
							&& (entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).isOnGround()
							&& !((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("forge:inanimate"))))) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new FrostSpikeEnityEntity(TnunlimitedModEntities.FROST_SPIKE_ENITY.get(), _level);
							entityToSpawn.moveTo(((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getX()), ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getY()),
									((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null).getZ()), world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
				}
				entity.getPersistentData().putDouble("AttackTime", ((entity.getPersistentData().getDouble("AttackTime") + 1) % 30));
			}
		}
	}
}
