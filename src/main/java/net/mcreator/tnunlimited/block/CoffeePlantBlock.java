
package net.mcreator.tnunlimited.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CoffeePlantBlock extends FlowerBlock {
	public CoffeePlantBlock() {
		super(MobEffects.DIG_SPEED, 800, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().noCollission());
	}

	@Override
	public int getEffectDuration() {
		return 800;
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
	public InteractionResult use(BlockState blockstate, Level world, BlockPos pos, Player entity, InteractionHand hand, BlockHitResult hit) {
		super.use(blockstate, world, pos, entity, hand, hit);
		CoffeePlantPlantRightClickedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return InteractionResult.SUCCESS;
	}

	@OnlyIn(Dist.CLIENT)
	public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
		event.getBlockColors().register((bs, world, pos, index) -> {
			return world != null && pos != null ? BiomeColors.getAverageFoliageColor(world, pos) : FoliageColor.getDefaultColor();
		}, TnunlimitedModBlocks.COFFEE_PLANT.get());
	}

	@OnlyIn(Dist.CLIENT)
	public static void itemColorLoad(RegisterColorHandlersEvent.Item event) {
		event.getItemColors().register((stack, index) -> {
			return FoliageColor.getDefaultColor();
		}, TnunlimitedModBlocks.COFFEE_PLANT.get());
	}
}