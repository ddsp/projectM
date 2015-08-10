package com.minecraftRPG.items;

import java.awt.List;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ReloadedSword extends ItemSword{
	protected float weaponDamage;
	public int reloaduses = 5;
	public IIconRegister r;
	
	World world;
	
	public ReloadedSword(ToolMaterial mat, float damage) {
		super(mat);
		weaponDamage = damage; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		if(reloaduses != 0)
		{
			this.itemIcon = reg.registerIcon("minecraftrpg:ActiveReloadSword");
			reg.registerIcon("minecraftrpg:UnactiveReloadSword");
		}
		else
		{
			this.itemIcon = reg.registerIcon("minecraftrpg:UnactiveReloadSword");
			this.weaponDamage = 0.0f;
			this.getItemAttributeModifiers();
		}
		
		r = reg;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{	
		reloaduses = reloaduses - 1;
		World worldRef = ((EntityPlayer) attacker).worldObj;
		if (!worldRef.isRemote)
		{
			if (reloaduses == 0)
			{
				if(target != null)
				{
					worldRef.createExplosion(null , target.posX, target.posY+1, target.posZ, 0.9F, false);
					this.registerIcons(r);
				}
			}
		}
		
		return true;
	}
	
	@Override
	public Multimap getItemAttributeModifiers(){
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier",  (double) this.weaponDamage, 0));
		return multimap;
	}
	
	@Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
    	 stack.stackTagCompound = new NBTTagCompound();
    	 stack.stackTagCompound.setInteger("currentCharge", reloaduses);
    }

    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
    	 if (stack.stackTagCompound != null) {
             int charge = stack.stackTagCompound.getInteger("currentCharge");
             list.add("Current Charge: " + charge);
    	 }
     }
}
