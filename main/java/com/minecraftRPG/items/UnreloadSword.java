package com.minecraftRPG.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import javax.swing.Icon;

import com.minecraftRPG.mobs.IvisiProj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class UnreloadSword extends ItemSword{
	
	protected final float weaponDamage;
	
	public UnreloadSword(ToolMaterial mat, float damage) {
		super(mat);
		this.weaponDamage = damage;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("minecraftrpg:UnactiveReloadSword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		return itemStack;
    }
	
}
