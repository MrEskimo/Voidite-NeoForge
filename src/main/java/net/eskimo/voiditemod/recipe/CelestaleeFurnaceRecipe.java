package net.eskimo.voiditemod.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record CelestaleeFurnaceRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CelestaleeFurnaceRecipeInput> {
    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);

        return list;
    }

    @Override
    public boolean matches(CelestaleeFurnaceRecipeInput celestaleeFurnaceRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(celestaleeFurnaceRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(CelestaleeFurnaceRecipeInput celestaleeFurnaceRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CELESTALEE_FURNACE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CELESTALEE_FURNACE_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<CelestaleeFurnaceRecipe> {
        public static final MapCodec<CelestaleeFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(CelestaleeFurnaceRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CelestaleeFurnaceRecipe::output)
        ).apply(inst, CelestaleeFurnaceRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, CelestaleeFurnaceRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, CelestaleeFurnaceRecipe::inputItem,
                        ItemStack.STREAM_CODEC, CelestaleeFurnaceRecipe::output,
                        CelestaleeFurnaceRecipe::new);

        @Override
        public MapCodec<CelestaleeFurnaceRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CelestaleeFurnaceRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
