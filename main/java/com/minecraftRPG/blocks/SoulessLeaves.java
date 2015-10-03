package com.minecraftRPG.blocks;

import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.tileEntity.DarkRitual;
import com.minecraftRPG.tileEntity.LeafTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class SoulessLeaves extends BlockContainer {

	public SoulessLeaves(Material material) {
        super(material);
    }
    
	@Override
	public void registerBlockIcons(IIconRegister reg)
    {
        this.blockIcon = reg.registerIcon(Strings.IMGMODID+":WhiteLeaves");
    }
	
	
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new LeafTileEntity();
    }
}
