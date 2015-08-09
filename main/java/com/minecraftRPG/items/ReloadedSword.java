package com.minecraftRPG.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ReloadedSword extends ItemSword{
	protected final float weaponDamage;
	public int reloaduses = 5;
	
	public ReloadedSword(ToolMaterial mat, float damage) {
		super(mat);
		this.weaponDamage = damage;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("minecraftrpg:ActiveReloadSword");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		return itemStack;
    }
}
