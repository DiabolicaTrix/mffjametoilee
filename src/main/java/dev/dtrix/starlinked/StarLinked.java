package dev.dtrix.starlinked;

import dev.dtrix.starlinked.client.renderer.ClientSetup;
import dev.dtrix.starlinked.command.StarlinkedCommands;
import dev.dtrix.starlinked.dimension.StarLinkedDimensions;
import dev.dtrix.starlinked.structure.StarlinkedStructures;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(StarLinked.MODID)
public class StarLinked
{
    public static final String MODID = "starlinked";

    private static final Logger LOGGER = LogManager.getLogger();

    public StarLinked() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(ClientSetup::init);
        MinecraftForge.EVENT_BUS.addListener(this::serverLoad);

        StarLinkedDimensions.init();
        StarLinkedProfessions.init();
        StarlinkedBlocks.init();
        StarlinkedEntity.init();
        StarLinkedItems.ITEMS.register(modEventBus);
    }

    public void commonSetup(FMLCommonSetupEvent event) {
        Biomes.PLAINS.addStructure(StarlinkedStructures.SHAMAN_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        Biomes.PLAINS.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, StarlinkedStructures.SHAMAN_HUT.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG).withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
       // DeferredWorkQueue.runLater(StarlinkedStructure::setupStructure);
    }

    public void serverLoad(FMLServerStartingEvent event) {
        StarlinkedCommands.register(event.getCommandDispatcher());
    }

}
