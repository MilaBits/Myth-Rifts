package milly.mythrifts.worldgen;

import milly.mythrifts.MythRifts;
import milly.mythrifts.common.block.BlockTestBlock;
import milly.mythrifts.common.init.ModBlocks;
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

    // TODO: Make editable in a config file
    public static final int MIN_SPAWN_HEIGHT = 0;
    public static final int MAX_SPAWN_HEIGHT = 255;
    public static final float SPAWN_RATE = 1f; // between 0 and 1

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {

        Block riftBlock = ModBlocks.TestBlock;

        int y = getGroundFromAbove(worldIn, position.getX(), position.getZ());

        if (y >= position.getY()) {
            BlockPos riftPos = new BlockPos(position.getX(), y + 1, position.getZ());
            BlockPos riftTopPos = new BlockPos(position.getX(), y + 2, position.getZ());
            Block toReplace = worldIn.getBlockState(riftPos).getBlock();

            if (toReplace == Blocks.AIR || toReplace.getMaterial(toReplace.getDefaultState()) == Material.PLANTS) {
                worldIn.setBlockState(riftPos, riftBlock.getDefaultState());
                worldIn.setBlockState(riftTopPos, riftBlock.getDefaultState());
            }
        }
        return false;
    }

    public static int getGroundFromAbove(World world, int x, int z) {
        int y = WorldGenRift.MAX_SPAWN_HEIGHT;
        boolean foundGround = false;
        while (!foundGround && y-- >= MIN_SPAWN_HEIGHT) {
            Block blockAt = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            // "ground" for our bush is grass or dirt
            foundGround = blockAt == Blocks.DIRT || blockAt == Blocks.GRASS || blockAt == Blocks.SAND || blockAt == Blocks.STONE || blockAt == Blocks.GRAVEL;
        }

        return y;
    }

//    @Override
//    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
//
//    }
}
