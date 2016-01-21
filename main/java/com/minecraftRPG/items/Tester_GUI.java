package com.minecraftRPG.items;

import com.minecraftRPG.GUI.GUILimiter_Def;
import com.minecraftRPG.GUI.ritualsGUI;
import com.minecraftRPG.mobs.entity.EntityBlackWolf;
import com.minecraftRPG.mobs.entity.EntityFlyingTestC;
import com.minecraftRPG.mobs.model.BlackWolf;
import com.minecraftRPG.structures.test;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Tester_GUI extends Item{
	
	public Tester_GUI(){
		super();
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		Minecraft.getMinecraft().displayGuiScreen(new ritualsGUI());
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("StrucFab:fab");
	}
	
}
