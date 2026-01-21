package net.eskimo.voiditemod.datagen;

import net.eskimo.voiditemod.block.ModBlocks;
import net.eskimo.voiditemod.block.custom.SincehePotatoCropBlock;
import net.eskimo.voiditemod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;


public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.END_SLUDGE.get());
        dropSelf(ModBlocks.END_SLUDGE_BRICKS.get());
        dropSelf(ModBlocks.PACKED_END_SLUDGE.get());
        dropSelf(ModBlocks.END_SLUDGE_BRICKS_WALL.get());
        dropSelf(ModBlocks.PACKED_END_SLUDGE_WALL.get());
        dropSelf(ModBlocks.END_STONE_BRICK_PILLAR.get());
        dropSelf(ModBlocks.CHISELED_END_STONE_BRICK_PILLAR.get());
        dropSelf(ModBlocks.PURPUR_LIGHT.get());
        dropSelf(ModBlocks.BLOCK_OF_VOIDITE.get());
        dropSelf(ModBlocks.SUNCROWN_OAK_PLANKS.get());
        dropSelf(ModBlocks.STRIPPED_SUNCROWN_OAK_LOG.get());
        dropSelf(ModBlocks.SUNCROWN_OAK_LOG.get());
        dropSelf(ModBlocks.STRIPPED_SUNCROWN_OAK_WOOD.get());
        dropSelf(ModBlocks.SUNCROWN_OAK_WOOD.get());
        dropSelf(ModBlocks.SUNCROWN_OAK_SAPLING.get());

        dropSelf(ModBlocks.SUNCROWN_SAND.get());
        dropSelf(ModBlocks.SUNCROWN_SANDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE.get());
        dropSelf(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE_STAIRS.get());

        dropSelf(ModBlocks.GROUTYOU_BEAN.get());

        dropSelf(ModBlocks.HARD_SAGE_FRUIT.get());
        dropSelf(ModBlocks.TREATED_SAGE_FRUIT.get());

        dropSelf(ModBlocks.SAGE_MOSS.get());

        add(ModBlocks.SAGE_BLOOM.get(),
                createShearsOnlyDrop(ModBlocks.SAGE_BLOOM.get()));
        add(ModBlocks.SAGE_GRASS.get(),
                createShearsOnlyDrop(ModBlocks.SAGE_GRASS.get()));

        dropSelf(ModBlocks.SAGE_FUNGUS.get());
        dropSelf(ModBlocks.SAGE_WART_BLOCK.get());
        dropSelf(ModBlocks.SAGE_STEM.get());
        dropSelf(ModBlocks.SAGE_PLANKS.get());
        dropSelf(ModBlocks.SAGE_BUTTON.get());
        dropSelf(ModBlocks.SAGE_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.SAGE_FENCE.get());
        dropSelf(ModBlocks.SAGE_FENCE_GATE.get());

        dropSelf(ModBlocks.SAGE_TRAPDOOR.get());
        this.add(ModBlocks.SAGE_DOOR.get(),
                block -> createDoorTable(ModBlocks.SAGE_DOOR.get()));

        this.add(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SMOOTH_SUNCROWN_SANDSTONE_SLAB.get()));

        this.add(ModBlocks.SUNCROWN_OAK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SUNCROWN_OAK_SLAB.get()));
        dropSelf(ModBlocks.SUNCROWN_OAK_STAIRS.get());

        dropSelf(ModBlocks.SUNCROWN_OAK_FENCE_GATE.get());
        dropSelf(ModBlocks.SUNCROWN_OAK_FENCE.get());

        dropSelf(ModBlocks.SUNCROWN_OAK_TRAPDOOR.get());
        this.add(ModBlocks.SUNCROWN_OAK_DOOR.get(),
                block -> createDoorTable(ModBlocks.SUNCROWN_OAK_DOOR.get()));

        dropSelf(ModBlocks.SUNCROWN_OAK_BUTTON.get());
        dropSelf(ModBlocks.SUNCROWN_OAK_PRESSURE_PLATE.get());


        add(ModBlocks.SUNCROWN_GRASS.get(),
                createShearsOnlyDrop(ModBlocks.SUNCROWN_GRASS.get()));
        add(ModBlocks.SHORT_SUNCROWN_GRASS.get(),
                createShearsOnlyDrop(ModBlocks.SHORT_SUNCROWN_GRASS.get()));
        add(ModBlocks.FLOWERING_SUNCROWN_GRASS.get(),
                createShearsOnlyDrop(ModBlocks.FLOWERING_SUNCROWN_GRASS.get()));

        this.add(ModBlocks.SUNCROWN_TURF.get(),
                createSilkTouchOnlyTable(ModBlocks.SUNCROWN_TURF.get()));

        this.add(ModBlocks.SUNCROWN_OAK_LEAVES.get(), block ->
               createLeavesDrops(block, ModBlocks.SUNCROWN_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.BLOCK_OF_SMILE.get(),
              block -> createOreDrop(ModBlocks.BLOCK_OF_SMILE.get(), ModItems.SMILE.get()));
        this.add(ModBlocks.VOIDITE_ORE.get(),
              block -> createOreDrop(ModBlocks.VOIDITE_ORE.get(), ModItems.RAW_VOIDITE.get()));

        dropSelf(ModBlocks.END_SLUDGE_BRICKS_STAIRS.get());
        this.add(ModBlocks.END_SLUDGE_BRICKS_SLAB.get(),
                 block -> createSlabItemTable(ModBlocks.END_SLUDGE_BRICKS_SLAB.get()));

        dropSelf(ModBlocks.PACKED_END_SLUDGE_STAIRS.get());
        this.add(ModBlocks.PACKED_END_SLUDGE_SLAB.get(),
                 block -> createSlabItemTable(ModBlocks.PACKED_END_SLUDGE_SLAB.get()));

        dropSelf(ModBlocks.SUNCROWN_SANDSTONE_STAIRS.get());
        this.add(ModBlocks.SUNCROWN_SANDSTONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SUNCROWN_SANDSTONE_SLAB.get()));

        dropSelf(ModBlocks.SAGE_STAIRS.get());
        this.add(ModBlocks.SAGE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SAGE_SLAB.get()));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.add(ModBlocks.GLOWING_VOID_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.GLOWING_VOID_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GLOWING_VOID_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.GLOWING_VOID_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.SINCEHE_POTATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SincehePotatoCropBlock.AGE, SincehePotatoCropBlock.MAX_AGE));

        this.add(ModBlocks.SINCEHE_POTATO_CROP.get(), this.createCropDrops(ModBlocks.SINCEHE_POTATO_CROP.get(),
               ModItems.SINCEHE_POTATO.get(), ModItems.SINCEHE_POTATO_SEEDS.get(), lootItemConditionBuilder));
        dropOther(ModBlocks.CELESTALEE.get(), Items.IRON_BLOCK);
        dropOther(ModBlocks.DHADE.get(), Items.IRON_BLOCK);
     }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
