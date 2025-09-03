package net.eskimo.voiditemod.worldgen;

import com.google.common.collect.ImmutableList;
import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> END_VOIDITE_ORE_PLACED_KEY = registerKey("end_voidite_ore_placed_key");
    public static final ResourceKey<PlacedFeature> GLOWING_VOID_BERRY_BUSH_PLACED_KEY = registerKey("glowing_void_berry_bush_placed_key");
    public static final ResourceKey<PlacedFeature> VOID_GRASS_PATCH_PLACED_KEY = registerKey("void_grass_patch_placed_key");
    public static final ResourceKey<PlacedFeature> SHORT_SC_GRASS_PATCH_PLACED_KEY = registerKey("short_sc_grass_patch_placed_key");
    public static final ResourceKey<PlacedFeature> END_SLUDGE_DISK_PLACED_KEY = registerKey("end_sludge_disk_placed_key");
    public static final ResourceKey<PlacedFeature> END_STONE_DISK_PLACED_KEY = registerKey("end_stone_disk_placed_key");
    public static final ResourceKey<PlacedFeature> SUNCROWN_OAK_PLAINS_PLACED_KEY = registerKey("suncrown_oak_placed_key");
    public static final ResourceKey<PlacedFeature> SINCEHE_POTATO_PLACE_KEY = registerKey("sincehe_potato_placed_key");
    public static final ResourceKey<PlacedFeature> SUNCROWN_OAK_FOREST_PLACED_KEY = registerKey("suncrown_oak_forest_placed_key");
    public static final ResourceKey<PlacedFeature> SUNCROWN_SAND_PLACED_KEY = registerKey("suncrown_sand_placed_key");



    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, END_VOIDITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_VOIDITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(19,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, GLOWING_VOID_BERRY_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GLOWING_VOID_BERRY_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, VOID_GRASS_PATCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VOID_GRASS_PATCH_KEY),
                ImmutableList.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, SHORT_SC_GRASS_PATCH_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SHORT_SC_GRASS_PATCH_KEY),
                ImmutableList.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, END_SLUDGE_DISK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_SLUDGE_DISK_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));
        register(context, END_STONE_DISK_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_STONE_DISK_KEY),
                List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));

        register(context, SUNCROWN_OAK_PLAINS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUNCROWN_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(0, 0.1f, 2),
                        ModBlocks.SUNCROWN_OAK_SAPLING.get()));

        register(context, SUNCROWN_OAK_FOREST_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUNCROWN_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10,0.1f,2),
                        ModBlocks.SUNCROWN_OAK_SAPLING.get()));

        register(context, SINCEHE_POTATO_PLACE_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SINCEHE_POTATO_KEY),
                List.of(RarityFilter.onAverageOnceEvery(24), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));

        register(context, SUNCROWN_SAND_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SUNCROWN_SAND_BLOB),
                List.of(RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));


    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
