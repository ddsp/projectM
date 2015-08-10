package com.minecraftRPG.blocks;

import java.util.Random;

import com.minecraftRPG.items.MinecraftRPGitems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class SilverOre  extends Block{

	protected SilverOre(Material mat) {
		super(mat);
		this.setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		this.setHarvestLevel("pickaxe", 1);
	}
	
	@Override
	public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("minecraftrpg:silverore");
    }
	
	public Item getItemDropped(int par1, Random rand, int par2){
		return MinecraftRPGitems.SilverIngot;
	}
	
	public int quantityDropped(Random rand){
		return rand.nextInt(3) + 1;
	}
	
	private Random rand = new Random();
	@Override
	public int getExpDrop(IBlockAccess p_149690_1_, int p_149690_5_, int p_149690_7_){
		if (this.getItemDropped(p_149690_5_, rand, p_149690_7_) != Item.getItemFromBlock(this))
		{
			return 1 + rand.nextInt(5);
		}
		return 0;
	}

}
