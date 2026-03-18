package net.eskimo.voiditemod.util;

import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ModTags {

    public static class Biomes {
        public static final TagKey<Biome> FOG = register("fog");

        private static TagKey<Biome> register(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(VoiditeMod.MOD_ID, name));
        }
    }
}
