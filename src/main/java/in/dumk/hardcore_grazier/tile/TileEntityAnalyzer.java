package in.dumk.hardcore_grazier.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityAnalyzer extends TileEntity {

  private int count;

  public TileEntityAnalyzer() {
    count = 0;
  }

  @Override
  public void readFromNBT(NBTTagCompound compound) {
    count = compound.getInteger("count");

    super.readFromNBT(compound);
  }

  @Override
  public NBTTagCompound writeToNBT(NBTTagCompound compound) {
    compound.setInteger("count", count);

    return super.writeToNBT(compound);
  }

  public int getCount() {
    return this.count;
  }

  public void incrementCount() {
    this.count++;
    this.markDirty();
  }
}