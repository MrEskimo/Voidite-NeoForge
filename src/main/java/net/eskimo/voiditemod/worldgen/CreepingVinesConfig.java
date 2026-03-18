package net.eskimo.voiditemod.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record CreepingVinesConfig(int spreadWidth, int spreadHeight, int maxHeight) implements FeatureConfiguration {
    public static final Codec<CreepingVinesConfig> CODEC = RecordCodecBuilder.create((p_191375_) -> p_191375_.group(ExtraCodecs.POSITIVE_INT.fieldOf("spread_width").forGetter(CreepingVinesConfig::spreadWidth), ExtraCodecs.POSITIVE_INT.fieldOf("spread_height").forGetter(CreepingVinesConfig::spreadHeight), ExtraCodecs.POSITIVE_INT.fieldOf("max_height").forGetter(CreepingVinesConfig::maxHeight)).apply(p_191375_, CreepingVinesConfig::new));
}
