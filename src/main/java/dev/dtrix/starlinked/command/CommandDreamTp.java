package dev.dtrix.starlinked.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.dtrix.starlinked.dimension.StarLinkedDimensions;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

public class CommandDreamTp implements Command<CommandSource> {

    private static final CommandDreamTp CMD = new CommandDreamTp();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("dim")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        if (player.dimension.equals(StarLinkedDimensions.DREAM_DIMENSION_TYPE)) {
            TeleportationTools.teleport(player, DimensionType.OVERWORLD, new BlockPos(player.getPosX(), 200, player.getPosZ()));
        } else {
            TeleportationTools.teleport(player, StarLinkedDimensions.DREAM_DIMENSION_TYPE, new BlockPos(19, 3, 11));
        }
        return 0;
    }
}
