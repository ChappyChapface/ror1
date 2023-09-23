
package net.mcreator.tnunlimited.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.material.Material;
import net.minecraft.nbt.Tag;
import net.minecraft.sounds.SoundEvent;

import javax.annotation.Nullable;

public class CoffeePotBug1Entity extends Monster {

	public CoffeePotBug1Entity(PlayMessages.SpawnEntity packet, Level world) {
		this(TnunlimitedModEntities.COFFEE_POT_BUG_1.get(), world);
	}

	public CoffeePotBug1Entity(EntityType<CoffeePotBug1Entity> type, Level world) {
		super(type, world);
		maxUpStep = 0.6f;
		xpReward = 0;
		setNoAi(false);

	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();

		this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Spider.class, (float) 12, 1, 1.2));
		this.targetSelector.addGoal(2, new NearestAttackableTargetGoal(this, Animal.class, false, false) {
			@Override
			public boolean canUse() {
				double x = CoffeePotBug1Entity.this.getX();
				double y = CoffeePotBug1Entity.this.getY();
				double z = CoffeePotBug1Entity.this.getZ();
				Entity entity = CoffeePotBug1Entity.this;
				Level world = CoffeePotBug1Entity.this.level;
				return super.canUse() &&

						NotRidingProcedure.execute(entity)

				;
			}

			@Override
			public boolean canContinueToUse() {
				double x = CoffeePotBug1Entity.this.getX();
				double y = CoffeePotBug1Entity.this.getY();
				double z = CoffeePotBug1Entity.this.getZ();
				Entity entity = CoffeePotBug1Entity.this;
				Level world = CoffeePotBug1Entity.this.level;
				return super.canContinueToUse() &&

						NotRidingProcedure.execute(entity)

				;
			}
		});
		this.targetSelector.addGoal(3, new NearestAttackableTargetGoal(this, Player.class, false, false) {
			@Override
			public boolean canUse() {
				double x = CoffeePotBug1Entity.this.getX();
				double y = CoffeePotBug1Entity.this.getY();
				double z = CoffeePotBug1Entity.this.getZ();
				Entity entity = CoffeePotBug1Entity.this;
				Level world = CoffeePotBug1Entity.this.level;
				return super.canUse() &&

						NotRidingProcedure.execute(entity)

				;
			}

			@Override
			public boolean canContinueToUse() {
				double x = CoffeePotBug1Entity.this.getX();
				double y = CoffeePotBug1Entity.this.getY();
				double z = CoffeePotBug1Entity.this.getZ();
				Entity entity = CoffeePotBug1Entity.this;
				Level world = CoffeePotBug1Entity.this.level;
				return super.canContinueToUse() &&

						NotRidingProcedure.execute(entity)

				;
			}
		});
		this.targetSelector.addGoal(4, new NearestAttackableTargetGoal(this, ServerPlayer.class, false, false) {
			@Override
			public boolean canUse() {
				double x = CoffeePotBug1Entity.this.getX();
				double y = CoffeePotBug1Entity.this.getY();
				double z = CoffeePotBug1Entity.this.getZ();
				Entity entity = CoffeePotBug1Entity.this;
				Level world = CoffeePotBug1Entity.this.level;
				return super.canUse() &&

						NotRidingProcedure.execute(entity)

				;
			}

			@Override
			public boolean canContinueToUse() {
				double x = CoffeePotBug1Entity.this.getX();
				double y = CoffeePotBug1Entity.this.getY();
				double z = CoffeePotBug1Entity.this.getZ();
				Entity entity = CoffeePotBug1Entity.this;
				Level world = CoffeePotBug1Entity.this.level;
				return super.canContinueToUse() &&

						NotRidingProcedure.execute(entity)

				;
			}
		});
		this.goalSelector.addGoal(5, new MeleeAttackGoal(this, 1.2, false) {

			@Override
			protected double getAttackReachSqr(LivingEntity entity) {
				return this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth();
			}

		});
		this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(7, new FloatGoal(this));

	}

	@Override
	public MobType getMobType() {
		return MobType.ARTHROPOD;
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.silverfish.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.silverfish.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.silverfish.death"));
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
		SpawnPlacements.register(TnunlimitedModEntities.COFFEE_POT_BUG_1.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
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
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 2);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 1);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		return builder;
	}

}
