package in.dumk.hardcore_grazier;

import in.dumk.hardcore_grazier.item.ItemInjector;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemsRegister {
  public static ItemInjector INJECTOR = new ItemInjector("injector");

  public static void register() {
    ForgeRegistries.ITEMS.register(INJECTOR);
  }

  @SideOnly(Side.CLIENT)
  public static void registerRender() {
    INJECTOR.registerModel();
  }
}