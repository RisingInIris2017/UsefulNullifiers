package com.bartz24.usefulnullifiers.inventory;

import com.bartz24.usefulnullifiers.References;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class FluidVoidGui extends GuiContainer {

	private EntityPlayer player;
	private FluidVoidInventory inv;

	public FluidVoidGui(EntityPlayer entityPlayer, FluidVoidInventory inventory) {
		super(new FluidVoidContainer(entityPlayer, inventory, -1));

		this.player = entityPlayer;
		this.inv = inventory;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.ModID, "textures/gui/singleslot.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = inv.getDisplayName().getUnformattedText();

		this.fontRenderer.drawString(s, 88 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.fontRenderer.drawString(this.player.inventory.getDisplayName().getUnformattedText(), 8, 72, 4210752);
	}
}
