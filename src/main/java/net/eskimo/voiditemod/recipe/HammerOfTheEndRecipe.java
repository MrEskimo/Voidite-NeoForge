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

public record HammerOfTheEndRecipe(Ingredient inputItem, ItemStack output) implements Recipe<HammerOfTheEndRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(HammerOfTheEndRecipeInput hammerOfTheEndRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(hammerOfTheEndRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(HammerOfTheEndRecipeInput hammerOfTheEndRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.HAMMER_OF_THE_END_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.HAMMER_OF_THE_END_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<HammerOfTheEndRecipe> {
        public static final MapCodec<HammerOfTheEndRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(HammerOfTheEndRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(HammerOfTheEndRecipe::output)
        ).apply(inst, HammerOfTheEndRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, HammerOfTheEndRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, HammerOfTheEndRecipe::inputItem,
                        ItemStack.STREAM_CODEC, HammerOfTheEndRecipe::output,
                        HammerOfTheEndRecipe::new);

        @Override
        public MapCodec<HammerOfTheEndRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, HammerOfTheEndRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}