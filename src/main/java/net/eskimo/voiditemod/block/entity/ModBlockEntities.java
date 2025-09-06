package net.eskimo.voiditemod.block.entity;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, VoiditeMod.MOD_ID);

    public static final Supplier<BlockEntityType<CelestaleeFurnaceBlockEntity>> CELESTALEE_FURNACE_BE =
            BLOCK_ENTITIES.register("celestalee_furnace_be", () -> BlockEntityType.Builder.of(
                    CelestaleeFurnaceBlockEntity::new, ModBlocks.CELESTALEE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
