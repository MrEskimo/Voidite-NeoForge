package net.eskimo.voiditemod.recipe;

import net.eskimo.voiditemod.VoiditeMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, VoiditeMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, VoiditeMod.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CelestaleeFurnaceRecipe>> CELESTALEE_FURNACE_SERIALIZER =
            SERIALIZERS.register("celestalee_furnace", CelestaleeFurnaceRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<CelestaleeFurnaceRecipe>> CELESTALEE_FURNACE_TYPE =
            TYPES.register("celestalee_furnace", () -> new RecipeType<CelestaleeFurnaceRecipe>() {
                @Override
                public String toString() {
                    return "celestalee_furnace";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
