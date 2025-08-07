package net.eskimo.voiditemod.block.custom;

import net.eskimo.voiditemod.block.ModBlocks;

import net.eskimo.voiditemod.worldgen.ModPlacedFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.lighting.LightEngine;
import net.neoforged.neoforge.common.util.TriState;

import java.util.List;
import java.util.Optional;


public class CustomGrass extends GrassBlock {
    public CustomGrass(Properties properties) {
        super(properties);
    }



    private static boolean canBeGrass(BlockState pState, LevelReader pLevelReader, BlockPos pPos) {
        BlockPos blockpos = pPos.above();
        BlockState blockstate = pLevelReader.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(pLevelReader, pState, pPos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(pLevelReader, blockpos));
            return i < pLevelReader.getMaxLightLevel();
        }
    }

    @Override
    public void randomTick(BlockState p_222508_, ServerLevel p_222509_, BlockPos p_222510_, RandomSource p_222511_)
    {
        if (!canBeGrass(p_222508_, p_222509_, p_222510_))
        {
            p_222509_.setBlockAndUpdate(p_222510_, Blocks.END_STONE.defaultBlockState());
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_153797_, BlockPos p_153798_, BlockState p_153799_)
    {
        return p_153797_.getBlockState(p_153798_.above()).isAir();
    }
}
