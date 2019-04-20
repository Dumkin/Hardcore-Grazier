package in.dumk.hardcore_grazier;

import in.dumk.hardcore_grazier.proxy.CommonProxy;
import in.dumk.hardcore_grazier.tabs.TabMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = HardcoreGrazier.MODID, name = HardcoreGrazier.NAME, version = HardcoreGrazier.VERSION, useMetadata = HardcoreGrazier.USEMETADATA)
public class HardcoreGrazier {
    public static final String MODID = "hardcore_grazier";
    public static final String NAME = "Hardcore Grazier";
    public static final String VERSION = "1.0.0";
    public static final boolean USEMETADATA = true;

    @SidedProxy(clientSide = "in.dumk.hardcore_grazier.proxy.ClientProxy", serverSide = "in.dumk.hardcore_grazier.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    public static final CreativeTabs Tab = new TabMain("main");

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}