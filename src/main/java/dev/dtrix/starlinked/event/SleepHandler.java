package dev.dtrix.starlinked.event;

import dev.dtrix.starlinked.StarlinkedBlocks;
import dev.dtrix.starlinked.command.TeleportationTools;
import dev.dtrix.starlinked.dimension.StarLinkedDimensions;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Iterator;

@Mod.EventBusSubscriber
public class SleepHandler {

    @SubscribeEvent
    public static void onSleep(PlayerSleepInBedEvent event) {
        if(!event.getPlayer().world.isRemote && isBelowDreamCatcher(event.getEntity().getEntityWorld(), event.getPos())) {
            ServerPlayerEntity player = (ServerPlayerEntity) event.getPlayer();
            if (event.getPlayer().dimension.equals(StarLinkedDimensions.DREAM_DIMENSION_TYPE)) {
                TeleportationTools.teleport(player, DimensionType.OVERWORLD, new BlockPos(player.getPosX(), 200, player.getPosZ()));
            } else {
                TeleportationTools.teleport(player, StarLinkedDimensions.DREAM_DIMENSION_TYPE, new BlockPos(0, 50,0));
            }
        }
    }

    private static boolean isBelowDreamCatcher(World world, BlockPos blockPos) {
        for (BlockPos pos : BlockPos.getAllInBoxMutable(blockPos.add(-1, 0, -1), blockPos.add(1, 1, 1))) {
            if(world.getBlockState(pos).getBlock().equals(StarlinkedBlocks.DREAM_CATCHER.get())) {
                return true;
            }
        }
        return false;
    }

}
