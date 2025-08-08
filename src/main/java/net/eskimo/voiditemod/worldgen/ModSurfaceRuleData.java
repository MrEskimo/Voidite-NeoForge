package net.eskimo.voiditemod.worldgen;

import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.worldgen.biome.ModBiomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;


public class ModSurfaceRuleData {
    private static final SurfaceRules.RuleSource CHORUS_TURF = makeStateRule(ModBlocks.SUNCROWN_TURF.get());
    private static final SurfaceRules.RuleSource END_SLUDGE = makeStateRule(ModBlocks.END_SLUDGE.get());


    private static SurfaceRules.RuleSource makeStateRule(Block p_194811_) {
        return SurfaceRules.state(p_194811_.defaultBlockState());
    }


    public static SurfaceRules.RuleSource end() {
        //SurfaceRules.RuleSource whiteSandstoneLining = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, WHITE_SANDSTONE), WHITE_SAND);

        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(
                        SurfaceRules.isBiome(ModBiomes.SUNCROWN_PLAINS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                        SurfaceRules.sequence(
                                                CHORUS_TURF
                                        )
                                ),
                                SurfaceRules.ifTrue(SurfaceRules.ON_CEILING,
                                        SurfaceRules.sequence(
                                                END_SLUDGE
                                        )
                                )
                        )
                )
        );
      //          SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.END_CORRUPTION), UNMAPPED_END_STONE),
       //       SurfaceRules.ifTrue(
       //               SurfaceRules.isBiome(ModBiomes.CHORUS_PLAINS),
       //               SurfaceRules.sequence(
       //                       SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
       //                               SurfaceRules.sequence(
       //                                       whiteSandstoneLining
       //                               )
       //                       )
       //               )
       //       )
       //;
    }
}

