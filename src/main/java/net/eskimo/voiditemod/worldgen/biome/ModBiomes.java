/*package net.eskimo.voiditemod.worldgen.biome;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.worldgen.ModPlacedFeatures;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.EndPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import terrablender.api.EndBiomeRegistry;

public class ModBiomes {
    public static final ResourceKey<Biome> TEST_BIOME = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "test_biome"));
    public static final ResourceKey<Biome> SUNCROWN_PLAINS = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "suncrown_plains"));
    public static final ResourceKey<Biome> SUNCROWN_FOREST = ResourceKey.create(Registries.BIOME,
            ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "suncrown_forest"));


    public static void boostrap(BootstrapContext<Biome> context) {

        //HolderGetter<ConfiguredWorldCarver<?>> carverGetter = context.lookup(Registries.CONFIGURED_CARVER);
        //HolderGetter<PlacedFeature> placedFeatureGetter = context.lookup(Registries.PLACED_FEATURE);

       // context.register(TEST_BIOME, testBiome(context));
//context.register(CHORUS_PLAINS, chorusBiome(context));
        register(context, ModBiomes.SUNCROWN_PLAINS, ModBiomes.chorusBiome(context));
        register(context, ModBiomes.SUNCROWN_FOREST, ModBiomes.suncrownForest(context));
    }
    public static void setupTerraBlender()
    {
        registerMidlandsBiome(ModBiomes.SUNCROWN_PLAINS, 4);
        registerHighlandsBiome(ModBiomes.SUNCROWN_FOREST,4);

    }

    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }

    public static void globalEndGeneration(BiomeGenerationSettings.Builder builder) {


    }
/*
    public static Biome testBiome(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        //spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.RHINO.get(), 2, 3, 5));

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        BiomeDefaultFeatures.endSpawns(spawnBuilder);
        //BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addMossyStoneBlock(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.TREES_PLAINS);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        // biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.PINE_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(0xe82e3b)
                        .waterFogColor(0xbf1b26)
                        .skyColor(0x30c918)
                        .grassColorOverride(0x7f03fc)
                        .foliageColorOverride(0xd203fc)
                        .fogColor(0x22a1e6)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
*/
  /*  public static Biome chorusBiome(BootstrapContext<Biome> context) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 5, 4, 4));
        BiomeDefaultFeatures.endSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
        //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
        globalEndGeneration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SINCEHE_POTATO_PLACE_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SUNCROWN_OAK_PLAINS_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, ModPlacedFeatures.SUNCROWN_SAND_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.CHORUS_PLANT);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.END_GATEWAY_RETURN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.END_STONE_DISK_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.END_VOIDITE_ORE_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.END_SLUDGE_DISK_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GLOWING_VOID_BERRY_BUSH_PLACED_KEY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.VOID_GRASS_PATCH_PLACED_KEY);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .downfall(0.8f)
                .temperature(0.7f)
                .generationSettings(biomeBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .specialEffects((new BiomeSpecialEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .skyColor(0)
                        .fogColor(10518688)
                        .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                .build();
    }
        public static Biome suncrownForest(BootstrapContext<Biome> context) {
            MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

            spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 5, 4, 4));
            BiomeDefaultFeatures.endSpawns(spawnBuilder);

            BiomeGenerationSettings.Builder biomeBuilder =
                    new BiomeGenerationSettings.Builder(context.lookup(Registries.PLACED_FEATURE), context.lookup(Registries.CONFIGURED_CARVER));
            //we need to follow the same order as vanilla biomes for the BiomeDefaultFeatures
            globalEndGeneration(biomeBuilder);

            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SINCEHE_POTATO_PLACE_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.SUNCROWN_OAK_FOREST_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.CHORUS_PLANT);
            biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, EndPlacements.END_GATEWAY_RETURN);
            biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.END_STONE_DISK_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.END_VOIDITE_ORE_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ModPlacedFeatures.END_SLUDGE_DISK_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.GLOWING_VOID_BERRY_BUSH_PLACED_KEY);
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, ModPlacedFeatures.VOID_GRASS_PATCH_PLACED_KEY);

            return new Biome.BiomeBuilder()
                    .hasPrecipitation(false)
                    .downfall(0.8f)
                    .temperature(0.7f)
                    .generationSettings(biomeBuilder.build())
                    .mobSpawnSettings(spawnBuilder.build())
                    .specialEffects((new BiomeSpecialEffects.Builder())
                            .waterColor(4159204)
                            .waterFogColor(329011)
                            .skyColor(0)
                            .fogColor(10518688)
                            .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS).build())
                    .build();
        }

    private static void registerHighlandsBiome(ResourceKey<Biome> key, int weight) {
        EndBiomeRegistry.registerHighlandsBiome(key, weight);
    }
    private static void registerMidlandsBiome(ResourceKey<Biome> key, int weight) {
        EndBiomeRegistry.registerMidlandsBiome(key, weight);
    }
    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome)
    {
        context.register(key, biome);
    }

}

   */