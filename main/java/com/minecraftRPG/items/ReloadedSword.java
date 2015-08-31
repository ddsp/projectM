package com.minecraftRPG.items;

import java.util.List;
import java.util.Random;

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
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) {
		if(stack.stackTagCompound.getBoolean("using")){
			int time = stack.stackTagCompound.getInteger("time") - 1;
			if(time > 0){
				stack.stackTagCompound.setInteger("time", time);
				if(world.isRemote){
					world.spawnParticle("instantSpell", player.posX, player.posY-1, player.posZ-2, 0, 0, 0);
				}
			}else{
				stack.stackTagCompound.setInteger("time", 100);
				stack.stackTagCompound.setBoolean("using", false);
			}
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{	
		int reloaduses = stack.getTagCompound().getInteger("currentCharge");
		World worldRef = ((EntityPlayer) attacker).worldObj;
		if(reloaduses > 0){
			if(!stack.stackTagCompound.getBoolean("using")){
				reloaduses = reloaduses - 1;
				if(reloaduses > 0){
				stack.stackTagCompound.setBoolean("using", true);
				}
			}
			stack.stackTagCompound.setInteger("currentCharge", reloaduses);
			if (!worldRef.isRemote)
			{
				if (reloaduses == 0)
				{
					if(target != null)
					{
						worldRef.createExplosion(null , target.posX, target.posY+1, target.posZ, 0.9F, false);
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
		stack.stackTagCompound.setInteger("time", 100);
		stack.stackTagCompound.setBoolean("using", false);
    }
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
    {
        Multimap multimap = super.getItemAttributeModifiers(); 
        multimap.clear();
        int reloaduses = stack.getTagCompound().getInteger("currentCharge");
		if(reloaduses > 0){
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
		}else{
			multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 1, 0));
		}
        return multimap;
    }

	// adds 'tooltip' text
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
    	 if (stack.stackTagCompound != null) {
    		 int reloaduses = stack.stackTagCompound.getInteger("currentCharge");
             list.add("Current Charge: " + reloaduses);
             if(stack.stackTagCompound.getBoolean("using")){
            	 int time = stack.stackTagCompound.getInteger("time")/20;
            	 list.add("Cooldown: " + time);
             }
    	 }else{
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setInteger("currentCharge", 5);
    		 stack.stackTagCompound.setInteger("time", 100);
    		 stack.stackTagCompound.setBoolean("using", false);
    	 }
     }
}
