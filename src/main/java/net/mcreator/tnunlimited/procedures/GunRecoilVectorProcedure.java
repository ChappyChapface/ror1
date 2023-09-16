package net.mcreator.tnunlimited.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class GunRecoilVectorProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double d = 0;
		double n = 0;
		n = 0;
		d = n * Math.sin((90 - entity.getXRot()) * (3.14159265 / 180));
		entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + d * Math.sin((90 - (entity.getYRot() + 90)) * (3.14159265 / 180))), (entity.getDeltaMovement().y() + (n * Math.sin((entity.getXRot() + 180) * (3.14159265 / 180))) / 2),
				(entity.getDeltaMovement().z() + d * Math.sin((entity.getYRot() + 90) * (3.14159265 / 180)))));
	}
}
