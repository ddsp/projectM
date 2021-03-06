package com.minecraftRPG.blocks;

import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.main.MinecraftRPG;
import com.minecraftRPG.tileEntity.DarkRitual;
import com.minecraftRPG.tileEntity.LeafTileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class SoulessLeaves extends BlockContainer {

	IIcon[] iconList = new IIcon[5];
	
	public SoulessLeaves(Material material) {
        super(material);
    }
    
	@Override
	public void registerBlockIcons(IIconRegister reg)
    {
        iconList[0] = reg.registerIcon(Strings.IMGMODID+":SoulLeaves0");
        iconList[1] = reg.registerIcon(Strings.IMGMODID+":SoulLeaves1");
        iconList[2] = reg.registerIcon(Strings.IMGMODID+":SoulLeaves2");
        iconList[3] = reg.registerIcon(Strings.IMGMODID+":SoulLeaves3");
        this.blockIcon = iconList[0];
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@Override
	public boolean renderAsNormalBlock()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int meta)
    {
        return iconList[meta];
    }
	
	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}
	
    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new LeafTileEntity();
    }
}
