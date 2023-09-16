package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;
import net.mcreator.tnunlimited.init.TnunlimitedModBlocks;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SickleHarvestProcedureProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double HarvestPower = 0;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:sickle")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.DIAMOND_SICKLE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NETHERITE_SICKLE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.AARDIUM_SICKLE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.NUBRIUM_SICKLE.get()) {
				HarvestPower = 2;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.GOLD_SICKLE.get()
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == TnunlimitedModItems.BOMAIND_SICKLE.get()) {
				HarvestPower = 3;
			} else {
				HarvestPower = 1;
			}
			if (blockstate.getBlock() == Blocks.CARROTS && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip17 ? blockstate.getValue(_getip17) : -1) == 7) {
				for (int index0 = 0; index0 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index0++) {
					if (Mth.nextInt(RandomSource.create(), 1, 10) <= EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
							+ HarvestPower) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.CARROT));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.GRASS || blockstate.getBlock() == Blocks.TALL_GRASS) {
				for (int index1 = 0; index1 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index1++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.WHEAT_SEEDS));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.WHEAT && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip39 ? blockstate.getValue(_getip39) : -1) == 7) {
				for (int index2 = 0; index2 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index2++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.WHEAT));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.MELON) {
				for (int index3 = 0; index3 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index3++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.MELON_SLICE));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.SWEET_BERRY_BUSH && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip59 ? blockstate.getValue(_getip59) : -1) == 3) {
				for (int index4 = 0; index4 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index4++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.SWEET_BERRIES));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.BEETROOTS && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip70 ? blockstate.getValue(_getip70) : -1) == 3) {
				for (int index5 = 0; index5 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index5++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.BEETROOT));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.NETHER_WART && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip81 ? blockstate.getValue(_getip81) : -1) == 3) {
				for (int index6 = 0; index6 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index6++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Blocks.NETHER_WART));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.COCOA && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip92 ? blockstate.getValue(_getip92) : -1) == 2) {
				for (int index7 = 0; index7 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index7++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.COCOA_BEANS));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == Blocks.POTATOES && (blockstate.getBlock().getStateDefinition().getProperty("age") instanceof IntegerProperty _getip103 ? blockstate.getValue(_getip103) : -1) == 7) {
				for (int index8 = 0; index8 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index8++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.POTATO));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			} else if (blockstate.getBlock() == TnunlimitedModBlocks.COFFEE_PLANT.get()) {
				for (int index9 = 0; index9 < (int) Math
						.ceil((EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower) / 2); index9++) {
					if (Mth.nextInt(RandomSource.create(),
							(int) (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.HARVESTING.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) + HarvestPower), 10) == 10) {
						if (world instanceof Level _level && !_level.isClientSide()) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(TnunlimitedModItems.COFFEE_BEANS.get()));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y, z, 10, 1, 1, 1, 1);
					}
				}
			}
		}
	}
}
