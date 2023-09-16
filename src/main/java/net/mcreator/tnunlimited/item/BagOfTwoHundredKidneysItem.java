
package net.mcreator.tnunlimited.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import java.util.List;

public class BagOfTwoHundredKidneysItem extends Item {
	public BagOfTwoHundredKidneysItem() {
		super(new Item.Properties().tab(null).stacksTo(64).rarity(Rarity.EPIC).food((new FoodProperties.Builder()).nutrition(12).saturationMod(7.2f).alwaysEat().meat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 64;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\"The kidneys are so fresh they must have"));
		list.add(Component.literal("\u00A77been removed within the past 24 hours\""));
		list.add(Component.literal("\u00A77- Dr. Louis Barrero"));
	}
}
