
package net.mcreator.tnunlimited.entity;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class FuryHookEntity extends AbstractArrow implements ItemSupplier {
	public FuryHookEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TnunlimitedModEntities.FURY_HOOK.get(), world);
	}

	public FuryHookEntity(EntityType<? extends FuryHookEntity> type, Level world) {
		super(type, world);
	}

	public FuryHookEntity(EntityType<? extends FuryHookEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public FuryHookEntity(EntityType<? extends FuryHookEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(TnunlimitedModItems.RAWTITANIUM.get());
	}

	@Override
	protected ItemStack getPickupItem() {
		return ItemStack.EMPTY;
	}

	@Override
	protected void doPostHurtEffects(LivingEntity entity) {
		super.doPostHurtEffects(entity);
		entity.setArrowCount(entity.getArrowCount() - 1);
	}

	@Override
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		FuryHookYoinkProcedure.execute();
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		FuryHookBlockHitProcedure.execute(this.getOwner(), this);
	}

	@Override
	public void tick() {
		super.tick();
		FuryHookNoGravProcedure.execute();
		if (this.inGround)
			this.discard();
	}

	public static FuryHookEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		FuryHookEntity entityarrow = new FuryHookEntity(TnunlimitedModEntities.FURY_HOOK.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(true);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static FuryHookEntity shoot(LivingEntity entity, LivingEntity target) {
		FuryHookEntity entityarrow = new FuryHookEntity(TnunlimitedModEntities.FURY_HOOK.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(0);
		entityarrow.setCritArrow(true);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.trident.throw")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
