
package net.mcreator.tnunlimited.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class RoseGoldDiscEntity extends AbstractArrow implements ItemSupplier {
	public RoseGoldDiscEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TnunlimitedModEntities.ROSE_GOLD_DISC.get(), world);
	}

	public RoseGoldDiscEntity(EntityType<? extends RoseGoldDiscEntity> type, Level world) {
		super(type, world);
	}

	public RoseGoldDiscEntity(EntityType<? extends RoseGoldDiscEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public RoseGoldDiscEntity(EntityType<? extends RoseGoldDiscEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(TnunlimitedModItems.ROSE_GOLD_DISC.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(TnunlimitedModItems.ROSE_GOLD_DISC.get());
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		RoseGoldDiskFlyProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		RoseGoldDiscProjectileHitsBlockProcedure.execute(this.level, this);
	}

	@Override
	public void tick() {
		super.tick();
		if (this.inGround)
			this.discard();
	}

	public static RoseGoldDiscEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		RoseGoldDiscEntity entityarrow = new RoseGoldDiscEntity(TnunlimitedModEntities.ROSE_GOLD_DISC.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static RoseGoldDiscEntity shoot(LivingEntity entity, LivingEntity target) {
		RoseGoldDiscEntity entityarrow = new RoseGoldDiscEntity(TnunlimitedModEntities.ROSE_GOLD_DISC.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 0.8f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(3);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
