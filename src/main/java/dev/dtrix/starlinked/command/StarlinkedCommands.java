package dev.dtrix.starlinked.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import dev.dtrix.starlinked.StarLinked;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class StarlinkedCommands {

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        LiteralCommandNode<CommandSource> cmdTut = dispatcher.register(
                Commands.literal(StarLinked.MODID)
                        .then(CommandDreamTp.register(dispatcher))
                        .then(CommandDreamShaman.register(dispatcher))
        );

        dispatcher.register(Commands.literal("tut").redirect(cmdTut));
    }

}
