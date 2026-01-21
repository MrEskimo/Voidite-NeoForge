package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.item.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TallGrassBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, VoiditeMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.SMILE.get());
        basicItem(ModItems.RAW_VOIDITE.get());
        basicItem(ModItems.VOIDITE_INGOT.get());
        tallGrassItem(ModBlocks.SUNCROWN_GRASS);
        tallGrassItem(ModBlocks.SHORT_SUNCROWN_GRASS);
        tallGrassItem(ModBlocks.FLOWERING_SUNCROWN_GRASS);
        tallGrassItem(ModBlocks.SAGE_GRASS);
        tallGrassItem(ModBlocks.SAGE_BLOOM);
        basicItem(ModItems.GLOWING_VOID_BERRIES.get());
        basicItem(ModItems.SINCEHE_POTATO.get());
        basicItem(ModItems.SINCEHE_POTATO_SEEDS.get());
        basicItem(ModItems.FORGE_SCALES.get());
        basicItem(ModItems.VOIDITE_PLATE.get());
        basicItem(ModItems.ANNEALED_VOIDITE_INGOT.get());
        basicItem(ModItems.ANNEALED_VOIDITE_PLATE.get());

        wallItem(ModBlocks.END_SLUDGE_BRICKS_WALL, ModBlocks.END_SLUDGE_BRICKS);
        wallItem(ModBlocks.PACKED_END_SLUDGE_WALL, ModBlocks.PACKED_END_SLUDGE);

        saplingItem(ModBlocks.SUNCROWN_OAK_SAPLING);
        saplingItem(ModBlocks.SAGE_FUNGUS);

        buttonItem(ModBlocks.SUNCROWN_OAK_BUTTON, ModBlocks.SUNCROWN_OAK_PLANKS);
        buttonItem(ModBlocks.SAGE_BUTTON, ModBlocks.SAGE_PLANKS);
        fenceItem(ModBlocks.SUNCROWN_OAK_FENCE, ModBlocks.SUNCROWN_OAK_PLANKS);
        fenceItem(ModBlocks.SAGE_FENCE, ModBlocks.SAGE_PLANKS);

        simpleBlockItem(ModBlocks.SUNCROWN_OAK_DOOR);
        simpleBlockItem(ModBlocks.SAGE_DOOR);

    }


    private ItemModelBuilder tallGrassItem(DeferredBlock<TallGrassBlock> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "block/" + item.getId().getPath()));
    }

    private ItemModelBuilder saplingItem(DeferredBlock<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,"block/" + item.getId().getPath()));
    }

    public void buttonItem(DeferredBlock<? extends Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,
                        "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void fenceItem(DeferredBlock<? extends Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,
                        "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(DeferredBlock<? extends Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(BuiltInRegistries.BLOCK.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID,
                        "block/" + BuiltInRegistries.BLOCK.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<? extends Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}