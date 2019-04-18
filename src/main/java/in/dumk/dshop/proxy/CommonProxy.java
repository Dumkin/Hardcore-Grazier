package in.dumk.dshop.proxy;

import in.dumk.dshop.ItemsRegister;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
  public void preInit(FMLPreInitializationEvent event)
  {
    System.out.println("\u001B[32m" + "[Starting Test Mod PRE-INITIALIZATION]" + "\u001B[0m");
    System.out.println("\u001B[32m" + event.getModConfigurationDirectory() + "\u001B[0m");

    ItemsRegister.register();
  }

  public void init(FMLInitializationEvent event)
  {
    System.out.println("\u001B[32m" + "[Starting Test Mod INITIALIZATION]" + "\u001B[0m");
  }

  public void postInit(FMLPostInitializationEvent event)
  {
    System.out.println("\u001B[32m" + "[Starting Test Mod POST-INITIALIZATION]" + "\u001B[0m");
  }
}