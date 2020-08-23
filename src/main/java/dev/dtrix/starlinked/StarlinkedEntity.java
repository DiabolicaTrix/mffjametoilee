package dev.dtrix.starlinked;

import dev.dtrix.starlinked.entity.ShamanEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StarlinkedEntity {

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, StarLinked.MODID);

    public static final RegistryObject<EntityType<ShamanEntity>> SHAMAN_ENTITY = ENTITIES.register("shaman", () -> EntityType.Builder.create(ShamanEntity::new, EntityClassification.MISC).size(0.5f,0.5f).setShouldReceiveVelocityUpdates(true).build("shaman"));

    public static void init() {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
