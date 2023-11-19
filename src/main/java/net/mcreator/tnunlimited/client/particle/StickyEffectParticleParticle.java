
package net.mcreator.tnunlimited.client.particle;

@OnlyIn(Dist.CLIENT)
public class StickyEffectParticleParticle extends TextureSheetParticle {

	public static StickyEffectParticleParticleProvider provider(SpriteSet spriteSet) {
		return new StickyEffectParticleParticleProvider(spriteSet);
	}

	public static class StickyEffectParticleParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public StickyEffectParticleParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new StickyEffectParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected StickyEffectParticleParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;

		this.setSize(0.2f, 0.2f);

		this.lifetime = 7;

		this.gravity = 1f;
		this.hasPhysics = true;

		this.xd = vx * 0.3;
		this.yd = vy * 0.3;
		this.zd = vz * 0.3;

		this.pickSprite(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();

	}

}
