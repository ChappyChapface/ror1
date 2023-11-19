
package net.mcreator.tnunlimited.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class BlueShroomFungiBlock extends FlowerBlock {
	public BlueShroomFungiBlock() {
		super(MobEffects.MOVEMENT_SPEED, 100, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 100;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TnunlimitedModBlocks.BLUE_SHROOM_FUNGI.get()));
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(TnunlimitedModBlocks.SHROOM_GRASS.get()) || groundState.is(TnunlimitedModBlocks.BLUE_SHROOMSLATE.get()) || groundState.is(Blocks.GRASS_BLOCK) || groundState.is(Blocks.DIRT)
				|| groundState.is(TnunlimitedModBlocks.BLUE_SHROOM_STEM.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}