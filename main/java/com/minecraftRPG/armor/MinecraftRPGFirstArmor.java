package com.minecraftRPG.armor;

import javax.annotation.Resource;

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
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

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
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel (EntityLivingBase entityLiving, ItemStack itemstack, int armorSlot){
		
		ModelBiped armorModel = ClientProxy.armorModels.get(this);
		
		if(armorModel != null){
    		armorModel.bipedHead.showModel = armorSlot == 0;
    		armorModel.bipedHeadwear.showModel = false;
    		armorModel.bipedBody.showModel = armorSlot == 1 || armorSlot == 2;
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
		}
		return armorModel;
	}
	
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer){	
		return Strings.IMGMODID+":textures/models/armor/BlackPendragonArmorV5_2.png";
	}
}