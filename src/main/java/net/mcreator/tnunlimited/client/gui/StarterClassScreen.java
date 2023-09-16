package net.mcreator.tnunlimited.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.world.inventory.StarterClassMenu;
import net.mcreator.tnunlimited.procedures.GUIText3Procedure;
import net.mcreator.tnunlimited.procedures.GUIText13Procedure;
import net.mcreator.tnunlimited.procedures.ClassUnlockProcedure;
import net.mcreator.tnunlimited.procedures.ClassTextProcedure;
import net.mcreator.tnunlimited.procedures.ClassText2Procedure;
import net.mcreator.tnunlimited.procedures.ClassLockProcedure;
import net.mcreator.tnunlimited.network.StarterClassButtonMessage;
import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StarterClassScreen extends AbstractContainerScreen<StarterClassMenu> {
	private final static HashMap<String, Object> guistate = StarterClassMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_confirm;
	Button button_empty;
	Button button_empty1;

	public StarterClassScreen(StarterClassMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/screens/starter_class.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.starter_class.label_starter_class"), 55, 5, -12829636);
		this.font.draw(poseStack,

				ClassTextProcedure.execute(entity), 9, 22, -12829636);
		this.font.draw(poseStack,

				ClassText2Procedure.execute(entity), 9, 31, -12829636);
		this.font.draw(poseStack,

				GUIText3Procedure.execute(entity), 9, 40, -12829636);
		if (ClassLockProcedure.execute(entity))
			this.font.draw(poseStack, Component.translatable("gui.tnunlimited.starter_class.label_locked"), 71, 60, -12829636);
		this.font.draw(poseStack,

				GUIText13Procedure.execute(entity), 3, 6, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_confirm = new Button(this.leftPos + 57, this.topPos + 53, 61, 20, Component.translatable("gui.tnunlimited.starter_class.button_confirm"), e -> {
			if (ClassUnlockProcedure.execute(entity)) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new StarterClassButtonMessage(0, x, y, z));
				StarterClassButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(PoseStack ms, int gx, int gy, float ticks) {
				if (ClassUnlockProcedure.execute(entity))
					super.render(ms, gx, gy, ticks);
			}
		};
		guistate.put("button:button_confirm", button_confirm);
		this.addRenderableWidget(button_confirm);
		button_empty = new Button(this.leftPos + 136, this.topPos + 53, 30, 20, Component.translatable("gui.tnunlimited.starter_class.button_empty"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new StarterClassButtonMessage(1, x, y, z));
				StarterClassButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 6, this.topPos + 53, 30, 20, Component.translatable("gui.tnunlimited.starter_class.button_empty1"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new StarterClassButtonMessage(2, x, y, z));
				StarterClassButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
	}
}
