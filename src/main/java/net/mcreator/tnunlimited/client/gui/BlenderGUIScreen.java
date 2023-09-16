package net.mcreator.tnunlimited.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.world.inventory.BlenderGUIMenu;
import net.mcreator.tnunlimited.network.BlenderGUIButtonMessage;
import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class BlenderGUIScreen extends AbstractContainerScreen<BlenderGUIMenu> {
	private final static HashMap<String, Object> guistate = BlenderGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_blend;

	public BlenderGUIScreen(BlenderGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/screens/blender_gui.png");

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
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.blender_gui.label_blender"), 22, 9, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.blender_gui.label_fuel"), 94, 36, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.blender_gui.label_ingredients"), 14, 63, -12829636);
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
		button_blend = new Button(this.leftPos + 78, this.topPos + 52, 51, 20, Component.translatable("gui.tnunlimited.blender_gui.button_blend"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new BlenderGUIButtonMessage(0, x, y, z));
				BlenderGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_blend", button_blend);
		this.addRenderableWidget(button_blend);
	}
}