package in.dumk.hardcore_grazier.container;

import in.dumk.hardcore_grazier.container.slot.SlotItemHandlerBlocked;
import in.dumk.hardcore_grazier.container.slot.SlotItemHandlerWhiteList;
import in.dumk.hardcore_grazier.tile.TileEntityAnalyzer;
import in.dumk.hardcore_grazier.util.HardcoreGrazierItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class ContainerBlockAnalyzer extends Container {
  public ContainerBlockAnalyzer(IInventory playerInv, TileEntityAnalyzer te) {
    IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);

    Item[] whitelist = {HardcoreGrazierItems.SYRINGE_BLOOD};

    this.addSlotToContainer(new SlotItemHandlerWhiteList(whitelist, handler, 0, 62 + 0 * 18, 17 + 1 * 18));
    this.addSlotToContainer(new SlotItemHandlerBlocked(handler, 1, 62 + 2 * 18, 17 + 1 * 18));

    int xPos = 8;
    int yPos = 84;

    for (int y = 0; y < 3; ++y) {
      for (int x = 0; x < 9; ++x) {
        this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xPos + x * 18, yPos + y * 18));
      }
    }

    for (int x = 0; x < 9; ++x) {
      this.addSlotToContainer(new Slot(playerInv, x, xPos + x * 18, yPos + 58));
    }
  }

  @Override
  public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
    int inventoryStart = TileEntityAnalyzer.itemsCount;
    int inventoryEnd = inventoryStart + 26;
    int hotbarStart = inventoryEnd + 1;
    int hotbarEnd = hotbarStart + 8;

    Slot theSlot = this.inventorySlots.get(slot);

    if (theSlot != null && theSlot.getHasStack()) {
      ItemStack newStack = theSlot.getStack();
      ItemStack currentStack = newStack.copy();

      // Other Slots in Inventory excluded
      if (slot >= inventoryStart) {
        // Shift from Inventory
        if (newStack.getItem() == HardcoreGrazierItems.SYRINGE_BLOOD) {
          if (!this.mergeItemStack(newStack, 0, 1, false)) {
            return ItemStack.EMPTY;
          }
        } else if (slot <= inventoryEnd) {
          if (!this.mergeItemStack(newStack, hotbarStart, hotbarEnd + 1, false)) {
            return ItemStack.EMPTY;
          }
        } else if (slot < hotbarEnd + 1 && !this.mergeItemStack(newStack, inventoryStart, inventoryEnd + 1, false)) {
          return ItemStack.EMPTY;
        }
      } else if (!this.mergeItemStack(newStack, inventoryStart, hotbarEnd + 1, false)) {
        return ItemStack.EMPTY;
      }

      if (newStack.isEmpty()) {
        theSlot.putStack(ItemStack.EMPTY);
      } else {
        theSlot.onSlotChanged();
      }

      if (newStack.getCount() == currentStack.getCount()) {
        return ItemStack.EMPTY;
      }
      theSlot.onTake(player, newStack);

      return currentStack;
    }
    return ItemStack.EMPTY;
  }

  @Override
  public boolean canInteractWith(EntityPlayer playerIn) {
    return !playerIn.isSpectator();
  }
}