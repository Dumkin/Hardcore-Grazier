package in.dumk.hardcore_grazier.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TileEntityAnalyzer extends TileEntity implements ICapabilityProvider {

  private ItemStackHandler handler;
  private int count;

  public TileEntityAnalyzer() {
    count = 0;
    handler = new ItemStackHandler(9);
  }

  @Override
  public void readFromNBT(NBTTagCompound compound) {
    count = compound.getInteger("count");
    handler.deserializeNBT(compound.getCompoundTag("handler"));

    super.readFromNBT(compound);
  }

  @Override
  public NBTTagCompound writeToNBT(NBTTagCompound compound) {
    compound.setInteger("count", count);
    compound.setTag("handler", handler.serializeNBT());

    return super.writeToNBT(compound);
  }

  public int getCount() {
    return this.count;
  }

  public void incrementCount() {
    this.count++;
    this.markDirty();
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
}