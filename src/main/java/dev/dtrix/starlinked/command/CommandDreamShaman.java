package dev.dtrix.starlinked.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import dev.dtrix.starlinked.StarLinkedProfessions;
import dev.dtrix.starlinked.dimension.StarLinkedDimensions;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

public class CommandDreamShaman implements Command<CommandSource> {

    private static final CommandDreamShaman CMD = new CommandDreamShaman();

    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("shaman")
                .requires(cs -> cs.hasPermissionLevel(0))
                .executes(CMD);
    }

    @Override
    public int run(CommandContext<CommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().asPlayer();
        VillagerEntity entity = new VillagerEntity(EntityType.VILLAGER, player.world);
        entity.setVillagerData(entity.getVillagerData().withProfession(StarLinkedProfessions.SHAMAN_PROFESSION.get()).withLevel(1));
        entity.resetBrain(player.getServerWorld());
        entity.setPosition(player.getPosX(), player.getPosY(), player.getPosZ());
        player.world.addEntity(entity);
        return 0;
    }
}
