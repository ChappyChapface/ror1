package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.init.TnunlimitedModParticleTypes;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;

public class GunReloadBaseProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean hit = false;
		double num = 0;
		double d = 0;
		double n = 0;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.FROST_BULLET.get())) : false) {
			itemstack.getOrCreateTag().putString("bullet_type", "frost");
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			hit = true;
			num = 0;
			while (hit && num < itemstack.getOrCreateTag().getDouble("clip_size")) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.FROST_BULLET.get())) : false) {
					num = num + 1;
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity))) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(TnunlimitedModItems.FROST_BULLET.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				} else {
					hit = false;
				}
			}
			if (num >= 0) {
				if (itemstack.getItem() == TnunlimitedModItems.REVOLVER.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (itemstack.getItem() == TnunlimitedModItems.BLUNDERBUSS.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("ammo", num);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) itemstack.getOrCreateTag().getDouble("reload_time"));
				if (itemstack.getOrCreateTag().getBoolean("dump_clip")) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BULLET_SHELL.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) itemstack.getOrCreateTag().getDouble("clip_size"), 0.2, 0.2, 0.2, 0.1);
				}
			}
		} else if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.LEAD_BULLET.get())) : false) {
			itemstack.getOrCreateTag().putString("bullet_type", "lead");
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			hit = true;
			num = 0;
			while (hit && num < itemstack.getOrCreateTag().getDouble("clip_size")) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.LEAD_BULLET.get())) : false) {
					num = num + 1;
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity))) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(TnunlimitedModItems.LEAD_BULLET.get());
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
				} else {
					hit = false;
				}
			}
			if (num >= 0) {
				if (itemstack.getItem() == TnunlimitedModItems.REVOLVER.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (itemstack.getItem() == TnunlimitedModItems.BLUNDERBUSS.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("ammo", num);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) itemstack.getOrCreateTag().getDouble("reload_time"));
				if (itemstack.getOrCreateTag().getBoolean("dump_clip")) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BULLET_SHELL.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) itemstack.getOrCreateTag().getDouble("clip_size"), 0.2, 0.2, 0.2, 0.1);
				}
			}
		} else if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.BULLET.get())) : false)) {
			itemstack.getOrCreateTag().putString("bullet_type", "iron");
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			hit = true;
			num = 0;
			while (hit && num < itemstack.getOrCreateTag().getDouble("clip_size")) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(TnunlimitedModItems.BULLET.get())) : false) {
					num = num + 1;
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(TnunlimitedModItems.BULLET.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				} else {
					hit = false;
				}
			}
			if (num >= 0) {
				if (itemstack.getItem() == TnunlimitedModItems.REVOLVER.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				} else if (itemstack.getItem() == TnunlimitedModItems.BLUNDERBUSS.get()) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1, false);
						}
					}
				}
				itemstack.getOrCreateTag().putDouble("ammo", num);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) itemstack.getOrCreateTag().getDouble("reload_time"));
				if (itemstack.getOrCreateTag().getBoolean("dump_clip")) {
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BULLET_SHELL.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) itemstack.getOrCreateTag().getDouble("clip_size"), 0.2, 0.2, 0.2, 0.1);
				}
			}
		} else if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level.isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) {
			itemstack.getOrCreateTag().putString("bullet_type", "iron");
			if (itemstack.getItem() == TnunlimitedModItems.REVOLVER.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:revolver_reload")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			} else if (itemstack.getItem() == TnunlimitedModItems.BLUNDERBUSS.get()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_reload")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
			itemstack.getOrCreateTag().putDouble("ammo", (itemstack.getOrCreateTag().getDouble("clip_size")));
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) itemstack.getOrCreateTag().getDouble("reload_time"));
			if (itemstack.getOrCreateTag().getBoolean("dump_clip")) {
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (TnunlimitedModParticleTypes.BULLET_SHELL.get()), (entity.getX()), (entity.getY() + 1), (entity.getZ()), (int) itemstack.getOrCreateTag().getDouble("clip_size"), 0.2, 0.2, 0.2, 0.1);
			}
		}
	}
}
