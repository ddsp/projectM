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
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.minecraftRPG.armor.MinecraftRPGFirstArmor;

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
    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.bow;
    }
    
	
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 240;
    }
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
		System.out.println(count);
    }
    
	@Override
	public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {	
		if(!world.isRemote){
			player.setItemInUse(item, this.getMaxItemUseDuration(item));
			if(player.inventory.armorInventory[2] != null){
				ItemStack bodyArmor = player.inventory.armorInventory[2];
				
				int charge = 0;
				int charge2 = item.stackTagCompound.getInteger("currentCharge");
				
				if(bodyArmor.stackTagCompound == null){
					System.out.println("Erro");
				}else{
					charge = bodyArmor.stackTagCompound.getInteger("charge");
				}
				
				if(charge > 0){
					charge--;					
					charge2++;
					
					bodyArmor.stackTagCompound.setInteger("charge", charge);
					item.stackTagCompound.setInteger("currentCharge", charge2);
				}
			}	
		}
		
        return item;
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int count)
    {
		System.out.println("HelloS");
    }
	
	@Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.stackTagCompound = new NBTTagCompound(); 
		stack.stackTagCompound.setInteger("currentCharge", 0);
		stack.stackTagCompound.setInteger("time", 100);
		stack.stackTagCompound.setBoolean("using", false);
		stack.stackTagCompound.setInteger("timeUsing", 0);
		stack.stackTagCompound.setBoolean("using2", false);
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
    		 stack.stackTagCompound.setInteger("currentCharge", 0);
    		 stack.stackTagCompound.setInteger("time", 100);
    		 stack.stackTagCompound.setBoolean("using", false);
    	 }
     }
}
