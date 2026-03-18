package net.eskimo.voiditemod.block.custom;

import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TwistingVinesBlock;

public class CreepingVinesBlock extends TwistingVinesBlock {
    public CreepingVinesBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected Block getBodyBlock() {
        return ModBlocks.CREEPING_VINE.get();
    }
}
