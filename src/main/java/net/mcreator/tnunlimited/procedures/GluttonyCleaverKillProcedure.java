package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.Registry;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GluttonyCleaverKillProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity player = null;
		if (sourceentity instanceof Player && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.GLUTTONYS_CLEAVER.get()) {
			if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("tnunlimited:quality_4")))) {
				sourceentity.getPersistentData().putDouble("foodQuality", (sourceentity.getPersistentData().getDouble("foodQuality") + 10));
				sourceentity.getPersistentData().putDouble("ingCount", (sourceentity.getPersistentData().getDouble("ingCount") + 1));
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("tnunlimited:quality_3")))) {
				sourceentity.getPersistentData().putDouble("foodQuality", (sourceentity.getPersistentData().getDouble("foodQuality") + 8));
				sourceentity.getPersistentData().putDouble("ingCount", (sourceentity.getPersistentData().getDouble("ingCount") + 1));
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(("This ingredient is perfect. I need " + (6 - sourceentity.getPersistentData().getDouble("ingCount")) + " more.")), true);
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("tnunlimited:quality_2")))) {
				sourceentity.getPersistentData().putDouble("foodQuality", (sourceentity.getPersistentData().getDouble("foodQuality") + 5));
				sourceentity.getPersistentData().putDouble("ingCount", (sourceentity.getPersistentData().getDouble("ingCount") + 1));
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(("This ingredient is acceptable. I need " + (6 - sourceentity.getPersistentData().getDouble("ingCount")) + " more.")), true);
			} else if (entity.getType().is(TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation("tnunlimited:quality_1")))) {
				sourceentity.getPersistentData().putDouble("foodQuality", (sourceentity.getPersistentData().getDouble("foodQuality") + 3));
				sourceentity.getPersistentData().putDouble("ingCount", (sourceentity.getPersistentData().getDouble("ingCount") + 1));
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(("This ingredient is mediocre at best. I need " + (6 - sourceentity.getPersistentData().getDouble("ingCount")) + " more.")), true);
			} else {
				sourceentity.getPersistentData().putDouble("foodQuality", (sourceentity.getPersistentData().getDouble("foodQuality") + 1));
				sourceentity.getPersistentData().putDouble("ingCount", (sourceentity.getPersistentData().getDouble("ingCount") + 1));
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal(("This ingredient is terrible. I need " + (6 - sourceentity.getPersistentData().getDouble("ingCount")) + " more.")), true);
			}
			if (6 <= sourceentity.getPersistentData().getDouble("ingCount")) {
				if (sourceentity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("I cannot hold any more ingredients."), true);
			}
		}
	}
}
