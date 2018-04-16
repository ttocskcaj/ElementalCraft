package com.ttocskcaj.elementalcraft.command;

import com.google.common.collect.Lists;
import com.sun.istack.internal.Nullable;
import com.ttocskcaj.elementalcraft.ElementalCraft;
import com.ttocskcaj.elementalcraft.dimension.TeleporterEP;
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
        return "ectp";
    }

    @Override
    @Nonnull
    public String getUsage(@Nonnull ICommandSender sender) {
        return "ectp";
    }

    @Override
    @Nonnull
    public List<String> getAliases() {
        return aliases;
    }

    @Override
    public void execute(@Nonnull MinecraftServer server, @Nonnull ICommandSender sender, @Nonnull String[] args) throws CommandException {

        if (sender instanceof EntityPlayer) {
            TeleporterEP.switchDimensions((EntityPlayer) sender);
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
