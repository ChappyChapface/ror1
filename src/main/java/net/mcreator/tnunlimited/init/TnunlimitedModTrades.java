
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package net.mcreator.tnunlimited.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TnunlimitedModTrades {
	@SubscribeEvent
	public static void registerWanderingTrades(WandererTradesEvent event) {
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.YELLOW_CANDLE_CAKE), new ItemStack(TnunlimitedModItems.BIRTHDAY_BLOCK_BOY_HELMET.get()), 1, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(TnunlimitedModItems.NUBRIUM.get(), 4), new ItemStack(TnunlimitedModItems.SPIKED_COLLAR.get()), 2, 5, 0.05f));
		event.getGenericTrades().add(new BasicItemListing(new ItemStack(Items.EMERALD, 16),

				new ItemStack(TnunlimitedModItems.THICK_HORSESHOE.get()), 10, 5, 0.05f));
	}

	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.FARMER) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(TnunlimitedModItems.COFFEE_BEANS.get()), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD),

					new ItemStack(TnunlimitedModItems.PEAR.get(), 4), 10, 5, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(Blocks.OAK_LOG), new ItemStack(TnunlimitedModItems.TREE_BARK.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.ARMORER) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.DIAMOND, 3), new ItemStack(TnunlimitedModItems.BAND_OF_BEATDOWN.get()), 1, 50, 0.05f));
		}
		if (event.getType() == VillagerProfession.WEAPONSMITH) {
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.DIAMOND, 3), new ItemStack(TnunlimitedModItems.KNIFE_SABER.get()), 1, 50, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(Items.IRON_SWORD), new ItemStack(TnunlimitedModItems.KATANA.get()), 5, 20, 0.05f));
		}
		if (event.getType() == VillagerProfession.BUTCHER) {
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3),

					new ItemStack(TnunlimitedModItems.HAMBURGER.get()), 10, 5, 0.05f));
		}
		if (event.getType() == VillagerProfession.MASON) {
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 20), new ItemStack(Items.IRON_INGOT, 5), new ItemStack(TnunlimitedModItems.EXTENDER.get()), 1, 20, 0.05f));
		}
		if (event.getType() == TnunlimitedModVillagerProfessions.MUSICIAN.get()) {
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 6),

					new ItemStack(Blocks.NOTE_BLOCK), 10, 5, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.YELLOW_DYE, 13), new ItemStack(Items.MUSIC_DISC_13), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.SALMON, 3), new ItemStack(Items.MUSIC_DISC_CAT), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.COBBLESTONE, 16), new ItemStack(Items.MUSIC_DISC_BLOCKS), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.FEATHER, 16), new ItemStack(Items.MUSIC_DISC_CHIRP), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.ENDER_PEARL), new ItemStack(Items.MUSIC_DISC_FAR), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.BREAD, 6), new ItemStack(Items.MUSIC_DISC_MALL), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 31), new ItemStack(Items.FERMENTED_SPIDER_EYE), new ItemStack(Items.MUSIC_DISC_MELLOHI), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.SHIELD), new ItemStack(Items.MUSIC_DISC_STAL), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.LEATHER_BOOTS), new ItemStack(Items.MUSIC_DISC_STRAD), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.AMETHYST_SHARD, 6), new ItemStack(Items.MUSIC_DISC_WARD), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.POISONOUS_POTATO, 11), new ItemStack(Items.MUSIC_DISC_11), 1, 25, 0.05f));
			event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.CLOCK), new ItemStack(Items.MUSIC_DISC_WAIT), 10, 25, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.NETHERRACK, 16), new ItemStack(Items.MUSIC_DISC_OTHERSIDE), 10, 25, 0.05f));
			event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Items.GOLD_INGOT, 16), new ItemStack(Items.MUSIC_DISC_PIGSTEP), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.SUNFLOWER, 8), new ItemStack(TnunlimitedModItems.SUNRISE.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 16), new ItemStack(TnunlimitedModItems.WITHER_AND_ROT.get()), new ItemStack(TnunlimitedModItems.WITHER_AND_ROT_CHIPTUNE.get()), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Blocks.KELP, 32), new ItemStack(TnunlimitedModItems.PLUNDER_N_BLUNDERBUSS.get()), 10, 25, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Blocks.WITHER_ROSE), new ItemStack(TnunlimitedModItems.WITHER_AND_ROT.get()), 10, 25, 0.05f));
			event.getTrades().get(5).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Items.CHORUS_FRUIT, 16), new ItemStack(TnunlimitedModItems.THE_DRAGON_GUARDING_THE_ABYSS.get()), 10, 25, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(Blocks.DEAD_FIRE_CORAL_BLOCK, 4), new ItemStack(TnunlimitedModItems.OCEAN_WASTE.get()), 10, 25, 0.05f));
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 32), new ItemStack(Blocks.DEAD_FIRE_CORAL), new ItemStack(TnunlimitedModItems.DRYOUT_DISC.get()), 10, 25, 0.05f));
		}
	}
}
