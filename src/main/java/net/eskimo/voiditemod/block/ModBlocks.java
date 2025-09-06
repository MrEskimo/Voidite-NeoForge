package net.eskimo.voiditemod.block;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.block.custom.*;
import net.eskimo.voiditemod.item.ModItems;
import net.eskimo.voiditemod.worldgen.tree.ModTreeGrowers;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(VoiditeMod.MOD_ID);

    public static final DeferredBlock<Block> BLOCK_OF_SMILE = registerBlock("block_of_smile",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    public static final DeferredBlock<Block> AMOGUS = registerBlock("amogus",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.BASALT).noLootTable()));

    public static final DeferredBlock<Block> END_SLUDGE = registerBlock("end_sludge",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.MUD)));
    public static final DeferredBlock<Block> PACKED_END_SLUDGE = registerBlock("packed_end_sludge",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));
    public static final DeferredBlock<Block> END_SLUDGE_BRICKS = registerBlock("end_sludge_bricks",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));

    public static final DeferredBlock<StairBlock> END_SLUDGE_BRICKS_STAIRS = registerBlock("end_sludge_bricks_stairs",
            () -> new StairBlock(ModBlocks.END_SLUDGE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final DeferredBlock<SlabBlock> END_SLUDGE_BRICKS_SLAB = registerBlock("end_sludge_bricks_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final DeferredBlock<WallBlock> END_SLUDGE_BRICKS_WALL = registerBlock("end_sludge_bricks_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));

    public static final DeferredBlock<StairBlock> PACKED_END_SLUDGE_STAIRS = registerBlock("packed_end_sludge_stairs",
            () -> new StairBlock(ModBlocks.PACKED_END_SLUDGE.get().defaultBlockState(),
                    BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));
    public static final DeferredBlock<SlabBlock> PACKED_END_SLUDGE_SLAB = registerBlock("packed_end_sludge_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));
    public static final DeferredBlock<WallBlock> PACKED_END_SLUDGE_WALL = registerBlock("packed_end_sludge_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().strength(2).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD)));

    public static final DeferredBlock<GrassBlock> SUNCROWN_TURF = registerBlock("suncrown_turf",
            ()-> new CustomGrass(BlockBehaviour.Properties.ofFullCopy(Blocks.GRASS_BLOCK)
                    .strength(0.5F)
                    .friction(0.65F)
                    .requiresCorrectToolForDrops()));

    public static final DeferredBlock<TallGrassBlock> SUNCROWN_GRASS = registerBlock("suncrown_grass",
            ()-> new ModTallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS), ModBlocks.SUNCROWN_TURF::get));
    public static final DeferredBlock<TallGrassBlock> SHORT_SUNCROWN_GRASS = registerBlock("short_suncrown_grass",
            ()-> new ModTallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS), ModBlocks.SUNCROWN_TURF::get));
    public static final DeferredBlock<TallGrassBlock> FLOWERING_SUNCROWN_GRASS = registerBlock("flowering_suncrown_grass",
            ()-> new ModTallGrassBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS).lightLevel(state -> 4), ModBlocks.SUNCROWN_TURF::get));

    public static final DeferredBlock<RotatedPillarBlock> END_STONE_BRICK_PILLAR = registerBlock("end_stone_brick_pillar",
            ()-> new RotatedPillarBlock(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 9.0F).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CHISELED_END_STONE_BRICK_PILLAR = registerBlock("chiseled_end_stone_brick_pillar",
            ()-> new ChiseledEndStoneBrickPillarBlock(BlockBehaviour.Properties.of().strength(3f)
                    .lightLevel(state -> state.getValue(ChiseledEndStoneBrickPillarBlock.CLICKED) ? 15 : 0)));

    public static final DeferredBlock<Block> PURPUR_LIGHT = registerBlock("purpur_light",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.PEARLESCENT_FROGLIGHT).sound(SoundType.STONE)));

    public static final DeferredBlock<Block> VOIDITE_ORE = registerBlock("voidite_ore",
            ()-> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()
                    .lightLevel(state -> 6)));

    public static final DeferredBlock<Block> BLOCK_OF_VOIDITE = registerBlock("block_of_voidite",
            ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> GLOWING_VOID_BERRY_BUSH = BLOCKS.register("glowing_void_berry_bush",
            () -> new GlowingVoidBerryBushBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SWEET_BERRY_BUSH)
                    .emissiveRendering((pState, pLevel, pPos) -> true)
                    .lightLevel(state -> 6), ModBlocks.SUNCROWN_TURF::get));
    public static final DeferredBlock<Block> SINCEHE_POTATO_CROP = BLOCKS.register("sincehe_potato_crop",
            () -> new SincehePotatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));

    public static final DeferredBlock<RotatedPillarBlock> SUNCROWN_OAK_LOG = registerBlock("suncrown_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SUNCROWN_OAK_LOG = registerBlock("stripped_suncrown_oak_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<RotatedPillarBlock> SUNCROWN_OAK_WOOD = registerBlock("suncrown_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_SUNCROWN_OAK_WOOD = registerBlock("stripped_suncrown_oak_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> SUNCROWN_OAK_PLANKS = registerBlock("suncrown_oak_planks",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)));
    public static final DeferredBlock<Block> SUNCROWN_OAK_LEAVES = registerBlock("suncrown_oak_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)));

    public static final DeferredBlock<ModCocoaBlock> GROUTYOU_BEAN = registerBlock("groutyou_bean",
            () -> new ModCocoaBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.COCOA)));

    public static final DeferredBlock<Block> SUNCROWN_OAK_SAPLING = registerBlock("suncrown_oak_sapling",
            () -> new ModSaplingBlock(ModTreeGrowers.SUNCROWN_OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.SUNCROWN_TURF::get));

    public static final DeferredBlock<SlabBlock> SUNCROWN_OAK_SLAB = registerBlock("suncrown_oak_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));
    public static final DeferredBlock<StairBlock> SUNCROWN_OAK_STAIRS = registerBlock("suncrown_oak_stairs",
            () -> new StairBlock(ModBlocks.SUNCROWN_OAK_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));

    public static final DeferredBlock<PressurePlateBlock> SUNCROWN_OAK_PRESSURE_PLATE = registerBlock("suncrown_oak_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<ButtonBlock> SUNCROWN_OAK_BUTTON = registerBlock("suncrown_oak_button",
            () -> new ButtonBlock(BlockSetType.OAK,20, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<FenceBlock> SUNCROWN_OAK_FENCE = registerBlock("suncrown_oak_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<FenceGateBlock> SUNCROWN_OAK_FENCE_GATE = registerBlock("suncrown_oak_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final DeferredBlock<DoorBlock> SUNCROWN_OAK_DOOR = registerBlock("suncrown_oak_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<TrapDoorBlock> SUNCROWN_OAK_TRAPDOOR = registerBlock("suncrown_oak_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));

    public static final DeferredBlock<Block> SUNCROWN_SAND = registerBlock("suncrown_sand",
            () -> new ColoredFallingBlock(new ColorRGBA(11173120),
                    BlockBehaviour.Properties.of().strength(0.25f).sound(SoundType.BASALT)) {
                @Override
                protected int getDelayAfterPlace() {
                    return 40;
                }});

    public static final DeferredBlock<Block> SUNCROWN_SANDSTONE = registerBlock("suncrown_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE)));
    public static final DeferredBlock<StairBlock> SUNCROWN_SANDSTONE_STAIRS = registerBlock("suncrown_sandstone_stairs",
            () -> new StairBlock(ModBlocks.SUNCROWN_SANDSTONE.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_STAIRS)));
    public static final DeferredBlock<SlabBlock> SUNCROWN_SANDSTONE_SLAB = registerBlock("suncrown_sandstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SANDSTONE_SLAB)));

    public static final DeferredBlock<Block> SMOOTH_SUNCROWN_SANDSTONE = registerBlock("smooth_suncrown_sandstone",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SMOOTH_SANDSTONE)));

    //IMPORTANT Celesta lee
    public static final DeferredBlock<CelestaleeFurnaceBlock> CELESTALEE = registerBlock("celestalee_furnace",
            () -> new CelestaleeFurnaceBlock(BlockBehaviour.Properties.of()));
    //
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}