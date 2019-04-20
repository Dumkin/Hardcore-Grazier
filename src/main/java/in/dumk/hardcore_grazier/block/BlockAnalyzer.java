package in.dumk.hardcore_grazier.block;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import in.dumk.hardcore_grazier.gui.GuiHandler;
import in.dumk.hardcore_grazier.tile.TileEntityAnalyzer;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class BlockAnalyzer extends Block {
  public BlockAnalyzer(String name) {
    super(Material.ANVIL);

    this.setSoundType(SoundType.ANVIL);
    this.setRegistryName(name);
    this.setUnlocalizedName(HardcoreGrazier.MODID + "." + name);

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

  // TODO: Wtf method?
  public TileEntityAnalyzer getTileEntity(IBlockAccess world, BlockPos position) {
    return (TileEntityAnalyzer) world.getTileEntity(position);
  }

  // TODO: wtf code
  // https://www.youtube.com/watch?v=4Y_9B58vbPw&list=PLpKu3PfwdqHRA8aoa4RAzO9camNR9Tm45&index=21
  // 7:29

  @Override
  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
    if (!worldIn.isRemote) {
//      TileEntityCoalGenerator press = (TileEntityCoalGenerator)world.getTileEntity(pos);
//      if (press != null) {
      playerIn.openGui(HardcoreGrazier.INSTANCE, GuiHandler.BLOCK_ANALYZER, worldIn, pos.getX(), pos.getY(), pos.getZ());
//      }
//      return true;
    }
//    return true;

//    if (!worldIn.isRemote) {
//      TileEntityAnalyzer tileEntity = getTileEntity(worldIn, pos);
//      if (facing == EnumFacing.UP) {
//        tileEntity.incrementCount();
//      }
//      playerIn.sendMessage(new TextComponentString("Count: " + tileEntity.getCount()));
//    }
//    return true;

    return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
  }

  @Override
  public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
    TileEntityAnalyzer tile = (TileEntityAnalyzer)worldIn.getTileEntity(pos);
    IItemHandler handler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

    for (int slot = 0; slot < handler.getSlots() - 1; slot++) {
      ItemStack stack = handler.getStackInSlot(slot);
      InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
    }

    super.breakBlock(worldIn, pos, state);
  }
}