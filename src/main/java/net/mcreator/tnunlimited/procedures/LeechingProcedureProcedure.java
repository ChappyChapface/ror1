package net.mcreator.tnunlimited.procedures;

import org.objectweb.asm.tree.analysis.Value;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class LeechingProcedureProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity sourceentity, double amount) {
		execute(null, sourceentity, amount);
	}

	private static void execute(@Nullable Event event, Entity sourceentity, double amount) {
		if (sourceentity == null)
			return;
		double Value = 0;
		if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.LEECHING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
			if (sourceentity instanceof LivingEntity _entity)
				_entity.setHealth((float) Math.min(sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1, Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1)
						+ amount / Math.ceil(20 / EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.LEECHING.get(), (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))))));
		}
	}
}
