package net.mcreator.tnunlimited.client.gui;

public class StatSheetScreen extends AbstractContainerScreen<StatSheetMenu> {

	private final static HashMap<String, Object> guistate = StatSheetMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_empty;
	Button button_empty1;

	public StatSheetScreen(StatSheetMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/screens/stat_sheet.png");

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
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.stat_sheet.label_stat_sheet"), 60, 7, -12829636);
		this.font.draw(poseStack,

				GUIPageDisplayProcedure.execute(entity), 69, 16, -12829636);
		this.font.draw(poseStack,

				ClassTextProcedure.execute(entity), 6, 34, -12829636);
		this.font.draw(poseStack,

				ClassText2Procedure.execute(entity), 6, 43, -12829636);
		this.font.draw(poseStack,

				GUIText3Procedure.execute(entity), 6, 52, -12829636);
		this.font.draw(poseStack,

				GUIText4Procedure.execute(entity), 6, 61, -12829636);
		this.font.draw(poseStack,

				GUIText5Procedure.execute(entity), 6, 70, -12829636);
		this.font.draw(poseStack,

				GUIText6Procedure.execute(entity), 6, 79, -12829636);
		this.font.draw(poseStack,

				GUIText7Procedure.execute(entity), 6, 88, -12829636);
		this.font.draw(poseStack,

				GUIText8Procedure.execute(entity), 6, 97, -12829636);
		this.font.draw(poseStack,

				GUIText9Procedure.execute(entity), 6, 106, -12829636);
		this.font.draw(poseStack,

				GUIText10Procedure.execute(entity), 6, 115, -12829636);
		this.font.draw(poseStack,

				GUIText11Procedure.execute(entity), 6, 124, -12829636);
		this.font.draw(poseStack,

				GUIText12Procedure.execute(entity), 6, 133, -12829636);
		this.font.draw(poseStack,

				GUIText13Procedure.execute(entity), 6, 142, -12829636);
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

		button_empty = new Button(this.leftPos + 132, this.topPos + 7, 30, 20, Component.translatable("gui.tnunlimited.stat_sheet.button_empty"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new StatSheetButtonMessage(0, x, y, z));
				StatSheetButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);

		button_empty1 = new Button(this.leftPos + 6, this.topPos + 7, 30, 20, Component.translatable("gui.tnunlimited.stat_sheet.button_empty1"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new StatSheetButtonMessage(1, x, y, z));
				StatSheetButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});

		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);

	}

}
