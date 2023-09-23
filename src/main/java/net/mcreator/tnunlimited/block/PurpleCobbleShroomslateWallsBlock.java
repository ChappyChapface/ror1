
package net.mcreator.tnunlimited.block;

import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.item.ItemStack;

import net.mcreator.tnunlimited.init.TnunlimitedModBlocks;

import java.util.List;
import java.util.Collections;

public class PurpleCobbleShroomslateWallsBlock extends WallBlock {
	public PurpleCobbleShroomslateWallsBlock() {
		super(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHERRACK).strength(1f, 10f).dynamicShape());
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(TnunlimitedModBlocks.PURPLE_COBBLE_SHROOMSLATE_WALLS.get()));
	}
}
