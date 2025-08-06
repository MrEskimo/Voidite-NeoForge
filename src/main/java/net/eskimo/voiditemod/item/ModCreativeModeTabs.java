package net.eskimo.voiditemod.item;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, VoiditeMod.MOD_ID);

    public static final Supplier<CreativeModeTab> END_STUFF = CREATIVE_MODE_TAB.register("end_stuff",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.VOIDITE_INGOT.get()))
                    .title(Component.translatable("creativetab.voiditemod.end_stuff"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.VOIDITE_ORE);
                        output.accept(ModItems.RAW_VOIDITE);
                        output.accept(ModItems.VOIDITE_INGOT);


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
