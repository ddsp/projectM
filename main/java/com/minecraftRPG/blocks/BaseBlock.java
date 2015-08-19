package com.minecraftRPG.blocks;

import com.minecraftRPG.tileEntity.DarkRitual;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BaseBlock extends BlockContainer {
    
	public BaseBlock(Material material) {
        super(material);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        TileEntity tile = world.getTileEntity(x, y, z);
        
        super.onNeighborBlockChange(world, x, y, z, block);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new DarkRitual();
    }
}