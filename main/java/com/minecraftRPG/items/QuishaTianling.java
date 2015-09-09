package com.minecraftRPG.items;

import java.util.List;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Multimap;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import com.minecraftRPG.armor.MinecraftRPGFirstArmor;

public class QuishaTianling extends ItemSword{
	
	protected float weaponDamage;
	
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
		return true;
	}
    
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {	
		super.onItemRightClick(item, world, player);		
        return item;
    }
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
    {
		int DamageBoost = stack.stackTagCompound.getInteger("DamageBoost");
		
        Multimap multimap = super.getItemAttributeModifiers(); 
        multimap.clear();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", this.weaponDamage + DamageBoost, 0));
        return multimap;
    }
		
	// adds 'tooltip' text
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
		//stack.getTooltip(player, false);
		
		EnumChatFormatting[] colorChar = 
	    {
	        EnumChatFormatting.RED,
	        EnumChatFormatting.GOLD,
	        EnumChatFormatting.YELLOW,
	        EnumChatFormatting.GREEN,
	        EnumChatFormatting.AQUA,
	        EnumChatFormatting.DARK_GRAY,
	        EnumChatFormatting.LIGHT_PURPLE,
	        EnumChatFormatting.DARK_PURPLE
	    }; 
		
		if (stack.stackTagCompound != null) {
    		 int Souls = stack.stackTagCompound.getInteger("Souls");
    		 int SoulLVL = stack.stackTagCompound.getInteger("SoulEaterLVL");
    		 int DamageLVL = stack.stackTagCompound.getInteger("DamageBoostLVL");
    		 int DamageBoost = stack.stackTagCompound.getInteger("DamageBoost");
    		 
    		 String SoulSlave = stack.stackTagCompound.getString("SoulSlave");
    		 
    		 boolean SoulEaterActive = stack.stackTagCompound.getBoolean("SoulEaterActive");
    		 boolean DamageBoostActive = stack.stackTagCompound.getBoolean("DamageBoostActive");
    		 
    		 
    		 list.add("Souls: " + Souls + "    Soul Slave: " + SoulSlave);
    		 list.add(" ");
    		 
    		 if(Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
    		 {
    			 if(SoulEaterActive == true)
        		 {
        			 list.add(colorChar[6%8] + "SoulEater lvl " + SoulLVL);
        		 }
    			 else
    			 {
    				 list.add(colorChar[5%8] + "To be unlocked.");
    			 }
        		 
        		 if(DamageBoostActive == true)
        		 {
        			 list.add(colorChar[2%8] + "Damage Boost lvl " + DamageLVL);
        		 }
        		 else
    			 {
    				 list.add(colorChar[5%8] + "To be unlocked.");
    			 }
    		 }
    		 else
    		 {
    			 list.add("Press Shift to see details.");
    		 }
    		 
    	 }else{
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setString("SoulSlave", "");
    		 stack.stackTagCompound.setInteger("healingDivider", 5);
    		 stack.stackTagCompound.setInteger("DamageBoost", 0);
    		 stack.stackTagCompound.setInteger("DamageBoostLVL", 0);
    		 stack.stackTagCompound.setBoolean("DamageBoostActive", false);
    		 stack.stackTagCompound.setInteger("Souls", 0);
    		 stack.stackTagCompound.setInteger("SoulEaterLVL", 0);
    		 stack.stackTagCompound.setBoolean("SoulEaterActive", false);
    	 }
     }
}
