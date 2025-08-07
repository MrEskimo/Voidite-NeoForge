package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                              CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, VoiditeMod.MOD_ID, existingFileHelper);

    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //tag(ModTags.Items.SOME ITEM TAG)
        //        .add(ModItems.ITEM IN THAT TAG.get())

        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.SUNCROWN_OAK_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get().asItem())
                .add(ModBlocks.SUNCROWN_OAK_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(ModBlocks.SUNCROWN_OAK_PLANKS.get().asItem());
    }
}
