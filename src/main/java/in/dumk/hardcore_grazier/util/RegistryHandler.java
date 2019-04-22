package in.dumk.hardcore_grazier.util;

import in.dumk.hardcore_grazier.block.BlockAnalyzer;
import in.dumk.hardcore_grazier.item.ItemDecodedDNA;
import in.dumk.hardcore_grazier.item.ItemSyringe;
import in.dumk.hardcore_grazier.item.ItemSyringeBlood;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
  @SubscribeEvent
  public static void registerBlocks(Register<Block> event) {
    final Block[] blocks = {
      new BlockAnalyzer("analyzer")
    };

    event.getRegistry().registerAll(blocks);
  }

  @SubscribeEvent
  public static void registerItems(Register<Item> event) {
    final Item[] items = {
      new ItemSyringe("syringe"),
      new ItemSyringeBlood("syringe_blood"),
      new ItemDecodedDNA("decoded_dna")
    };
    final Item[] itemBlocks = {
      new ItemBlock(HardcoreGrazierBlocks.ANALYZER).setRegistryName(HardcoreGrazierBlocks.ANALYZER.getRegistryName())
    };

    event.getRegistry().registerAll(items);
    event.getRegistry().registerAll(itemBlocks);
  }
}