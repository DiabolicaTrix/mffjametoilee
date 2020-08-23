package dev.dtrix.starlinked.dimension;

import dev.dtrix.starlinked.StarLinked;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ModDimension;
import net.minecraftforge.event.world.RegisterDimensionsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class StarLinkedDimensions {

    public static ResourceLocation DREAM_DIMENSION_ID = new ResourceLocation(StarLinked.MODID, "dream_dimension");

    public static final DeferredRegister<ModDimension> DIMENSIONS = DeferredRegister.create(ForgeRegistries.MOD_DIMENSIONS, StarLinked.MODID);

    public static final RegistryObject<ModDimension> DREAM_DIMENSION = DIMENSIONS.register("dream_dimension", StarLinkedDimension::new);
    public static DimensionType DREAM_DIMENSION_TYPE;

    public static void init() {
        DIMENSIONS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EventHandler {

        @SubscribeEvent
        public static void onDimensionRegister(RegisterDimensionsEvent event) {
            DREAM_DIMENSION_TYPE = DimensionManager.registerOrGetDimension(DREAM_DIMENSION_ID, DREAM_DIMENSION.get(), null, true);
        }

    }

}
