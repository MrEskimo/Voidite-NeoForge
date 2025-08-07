package net.eskimo.voiditemod.block.custom;

import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SincehePotatoCropBlock extends CropBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, 4);
    private static final VoxelShape[] SHAPE_BY_AGE =
            new VoxelShape[]{
                    Block.box(0.0, 0.0, 0.0, 16.0, 2.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 4.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 6.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
                    Block.box(0.0, 0.0, 0.0, 16.0, 10.0, 16.0)};


    public SincehePotatoCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(AGE)];
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.SINCEHE_POTATO_SEEDS;
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockPos blockPos = pPos.below();
        return this.mayPlaceOn(pLevel.getBlockState(blockPos), pLevel, pPos);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter worldIn, BlockPos pPos) {
        BlockState groundState = worldIn.getBlockState(pPos.below());

        return groundState.is(ModBlocks.SUNCROWN_TURF.get());
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (level.getRawBrightness(pos, 0) >= 0) {
            int i = this.getAge(state);
            if (i < this.getMaxAge()) {
                float f = getGrowthSpeed(this.defaultBlockState(), level, pos);
                if (net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos, state, random.nextInt((int) (25.0F / f) + 1) == 0)) {
                    level.setBlock(pos, this.getStateForAge(i + 1), 2);
                    net.neoforged.neoforge.common.CommonHooks.canCropGrow(level, pos, state, random.nextBoolean());
                }
            }
        }
    }
}
