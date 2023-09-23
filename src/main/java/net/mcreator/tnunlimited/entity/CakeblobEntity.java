
package net.mcreator.tnunlimited.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class CakeblobEntity extends AbstractArrow implements ItemSupplier {
	public CakeblobEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TnunlimitedModEntities.CAKEBLOB.get(), world);
	}

	public CakeblobEntity(EntityType<? extends CakeblobEntity> type, Level world) {
		super(type, world);
	}

	public CakeblobEntity(EntityType<? extends CakeblobEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public CakeblobEntity(EntityType<? extends CakeblobEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
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

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static CakeblobEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		CakeblobEntity entityarrow = new CakeblobEntity(TnunlimitedModEntities.CAKEBLOB.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(true);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.attack")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static CakeblobEntity shoot(LivingEntity entity, LivingEntity target) {
		CakeblobEntity entityarrow = new CakeblobEntity(TnunlimitedModEntities.CAKEBLOB.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(2);
		entityarrow.setCritArrow(true);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.slime.attack")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
