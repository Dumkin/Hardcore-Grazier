package in.dumk.dshop;

import in.dumk.dshop.proxy.CommonProxy;
import in.dumk.dshop.tabs.TabMain;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = dShopMod.MODID, name = dShopMod.NAME, version = dShopMod.VERSION, useMetadata = dShopMod.USEMETADATA)
public class dShopMod {
    public static final String MODID = "dshop";
    public static final String NAME = "dShop";
    public static final String VERSION = "1.0.0";
    public static final boolean USEMETADATA = true;

    @SidedProxy(clientSide = "in.dumk.dshop.proxy.ClientProxy", serverSide = "in.dumk.dshop.proxy.CommonProxy")
    public static CommonProxy proxy;

    private static Logger logger;

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