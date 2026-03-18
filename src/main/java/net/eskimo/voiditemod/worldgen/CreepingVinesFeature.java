package net.eskimo.voiditemod.worldgen;

import com.mojang.serialization.Codec;
import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.TwistingVinesConfig;

public class CreepingVinesFeature extends Feature<CreepingVinesConfig> {
    public CreepingVinesFeature(Codec<CreepingVinesConfig> p_66219_) {
        super(p_66219_);
    }


    public boolean place(FeaturePlaceContext<CreepingVinesConfig> context) {
        WorldGenLevel worldgenlevel = context.level();
        BlockPos blockpos = context.origin();
        if (isInvalidPlacementLocation(worldgenlevel, blockpos)) {
            return false;
        } else {
            RandomSource randomsource = context.random();
            CreepingVinesConfig creepingVinesConfig = (CreepingVinesConfig) context.config();
            int i = creepingVinesConfig.spreadWidth();
            int j = creepingVinesConfig.spreadHeight();
            int k = creepingVinesConfig.maxHeight();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

            for(int l = 0; l < i * i; ++l) {
                blockpos$mutableblockpos.set(blockpos).move(Mth.nextInt(randomsource, -i, i), Mth.nextInt(randomsource, -j, j), Mth.nextInt(randomsource, -i, i));
                if (findFirstAirBlockAboveGround(worldgenlevel, blockpos$mutableblockpos) && !isInvalidPlacementLocation(worldgenlevel, blockpos$mutableblockpos)) {
                    int i1 = Mth.nextInt(randomsource, 1, k);
                    if (randomsource.nextInt(6) == 0) {
                        i1 *= 2;
                    }

                    if (randomsource.nextInt(5) == 0) {
                        i1 = 1;
                    }

                    int j1 = 17;
                    int k1 = 25;
                    placeWeepingVinesColumn(worldgenlevel, randomsource, blockpos$mutableblockpos, i1, 17, 25);
                }
            }

            return true;
        }
    }

    private static boolean findFirstAirBlockAboveGround(LevelAccessor level, BlockPos.MutableBlockPos pos) {
        do {
            pos.move(0, -1, 0);
            if (level.isOutsideBuildHeight(pos)) {
                return false;
            }
        } while(level.getBlockState(pos).isAir());

        pos.move(0, 1, 0);
        return true;
    }

    public static void placeWeepingVinesColumn(LevelAccessor level, RandomSource random, BlockPos.MutableBlockPos pos, int length, int minAge, int maxAge) {
        for(int i = 1; i <= length; ++i) {
            if (level.isEmptyBlock(pos)) {
                if (i == length || !level.isEmptyBlock(pos.above())) {
                    level.setBlock(pos, (BlockState) ModBlocks.CREEPING_VINE.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(random, minAge, maxAge)), 2);
                    break;
                }

                level.setBlock(pos, ModBlocks.CREEPING_VINE.get().defaultBlockState(), 2);
            }

            pos.move(Direction.UP);
        }

    }

    private static boolean isInvalidPlacementLocation(LevelAccessor level, BlockPos pos) {
        if (!level.isEmptyBlock(pos)) {
            return true;
        } else {
            BlockState blockstate = level.getBlockState(pos.below());
            return !blockstate.is(ModBlocks.AMINARIA_REGOLITH);
        }
    }
}
