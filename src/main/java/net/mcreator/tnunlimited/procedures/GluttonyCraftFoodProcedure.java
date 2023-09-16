package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class GluttonyCraftFoodProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack Food = ItemStack.EMPTY;
		double rand = 0;
		if (entity.getPersistentData().getDouble("foodQuality") == 0) {
			entity.hurt(DamageSource.GENERIC, 18);
			Food = new ItemStack(Items.ROTTEN_FLESH);
		} else if (entity.getPersistentData().getDouble("foodQuality") <= 18) {
			Food = new ItemStack(Items.ROTTEN_FLESH);
		} else if (entity.getPersistentData().getDouble("foodQuality") <= 23) {
			if (rand == 1) {
				Food = new ItemStack(Items.COOKED_BEEF);
			} else if (rand == 2) {
				Food = new ItemStack(Items.COOKED_PORKCHOP);
			}
		} else if (entity.getPersistentData().getDouble("foodQuality") <= 30) {
			Food = new ItemStack(Items.GOLDEN_CARROT);
		} else if (entity.getPersistentData().getDouble("foodQuality") <= 41) {
			Food = new ItemStack(Items.GOLDEN_APPLE);
		} else if (entity.getPersistentData().getDouble("foodQuality") <= 59) {
			Food = new ItemStack(TnunlimitedModItems.GOLDEN_HAMBURGER.get());
		} else if (entity.getPersistentData().getDouble("foodQuality") >= 60) {
			Food = new ItemStack(Items.ENCHANTED_GOLDEN_APPLE);
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = Food;
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
		entity.getPersistentData().putDouble("foodQuality", 0);
		entity.getPersistentData().putDouble("ingCount", 0);
	}
}
