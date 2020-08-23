package dev.dtrix.starlinked.client.renderer;

import dev.dtrix.starlinked.StarLinked;
import dev.dtrix.starlinked.StarlinkedEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientSetup {

    public static void init(FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(StarlinkedEntity.SHAMAN_ENTITY.get(), ShamanEntityRenderer::new);
    }

}
