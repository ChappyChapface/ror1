package net.mcreator.tnunlimited.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

public class BlunderbussRightClickedInAirProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean hit = false;
		double num = 0;
		double xrot = 0;
		double yrot = 0;
		double d = 0;
		double n = 0;
		if (itemstack.getOrCreateTag().getDouble("ammo") > 0) {
			if (world instanceof ServerLevel _level)
				_level.sendParticles(ParticleTypes.SMOKE, (entity.getX()), (entity.getY() + 1), (entity.getZ()), 5, 0.2, 0.2, 0.2, 0.02);
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), (int) (10 / (1 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.TRIGGER_HAPPY.get(), itemstack) * 0.25)));
			xrot = entity.getXRot();
			yrot = entity.getYRot();
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, new BlockPos(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_shoot")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("tnunlimited:blunderbuss_shoot")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			itemstack.getOrCreateTag().putDouble("gun_damage", 1.5);
			itemstack.getOrCreateTag().putDouble("knockback", 0);
			itemstack.getOrCreateTag().putDouble("piercing", 0);
			itemstack.getOrCreateTag().putDouble("inaccuracy", 15);
			for (int index0 = 0; index0 < 18; index0++) {
				GunShootBaseProcedure.execute(entity, itemstack);
			}
			if (0.1 < Math.random() / (1 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.FULL_MAGIC_JACKET.get(), itemstack) + 0.25)) {
				itemstack.getOrCreateTag().putDouble("ammo", 0);
			} else if (0 == EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.FULL_MAGIC_JACKET.get(), itemstack)) {
				itemstack.getOrCreateTag().putDouble("ammo", 0);
			}
			{
				Entity _ent = entity;
				_ent.setYRot((float) yrot);
				_ent.setXRot((float) xrot);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
			if (entity instanceof LivingEntity _entity)
				_entity.swing(InteractionHand.MAIN_HAND, true);
			if (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.KICKBACK.get(), itemstack) >= 1) {
				n = (((1 * 4 * (-1) + -8) * (1 + 0.25 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack)))
						/ (1 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.SHARP_SHOOTER.get(), itemstack) * 0.25)) * 0.1;
				d = n * Math.sin((90 - entity.getXRot()) * (3.14159265 / 180));
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + 0.4 * d * Math.sin((90 - (entity.getYRot() + 90)) * (3.14159265 / 180))),
						(entity.getDeltaMovement().y() + 0.4 * ((n * Math.sin((entity.getXRot() + 180) * (3.14159265 / 180))) / 2)), (entity.getDeltaMovement().z() + 0.4 * d * Math.sin((entity.getYRot() + 90) * (3.14159265 / 180)))));
			}
			entity.getPersistentData().putDouble("yawrecoil", (((Math.random() * 10 - 5) * (1 + 0.25 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack)))
					/ (1 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.SHARP_SHOOTER.get(), itemstack) * 0.25)));
			entity.getPersistentData().putDouble("pitchrecoil", (((Math.random() * 4 * (-1) + -8) * (1 + 0.25 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack)))
					/ (1 + EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.SHARP_SHOOTER.get(), itemstack) * 0.25)));
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
				{
					ItemStack _ist = itemstack;
					if (_ist.hurt(1, RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		} else {
			itemstack.getOrCreateTag().putDouble("clip_size", 18);
			itemstack.getOrCreateTag().putDouble("reload_time", 60);
			itemstack.getOrCreateTag().putBoolean("dump_clip", false);
			GunReloadBaseProcedure.execute(world, x, y, z, entity, itemstack);
		}
	}
}
