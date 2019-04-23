package in.dumk.hardcore_grazier.tile;

import in.dumk.hardcore_grazier.util.HardcoreGrazierItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityAnalyzer extends TileEntity implements ITickable, ICapabilityProvider {

  private ItemStackHandler handler;
  private int processUntil;

  public static final int itemsCount = 2;
  public static final int tickOnItem = 300;

  public TileEntityAnalyzer() {
    this.processUntil = tickOnItem;
    this.handler = new ItemStackHandler(itemsCount);
  }

  @Override
  public void readFromNBT(NBTTagCompound compound) {
    processUntil = compound.getInteger("processUntil");
    handler.deserializeNBT(compound.getCompoundTag("handler"));

    super.readFromNBT(compound);
  }

  @Override
  public NBTTagCompound writeToNBT(NBTTagCompound compound) {
    compound.setInteger("processUntil", processUntil);
    compound.setTag("handler", handler.serializeNBT());

    return super.writeToNBT(compound);
  }

  public String getProgress() {
    return String.format("%.1f%%", ((this.tickOnItem - this.processUntil) * 100.0f) / this.tickOnItem);
  }

  @Override
  public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
    if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return true;
    }

    return super.hasCapability(capability, facing);
  }

  @Override
  @Nullable
  public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
    if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
      return (T) handler;
    }

    return super.getCapability(capability, facing);
  }

  @Override
  public void update() {
    if (this.handler.getStackInSlot(0).isEmpty()) {
      this.processUntil = tickOnItem;
      this.markDirty();
    } else if (this.handler.getStackInSlot(0).getItem() == HardcoreGrazierItems.SYRINGE_BLOOD && this.handler.getStackInSlot(1).isEmpty()){
      this.processUntil--;
      this.markDirty();
    }

    if (!this.world.isRemote && this.processUntil == 0) {
      NBTTagCompound nbt;
      ItemStack dna = new ItemStack(HardcoreGrazierItems.DECODED_DNA, 1);
      if (this.handler.getStackInSlot(0).hasTagCompound()) {
        nbt = this.handler.getStackInSlot(0).getTagCompound();
        dna.setTagCompound(nbt);
      }

      this.handler.getStackInSlot(0).shrink(1);
      this.handler.setStackInSlot(1, dna);
      this.markDirty();
    }
  }
}