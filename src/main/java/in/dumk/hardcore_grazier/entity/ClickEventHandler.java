package in.dumk.hardcore_grazier.entity;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import in.dumk.hardcore_grazier.item.ItemSyringe;
import in.dumk.hardcore_grazier.item.ItemSyringeBlood;
import in.dumk.hardcore_grazier.util.HardcoreGrazierItems;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClickEventHandler {
  @SubscribeEvent
  public void onEntityRightClicked(PlayerInteractEvent.EntityInteract event) {
    if (event.getWorld().isRemote) {
      return;
    }

    ItemStack item = event.getEntityPlayer().inventory.getCurrentItem();

    if (item.getItem() instanceof ItemSyringe == false) {
      return;
    }
    if (event.getTarget() instanceof EntityHorse == false) {
      return;
    }

    EntityHorse horse = (EntityHorse) event.getTarget();

    horse.attackEntityFrom(new DamageSource("Syringe"), 2f);

    item.shrink(1);
    ItemStack dna = new ItemStack(HardcoreGrazierItems.SYRINGE_BLOOD, 1);

    NBTTagCompound nbt;
    if (dna.hasTagCompound()) {
      nbt = dna.getTagCompound();
    } else {
      nbt = new NBTTagCompound();
    }

    nbt.setDouble("Jump Strength", horse.getHorseJumpStrength());
    nbt.setFloat("Max Health", horse.getMaxHealth());
    nbt.setDouble("Movement Speed", horse.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());

    dna.setTagCompound(nbt);

    event.getEntityPlayer().inventory.addItemStackToInventory(dna);
  }
}