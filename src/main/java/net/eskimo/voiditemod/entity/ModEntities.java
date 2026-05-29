package net.eskimo.voiditemod.entity;

import net.eskimo.voiditemod.VoiditeMod;
import net.eskimo.voiditemod.entity.custom.VKProjectileEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;


public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, VoiditeMod.MOD_ID);

    public static final Supplier<EntityType<VKProjectileEntity>> VK =
            ENTITY_TYPES.register("vk", () -> EntityType.Builder.<VKProjectileEntity>of(VKProjectileEntity::new, MobCategory.MISC)
                    .sized(0.5f, 1.15f).build("vk"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
