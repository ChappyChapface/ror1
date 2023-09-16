
package net.mcreator.tnunlimited.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.procedures.ReturnChargeProcedure;
import net.mcreator.tnunlimited.procedures.OverchargedCleaverConProcedure;
import net.mcreator.tnunlimited.procedures.NitroKnifeConProcedure;
import net.mcreator.tnunlimited.procedures.NitroClaymoreConProcedure;
import net.mcreator.tnunlimited.procedures.NitroBladeConProcedure;
import net.mcreator.tnunlimited.procedures.BluntConProcedure;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class NitroChargeOverlay {
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		int posX = w / 2;
		int posY = h / 2;
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level;
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (true) {
			if (NitroKnifeConProcedure.execute(entity))
				Minecraft.getInstance().font.draw(event.getPoseStack(),

						ReturnChargeProcedure.execute(world, entity), posX + -108, posY + 104, -25345);
			if (NitroBladeConProcedure.execute(entity))
				Minecraft.getInstance().font.draw(event.getPoseStack(),

						ReturnChargeProcedure.execute(world, entity), posX + -108, posY + 104, -25345);
			if (NitroClaymoreConProcedure.execute(entity))
				Minecraft.getInstance().font.draw(event.getPoseStack(),

						ReturnChargeProcedure.execute(world, entity), posX + -108, posY + 104, -25345);
			if (BluntConProcedure.execute(entity))
				Minecraft.getInstance().font.draw(event.getPoseStack(),

						ReturnChargeProcedure.execute(world, entity), posX + -108, posY + 104, -39424);
			if (OverchargedCleaverConProcedure.execute(entity))
				Minecraft.getInstance().font.draw(event.getPoseStack(),

						ReturnChargeProcedure.execute(world, entity), posX + -108, posY + 104, -26317);
		}
	}
}
