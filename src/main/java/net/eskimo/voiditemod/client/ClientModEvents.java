package net.eskimo.voiditemod.client;

import net.eskimo.voiditemod.screen.ModMenuTypes;
import net.eskimo.voiditemod.screen.custom.CelestaleeFurnaceScreen;
import net.eskimo.voiditemod.screen.custom.HammerOfEndScreen;
import net.eskimo.voiditemod.util.ModTags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.ViewportEvent;

import static net.eskimo.voiditemod.VoiditeMod.MOD_ID;

// You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
@EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {


    @SubscribeEvent
    public static void denserFog(ViewportEvent.RenderFog event) {
        ClientLevel level = Minecraft.getInstance().level;
        BlockPos pos = Minecraft.getInstance().player.getOnPos();
        if(level == null) return;
        Holder<Biome> biome = level.getBiome(pos);
        if(biome.is(ModTags.Biomes.FOG)) {
            event.setFarPlaneDistance(10);
            event.setNearPlaneDistance(5);
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
    }

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.CELESTALEE_FURNACE_MENU.get(), CelestaleeFurnaceScreen::new);
        event.register(ModMenuTypes.HAMMER_OF_END_MENU.get(), HammerOfEndScreen::new);
    }
}
