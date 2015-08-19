package com.minecraftRPG.items;

import com.minecraftRPG.GUI.GuiFirstBook;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CostumBook  extends Item
{
	public CostumBook()
	{
		super();
    	this.setMaxStackSize(1);
    }
   
   public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
   {
	   if (player.worldObj.isRemote)
	   {
		   Minecraft.getMinecraft().displayGuiScreen(new GuiFirstBook());
	   }
	   
	   return par1ItemStack;
   }
}
