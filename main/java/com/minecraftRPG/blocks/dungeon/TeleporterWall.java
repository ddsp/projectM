package com.minecraftRPG.blocks.dungeon;

import com.minecraftRPG.tileEntity.DarkRitual;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TeleporterWall extends Block{
    
	public TeleporterWall(Material material) {
        super(material);
    }
	
	@Override
	public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon("minecraftrpg:tWall");
    }	
}