package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class CooldownWhenNotHeldInMainProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem())) {
			if (itemstack.getItem() == TnunlimitedModItems.SERENITY.get() && entity.getPersistentData().getDouble("serenCooldown") <= 240) {
				entity.getPersistentData().putDouble("serenCooldown", 240);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), 240);
			}
		} else {
			entity.getPersistentData().putDouble("serenCooldown", (entity.getPersistentData().getDouble("serenCooldown") - 1));
			entity.getPersistentData().putDouble("effulCooldown", (entity.getPersistentData().getDouble("effulCooldown") - 1));
			entity.getPersistentData().putDouble("luminCooldown", (entity.getPersistentData().getDouble("luminCooldown") - 1));
			entity.getPersistentData().putDouble("kightbladeCooldown", (entity.getPersistentData().getDouble("kightbladeCooldown") - 1));
		}
	}
}
