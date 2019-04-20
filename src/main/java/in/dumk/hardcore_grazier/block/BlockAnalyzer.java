package in.dumk.hardcore_grazier.block;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import in.dumk.hardcore_grazier.tile.TileEntityAnalyzer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAnalyzer extends Block {
  public BlockAnalyzer(String name) {
    super(Material.IRON);

    this.setRegistryName(name);
    this.setUnlocalizedName(getRegistryName().toString());

    setCreativeTab(HardcoreGrazier.Tab);
  }

  @SideOnly(Side.CLIENT)
  public BlockRenderLayer getBlockLayer() {
    return BlockRenderLayer.CUTOUT;
  }

  @Override
  public boolean hasTileEntity(IBlockState state) {
    return true;
  }

  @Override
  public TileEntity createTileEntity(World world, IBlockState state) {
    return new TileEntityAnalyzer();
  }

  @Override
  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
//    if (!worldIn.isRemote) {
//      TileEntityCoalGenerator press = (TileEntityCoalGenerator)world.getTileEntity(pos);
//      if (press != null) {
//        player.openGui(HardcoreGrazier.INSTANCE, GuiHandler.GuiTypes.COAL_GENERATOR.ordinal(), world, pos.getX(), pos.getY(), pos.getZ());
//      }
//      return true;
//    }
    return true;
  }
}