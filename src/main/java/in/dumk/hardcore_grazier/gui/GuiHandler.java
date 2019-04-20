package in.dumk.hardcore_grazier.gui;

import in.dumk.hardcore_grazier.container.ContainerBlockAnalyzer;
import in.dumk.hardcore_grazier.tile.TileEntityAnalyzer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

  public static final int BLOCK_ANALYZER = 0;

  @Nullable
  @Override
  public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    switch (ID) {
      case BLOCK_ANALYZER:
        return new ContainerBlockAnalyzer(player.inventory, (TileEntityAnalyzer) world.getTileEntity(new BlockPos(x, y, z)));
      default:
//        throw new Error("wtf");
    }
    return null;
  }

  @Nullable
  @Override
  public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
    switch (ID) {
      case BLOCK_ANALYZER:
        return new GuiBlockAnalyzer(player.inventory, (TileEntityAnalyzer) world.getTileEntity(new BlockPos(x, y, z)));
      default:
//        throw new Error("wtf");
    }
    return null;
  }
}