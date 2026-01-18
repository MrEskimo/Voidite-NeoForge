package net.eskimo.voiditemod.worldgen.tree;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower SUNCROWN_OAK = new TreeGrower(VoiditeMod.MOD_ID + ";suncrown_oak",
            Optional.empty(), Optional.of(ModConfiguredFeatures.SUNCROWN_OAK_KEY), Optional.empty());

    public static final TreeGrower GREEN_FUNGUS = new TreeGrower(VoiditeMod.MOD_ID + ";green_fungus",
            Optional.empty(), Optional.of(ModConfiguredFeatures.GREEN_WART_KEY), Optional.empty());
}

