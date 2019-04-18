package in.dumk.dshop.item;

import in.dumk.dshop.dShopMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemInjector extends Item {
  public ItemInjector(String name) {
    this.setRegistryName(name);
    this.setUnlocalizedName(getRegistryName().toString());

    setCreativeTab(dShopMod.Tab);
  }

  @SideOnly(Side.CLIENT)
  public void registerModel() {
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
  }
}