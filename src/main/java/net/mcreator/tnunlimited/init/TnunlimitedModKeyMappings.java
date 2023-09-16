
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tnunlimited.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.tnunlimited.network.ShiftPlateKeyRMessage;
import net.mcreator.tnunlimited.network.ShiftPlateKeyMessage;
import net.mcreator.tnunlimited.network.ShiftPlateKeyLMessage;
import net.mcreator.tnunlimited.network.OpenStatSheetKeyMessage;
import net.mcreator.tnunlimited.network.OpenAccessoryMenuMessage;
import net.mcreator.tnunlimited.network.DoublejumpMessage;
import net.mcreator.tnunlimited.TnunlimitedMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TnunlimitedModKeyMappings {
	public static final KeyMapping OPEN_ACCESSORY_MENU = new KeyMapping("key.tnunlimited.open_accessory_menu", GLFW.GLFW_KEY_R, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new OpenAccessoryMenuMessage(0, 0));
				OpenAccessoryMenuMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_STAT_SHEET_KEY = new KeyMapping("key.tnunlimited.open_stat_sheet_key", GLFW.GLFW_KEY_RIGHT_SHIFT, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new OpenStatSheetKeyMessage(0, 0));
				OpenStatSheetKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DOUBLEJUMP = new KeyMapping("key.tnunlimited.doublejump", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new DoublejumpMessage(0, 0));
				DoublejumpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHIFT_PLATE_KEY = new KeyMapping("key.tnunlimited.shift_plate_key", GLFW.GLFW_KEY_X, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new ShiftPlateKeyMessage(0, 0));
				ShiftPlateKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHIFT_PLATE_KEY_L = new KeyMapping("key.tnunlimited.shift_plate_key_l", GLFW.GLFW_KEY_Z, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new ShiftPlateKeyLMessage(0, 0));
				ShiftPlateKeyLMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SHIFT_PLATE_KEY_R = new KeyMapping("key.tnunlimited.shift_plate_key_r", GLFW.GLFW_KEY_C, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new ShiftPlateKeyRMessage(0, 0));
				ShiftPlateKeyRMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_ACCESSORY_MENU);
		event.register(OPEN_STAT_SHEET_KEY);
		event.register(DOUBLEJUMP);
		event.register(SHIFT_PLATE_KEY);
		event.register(SHIFT_PLATE_KEY_L);
		event.register(SHIFT_PLATE_KEY_R);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_ACCESSORY_MENU.consumeClick();
				OPEN_STAT_SHEET_KEY.consumeClick();
				DOUBLEJUMP.consumeClick();
				SHIFT_PLATE_KEY.consumeClick();
				SHIFT_PLATE_KEY_L.consumeClick();
				SHIFT_PLATE_KEY_R.consumeClick();
			}
		}
	}
}
