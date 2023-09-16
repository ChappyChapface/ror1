package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;

import net.mcreator.tnunlimited.init.TnunlimitedModEntities;
import net.mcreator.tnunlimited.init.TnunlimitedModEnchantments;
import net.mcreator.tnunlimited.entity.OffhandFrostBulletEntity;
import net.mcreator.tnunlimited.entity.OffhandBulletProjectileEntity;
import net.mcreator.tnunlimited.entity.FrostBulletProjectileEntity;
import net.mcreator.tnunlimited.entity.BulletProjectileEntity;

public class GunShootBaseProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean hit = false;
		double num = 0;
		double d = 0;
		double n = 0;
		if (("no").equals("yes")) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
		} else if ((itemstack.getOrCreateTag().getString("bullet_type")).equals("frost")) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new OffhandFrostBulletEntity(TnunlimitedModEntities.OFFHAND_FROST_BULLET.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((itemstack.getOrCreateTag().getDouble("gun_damage") + -0.15) * (1 + 0.15 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack))),
								(int) itemstack.getOrCreateTag().getDouble("knockback"), (byte) (itemstack.getOrCreateTag().getDouble("piercing")));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) itemstack.getOrCreateTag().getDouble("inaccuracy"));
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new FrostBulletProjectileEntity(TnunlimitedModEntities.FROST_BULLET_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((itemstack.getOrCreateTag().getDouble("gun_damage") + -0.15) * (1 + 0.15 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack))),
								(int) itemstack.getOrCreateTag().getDouble("knockback"), (byte) (itemstack.getOrCreateTag().getDouble("piercing")));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) itemstack.getOrCreateTag().getDouble("inaccuracy"));
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else if ((itemstack.getOrCreateTag().getString("bullet_type")).equals("lead")) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new OffhandBulletProjectileEntity(TnunlimitedModEntities.OFFHAND_BULLET_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((itemstack.getOrCreateTag().getDouble("gun_damage") + 0.25) * (1 + 0.15 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack))),
								(int) itemstack.getOrCreateTag().getDouble("knockback"), (byte) (itemstack.getOrCreateTag().getDouble("piercing")));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) itemstack.getOrCreateTag().getDouble("inaccuracy"));
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new BulletProjectileEntity(TnunlimitedModEntities.BULLET_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((itemstack.getOrCreateTag().getDouble("gun_damage") + 0.25) * (1 + 0.15 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack))),
								(int) itemstack.getOrCreateTag().getDouble("knockback"), (byte) (itemstack.getOrCreateTag().getDouble("piercing")));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) itemstack.getOrCreateTag().getDouble("inaccuracy"));
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem()) {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new OffhandBulletProjectileEntity(TnunlimitedModEntities.OFFHAND_BULLET_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((itemstack.getOrCreateTag().getDouble("gun_damage") + 0) * (1 + 0.15 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack))),
								(int) itemstack.getOrCreateTag().getDouble("knockback"), (byte) (itemstack.getOrCreateTag().getDouble("piercing")));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) itemstack.getOrCreateTag().getDouble("inaccuracy"));
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			} else {
				{
					Entity _shootFrom = entity;
					Level projectileLevel = _shootFrom.level;
					if (!projectileLevel.isClientSide()) {
						Projectile _entityToSpawn = new Object() {
							public Projectile getArrow(Level level, Entity shooter, float damage, int knockback, byte piercing) {
								AbstractArrow entityToSpawn = new BulletProjectileEntity(TnunlimitedModEntities.BULLET_PROJECTILE.get(), level);
								entityToSpawn.setOwner(shooter);
								entityToSpawn.setBaseDamage(damage);
								entityToSpawn.setKnockback(knockback);
								entityToSpawn.setSilent(true);
								entityToSpawn.setPierceLevel(piercing);
								return entityToSpawn;
							}
						}.getArrow(projectileLevel, entity, (float) ((itemstack.getOrCreateTag().getDouble("gun_damage") + 0) * (1 + 0.15 * EnchantmentHelper.getItemEnchantmentLevel(TnunlimitedModEnchantments.CALIBER.get(), itemstack))),
								(int) itemstack.getOrCreateTag().getDouble("knockback"), (byte) (itemstack.getOrCreateTag().getDouble("piercing")));
						_entityToSpawn.setPos(_shootFrom.getX(), _shootFrom.getEyeY() - 0.1, _shootFrom.getZ());
						_entityToSpawn.shoot(_shootFrom.getLookAngle().x, _shootFrom.getLookAngle().y, _shootFrom.getLookAngle().z, 3, (float) itemstack.getOrCreateTag().getDouble("inaccuracy"));
						projectileLevel.addFreshEntity(_entityToSpawn);
					}
				}
			}
		}
	}
}
