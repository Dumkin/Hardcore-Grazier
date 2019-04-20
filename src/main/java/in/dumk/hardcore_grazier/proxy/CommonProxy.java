package in.dumk.hardcore_grazier.proxy;

import in.dumk.hardcore_grazier.entity.ClickEventHandler;
import in.dumk.hardcore_grazier.HardcoreGrazier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
  public void preInit(FMLPreInitializationEvent event) {
    HardcoreGrazier.logger.info("\u001B[32m" + "[PRE-INITIALIZATION]" + "\u001B[0m");
    HardcoreGrazier.logger.info("\u001B[32m" + event.getModConfigurationDirectory() + "\u001B[0m");

    MinecraftForge.EVENT_BUS.register(new ClickEventHandler());
  }

  public void init(FMLInitializationEvent event) {
    HardcoreGrazier.logger.info("\u001B[32m" + "[INITIALIZATION]" + "\u001B[0m");
  }

  public void postInit(FMLPostInitializationEvent event) {
    HardcoreGrazier.logger.info("\u001B[32m" + "[POST-INITIALIZATION]" + "\u001B[0m");
  }
}