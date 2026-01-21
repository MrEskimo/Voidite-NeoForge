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
                        output.accept(ModBlocks.END_SLUDGE.get());

                        output.accept(ModBlocks.PACKED_END_SLUDGE.get());
                        output.accept(ModBlocks.PACKED_END_SLUDGE_STAIRS.get());
                        output.accept(ModBlocks.PACKED_END_SLUDGE_SLAB.get());
                        output.accept(ModBlocks.PACKED_END_SLUDGE_WALL.get());

                        output.accept(ModBlocks.END_SLUDGE_BRICKS.get());
                        output.accept(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get());
                        output.accept(ModBlocks.END_SLUDGE_BRICKS_SLAB.get());
                        output.accept(ModBlocks.END_SLUDGE_BRICKS_WALL.get());

                        output.accept(ModBlocks.SUNCROWN_TURF.get());
                        output.accept(ModBlocks.SUNCROWN_GRASS.get());
                        output.accept(ModBlocks.SHORT_SUNCROWN_GRASS.get());
                        output.accept(ModBlocks.FLOWERING_SUNCROWN_GRASS.get());

                        output.accept(ModBlocks.END_STONE_BRICK_PILLAR.get());
                        output.accept(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get());

                        output.accept(ModBlocks.VOIDITE_ORE.get());
                        output.accept(ModItems.RAW_VOIDITE.get());
                        output.accept(ModItems.VOIDITE_INGOT.get());
                        output.accept(ModBlocks.BLOCK_OF_VOIDITE.get());
                        output.accept(ModItems.VOIDITE_PLATE.get());

                        output.accept(ModBlocks.PURPUR_LIGHT.get());

                        output.accept(ModItems.GLOWING_VOID_BERRIES.get());

                        output.accept(ModItems.SINCEHE_POTATO.get());
                        output.accept(ModItems.SINCEHE_POTATO_SEEDS.get());

                        output.accept(ModBlocks.CELESTALEE.get());
                        output.accept(ModBlocks.DHADE.get());
                        output.accept(ModItems.FORGE_SCALES.get());

                        output.accept(ModItems.ANNEALED_VOIDITE_INGOT.get());
                        output.accept(ModItems.ANNEALED_VOIDITE_PLATE.get());

                        output.accept(ModBlocks.SUNCROWN_OAK_LOG.get());

                        output.accept(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_SAPLING.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_LEAVES.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_PLANKS.get());

                        output.accept(ModBlocks.SUNCROWN_OAK_STAIRS.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_SLAB.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_FENCE.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_FENCE_GATE.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_DOOR.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_TRAPDOOR.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SUNCROWN_OAK_BUTTON.get());

                        output.accept(ModBlocks.SUNCROWN_SAND.get());
                        output.accept(ModBlocks.SUNCROWN_SANDSTONE.get());
                        output.accept(ModBlocks.SUNCROWN_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.SUNCROWN_SANDSTONE_SLAB.get());

                        output.accept(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE.get());
                        output.accept(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE_SLAB.get());

                        output.accept(ModBlocks.SAGE_FUNGUS.get());
                        output.accept(ModBlocks.SAGE_WART_BLOCK.get());
                        output.accept(ModBlocks.SAGE_STEM.get());

                        output.accept(ModBlocks.SAGE_PLANKS.get());
                        output.accept(ModBlocks.SAGE_SLAB.get());
                        output.accept(ModBlocks.SAGE_STAIRS.get());

                        output.accept(ModBlocks.SAGE_BUTTON.get());
                        output.accept(ModBlocks.SAGE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.SAGE_FENCE.get());
                        output.accept(ModBlocks.SAGE_FENCE_GATE.get());

                        output.accept(ModBlocks.SAGE_DOOR.get());
                        output.accept(ModBlocks.SAGE_TRAPDOOR.get());

                        output.accept(ModBlocks.HARD_SAGE_FRUIT.get());
                        output.accept(ModBlocks.TREATED_SAGE_FRUIT.get());

                        output.accept(ModBlocks.SAGE_MOSS.get());
                        output.accept(ModBlocks.SAGE_GRASS.get());
                        output.accept(ModBlocks.SAGE_BLOOM.get());


                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
