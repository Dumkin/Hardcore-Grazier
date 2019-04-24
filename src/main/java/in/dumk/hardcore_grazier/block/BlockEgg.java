package in.dumk.hardcore_grazier.block;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockEgg extends Block {
  public BlockEgg(String name) {
    super(Material.CAKE);

    this.setSoundType(SoundType.CLOTH);
    this.setRegistryName(name);
    this.setUnlocalizedName(HardcoreGrazier.MODID + "." + name);

    setCreativeTab(HardcoreGrazier.Tab);
  }

  @Override
  public boolean isOpaqueCube(IBlockState state) {
    return false;
  }
}