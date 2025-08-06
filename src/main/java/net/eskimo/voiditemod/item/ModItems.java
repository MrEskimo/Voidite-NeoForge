package net.eskimo.voiditemod.item;

import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.world.item.Item;
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

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
