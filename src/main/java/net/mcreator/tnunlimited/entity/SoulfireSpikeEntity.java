
package net.mcreator.tnunlimited.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.Packet;

import net.mcreator.tnunlimited.procedures.SoulfireSpikeHitMobProcedure;
import net.mcreator.tnunlimited.procedures.SfSpikeHitMobProcedure;
import net.mcreator.tnunlimited.procedures.AmethystFireballFlyProcedure;
import net.mcreator.tnunlimited.init.TnunlimitedModItems;
import net.mcreator.tnunlimited.init.TnunlimitedModEntities;

@OnlyIn(value = Dist.CLIENT, _interface = ItemSupplier.class)
public class SoulfireSpikeEntity extends AbstractArrow implements ItemSupplier {
	public SoulfireSpikeEntity(PlayMessages.SpawnEntity packet, Level world) {
		super(TnunlimitedModEntities.SOULFIRE_SPIKE.get(), world);
	}

	public SoulfireSpikeEntity(EntityType<? extends SoulfireSpikeEntity> type, Level world) {
		super(type, world);
	}

	public SoulfireSpikeEntity(EntityType<? extends SoulfireSpikeEntity> type, double x, double y, double z, Level world) {
		super(type, x, y, z, world);
	}

	public SoulfireSpikeEntity(EntityType<? extends SoulfireSpikeEntity> type, LivingEntity entity, Level world) {
		super(type, entity, world);
	}

	@Override
	public Packet<?> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public ItemStack getItem() {
		return new ItemStack(TnunlimitedModItems.PEPPERONI_FOOD.get());
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
	public void onHitEntity(EntityHitResult entityHitResult) {
		super.onHitEntity(entityHitResult);
		SoulfireSpikeHitMobProcedure.execute(this.level, entityHitResult.getEntity(), this);
	}

	@Override
	public void onHitBlock(BlockHitResult blockHitResult) {
		super.onHitBlock(blockHitResult);
		SfSpikeHitMobProcedure.execute(this.level, this);
	}

	@Override
	public void tick() {
		super.tick();
		AmethystFireballFlyProcedure.execute(this.level, this.getX(), this.getY(), this.getZ(), this);
		if (this.inGround)
			this.discard();
	}

	public static SoulfireSpikeEntity shoot(Level world, LivingEntity entity, RandomSource random, float power, double damage, int knockback) {
		SoulfireSpikeEntity entityarrow = new SoulfireSpikeEntity(TnunlimitedModEntities.SOULFIRE_SPIKE.get(), entity, world);
		entityarrow.shoot(entity.getViewVector(1).x, entity.getViewVector(1).y, entity.getViewVector(1).z, power * 2, 0);
		entityarrow.setSilent(true);
		entityarrow.setCritArrow(false);
		entityarrow.setBaseDamage(damage);
		entityarrow.setKnockback(knockback);
		world.addFreshEntity(entityarrow);
		world.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1f / (random.nextFloat() * 0.5f + 1) + (power / 2));
		return entityarrow;
	}

	public static SoulfireSpikeEntity shoot(LivingEntity entity, LivingEntity target) {
		SoulfireSpikeEntity entityarrow = new SoulfireSpikeEntity(TnunlimitedModEntities.SOULFIRE_SPIKE.get(), entity, entity.level);
		double dx = target.getX() - entity.getX();
		double dy = target.getY() + target.getEyeHeight() - 1.1;
		double dz = target.getZ() - entity.getZ();
		entityarrow.shoot(dx, dy - entityarrow.getY() + Math.hypot(dx, dz) * 0.2F, dz, 1f * 2, 12.0F);
		entityarrow.setSilent(true);
		entityarrow.setBaseDamage(5);
		entityarrow.setKnockback(5);
		entityarrow.setCritArrow(false);
		entity.level.addFreshEntity(entityarrow);
		entity.level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.arrow.shoot")), SoundSource.PLAYERS, 1, 1f / (RandomSource.create().nextFloat() * 0.5f + 1));
		return entityarrow;
	}
}
