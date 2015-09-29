package com.minecraftRPG.armor;

import java.util.List;

import javax.annotation.Resource;

import com.minecraftRPG.items.MinecraftRPGitems;
import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.main.ClientProxy;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class MinecraftRPGFirstArmor extends ItemArmor{ 
	
	public MinecraftRPGFirstArmor(ArmorMaterial material, int render_idx, int type) {
		super(material, render_idx, type);
		this.setMaxStackSize(1);
	}
	
	@Override
	public String getUnlocalizedName(){
		return String.format("item.%s%s", Strings.IMGMODID+":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack itemstack){
		return String.format("item.%s%s", Strings.IMGMODID+":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	
	protected String getUnwrappedUnlocalizedName(String unlocalizedName){		
		return unlocalizedName.substring(unlocalizedName.indexOf('.') + 1);
	}
	
	@Override 
	@SideOnly(Side.CLIENT) 
	public void registerIcons(IIconRegister iconRegister) { 
		this.itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf('.') + 1)); 
	}
	
	@Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.stackTagCompound = new NBTTagCompound(); 
		stack.stackTagCompound.setInteger("charge", 0);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot){
		
		ModelBiped armorModel = ClientProxy.armorModels.get(this);
		
		if(armorModel != null){
    		armorModel.bipedHead.showModel = armorSlot == 0;
    		armorModel.bipedHeadwear.showModel = false;
    		armorModel.bipedBody.showModel = armorSlot == 1;
    		armorModel.bipedRightArm.showModel = armorSlot == 1;
    		armorModel.bipedLeftArm.showModel = armorSlot == 1;
    		armorModel.bipedRightLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		armorModel.bipedLeftLeg.showModel = armorSlot == 2 || armorSlot == 3;
    		
    		armorModel.isSneak = entityLiving.isSneaking();
    		armorModel.isRiding = entityLiving.isRiding();
    		armorModel.isChild = entityLiving.isChild();
    		
    		armorModel.heldItemRight = 0;
    		armorModel.aimedBow = false;
    		
    		EntityPlayer player = (EntityPlayer)entityLiving;
    		
    		ItemStack held_item = player.getEquipmentInSlot(0);
    		
    		if (held_item != null){
    			armorModel.heldItemRight = 1;
    			
    			if (player.getItemInUseCount() > 0){
      				EnumAction enumaction = held_item.getItemUseAction();
    				
    				if (enumaction == EnumAction.bow){
    					armorModel.aimedBow = true;
    				}else if (enumaction == EnumAction.block){
    					armorModel.heldItemRight = 3;
    				}
    			}
    		}
    		
    		if(armorSlot == 1){
    			
    			int c = 0;
    			if(itemstack.stackTagCompound == null){
    				itemstack.stackTagCompound = new NBTTagCompound(); 
    				itemstack.stackTagCompound.setInteger("charge", 0);
    			}else{
					c = itemstack.stackTagCompound.getInteger("charge");  				
    			}
    			int s = 0;
    			
    			for(ItemStack i : player.inventory.mainInventory){
	    			if(i != null){
	    				if((Item.getIdFromItem(i.getItem()) == Item.getIdFromItem(MinecraftRPGitems.SilverSword)) && (c < 4)){
	    					player.inventory.mainInventory[s] = null;
	    					c++;
	    				}
	    			}
	    			s++;
    			}
    			
    			itemstack.stackTagCompound.setInteger("charge", c);
    		}
		}
		
		if(entityLiving instanceof EntityPlayer ){
			EntityPlayer player = (EntityPlayer) entityLiving;
			Boolean veri = false;
			for(ItemStack piece : player.inventory.armorInventory){
				if(piece == null || !(
						piece.getItem().equals(MinecraftRPGArmor.PendragonHelmet) ||
						piece.getItem().equals(MinecraftRPGArmor.PendragonChestplate) ||
						piece.getItem().equals(MinecraftRPGArmor.PendragonLeggins) ||
						piece.getItem().equals(MinecraftRPGArmor.PendragonBoots))){
					veri = true;
				}
			}
			//System.out.println(veri);
		}
		
		return armorModel;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
    	 if (stack.stackTagCompound == null) {
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setInteger("charge", 0);
    	 }
    	 
    	 if(stack.getItem().equals(MinecraftRPGArmor.PendragonChestplate)){
    		 list.add("Unsheded Swords: " + stack.stackTagCompound.getInteger("charge"));
    	 }
     }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){	
		return Strings.IMGMODID+":textures/models/armor/BlackPendragonArmorV5_2.png";
	}
}