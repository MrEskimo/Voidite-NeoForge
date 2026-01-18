package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.item.ModItems;
import net.eskimo.voiditemod.worldgen.ModBiomeModifiers;
import net.eskimo.voiditemod.worldgen.ModConfiguredFeatures;
import net.eskimo.voiditemod.worldgen.ModPlacedFeatures;
import net.eskimo.voiditemod.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }
        public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
           .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
           .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
           .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
           .add(Registries.BIOME, ModBiomes::boostrap);
}
