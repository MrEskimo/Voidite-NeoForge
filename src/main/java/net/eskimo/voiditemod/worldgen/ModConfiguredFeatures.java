package net.eskimo.voiditemod.worldgen;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.block.custom.SincehePotatoCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.HugeFungusConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_VOIDITE_ORE_KEY = registerKey("end_voidite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VOID_GRASS_PATCH_KEY = registerKey("void_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SHORT_SC_GRASS_PATCH_KEY = registerKey("short_sc_grass_patch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GLOWING_VOID_BERRY_BUSH_KEY = registerKey("glowing_void_berry_bush");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SLUDGE_DISK_KEY = registerKey("end_sludge_disk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_STONE_DISK_KEY = registerKey("end_stone_disk");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SINCEHE_POTATO_KEY = registerKey("sincehe_potato");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SUNCROWN_SAND_BLOB = registerKey("sand_blob");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SUNCROWN_OAK_KEY = registerKey("suncrown_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GREEN_WART_KEY = registerKey("green");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        BlockPredicate blockpredicate = BlockPredicate.matchesBlocks(
                Blocks.END_STONE,
                ModBlocks.SUNCROWN_TURF.get()
        );


        register(context, END_VOIDITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.VOIDITE_ORE.get().defaultBlockState(), 6));

        register(context, VOID_GRASS_PATCH_KEY, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(
                SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.SUNCROWN_GRASS.get().defaultBlockState(), 5)
                        .add(ModBlocks.FLOWERING_SUNCROWN_GRASS.get().defaultBlockState(), 1)), 128));

        register(context, SHORT_SC_GRASS_PATCH_KEY, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(ModBlocks.SHORT_SUNCROWN_GRASS.get()), 64));

        register(context, GLOWING_VOID_BERRY_BUSH_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.GLOWING_VOID_BERRY_BUSH.get()
                                        .defaultBlockState().setValue(SweetBerryBushBlock.AGE, 3))
                        ), List.of(Blocks.GRASS_BLOCK, ModBlocks.SUNCROWN_TURF.get())));

        register(context, SINCEHE_POTATO_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.SINCEHE_POTATO_CROP.get()
                                        .defaultBlockState().setValue(SincehePotatoCropBlock.AGE, 4))
                        ), List.of(ModBlocks.SUNCROWN_TURF.get())));
        register(context, END_SLUDGE_DISK_KEY, Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(ModBlocks.END_SLUDGE.get()),
                        blockpredicate,
                        UniformInt.of(2, 6),2));

        register(context, END_STONE_DISK_KEY, Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.END_STONE),
                        blockpredicate,
                        UniformInt.of(2,3),1));



        register(context, SUNCROWN_OAK_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.SUNCROWN_OAK_LOG.get()),
                new ForkingTrunkPlacer(2, 5, 6),

                BlockStateProvider.simple(ModBlocks.SUNCROWN_OAK_LEAVES.get()),
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(2), 2),

                new TwoLayersFeatureSize(1, 0, 2)).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build());

        register(context, GREEN_WART_KEY, Feature.HUGE_FUNGUS, new HugeFungusConfiguration( //Make a custom configurator
                ModBlocks.SUNCROWN_TURF.get().defaultBlockState(), //Plant on
                ModBlocks.SAGE_STEM.get().defaultBlockState(), //Stem
                ModBlocks.SAGE_WART_BLOCK.get().defaultBlockState(), //Cap
                ModBlocks.BLOCK_OF_VOIDITE.get().defaultBlockState(), //Fruit
                blockpredicate, //Can replace
                false

        ));


        register(context, SUNCROWN_SAND_BLOB, Feature.REPLACE_BLOBS,
                new ReplaceSphereConfiguration(Blocks.END_STONE.defaultBlockState(),
                        ModBlocks.SUNCROWN_SAND.get().defaultBlockState(), UniformInt.of(3, 7)));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider pStateProvider, int pTries) {
        return FeatureUtils.simpleRandomPatchConfiguration(pTries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(pStateProvider)));
    }
}