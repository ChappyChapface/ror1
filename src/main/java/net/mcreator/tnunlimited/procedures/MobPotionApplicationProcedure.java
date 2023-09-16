package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Phantom;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.Difficulty;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModGameRules;

import javax.annotation.Nullable;

import java.util.Comparator;

@Mod.EventBusSubscriber
public class MobPotionApplicationProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double thingy = 0;
		double difficultyInt = 0;
		if (!(entity.getPersistentData().getBoolean("staticPotions") == true)) {
			if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.MOBPOTIONSPAWNS)) {
				if (entity instanceof Zombie || entity instanceof Skeleton) {
					if (world.getDifficulty() == Difficulty.HARD && Mth.nextInt(RandomSource.create(), 1, 20) == 1 || world.getDifficulty() == Difficulty.NORMAL && Mth.nextInt(RandomSource.create(), 1, 100) == 1
							|| world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE) && Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
						thingy = Mth.nextInt(RandomSource.create(), 1, 100);
						if (thingy <= 15) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, 0));
						} else if (thingy > 15 && thingy <= 55) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 999999, 0));
						} else if (thingy > 55 && thingy <= 75) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 999999, 0));
						} else if (thingy > 75 && thingy <= 90) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, 0));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 999999, 0));
						}
					}
				} else if (entity instanceof Spider) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 999999, 5, false, false));
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
						thingy = Mth.nextInt(RandomSource.create(), 1, 100);
						if (thingy <= 20) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 999999, Mth.nextInt(RandomSource.create(), 0, 1)));
						} else if (thingy > 20 && thingy <= 50) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 999999, Mth.nextInt(RandomSource.create(), 0, 1)));
						} else if (thingy > 50 && thingy <= 80) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 999999, Mth.nextInt(RandomSource.create(), 0, 1)));
						} else if (thingy > 80 && thingy <= 98) {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 999999, Mth.nextInt(RandomSource.create(), 0, 1)));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 999999, 0));
						}
					}
				}
			}
		}
		if (world.getDifficulty() == Difficulty.EASY) {
			difficultyInt = 100;
		} else if (world.getDifficulty() == Difficulty.NORMAL) {
			difficultyInt = 50;
		} else if (world.getDifficulty() == Difficulty.HARD) {
			difficultyInt = 10;
		}
		if (Mth.nextInt(RandomSource.create(), 1, (int) difficultyInt) == 1 && world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.INCREASEDMOBARMORRATES)
				|| world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
			if (!(entity.getPersistentData().getBoolean("staticLoadout") == true)) {
				if ((entity instanceof Zombie || entity instanceof Skeleton) && !(entity instanceof ZombifiedPiglin)) {
					if (!world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.CHAINMAIL_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.CHAINMAIL_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.CHAINMAIL_LEGGINGS));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.CHAINMAIL_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.CHAINMAIL_BOOTS));
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(Items.IRON_HELMET));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.AARDIUM_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.AARDIUM_HELMET.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(TnunlimitedModItems.AARDIUM_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TnunlimitedModItems.AARDIUM_CHESTPLATE.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(TnunlimitedModItems.AARDIUM_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(TnunlimitedModItems.AARDIUM_LEGGINGS.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(TnunlimitedModItems.AARDIUM_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(TnunlimitedModItems.AARDIUM_BOOTS.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.SHIELD);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					} else {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.AARDIUM_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.AARDIUM_HELMET.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(TnunlimitedModItems.AARDIUM_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TnunlimitedModItems.AARDIUM_CHESTPLATE.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(TnunlimitedModItems.AARDIUM_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(TnunlimitedModItems.AARDIUM_LEGGINGS.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(TnunlimitedModItems.AARDIUM_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(TnunlimitedModItems.AARDIUM_BOOTS.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 50) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.GLASS_SKULL_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.GLASS_SKULL_HELMET.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_HELMET.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_CHESTPLATE.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_LEGGINGS.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(TnunlimitedModItems.SLIME_ARMOUR_BOOTS.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.FLEUR_BAND.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.IRON_BAND.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.SHIELD);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_BAND.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 20) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.PET_CACTUS.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.TOTEM_OF_UNDYING);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
				if (entity instanceof Zombie) {
					if (!world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (!(Math.abs(x) >= 3000 && Math.abs(x) <= 6000 || Math.abs(z) >= 3000 && Math.abs(z) <= 6000)) {
							if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.STONE_SWORD);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.STONE_SHOVEL);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.STONE_PICKAXE);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.STONE_AXE);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.IRON_SICKLE.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.IRON_SWORD);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 7) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.AARDUIMSWORD.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.GRANITE_CLUB.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.DIORITE_SPEAR.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.KATANA.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
						} else {
							if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.IRON_AXE);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.GALVANIZED_SWORD.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 3) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD);
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.RITHIUM_SWORD.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_SICKLE.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_SWORD.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_AXE.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
								if (entity instanceof LivingEntity _entity) {
									ItemStack _setstack = new ItemStack(TnunlimitedModItems.ANTIMONY_TOOLS_SWORD.get());
									_setstack.setCount(1);
									_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
									if (_entity instanceof Player _player)
										_player.getInventory().setChanged();
								}
							}
						}
					} else if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.IRON_SICKLE.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.IRON_AXE);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.IRON_SWORD);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.DIAMOND_AXE);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 7) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.IRON_CLUB.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 7) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.DIORITE_SPEAR.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.CUTLASS.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.KATANA.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 25) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.GLACIER_GLAIVE.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 40) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.CRITICAL_SWORD.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 40) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.BLOODY_RAPIER.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 50) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.KNIFE_SABER.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.SWORD_SABER.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
				if (entity instanceof Skeleton) {
					if (Mth.nextInt(RandomSource.create(), 1, 20) == 1) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.STONE_SWORD);
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if (!world.getEntitiesOfClass(Phantom.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).isEmpty()) {
						entity.startRiding(((Entity) world.getEntitiesOfClass(Phantom.class, AABB.ofSize(new Vec3(x, y, z), 2, 2, 2), e -> true).stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
							}
						}.compareDistOf(x, y, z)).findFirst().orElse(null)));
					}
				}
				if (entity instanceof Piglin) {
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.GOLDEN_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.GOLDEN_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.GOLDEN_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.NETHERITE_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.NETHERITE_HELMET));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.NETHERITE_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.NETHERITE_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.NETHERITE_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
							}
						}
					}
					if (Mth.nextInt(RandomSource.create(), 1, 30) == 1) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.GOLDEN_CROWN_HELMET.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.GOLDEN_CROWN_HELMET.get()));
							}
						}
					}
				}
				if (entity instanceof Phantom) {
					if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
						if (world instanceof ServerLevel _level) {
							Entity entityToSpawn = new Skeleton(EntityType.SKELETON, _level);
							entityToSpawn.moveTo(x, y, z, world.getRandom().nextFloat() * 360F, 0);
							if (entityToSpawn instanceof Mob _mobToSpawn)
								_mobToSpawn.finalizeSpawn(_level, world.getCurrentDifficultyAt(entityToSpawn.blockPosition()), MobSpawnType.MOB_SUMMONED, null, null);
							world.addFreshEntity(entityToSpawn);
						}
					}
				}
				if (entity instanceof WitherSkeleton) {
					if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_HELMET.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_CHESTPLATE.get()));
								}
							}
							if (Mth.nextInt(RandomSource.create(), 1, 2) == 1) {
								{
									Entity _entity = entity;
									if (_entity instanceof Player _player) {
										_player.getInventory().armor.set(1, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_LEGGINGS.get()));
										_player.getInventory().setChanged();
									} else if (_entity instanceof LivingEntity _living) {
										_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_LEGGINGS.get()));
									}
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 5) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_BOOTS.get()));
								}
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.NETHERITE_SWORD);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 10) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_SWORD.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.BOW);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
						if (Mth.nextInt(RandomSource.create(), 1, 100) == 1) {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.PROPHET_HELMET.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.PROPHET_HELMET.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(2, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_CHESTPLATE.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_CHESTPLATE.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(1, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_LEGGINGS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_LEGGINGS.get()));
								}
							}
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(0, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_BOOTS.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_BOOTS.get()));
								}
							}
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_AXE.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_AXE.get());
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					} else {
						if (Mth.nextInt(RandomSource.create(), 1, 15) == 1) {
							if (entity instanceof LivingEntity _entity) {
								ItemStack _setstack = new ItemStack(Items.BOW);
								_setstack.setCount(1);
								_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
								if (_entity instanceof Player _player)
									_player.getInventory().setChanged();
							}
						}
					}
				}
				if (!world.getEntitiesOfClass(WitherBoss.class, AABB.ofSize(new Vec3(x, y, z), 8, 8, 8), e -> true).isEmpty() && entity instanceof WitherSkeleton) {
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 254, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 40, 254, false, false));
					if (entity instanceof LivingEntity _entity && !_entity.level.isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 254, false, false));
					{
						Entity _entity = entity;
						if (_entity instanceof Player _player) {
							_player.getInventory().armor.set(3, new ItemStack(TnunlimitedModItems.PROPHET_HELMET.get()));
							_player.getInventory().setChanged();
						} else if (_entity instanceof LivingEntity _living) {
							_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(TnunlimitedModItems.PROPHET_HELMET.get()));
						}
					}
					if (world.getDifficulty() == Difficulty.HARD && !world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.STONE_AXE);
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.STONE_AXE);
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_AXE.get());
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(TnunlimitedModItems.LEAD_AXE.get());
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_CHESTPLATE.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_CHESTPLATE.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_LEGGINGS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_LEGGINGS.get()));
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_BOOTS.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(TnunlimitedModItems.LEAD_ARMOR_BOOTS.get()));
							}
						}
					}
				}
			}
			if (!(entity.getPersistentData().getBoolean("staticEnchants") == true)) {
				if (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
					difficultyInt = 30;
				} else if (world.getDifficulty() == Difficulty.HARD) {
					difficultyInt = 15;
				} else {
					difficultyInt = 50;
				}
				if (!(entity instanceof Player || entity instanceof ServerPlayer)) {
					if (Mth.nextInt(RandomSource.create(), 1, (int) Math.floor(difficultyInt / 5)) == 1 || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (!(world.getDifficulty() == Difficulty.HARD)) {
							difficultyInt = 0;
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
							}
						}
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)).enchant(Enchantments.VANISHING_CURSE, 1);
					}
					if (Mth.nextInt(RandomSource.create(), 1, (int) Math.floor(difficultyInt / 5)) == 1 || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (!(world.getDifficulty() == Difficulty.HARD)) {
							difficultyInt = 0;
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
							}
						}
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)).enchant(Enchantments.VANISHING_CURSE, 1);
					}
					if (Mth.nextInt(RandomSource.create(), 1, (int) Math.floor(difficultyInt / 5)) == 1 || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (!(world.getDifficulty() == Difficulty.HARD)) {
							difficultyInt = 0;
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
							}
						}
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)).enchant(Enchantments.VANISHING_CURSE, 1);
					}
					if (Mth.nextInt(RandomSource.create(), 1, (int) Math.floor(difficultyInt / 5)) == 1 || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (!(world.getDifficulty() == Difficulty.HARD)) {
							difficultyInt = 0;
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY),
										Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)))));
							}
						}
						((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)).enchant(Enchantments.VANISHING_CURSE, 1);
					}
					if (Mth.nextInt(RandomSource.create(), 1, (int) Math.floor(difficultyInt / 5)) == 1 || world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE)) {
						if (!(world.getDifficulty() == Difficulty.HARD)) {
							difficultyInt = 0;
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY),
									Mth.nextInt(RandomSource.create(), (int) difficultyInt, 30), (world.getLevelData().getGameRules().getBoolean(TnunlimitedModGameRules.PURGATORYMODE))));
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).enchant(Enchantments.VANISHING_CURSE, 1);
						((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY)).enchant(Enchantments.VANISHING_CURSE, 1);
					}
				}
			}
		}
		if (entity instanceof WitherBoss) {
			entity.getPersistentData().putBoolean("prophetsSpawned", false);
		}
	}
}
