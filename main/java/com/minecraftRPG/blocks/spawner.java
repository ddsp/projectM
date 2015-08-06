package com.minecraftRPG.blocks;

import java.util.Random;

import com.minecraftRPG.tileEntity.TileEntitySpawnerB;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

public class spawner extends BlockContainer {	
	
	World world;
	
	public spawner(Material mat){
		super(mat);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("minecraftrpg:blockSpawner");
    }

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntitySpawnerB(this);
	}
	
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta)
	{
		TileEntitySpawnerB tileentity = (TileEntitySpawnerB)world.getTileEntity(x, y, z);
		meta = world.getBlockMetadata(x, y, z);
		world.removeTileEntity(x, y, z);
		world.setBlock(x, y, z, Blocks.air, 0, 1 | 2);
	}
}
