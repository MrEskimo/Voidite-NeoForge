package net.eskimo.voiditemod.item;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoiditeMod.MOD_ID);

    public static final DeferredItem<Item> SMILE = ITEMS.register("smile",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_VOIDITE = ITEMS.register("raw_voidite",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> VOIDITE_INGOT = ITEMS.register("voidite_ingot",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final DeferredItem<Item> GLOWING_VOID_BERRIES = ITEMS.register("glowing_void_berries",
            () -> new ItemNameBlockItem(ModBlocks.GLOWING_VOID_BERRY_BUSH.get(), new Item.Properties().food(ModFoodProperties.GLOWING_VOID_BERRY)));

    public static final DeferredItem<Item> SINCEHE_POTATO = ITEMS.register("sincehe_potato",
            () -> new Item(new Item.Properties().food(ModFoodProperties.SINCEHE_POTATO)));
    public static final DeferredItem<Item> SINCEHE_POTATO_SEEDS = ITEMS.register("sincehe_potato_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SINCEHE_POTATO_CROP.get(), new Item.Properties()));

    public static final DeferredItem<Item> FORGE_SCALES = ITEMS.register("forge_scales",
            () -> new Item(new Item.Properties().fireResistant()));
    public static final DeferredItem<Item> VOIDITE_PLATE = ITEMS.register("voidite_plate",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ANNEALED_VOIDITE_INGOT = ITEMS.register("annealed_voidite_ingot",
            () -> new Item(new Item.Properties()));
    //.durability(800)
    public static final DeferredItem<Item> ANNEALED_VOIDITE_PLATE = ITEMS.register("annealed_voidite_plate",
            () -> new Item(new Item.Properties()));
    //.durability(1000)


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
