package net.eskimo.voiditemod.worldgen;

import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.KelpFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.xml.catalog.CatalogFeatures;
import java.util.function.Supplier;

public class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(BuiltInRegistries.FEATURE, VoiditeMod.MOD_ID);

    public static final Supplier<Feature<CreepingVinesConfig>> CREEPING_VINES = FEATURES.register("creeping_vines",
            () -> new CreepingVinesFeature(CreepingVinesConfig.CODEC));

    public static void register(IEventBus eventBus) {FEATURES.register(eventBus);}
}
