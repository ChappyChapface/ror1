
package net.mcreator.tnunlimited.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class CakemonsterEntityProjectile extends AbstractArrow implements ItemSupplier {

	public CakemonsterEntityProjectile(PlayMessages.SpawnEntity packet, Level world) {
		super(TnunlimitedModEntities.CAKEMONSTER_PROJECTILE.get(), world);
	}

	public CakemonsterEntityProjectile(EntityType<? extends CakemonsterEntityProjectile> type, Level world) {
		super(type, world);
	}

	public CakemonsterEntityProjectile(EntityType<? extends CakemonsterEntityProjectile> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public CakemonsterEntityProjectile(EntityType<? extends CakemonsterEntityProjectile> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void doPostHurtEffects(LivingEntity livingEntity) {
		super.doPostHurtEffects(livingEntity);
		livingEntity.setArrowCount(livingEntity.getArrowCount() - 1);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(TnunlimitedModItems.CAKEBLOBAMMO.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(TnunlimitedModItems.CAKEBLOBAMMO.get());
	}
}
