package milly.mythrifts.worldgen.Structures;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureRift extends WorldGenerator {



    private boolean canReplace(World world, BlockPos pos)
    {
        Block at = world.getBlockState(pos).getBlock();
        Material material = at.getMaterial(at.getDefaultState());
        // we think it's replaceable if it's air / liquid / snow, plants, or leaves
        return material.isReplaceable() || material == Material.PLANTS || material == Material.LEAVES;
    }
}
