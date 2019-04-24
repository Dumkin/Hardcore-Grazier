package in.dumk.hardcore_grazier.container.slot;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

import java.util.stream.Stream;

public class SlotItemHandlerWhiteList extends SlotItemHandler {
  private Item[] whitelist;

  public SlotItemHandlerWhiteList(Item[] whitelist, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
    super(itemHandler, index, xPosition, yPosition);

    this.whitelist = whitelist;
  }

  public SlotItemHandlerWhiteList(Item whitelist, IItemHandler itemHandler, int index, int xPosition, int yPosition) {
    super(itemHandler, index, xPosition, yPosition);

    this.whitelist = new Item[]{whitelist};
  }

  @Override
  public boolean isItemValid(ItemStack stack) {
    return Stream.of(whitelist).anyMatch(x -> x == stack.getItem());
  }
}