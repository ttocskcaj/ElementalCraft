package com.ttocskcaj.elementalcraft.world;

import com.ttocskcaj.elementalcraft.util.Config;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;

import javax.annotation.Nonnull;

public class TeleporterEP extends Teleporter {

    public TeleporterEP(WorldServer world, double x, double y, double z) {
        super(world);
        this.worldServer = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private final WorldServer worldServer;
    private double x;
    private double y;
    private double z;

    @Override
    public void placeInPortal(@Nonnull Entity entity, float rotationYaw) {
        // The main purpose of this function is to *not* create a nether portal
        this.worldServer.getBlockState(new BlockPos((int) this.x, (int) this.y, (int) this.z));

        entity.setPosition(this.x, this.y, this.z);
        entity.motionX = 0.0f;
        entity.motionY = 0.0f;
        entity.motionZ = 0.0f;
    }


    public static void switchDimensions(EntityPlayer player) {
        int oldDimension = player.getEntityWorld().provider.getDimension();
        int newDimension = 0;
        int x = player.getPosition().getX();
        int y = 128;
        int z = player.getPosition().getZ();

        if (oldDimension == Config.dimensionID) {
            newDimension = 0;
        } else newDimension = 50;
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
        MinecraftServer server = player.getEntityWorld().getMinecraftServer();

        WorldServer worldServer = server.getWorld(newDimension);

        if (worldServer == null || worldServer.getMinecraftServer() == null) { //Dimension doesn't exist
            throw new IllegalArgumentException("Dimension: " + newDimension + " doesn't exist!");
        }

        worldServer.getMinecraftServer().getPlayerList().transferPlayerToDimension(entityPlayerMP, newDimension, new TeleporterEP(worldServer, x, y, z));
        player.setPositionAndUpdate(x, y, z);
    }

}
