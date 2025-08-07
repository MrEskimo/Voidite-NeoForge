package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, net.neoforged.neoforge.common.data.ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, VoiditeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.END_SLUDGE_BRICKS.get())
                .add(ModBlocks.BLOCK_OF_SMILE.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_SLAB.get())
                .add(ModBlocks.PACKED_END_SLUDGE_SLAB.get())
                .add(ModBlocks.PACKED_END_SLUDGE_STAIRS.get())
                .add(ModBlocks.PACKED_END_SLUDGE_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE.get())
                .add(ModBlocks.END_STONE_BRICK_PILLAR.get())
                .add(ModBlocks.VOIDITE_ORE.get())
                .add(ModBlocks.BLOCK_OF_VOIDITE.get())
                .add(ModBlocks.SUNCROWN_TURF.get())
                .add(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get());

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(ModBlocks.SUNCROWN_SAND.get())
                .add(ModBlocks.END_SLUDGE.get());


        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.END_SLUDGE_BRICKS.get())
                .add(ModBlocks.END_SLUDGE.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_SLAB.get())
                .add(ModBlocks.END_SLUDGE_BRICKS_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE.get())
                .add(ModBlocks.PACKED_END_SLUDGE_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE_SLAB.get())
                .add(ModBlocks.END_STONE_BRICK_PILLAR.get())
                .add(ModBlocks.SUNCROWN_TURF.get())
                .add(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get())
                .add(ModBlocks.SUNCROWN_SAND.get())
                .add(ModBlocks.PACKED_END_SLUDGE_STAIRS.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.VOIDITE_ORE.get())
                .add(ModBlocks.BLOCK_OF_VOIDITE.get());

        tag(BlockTags.WALLS)
                .add(ModBlocks.END_SLUDGE_BRICKS_WALL.get())
                .add(ModBlocks.PACKED_END_SLUDGE_WALL.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.SUNCROWN_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get())
                .add(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get())
                .add(ModBlocks.SUNCROWN_OAK_WOOD.get());

        tag(BlockTags.WOODEN_FENCES).add(ModBlocks.SUNCROWN_OAK_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(ModBlocks.SUNCROWN_OAK_FENCE_GATE.get());

        tag(BlockTags.FALL_DAMAGE_RESETTING).add(ModBlocks.SUNCROWN_SAND.get());

      //  tag(ModTags.Blocks.SUNCROWN_OAK_ROOT_REPLACEABLE)
      //          .add(ModBlocks.SUNCROWN_TURF.get())
      //          .add(ModBlocks.END_SLUDGE.get())
      //          .add(Blocks.END_STONE);
//
      //  this.tag(ModTags.Blocks.SUNCROWN_OAK_GROWS_ON)
      //          .add(ModBlocks.SUNCROWN_TURF.get())
      //          .add(Blocks.END_STONE);
//
      //  this.tag(ModTags.Blocks.GROWS_ON_SUNCROWN_TURF)
      //          .add(ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
      //          .add(ModBlocks.SUNCROWN_GRASS.get())
      //          .add(ModBlocks.SINCEHE_POTATO_CROP.get())
      //          .add(ModBlocks.SUNCROWN_OAK_SAPLING.get())
      //          .add(ModBlocks.SUNCROWN_OAK_SAPLING.get())
      //          .add(Blocks.TORCHFLOWER);
//
      //  this.tag(ModTags.Blocks.SUNCROWN_OAK_LOGS)
      //          .add(ModBlocks.SUNCROWN_OAK_LOG.get())
      //          .add(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get());
    }
}
