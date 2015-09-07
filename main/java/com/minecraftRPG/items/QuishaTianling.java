package com.minecraftRPG.items;

import java.util.List;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.minecraftRPG.armor.MinecraftRPGFirstArmor;

public class QuishaTianling extends ItemSword{
	
	protected float weaponDamage;
	int damageDealt = 0;
	
	public QuishaTianling(ToolMaterial mat, float damage) {
		super(mat);
		weaponDamage = damage; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		reg.registerIcon("minecraftrpg:ActiveReloadSword");
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) {
		super.onUpdate(stack, world, player, par4, par5);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{	
		//super.hitEntity(stack, target, attacker);
		damageDealt += (int) (target.prevHealth - target.getHealth());
		System.out.println(damageDealt);
		return true;
	}
    
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {	
		super.onItemRightClick(item, world, player);		
        return item;
    }
	
	@Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.stackTagCompound = new NBTTagCompound(); 
		stack.stackTagCompound.setInteger("currentCharge", 0);
		stack.stackTagCompound.setInteger("time", 100);
		stack.stackTagCompound.setBoolean("using", false);
    }
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
    {
        Multimap multimap = super.getItemAttributeModifiers(); 
        multimap.clear();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage, 0));
        return multimap;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 16);
		System.out.println(entity.isDead);
        return false;
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
    		 stack.stackTagCompound.setInteger("currentCharge", 0);
    		 stack.stackTagCompound.setInteger("time", 100);
    		 stack.stackTagCompound.setBoolean("using", false);
    	 }
     }
}
