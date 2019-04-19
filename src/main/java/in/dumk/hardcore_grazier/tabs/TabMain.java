package in.dumk.hardcore_grazier.tabs;

import in.dumk.hardcore_grazier.ItemsRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class TabMain extends CreativeTabs {
  public TabMain(String label){
    super(label);
  }

  @Override
  public ItemStack getTabIconItem() {
    return new ItemStack(ItemsRegister.INJECTOR);
  }
}