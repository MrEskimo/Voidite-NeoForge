package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.util.ModTags;
import net.eskimo.voiditemod.worldgen.biome.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.biome.Biome;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTagGenerator extends TagsProvider<Biome> {

    @SuppressWarnings("deprecation")
    public ModBiomeTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, Registries.BIOME, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider provider) {
        HolderLookup.RegistryLookup<Biome> biomeLookup = provider.lookupOrThrow(Registries.BIOME);
        this.tag(ModTags.Biomes.FOG)
                .add(biomeLookup.getOrThrow(ModBiomes.AMINARIA_PIT).key());
    }
}