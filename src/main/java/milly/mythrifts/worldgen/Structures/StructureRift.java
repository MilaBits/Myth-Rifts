package milly.mythrifts.worldgen.Structures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class StructureRift extends WorldGenerator {

    private final int[][] riftpos = new int[][]
            {
                    // corners (first layer)
                    {0,0,0},{0,1,0},	// front-left
                    {4,0,0},{4,1,0},	// front-right
                    {4,0,4},{4,1,4},	// back-right
                    {0,0,4},{0,1,4},	// back-left
                    // upper trim (first part of roof)
                    {0,2,0},{1,2,0},{2,2,0},{3,2,0},{4,2,0},	// front
                    {0,2,4},{1,2,4},{2,2,4},{3,2,4},{4,2,4},	// back
                    {0,2,1},{0,2,2},{0,2,3},	// left
                    {4,2,1},{4,2,2},{4,2,3},	// right
                    // roof
                    {1,3,1},{2,3,1},{3,3,1},
                    {1,3,2},{2,3,2},{3,3,2},
                    {1,3,3},{2,3,3},{3,3,3}
            };



    private boolean canReplace(World world, BlockPos pos)
    {
        Block at = world.getBlockState(pos).getBlock();
        Material material = at.getMaterial(at.getDefaultState());
        // we think it's replaceable if it's air / liquid / snow, plants, or leaves
        return material.isReplaceable() || material == Material.PLANTS || material == Material.LEAVES;
    }

    private boolean canSpawnHere(World world, BlockPos posAboveGround, int structureSize)
    {
        // check all the corners to see which ones are replaceable
        boolean corner1Air = canReplace(world, posAboveGround);
        boolean corner2Air = canReplace(world, posAboveGround.add(structureSize, 0, 0));
        boolean corner4Air = canReplace(world, posAboveGround.add(0, 0, structureSize));
        boolean corner3Air = canReplace(world, posAboveGround.add(structureSize, 0, 4));

        // if Y > 20 and all corners pass the test, it's okay to spawn the structure
        return posAboveGround.getY() > 20 && corner1Air && corner2Air && corner3Air && corner4Air;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        return false;
    }
}
