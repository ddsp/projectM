package com.minecraftRPG.mobs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySpiritWolf extends EntityWolf {

	public EntitySpiritWolf(World par1World) {
		super(par1World);
		this.setSize(1F, 1F);
		this.setTamed(true);
	}
	
	public boolean isAIEnabled(){
		return true;
	}
	
	@Override
	protected void applyEntityAttributes(){
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(5.0F);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(6.5D);
	}

	@Override
	public EntityWolf createChild(EntityAgeable p_90011_1_) {
		
		return new EntitySpiritWolf(worldObj);
	}
	
	@Override
	public boolean attackEntityAsMob(Entity entity)
    {
		entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4);
		this.setDead();
        return true;
    }

	@Override
	protected boolean canDespawn()
    {
        return this.ticksExisted > 100;
    }
}
