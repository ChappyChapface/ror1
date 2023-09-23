
package net.mcreator.tnunlimited.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;

public class PurpleShroomslateWallsBlock extends WallBlock {
	public PurpleShroomslateWallsBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHERRACK).strength(1f, 10f).dynamicShape());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TnunlimitedModBlocks.PURPLE_SHROOMSLATE_WALLS.get()));
	}
}