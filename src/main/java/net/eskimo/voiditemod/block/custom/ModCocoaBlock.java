package net.eskimo.voiditemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CocoaBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModCocoaBlock extends CocoaBlock {
    public ModCocoaBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
            BlockState blockstate = level.getBlockState(pos.relative(state.getValue(FACING)));
            return blockstate.is(BlockTags.LOGS_THAT_BURN);
    }
}
