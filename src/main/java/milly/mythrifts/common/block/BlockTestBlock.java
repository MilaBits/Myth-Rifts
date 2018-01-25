package milly.mythrifts.common.block;

import milly.mythrifts.MythRifts;
import milly.mythrifts.common.lib.BlockNames;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockTestBlock extends Block {
    public BlockTestBlock() {

        super(Material.ROCK);
        setBlockName(this, BlockNames.TEST_BLOCK);
        this.setHardness(2);

        //TODO: Creative Tab
        //setCreativeTab(this, MythRifts.CreativeTab);
    }

    public static void setBlockName(final Block block, final String blockName) {
        block.setRegistryName(MythRifts.MODID, blockName);
        block.setUnlocalizedName(block.getRegistryName().toString());
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(this);
    }
}
