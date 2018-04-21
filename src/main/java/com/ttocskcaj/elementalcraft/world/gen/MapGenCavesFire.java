package com.ttocskcaj.elementalcraft.world.gen;


import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.MapGenCaves;


public class MapGenCavesFire extends MapGenCaves {
    @Override
    protected void recursiveGenerate(World worldIn, int chunkX, int chunkZ, int originalX, int originalZ, ChunkPrimer chunkPrimerIn) {
        float scale = 0.3f;

        int i = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(35) + 1) + 1);

        if (this.rand.nextInt(25) != 0) {
            i = 0;
        }

        for (int j = 0; j < i; ++j) {
            double worldX = (double) (chunkX * 16 + this.rand.nextInt(16));
            double worldY = (double) this.rand.nextInt(this.rand.nextInt(220) + 8);
            double worldZ = (double) (chunkZ * 16 + this.rand.nextInt(16));
            int k = 1;

            if (this.rand.nextInt(4) == 0) {
                this.addRoom(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, worldX, worldY, worldZ);
                k += this.rand.nextInt(4);
            }

            for (int l = 0; l < k; ++l) {
                float circumference = this.rand.nextFloat() * ((float) Math.PI * 2F) * scale;
                float f1 = ((this.rand.nextFloat() - 0.5F) * 2.0F / 8.0F) * scale;
                float f2 = this.rand.nextFloat() * 2.0F + this.rand.nextFloat() * scale;

                if (this.rand.nextInt(10) == 0) {
                    f2 *= this.rand.nextFloat() * this.rand.nextFloat() * 3.0F * scale + 1.0F;
                }

                this.addTunnel(this.rand.nextLong(), originalX, originalZ, chunkPrimerIn, worldX, worldY, worldZ, f2, circumference, f1, 0, 0, 1.0D);
            }
        }
    }
}
