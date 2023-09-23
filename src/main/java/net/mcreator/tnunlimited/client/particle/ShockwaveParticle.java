
package net.mcreator.tnunlimited.client.particle;

@OnlyIn(Dist.CLIENT)
public class ShockwaveParticle extends TextureSheetParticle {

	public static ShockwaveParticleProvider provider(SpriteSet spriteSet) {
		return new ShockwaveParticleProvider(spriteSet);
	}

	public static class ShockwaveParticleProvider implements ParticleProvider<SimpleParticleType> {
		private final SpriteSet spriteSet;

		public ShockwaveParticleProvider(SpriteSet spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle createParticle(SimpleParticleType typeIn, ClientLevel worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new ShockwaveParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final SpriteSet spriteSet;

	protected ShockwaveParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;

		this.setSize(0.2f, 0.2f);
		this.quadSize *= 7f;

		this.lifetime = 9;

		this.gravity = 0f;
		this.hasPhysics = false;

		this.xd = vx * 0;
		this.yd = vy * 0;
		this.zd = vz * 0;

		this.setSpriteFromAge(spriteSet);
	}

	@Override
	public ParticleRenderType getRenderType() {
		return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
	}

	@Override
	public void tick() {
		super.tick();

		if (!this.removed) {
			this.setSprite(this.spriteSet.get((this.age / 2) % 5 + 1, 5));
		}

	}

}
