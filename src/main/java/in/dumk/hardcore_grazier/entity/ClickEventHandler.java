package in.dumk.hardcore_grazier.entity;

import in.dumk.hardcore_grazier.HardcoreGrazier;
import in.dumk.hardcore_grazier.item.ItemInjector;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClickEventHandler {
  @SubscribeEvent
  public void onEntityRightClicked(PlayerInteractEvent.EntityInteract event) {
    ItemStack item = event.getEntityPlayer().inventory.getCurrentItem();

    if (item.getItem() instanceof ItemInjector == false) {
      return;
    }
    if (event.getTarget() instanceof EntityHorse == false) {
      return;
    }

    EntityHorse horse = (EntityHorse)event.getTarget();

    horse.attackEntityFrom(new DamageSource("Injector"),2f);

    HardcoreGrazier.logger.info("\u001B[32m" + "Get DNA" + "\u001B[0m");
    // TODO: Called twice
    HardcoreGrazier.logger.info("\u001B[32m" + "Horse HP: " + horse.getHealth() + "\u001B[0m");

    double mov_sp = horse.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();

    NBTTagCompound nbt;
    if (item.hasTagCompound()) {
      nbt = item.getTagCompound();
    } else {
      nbt = new NBTTagCompound();
    }

    nbt.setDouble("Jump Strength", horse.getHorseJumpStrength());
    nbt.setFloat("Max Health", horse.getMaxHealth());
    nbt.setDouble("Movement Speed", mov_sp);

    item.setTagCompound(nbt);
  }
}