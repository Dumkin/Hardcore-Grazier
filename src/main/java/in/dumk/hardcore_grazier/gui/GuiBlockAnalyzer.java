package in.dumk.hardcore_grazier.gui;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import in.dumk.hardcore_grazier.container.ContainerBlockAnalyzer;
import in.dumk.hardcore_grazier.tile.TileEntityAnalyzer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiBlockAnalyzer extends GuiContainer {

  private TileEntityAnalyzer te;
  private IInventory playerInv;

  public GuiBlockAnalyzer(IInventory playerInv, TileEntityAnalyzer te) {
    super(new ContainerBlockAnalyzer(playerInv, te));

    this.xSize = 176;
    this.ySize = 166;

    this.playerInv = playerInv;
    this.te = te;
  }

  @Override
  protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
    GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);

    this.mc.getTextureManager().bindTexture(new ResourceLocation(HardcoreGrazier.MODID, "textures/gui/container/analyzer.png"));

    this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

    String s = I18n.format("container.block_breaker"); //Gets the formatted name for the block breaker from the language file - NOTE ADD "container.block_breaker=Block Breaker" to the language file (without quotes) and then delete this note
    this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752); //Draws the block breaker name in the center on the top of the gui
    this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752); //The player's inventory name
  }

}
