package net.eskimo.voiditemod.worldgen.biome.surface;

import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

import static net.minecraft.world.level.levelgen.SurfaceRules.stoneDepthCheck;

public class ModSurfaceRules {
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource VOIDITE = makeStateRule(ModBlocks.BLOCK_OF_VOIDITE.get());
    private static final SurfaceRules.RuleSource RAW_VOIDITE = makeStateRule(ModBlocks.VOIDITE_ORE.get());
    private static final SurfaceRules.RuleSource CHORUS_TURF = makeStateRule(ModBlocks.SUNCROWN_TURF.get());
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource END_SLUDGE = makeStateRule(ModBlocks.END_SLUDGE.get());
    private static final SurfaceRules.RuleSource SAGE_MOSS = makeStateRule(ModBlocks.SAGE_MOSS.get());
    private static final SurfaceRules.RuleSource AMINARIA = makeStateRule(ModBlocks.AMINARIA_REGOLITH.get());
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);

    public static final SurfaceRules.ConditionSource EXTREMELY_DEEP_UNDER_FLOOR;
    public static final SurfaceRules.ConditionSource NO_UNDER_FLOOR;

    static {
        EXTREMELY_DEEP_UNDER_FLOOR = stoneDepthCheck(0, true, 55, CaveSurface.FLOOR);
        NO_UNDER_FLOOR = stoneDepthCheck(0, true, 250, CaveSurface.FLOOR);
    }


    public static SurfaceRules.RuleSource makeRules() {
        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);

        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);

        return SurfaceRules.sequence(
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SUNCROWN_PLAINS),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CHORUS_TURF))),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SUNCROWN_PLAINS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, END_SLUDGE))),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SAGE_FOREST),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SAGE_MOSS))),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SUNCROWN_FOREST),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, CHORUS_TURF))),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.SUNCROWN_FOREST),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, END_SLUDGE))),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMINARIA_PIT),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, AIR))),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMINARIA_PIT),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, AMINARIA))),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMINARIA_PIT),
                                SurfaceRules.ifTrue(ModSurfaceRules.NO_UNDER_FLOOR, AIR))),


                /* to remove a biomes floor fully
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMINARIA_PIT),
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, AIR))),

                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMINARIA_PIT),
                                SurfaceRules.ifTrue(ModSurfaceRules.NO_UNDER_FLOOR, AIR))),
                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.AMINARIA_PIT),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, AMINARIA))),
                */


                        // Default to stone surface
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, STONE));
    }


    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }
}