package dev.dtrix.starlinked.structure;

import dev.dtrix.starlinked.StarLinked;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Iterator;

public class StarlinkedStructures {

    public static Structure<NoFeatureConfig> SHAMAN_HUT = new ShamanHutStructure(NoFeatureConfig::deserialize);
    public static final IStructurePieceType SHAMAN_HUT_PIECE = Registry.register(Registry.STRUCTURE_PIECE, new ResourceLocation(StarLinked.MODID, "shaman_hut_piece"), ShamanHutPiece.ShamanHut::new);

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void onRegister(RegistryEvent.Register<Feature<?>> event) {
            event.getRegistry().register(SHAMAN_HUT.setRegistryName("shaman_hut"));
        }

    }

}
