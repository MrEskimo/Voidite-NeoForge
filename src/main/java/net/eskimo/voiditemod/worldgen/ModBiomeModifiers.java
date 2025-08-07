package net.eskimo.voiditemod.worldgen;

import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModBiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_END_VOIDITE_ORE = registerKey("add_end_voidite_ore");
    public static final ResourceKey<BiomeModifier> ADD_GLOWING_VOID_BERRY_BUSH = registerKey("add_glowing_void_berry_bush");
    public static final ResourceKey<BiomeModifier> ADD_VOID_GRASS_PATCH = registerKey("add_void_grass_patch");
    public static final ResourceKey<BiomeModifier> ADD_END_SLUDGE_DISK = registerKey("add_end_sludge_disk");


    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        var placedFeature = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

      //  context.register(ADD_END_VOIDITE_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
      //          biomes.getOrThrow(BiomeTags.IS_END),
      //          HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.END_VOIDITE_ORE_PLACED_KEY)),
      //          GenerationStep.Decoration.UNDERGROUND_ORES));
//
      //  context.register(ADD_GLOWING_VOID_BERRY_BUSH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
      //          HolderSet.direct(biomes.getOrThrow(Biomes.)),
      //          HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.GLOWING_VOID_BERRY_BUSH_PLACED_KEY)),
      //          GenerationStep.Decoration.VEGETAL_DECORATION));
//
      //  context.register(ADD_VOID_GRASS_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
      //          HolderSet.direct(biomes.getOrThrow(Biomes.)),
      //          HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.VOID_GRASS_PATCH_PLACED_KEY)),
      //          GenerationStep.Decoration.VEGETAL_DECORATION));
//
      //  context.register(ADD_END_SLUDGE_DISK, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
      //          HolderSet.direct(biomes.getOrThrow(Biomes.)),
      //          HolderSet.direct(placedFeature.getOrThrow(ModPlacedFeatures.END_SLUDGE_DISK_PLACED_KEY)),
      //          GenerationStep.Decoration.UNDERGROUND_ORES));


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
    }
}
