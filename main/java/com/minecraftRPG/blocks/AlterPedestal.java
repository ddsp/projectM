package com.minecraftRPG.blocks;

import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.tileEntity.AlterPedestalTileEntity;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AlterPedestal extends BlockContainer{
	//Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
    //And the second three are the top-right corner.
    public AlterPedestal(Material mat) {
            super(mat);
    }

    //Make sure you set this as your TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
            return new AlterPedestalTileEntity();
    }
    
    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
    
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    //This is the icon to use for showing the block in your hand.
    public void registerIcons(IIconRegister icon) {
            this.blockIcon = icon.registerIcon(Strings.IMGMODID+":AlterPedestalV1");
    }
}
