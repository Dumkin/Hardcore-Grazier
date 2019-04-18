package in.dumk.dshop;

import in.dumk.dshop.item.ItemInjector;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsRegister {
  public static ItemInjector INJECTOR = new ItemInjector("injector");

  public static void register()
  {
    setRegister(INJECTOR);
  }

  @SideOnly(Side.CLIENT)
  public static void registerRender()
  {
//    setRender(INJECTOR);
    INJECTOR.registerModel();
  }

  private static void setRegister(Item item)
  {
    ForgeRegistries.ITEMS.register(item);
  }

//  @SideOnly(Side.CLIENT)
//  private static void setRender(Item item)
//  {
//    item.reg
//  }
}