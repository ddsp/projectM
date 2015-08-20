package com.minecraftRPG.items;

import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.models.BlackWolf;
import com.minecraftRPG.structures.test;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class StrucFab extends Item{
	
	public StrucFab(){
		super();
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{
		if (!world.isRemote)
		{
			EntityBlackWolf wolf = new EntityBlackWolf(world);
			wolf.setLocationAndAngles(x, y+2, z,world.rand.nextFloat() * 360.0F, 0.0F);
			world.spawnEntityInWorld(wolf);
		}
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("StrucFab:fab");
	}
	
}
