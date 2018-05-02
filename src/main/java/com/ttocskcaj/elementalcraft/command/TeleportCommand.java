package com.ttocskcaj.elementalcraft.command;

import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.util.Config;
import com.ttocskcaj.elementalcraft.util.TeleporterEP;
import net.minecraft.client.resources.I18n;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

public class TeleportCommand extends CommandBase {


    public TeleportCommand() {
        aliases = Lists.newArrayList(ElementalCraft.MOD_ID, "ectp", "ECTP");
    }

    private final List<String> aliases;

    @Override
    @Nonnull
    public String getName() {
        return "ElementalCraft Teleport";
    }

    @Override
    @Nonnull
    public String getUsage(@Nonnull ICommandSender sender) {
        return "ectp <home|earth|air|fire|water>";
    }

    @Override
    @Nonnull
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) throws CommandException {

        if (sender instanceof EntityPlayer) {
            if (args.length < 1) {
                throw new CommandException(I18n.format("must_enter_world"), this);
            } else {
                int dimension = 0;
                switch (args[0]) {
                    case "air":
                        dimension = Config.airDimensionID;
                        break;
                    case "earth":
                        dimension = Config.earthDimensionID;
                        break;
                    case "fire":
                        dimension = Config.fireDimensionID;
                        break;
                    case "water":
                        dimension = Config.waterDimensionID;
                        break;
                }
                try {
                    TeleporterEP.gotToDimension((EntityPlayer) sender, dimension);
                } catch (IllegalArgumentException e) {
                    throw new CommandException(I18n.format("dimension_not_found"), this);
                }

            }
        }
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }

    @Override
    @Nonnull
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
        return Collections.emptyList();
    }

}
