package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
        protected void buildRecipes(RecipeOutput pRecipeOutput) {
            List<ItemLike> VOIDITE_SMELTABLES = List.of(ModItems.RAW_VOIDITE.get(),
                    ModBlocks.VOIDITE_ORE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLOCK_OF_SMILE.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.SMILE.get())
                .unlockedBy(getHasName(ModItems.SMILE.get()), has(ModItems.SMILE.get())).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_END_SLUDGE.get())
                .requires(ModBlocks.END_SLUDGE.get())
                .requires(Items.WHEAT)
                .unlockedBy(getHasName(ModBlocks.END_SLUDGE.get()), has(ModBlocks.END_SLUDGE.get())).save(pRecipeOutput);

        twoByTwoPacker(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_SLUDGE_BRICKS.get(), ModBlocks.PACKED_END_SLUDGE.get());
        twoByTwoPacker(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNCROWN_SANDSTONE.get(), ModBlocks.SUNCROWN_SAND.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SMILE.get(), 9)
                .requires(ModBlocks.BLOCK_OF_SMILE.get())
                .unlockedBy(getHasName(ModBlocks.BLOCK_OF_SMILE.get()), has(ModBlocks.BLOCK_OF_SMILE.get())).save(pRecipeOutput);

        stairBuilder(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get(), Ingredient.of(ModBlocks.END_SLUDGE_BRICKS.get())).group("end_sludge_bricks")
                .unlockedBy(getHasName(ModBlocks.END_SLUDGE_BRICKS.get()), has(ModBlocks.END_SLUDGE_BRICKS.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_SLUDGE_BRICKS_SLAB.get(), ModBlocks.END_SLUDGE_BRICKS.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_SLUDGE_BRICKS_WALL.get(), ModBlocks.END_SLUDGE_BRICKS.get());

        stairBuilder(ModBlocks.PACKED_END_SLUDGE_STAIRS.get(), Ingredient.of(ModBlocks.PACKED_END_SLUDGE.get())).group("packed_end_sludge")
                .unlockedBy(getHasName(ModBlocks.PACKED_END_SLUDGE.get()), has(ModBlocks.PACKED_END_SLUDGE.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_END_SLUDGE_SLAB.get(), ModBlocks.PACKED_END_SLUDGE.get());
        wall(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_END_SLUDGE_WALL.get(), ModBlocks.PACKED_END_SLUDGE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_BRICK_PILLAR.get())
                .pattern("   ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Blocks.END_STONE_BRICK_SLAB)
                .unlockedBy(getHasName(Blocks.END_STONE_BRICK_SLAB), has(Blocks.END_STONE_BRICK_SLAB)).save(pRecipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get())
               .pattern("BBB")
               .pattern("BAB")
               .pattern("BBB")
               .define('A', ModBlocks.END_STONE_BRICK_PILLAR.get())
               .define('B', Blocks.QUARTZ_PILLAR)
              .unlockedBy(getHasName(ModBlocks.END_STONE_BRICK_PILLAR.get()), has(ModBlocks.END_STONE_BRICK_PILLAR.get())).save(pRecipeOutput);

        oreSmelting(pRecipeOutput, VOIDITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDITE_INGOT.get(), 1f, 300, "voidite");
        oreBlasting(pRecipeOutput, VOIDITE_SMELTABLES, RecipeCategory.MISC, ModItems.VOIDITE_INGOT.get(), 3f, 150, "voidite");
        nineBlockStorageRecipes(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModItems.VOIDITE_INGOT.get(), RecipeCategory.MISC, ModBlocks.BLOCK_OF_VOIDITE.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPUR_LIGHT.get())
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('B', Items.CHORUS_FRUIT)
                .define('A', Items.POPPED_CHORUS_FRUIT)
                .define('C', Blocks.END_ROD)
                .unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT)).save(pRecipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNCROWN_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.SUNCROWN_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_LOG.get()), has(ModBlocks.SUNCROWN_OAK_LOG.get()))
                .save(pRecipeOutput, VoiditeMod.MOD_ID + ":suncrown_oak_planks_from_normal_log");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNCROWN_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get()), has(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get()))
                .save(pRecipeOutput, VoiditeMod.MOD_ID + ":suncrown_oak_planks_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNCROWN_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.SUNCROWN_OAK_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_WOOD.get()), has(ModBlocks.SUNCROWN_OAK_WOOD.get()))
                .save(pRecipeOutput, VoiditeMod.MOD_ID + ":suncrown_oak_planks_from_normal_wood");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNCROWN_OAK_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get()), has(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get()))
                .save(pRecipeOutput, VoiditeMod.MOD_ID + ":suncrown_oak_planks_from_stripped_wood");

        woodFromLogs(pRecipeOutput, ModBlocks.SUNCROWN_OAK_WOOD.get(), ModBlocks.SUNCROWN_OAK_LOG.get());
        woodFromLogs(pRecipeOutput, ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get(), ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get());

        stairBuilder(ModBlocks.SUNCROWN_OAK_STAIRS.get(), Ingredient.of(ModBlocks.SUNCROWN_OAK_PLANKS.get())).group("suncrown_oak")
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_PLANKS.get()), has(ModBlocks.SUNCROWN_OAK_PLANKS.get())).save(pRecipeOutput);
        slab(pRecipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SUNCROWN_OAK_SLAB.get(), ModBlocks.SUNCROWN_OAK_PLANKS.get());

        buttonBuilder(ModBlocks.SUNCROWN_OAK_BUTTON.get(), Ingredient.of(ModBlocks.SUNCROWN_OAK_PLANKS.get())).group("suncrown_oak")
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_PLANKS.get()), has(ModBlocks.SUNCROWN_OAK_PLANKS.get())).save(pRecipeOutput);
        pressurePlate(pRecipeOutput, ModBlocks.SUNCROWN_OAK_PRESSURE_PLATE.get(), ModBlocks.SUNCROWN_OAK_PLANKS.get());

        fenceBuilder(ModBlocks.SUNCROWN_OAK_FENCE.get(), Ingredient.of(ModBlocks.SUNCROWN_OAK_PLANKS.get())).group("suncrown_oak")
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_PLANKS.get()), has(ModBlocks.SUNCROWN_OAK_PLANKS.get())).save(pRecipeOutput);
        fenceGateBuilder(ModBlocks.SUNCROWN_OAK_FENCE_GATE.get(), Ingredient.of(ModBlocks.SUNCROWN_OAK_PLANKS.get())).group("suncrown_oak")
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_PLANKS.get()),has(ModBlocks.SUNCROWN_OAK_PLANKS.get())).save(pRecipeOutput);

        doorBuilder(ModBlocks.SUNCROWN_OAK_DOOR.get(), Ingredient.of(ModBlocks.SUNCROWN_OAK_PLANKS.get())).group("suncrown_oak")
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_PLANKS.get()), has(ModBlocks.SUNCROWN_OAK_PLANKS.get())).save(pRecipeOutput);
        trapdoorBuilder(ModBlocks.SUNCROWN_OAK_TRAPDOOR.get(), Ingredient.of(ModBlocks.SUNCROWN_OAK_PLANKS.get())).group("suncrown_oak")
                .unlockedBy(getHasName(ModBlocks.SUNCROWN_OAK_PLANKS.get()), has(ModBlocks.SUNCROWN_OAK_PLANKS.get())).save(pRecipeOutput);
    }
}
