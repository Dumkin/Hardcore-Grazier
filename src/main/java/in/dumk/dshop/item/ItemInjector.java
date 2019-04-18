package in.dumk.dshop.item;

import in.dumk.dshop.dShopMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInjector extends Item
{
  public ItemInjector(String name)
  {
    this.setRegistryName(name);
    this.setUnlocalizedName(name);

    System.out.println("\u001B[32m" + name + "\u001B[0m");
    System.out.println("\u001B[32m" + getRegistryName().toString() + "\u001B[0m");

    setCreativeTab(dShopMod.Tab);
  }

  @SideOnly(Side.CLIENT)
  public void registerModel(){
//    ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
//    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("injector", "inventory"));
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
  }
}