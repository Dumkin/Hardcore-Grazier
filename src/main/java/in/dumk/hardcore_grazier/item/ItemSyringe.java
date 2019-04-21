package in.dumk.hardcore_grazier.item;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemSyringe extends Item {
  public ItemSyringe(String name) {
    this.setRegistryName(name);
    this.setUnlocalizedName(HardcoreGrazier.MODID + "." + name);

    this.maxStackSize = 1;

    setCreativeTab(HardcoreGrazier.Tab);
  }

  @SideOnly(Side.CLIENT)
  @Override
  public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
//    if (stack.hasTagCompound() && stack.getTagCompound().hasKey("Jump Strength")) {
//      tooltip.add("Jump Strength: " + stack.getTagCompound().getDouble("Jump Strength"));
//      tooltip.add("Max Health: " + stack.getTagCompound().getFloat("Max Health"));
//      tooltip.add("Movement Speed: " + stack.getTagCompound().getDouble("Movement Speed"));
//      tooltip.add("Information need analyze");
//    } else {
//      tooltip.add("Click to horse to get DNA");
//    }
    tooltip.add("Click to horse to get DNA");
  }
}