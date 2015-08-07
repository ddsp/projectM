package com.minecraftRPG.items;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntitySpiritWolf;
import com.minecraftRPG.mobs.IvisiProj;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class SpiritWolfStaff extends ItemSword{
	
	protected final float weaponDamage;
	
	public SpiritWolfStaff(ToolMaterial mat, float damage) {
		super(mat);
		this.weaponDamage = damage;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon("minecraftrpg:SpiritWolfStaff");
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
	{
		if (!world.isRemote)
		{
			EntitySpiritWolf wolf = new EntitySpiritWolf(world);
			wolf.setLocationAndAngles(player.posX, player.posY+1, player.posZ+1,world.rand.nextFloat() * 360.0F, 0.0F);
			world.spawnEntityInWorld(wolf); 
			
			EntitySpiritWolf wolf2 = new EntitySpiritWolf(world);
			wolf2.setLocationAndAngles(player.posX, player.posY+1, player.posZ-1,world.rand.nextFloat() * 360.0F, 0.0F);
			world.spawnEntityInWorld(wolf2);
			
			System.out.println("cheguei");
			
			world.spawnEntityInWorld(new IvisiProj( world, player, wolf, wolf2));		
		}
		
		return itemStack;
    }
	
	@Override
	public Multimap getItemAttributeModifiers(){
		Multimap multimap = HashMultimap.create();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier",  (double) this.weaponDamage, 0));
		return multimap;
	}
}
