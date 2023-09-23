package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class QueensAltarOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.FROSTANT_CROWN.get()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new FrostAntQueenEntity(TnunlimitedModEntities.FROST_ANT_QUEEN.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), TnunlimitedModItems.DELETED_MOD_ELEMENT.get().defaultBlockState(), 3);
			((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).shrink(1);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.FROSTANT_CROWN.get()) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = new FrostAntQueenEntity(TnunlimitedModEntities.FROST_ANT_QUEEN.get(), _level);
				entityToSpawn.moveTo(x, (y + 1), z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof Mob _mobToSpawn)
					_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
				world.addFreshEntity(entityToSpawn);
			}
			world.setBlock(new BlockPos(x, y, z), TnunlimitedModItems.DELETED_MOD_ELEMENT.get().defaultBlockState(), 3);
			((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).shrink(1);
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.OFF_HAND, true);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.beacon.activate")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}
