package net.eskimo.voiditemod.item;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SMILE = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400), 0.20f).build();
    public static final FoodProperties GLOWING_VOID_BERRY = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f)
            .effect(new MobEffectInstance(MobEffects.GLOWING, 24000),0.07f).fast()
            .effect(new MobEffectInstance(MobEffects.CONFUSION, 100),0.02f).fast().build();
    public static final FoodProperties SINCEHE_POTATO = new FoodProperties.Builder().nutrition(7).saturationModifier(0.7f)
            .effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1200), 1).build();



}
