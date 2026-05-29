package net.eskimo.voiditemod.events;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.entity.client.VKProjectileModel;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;


@EventBusSubscriber(modid = VoiditeMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(VKProjectileModel.LAYER_LOCATION, VKProjectileModel::createBodyLayer);
    }
}