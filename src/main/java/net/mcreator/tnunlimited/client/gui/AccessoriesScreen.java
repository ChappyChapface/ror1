package net.mcreator.tnunlimited.client.gui;

public class AccessoriesScreen extends AbstractContainerScreen<AccessoriesMenu> {

	private final static HashMap<String, Object> guistate = AccessoriesMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_equip;

	public AccessoriesScreen(AccessoriesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tnunlimited:textures/screens/accessories.png");

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
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.accessories.label_accessories"), 58, 7, -12829636);
		this.font.draw(poseStack, Component.translatable("gui.tnunlimited.accessories.label_empty"), 71, 48, -12829636);
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

		button_equip = new Button(this.leftPos + 61, this.topPos + 25, 51, 20, Component.translatable("gui.tnunlimited.accessories.button_equip"), e -> {
			if (true) {
				TnunlimitedMod.PACKET_HANDLER.sendToServer(new AccessoriesButtonMessage(0, x, y, z));
				AccessoriesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:button_equip", button_equip);
		this.addRenderableWidget(button_equip);

	}

}
