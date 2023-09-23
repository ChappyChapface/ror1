
package net.mcreator.tnunlimited.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

public class DuneSpiderEntity extends PathfinderMob {

	public DuneSpiderEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(TnunlimitedModEntities.DUNE_SPIDER.get(), world);
	}

	public DuneSpiderEntity(EntityType<DuneSpiderEntity> type, Level world) {
		super(type, world);
		maxUpStep = 0.6f;
		xpReward = 8;
		setNoAi(false);

	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new RestrictSunGoal(this));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, true) {

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, Llama.class, true, false));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Rabbit.class, true, false));
		this.goalSelector.addGoal(6, new LeapAtTargetGoal(this, (float) 0.5));
		this.goalSelector.addGoal(7, new RandomStrollGoal(this, 0.8));
		this.targetSelector.addGoal(8, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(10, new FloatGoal(this));

	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.ambient"));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.death"));
	}

	@Override
	public boolean hurt(DamageSource source, float amount) {
		if (source == DamageSource.FALL)
			return false;
		if (source == DamageSource.CACTUS)
			return false;
		return super.hurt(source, amount);
	}

	public static void init() {
		SpawnPlacements.register(TnunlimitedModEntities.DUNE_SPIDER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return

			DuneSpiderSpawnProcedure.execute(x, z)

			;
		});

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.4);
		builder = builder.add(Attributes.MAX_HEALTH, 30);
		builder = builder.add(Attributes.ARMOR, 8);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 16);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.7);

		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 1);

		return builder;
	}

}
