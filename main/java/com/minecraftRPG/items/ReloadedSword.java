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
	public IIconRegister r;
	
	World world;
	
	public ReloadedSword(ToolMaterial mat, float damage) {
		super(mat);
		weaponDamage = damage; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("minecraftrpg:ActiveReloadSword");
		reg.registerIcon("minecraftrpg:UnactiveReloadSword");
		r = reg;
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{	
		int reloaduses = 5;
		
		if (stack.stackTagCompound != null) {
			reloaduses = stack.getTagCompound().getInteger("currentCharge");
		}else{
			stack.setTagCompound(new NBTTagCompound());
		}
		reloaduses = reloaduses - 1;
		System.out.println(reloaduses);
		stack.stackTagCompound.setInteger("currentCharge", reloaduses);
		this.addInformation(stack, null, stack.getTooltip((EntityPlayer) attacker, true), false);
		World worldRef = ((EntityPlayer) attacker).worldObj;
		if (!worldRef.isRemote)
		{
			if (reloaduses == 0)
			{
				if(target != null)
				{
					worldRef.createExplosion(null , target.posX, target.posY+1, target.posZ, 0.9F, false);
					this.itemIcon = r.registerIcon("minecraftrpg:UnactiveReloadSword");
					this.weaponDamage = 0.0f;
					this.getItemAttributeModifiers();
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
		if( stack.stackTagCompound == null ){
    	 stack.setTagCompound(new NBTTagCompound());
    	 System.out.println("cheguei2");
    	 stack.stackTagCompound.setInteger("currentCharge", 5);
		}
		System.out.println("cheguei");
    }

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
    	 if (stack.stackTagCompound != null) {
    		 int reloaduses = stack.stackTagCompound.getInteger("currentCharge");
    		 System.out.println("cheguei3");
             list.add("Current Charge: " + reloaduses);
    	 }
     }
}
