package milly.mythrifts.worldgen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class MythRiftsWorldGenerator implements IWorldGenerator {

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

        int blockX = chunkX * 16;
        int blockZ = chunkZ * 16;

        if (world.provider.getDimensionType() == DimensionType.OVERWORLD) {
            generateOverworld(world, random, blockX, blockZ);
        }
    }

    private void generateOverworld(World world, Random random, int blockX, int blockZ) {
        WorldGenerator genRifts= new WorldGenRift();

        //Random float below 1 to compare with spawnrate
        float genFloat = random.nextFloat() * (1);

        if (genFloat <= WorldGenRift.SPAWN_RATE){
            int randX = blockX + random.nextInt(16);
            int randZ = blockZ + random.nextInt(16);

            // Y value is minimum height to spawn at
            genRifts.generate(world, random, new BlockPos(randX, WorldGenRift.MIN_SPAWN_HEIGHT, randZ));
        }
    }
}
