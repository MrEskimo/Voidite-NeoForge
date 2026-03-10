package net.eskimo.voiditemod.events;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.item.ModItems;
import net.eskimo.voiditemod.potion.ModPotions;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber(modid = VoiditeMod.MOD_ID, bus = EventBusSubscriber.Bus.GAME)
public class ModEvents {

    @SubscribeEvent
    public static void onBrewingRecipeRegister(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, ModItems.GLOWING_VOID_BERRIES.get(), ModPotions.GLOWING_POTION);
    }
}
