package com.bartz24.usefulnullifiers.inventory;

import com.bartz24.usefulnullifiers.References;
import net.minecraft.block.Block;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class AIONGui extends GuiContainer {

    private EntityPlayer player;
    private AIONInventory inv;

    public AIONGui(EntityPlayer entityPlayer, AIONInventory inventory) {
        super(new AIONContainer(entityPlayer, inventory, -1));

        this.player = entityPlayer;
        this.inv = inventory;

        this.xSize = 176;
        this.ySize = 166;
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.ModID, "textures/gui/threeslot.png"));
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        ItemStack stack = inv.getStackInSlot(1);
        Block block = stack.isEmpty() ? Blocks.AIR : Block.getBlockFromItem(stack.getItem());
        String s = "Portable AION Nullifier";
        this.fontRenderer.drawString(s, 88 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.player.inventory.getDisplayName().getUnformattedText(), 8, 72, 4210752);
        String s2 = (block == Blocks.AIR ? "Not Placeable" : "Placeable");
        this.fontRenderer.drawString(s2, this.xSize / 2 - this.fontRenderer.getStringWidth(s2) / 2, 30, 4210752);
        s = "Overflow";
        this.fontRenderer.drawString(s, xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 40, 4210752);
        s = "Items";
        this.fontRenderer.drawString(s, 36 - this.fontRenderer.getStringWidth(s) / 2, 40, 4210752);
        s = "Fluids";
        this.fontRenderer.drawString(s, 144 - this.fontRenderer.getStringWidth(s) / 2, 40, 4210752);
    }
}
