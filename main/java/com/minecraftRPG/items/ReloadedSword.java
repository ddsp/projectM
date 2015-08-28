package com.minecraftRPG.items;

import java.util.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ReloadedSword extends ItemSword{
	protected float weaponDamage;
	IIcon reloadedSword;
	IIcon unreloadedSword;
	
	public ReloadedSword(ToolMaterial mat, float damage) {
		super(mat);
		weaponDamage = damage; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		reloadedSword = reg.registerIcon("minecraftrpg:ActiveReloadSword");
		unreloadedSword = reg.registerIcon("minecraftrpg:UnactiveReloadSword");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconIndex(ItemStack stack) {
		int reloaduses = 5;
		
		if (stack.stackTagCompound != null) {
			reloaduses = stack.getTagCompound().getInteger("currentCharge");
		}
		
		if(reloaduses > 0){
			this.itemIcon = reloadedSword;
			return reloadedSword;
		}else{
			this.itemIcon = unreloadedSword;
			return unreloadedSword;
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{	
		int reloaduses = stack.getTagCompound().getInteger("currentCharge");
		if(reloaduses > 0){
			
			 
			reloaduses = reloaduses - 1;
			stack.stackTagCompound.setInteger("currentCharge", reloaduses);
			World worldRef = ((EntityPlayer) attacker).worldObj;
			if (!worldRef.isRemote)
			{
				if (reloaduses == 0)
				{
					if(target != null)
					{
						worldRef.createExplosion(null , target.posX, target.posY+1, target.posZ, 0.9F, false);
						this.weaponDamage = 0.0f;
					}
				}
			}
		}
		return true;
	}

	
	@Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.stackTagCompound = new NBTTagCompound(); 
		stack.stackTagCompound.setInteger("currentCharge", 5);
    }
	
	//https://www.youtube.com/watch?v=8WpEPQtPsTc
	
	/*@Override
	public Multimap getAttributeModifiers(ItemStack stack)
    {
        Multimap multimap = super.getItemAttributeModifiers();
        System.out.println(multimap.size());        
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 3, 0));
        return multimap;
    }
	
	@Override
	public Multimap getItemAttributeModifiers()
    {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.field_150934_a, 0));
        return multimap;
    }*/

// adds 'tooltip' text
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
    	 if (stack.stackTagCompound != null) {
    		 int reloaduses = stack.stackTagCompound.getInteger("currentCharge");
             list.add("Current Charge: " + reloaduses);
    	 }else{
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setInteger("currentCharge", 5);
    	 }
     }
}
