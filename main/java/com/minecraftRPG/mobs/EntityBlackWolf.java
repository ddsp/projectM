package com.minecraftRPG.mobs;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityBlackWolf extends EntityWolf {

	public EntityBlackWolf(World par1World) {
		super(par1World);
		this.setSize(1F, 1F);
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAITempt(this, 0.7D, Items.beef, false));
	}
	
	public boolean isAIEnabled(){
		return true;
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
	}

	@Override
	public EntityWolf createChild(EntityAgeable p_90011_1_) {
		
		return new EntityBlackWolf(worldObj);
	}

}
