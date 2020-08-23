package dev.dtrix.starlinked.event;

import dev.dtrix.starlinked.StarLinked;
import dev.dtrix.starlinked.entity.ShamanEntity;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DimensionEvent {

    @SubscribeEvent
    public static void enterDimension(EntityJoinWorldEvent event) {
        if(event.getEntity() instanceof PlayerEntity && event.getWorld() instanceof ServerWorld && event.getWorld().getBlockState(new BlockPos(0, 0, 0)).getBlock() == Blocks.BEDROCK) {
            ServerWorld world = (ServerWorld) event.getWorld();
            TemplateManager templateManager = world.getStructureTemplateManager();
            templateManager.getTemplate(new ResourceLocation(StarLinked.MODID, "shaman_hut/spawn")).addBlocksToWorld(world, new BlockPos(0, 0, 0), new PlacementSettings());
            templateManager.getTemplate(new ResourceLocation(StarLinked.MODID, "shaman_hut/portal")).addBlocksToWorld(world, new BlockPos(-32, 1, 0), new PlacementSettings());
            ShamanEntity entity = new ShamanEntity(EntityType.VILLAGER, world);
            entity.setPositionAndRotation(7.6D, 3.0D, 12.4D, -95, 0);
            event.getWorld().addEntity(entity);
        }
    }

}
