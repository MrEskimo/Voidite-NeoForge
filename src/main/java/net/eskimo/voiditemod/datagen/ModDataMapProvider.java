package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class ModDataMapProvider extends DataMapProvider {
    protected ModDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(ModItems.SMILE.getId(), new FurnaceFuel(1200), false);

    // public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
   //         .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
   //         .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
   //         .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
   //         .add(Registries.BIOME, ModBiomes::boostrap);

    }
}
