package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.block.custom.ChiseledEndStoneBrickPillarBlock;
import net.eskimo.voiditemod.block.custom.GlowingVoidBerryBushBlock;
import net.eskimo.voiditemod.block.custom.SincehePotatoCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, VoiditeMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_SMILE);
        blockWithItem(ModBlocks.AMOGUS);

        blockWithItem(ModBlocks.END_SLUDGE);
        blockWithItem(ModBlocks.END_SLUDGE_BRICKS);
        blockWithItem(ModBlocks.PACKED_END_SLUDGE);
        blockWithItem(ModBlocks.PURPUR_LIGHT);

        blockWithItem(ModBlocks.VOIDITE_ORE);
        blockWithItem(ModBlocks.BLOCK_OF_VOIDITE);

        blockWithItem(ModBlocks.SUNCROWN_OAK_PLANKS);

        stairsBlock(ModBlocks.SUNCROWN_OAK_STAIRS.get(), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()));

        slabBlock(ModBlocks.SUNCROWN_OAK_SLAB.get(), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()));

        blockItem(ModBlocks.SUNCROWN_OAK_STAIRS);
        blockItem(ModBlocks.SUNCROWN_OAK_SLAB);
        blockItem(ModBlocks.SUNCROWN_OAK_PRESSURE_PLATE);
        blockItem(ModBlocks.SUNCROWN_OAK_FENCE_GATE);
        blockItem(ModBlocks.SUNCROWN_OAK_TRAPDOOR, "_bottom");

        buttonBlock(ModBlocks.SUNCROWN_OAK_BUTTON.get(), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()));
        pressurePlateBlock(ModBlocks.SUNCROWN_OAK_PRESSURE_PLATE.get(), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()));

        fenceBlock(ModBlocks.SUNCROWN_OAK_FENCE.get(), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()));
        fenceGateBlock(ModBlocks.SUNCROWN_OAK_FENCE_GATE.get(), blockTexture(ModBlocks.SUNCROWN_OAK_PLANKS.get()));

        doorBlockWithRenderType(ModBlocks.SUNCROWN_OAK_DOOR.get(), modLoc("block/suncrown_oak_door_bottom"), modLoc("block/suncrown_oak_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.SUNCROWN_OAK_TRAPDOOR.get(), modLoc("block/suncrown_oak_trapdoor"), true, "cutout");


        stairsBlock(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get(), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()));
        wallBlock(ModBlocks.END_SLUDGE_BRICKS_WALL.get(), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()));
        slabBlock(ModBlocks.END_SLUDGE_BRICKS_SLAB.get(), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()), blockTexture(ModBlocks.END_SLUDGE_BRICKS.get()));

        blockItem(ModBlocks.END_SLUDGE_BRICKS_STAIRS);
        blockItem(ModBlocks.END_SLUDGE_BRICKS_SLAB);
        stairsBlock(ModBlocks.PACKED_END_SLUDGE_STAIRS.get(), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()));
        wallBlock(ModBlocks.PACKED_END_SLUDGE_WALL.get(), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()));
        slabBlock(ModBlocks.PACKED_END_SLUDGE_SLAB.get(), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()), blockTexture(ModBlocks.PACKED_END_SLUDGE.get()));

        blockItem(ModBlocks.PACKED_END_SLUDGE_STAIRS);
        blockItem(ModBlocks.PACKED_END_SLUDGE_SLAB);

        simpleBlockWithItem(ModBlocks.SUNCROWN_TURF.get(), models().cubeBottomTop(
                "suncrown_turf",
                modLoc("block/suncrown_turf"),
                modLoc("block/suncrown_turf_bottom"),
                modLoc("block/suncrown_turf_top")
        ));

        tallGrassBlock(ModBlocks.SUNCROWN_GRASS);
        tallGrassBlock(ModBlocks.SHORT_SUNCROWN_GRASS);
        tallGrassBlock(ModBlocks.FLOWERING_SUNCROWN_GRASS);

        axisBlock(ModBlocks.END_STONE_BRICK_PILLAR.get(), modLoc("block/end_stone_brick_pillar_side"), modLoc("block/end_stone_brick_pillar_end"));
        blockItem(ModBlocks.END_STONE_BRICK_PILLAR);

        makeBush(((SweetBerryBushBlock) ModBlocks.GLOWING_VOID_BERRY_BUSH.get()), "glowing_void_berry_bush_stage", "glowing_void_berry_bush_stage");

        customLamp();

        makeCrop(((CropBlock) ModBlocks.SINCEHE_POTATO_CROP.get()), "sincehe_potato_crop_stage", "sincehe_potato_crop_stage");

        logBlock(ModBlocks.SUNCROWN_OAK_LOG.get());
        axisBlock(ModBlocks.SUNCROWN_OAK_WOOD.get(), blockTexture(ModBlocks.SUNCROWN_OAK_LOG.get()), blockTexture(ModBlocks.SUNCROWN_OAK_LOG.get()));
        logBlock(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get());
        axisBlock(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get(), blockTexture(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get()), blockTexture(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get()));

        blockItem(ModBlocks.SUNCROWN_OAK_LOG);
        blockItem(ModBlocks.SUNCROWN_OAK_WOOD);
        blockItem(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG);
        blockItem(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD);

        saplingBlock(ModBlocks.SUNCROWN_OAK_SAPLING);
        leavesBlock(ModBlocks.SUNCROWN_OAK_LEAVES);

        blockWithItem(ModBlocks.SUNCROWN_SAND);
        blockWithItem(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE);

        blockWithItem(ModBlocks.SUNCROWN_SANDSTONE);
        stairsBlock(ModBlocks.SUNCROWN_SANDSTONE_STAIRS.get(), blockTexture(ModBlocks.SUNCROWN_SANDSTONE.get()));
        blockItem(ModBlocks.SUNCROWN_SANDSTONE_STAIRS);
        slabBlock(ModBlocks.SUNCROWN_SANDSTONE_SLAB.get(), blockTexture(ModBlocks.SUNCROWN_SANDSTONE.get()), blockTexture(ModBlocks.SUNCROWN_SANDSTONE.get()));
        blockItem(ModBlocks.SUNCROWN_SANDSTONE_SLAB);

        //Celestalee
        //blockWithItem(ModBlocks.CELESTALEE);

        simpleBlockWithItem(ModBlocks.CELESTALEE.get(), models().cubeBottomTop(
                "celestalee_furnace",
                modLoc("block/celestalee_furnace"),
                modLoc("block/celestalee_furnace_bottom"),
                modLoc("block/celestalee_furnace_top")
        ));
        //blockWithItem(ModBlocks.DHADE);

        simpleBlockWithItem(ModBlocks.DHADE.get(), models().cubeBottomTop(
                "hammer_of_end",
                modLoc("block/hammer_of_end"),
                modLoc("block/hammer_of_end_bottom"),
                modLoc("block/hammer_of_end_top")
        ));
        //
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void tallGrassBlock(DeferredBlock<TallGrassBlock> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(GlowingVoidBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "block/" + textureName + state.getValue(GlowingVoidBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SincehePotatoCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "block/" + textureName + state.getValue(((SincehePotatoCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get()).forAllStates(state -> {
            if(state.getValue(ChiseledEndStoneBrickPillarBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("chiseled_end_stone_brick_pillar_on",
                        ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "block/" + "chiseled_end_stone_brick_pillar_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("chiseled_end_stone_brick_pillar_off",
                        ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "block/" + "chiseled_end_stone_brick_pillar_off")))};
            }
        });
        simpleBlockItem(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get(), models().cubeAll("chiseled_end_stone_brick_pillar_off",
                ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, "block/" + "chiseled_end_stone_brick_pillar_off")));
    }


    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("voiditemod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("voiditemod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}