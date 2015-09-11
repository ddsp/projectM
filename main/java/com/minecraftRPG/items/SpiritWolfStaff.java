package com.minecraftRPG.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntitySpiritWolf;
import com.minecraftRPG.mobs.IvisiProj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class SpiritWolfStaff extends ItemSword{
	
	protected final float weaponDamage;
	protected int cooldown;
	
	
	public SpiritWolfStaff(ToolMaterial mat, float damage) {
		super(mat);
		this.weaponDamage = damage;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("minecraftrpg:SpiritWolfStaff");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		
		if(cooldown == 0){
			if (!world.isRemote)
			{					
				
				world.spawnEntityInWorld(new IvisiProj( world, player, this));
				cooldown = 60;
			}
		}else{
			player.addChatComponentMessage(new ChatComponentText("This item is on cooldown "+ cooldown + "."));
		}
		
		return itemStack;
    }
	
	@Override
	public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {
		if(cooldown > 0){
			cooldown--;
		}
	}
	
	@Override
	public Multimap getItemAttributeModifiers(){
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier",  (double) this.weaponDamage, 0));
		return multimap;
	}
	
	public void increaseCooldown(){
		cooldown = 200; 
	}
}
