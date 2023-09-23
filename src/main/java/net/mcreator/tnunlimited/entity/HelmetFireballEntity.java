
package net.mcreator.tnunlimited.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class HelmetFireballEntity extends AbstractArrow implements ItemSupplier {
	public HelmetFireballEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TnunlimitedModEntities.HELMET_FIREBALL.get(), world);
	}

	public HelmetFireballEntity(EntityType<? extends HelmetFireballEntity> type, Level world) {
		super(type, world);
	}

	public HelmetFireballEntity(EntityType<? extends HelmetFireballEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public HelmetFireballEntity(EntityType<? extends HelmetFireballEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(TnunlimitedModItems.HELMET_FIREBALL.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return new ItemStack(TnunlimitedModItems.BAG_OF_TWO_HUNDRED_KIDNEYS.get());
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void tick() {
		super.tick();
		AmethystFireballFlyProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		if (this.inGround)
			this.discard();
	}

	public static HelmetFireballEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		HelmetFireballEntity entityarrow = new HelmetFireballEntity(TnunlimitedModEntities.HELMET_FIREBALL.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static HelmetFireballEntity shoot(LivingEntity entity, LivingEntity target) {
		HelmetFireballEntity entityarrow = new HelmetFireballEntity(TnunlimitedModEntities.HELMET_FIREBALL.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(3);
		entityarrow.setKnockback(1);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ghast.shoot")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
