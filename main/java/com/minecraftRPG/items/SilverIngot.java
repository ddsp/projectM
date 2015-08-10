package com.minecraftRPG.items;

import com.minecraftRPG.blocks.MinecraftRPGBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SilverIngot extends Item{
	public SilverIngot(){
		super();
		this.setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		this.setMaxStackSize(64);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("minecraftrpg:SilverIngot");
	}
}
