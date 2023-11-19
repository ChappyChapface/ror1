package net.mcreator.tnunlimited.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tnunlimited.world.inventory.GluttonyCraftMenu;
import net.mcreator.tnunlimited.procedures.GluttonyCraftNBTDisplayProcedure;
import net.mcreator.tnunlimited.procedures.GluttonyCraftKillsProcedure;
import net.mcreator.tnunlimited.network.GluttonyCraftButtonMessage;
import net.mcreator.tnunlimited.TnunlimitedMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GluttonyCraftScreen extends AbstractContainerScreen<GluttonyCraftMenu> {
	private final static HashMap<String, Object> guistate = GluttonyCraftMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_craft;

	public GluttonyCraftScreen(GluttonyCraftMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/screens/gluttony_craft.png");

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
		this.font.draw(poseStack,

				GluttonyCraftNBTDisplayProcedure.execute(entity), 32, 12, -12829636);
		this.font.draw(poseStack,

				GluttonyCraftKillsProcedure.execute(entity), 32, 3, -12829636);
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
		button_craft = new Button(this.leftPos + 60, this.topPos + 25, 51, 20, Component.translatable("gui.tnunlimited.gluttony_craft.button_craft"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new GluttonyCraftButtonMessage(0, x, y, z));
				GluttonyCraftButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_craft", button_craft);
		this.addRenderableWidget(button_craft);
	}
}
