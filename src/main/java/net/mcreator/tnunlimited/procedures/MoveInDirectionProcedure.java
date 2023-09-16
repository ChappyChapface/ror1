package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;

public class MoveInDirectionProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double d = 0;
		double n = 0;
		if (entity.isOnGround()) {
			n = (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.LUNGING.get(), itemstack) + 3) * 0.33;
			d = n * Math.sin((90 - entity.getXRot()) * (3.14159265 / 180));
			entity.setDeltaMovement(new Vec3((d * Math.sin((90 - (entity.getYRot() + 90)) * (3.14159265 / 180))), ((n * Math.sin((entity.getXRot() + 180) * (3.14159265 / 180))) / 2), (d * Math.sin((entity.getYRot() + 90) * (3.14159265 / 180)))));
			entity.fallDistance = 0;
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
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
		} else if (!(entity instanceof LivingEntity _livEnt ? _livEnt.isFallFlying() : false) && EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.AERIAL_MOVEMENT.get(), itemstack) > 0) {
			n = (EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.LUNGING.get(), itemstack) + 3) * 0.066 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.AERIAL_MOVEMENT.get(), itemstack);
			d = n * Math.sin((90 - entity.getXRot()) * (3.14159265 / 180));
			entity.setDeltaMovement(new Vec3((d * Math.sin((90 - (entity.getYRot() + 90)) * (3.14159265 / 180))), ((n * Math.sin((entity.getXRot() + 180) * (3.14159265 / 180))) / 2), (d * Math.sin((entity.getYRot() + 90) * (3.14159265 / 180)))));
			entity.fallDistance = 0;
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 25);
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
		}
	}
}
