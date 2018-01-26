package milly.mythrifts.worldgen;

import milly.mythrifts.common.block.BlockTestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenRift extends WorldGenerator /*implements IWorldGenerator*/ {

    public WorldGenRift() {
//        rift = new WorldGen
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        Block riftBlock = new BlockTestBlock();

        int y = getGroundFromAbove(worldIn, position.getX(), position.getZ());

        if (y >= position.getY()) {
            BlockPos riftPos = new BlockPos(position.getX(), y, position.getZ());
            BlockPos riftTopPos = new BlockPos(position.getX(), y + 1, position.getZ());
            Block toReplace = worldIn.getBlockState(riftPos).getBlock();
            if (toReplace == Blocks.AIR) {
                worldIn.setBlockState(riftPos, riftBlock.getDefaultState(), 2);
                worldIn.setBlockState(riftTopPos, riftBlock.getDefaultState(), 2);
            }
        }
        return false;
    }

    public static int getGroundFromAbove(World world, int x, int z) {
        int y = 255;
        boolean foundGround = false;
        while (!foundGround && y-- >= 0) {
            Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            // "ground" for our bush is grass or dirt
            // foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS;
        }

        return y;
    }

//    @Override
//    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
//
//    }
}