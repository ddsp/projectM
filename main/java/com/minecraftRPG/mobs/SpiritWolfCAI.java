package com.minecraftRPG.mobs;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;

public class SpiritWolfCAI extends EntityAIBase{

	private EntityLiving theEntity;
	private EntityLiving theEnemyEntity;
    private static final String __OBFID = "CL_00001584";

    public SpiritWolfCAI(EntityLiving entity, EntityLiving entityEnemy)
    {
        this.theEntity = entity;
        this.theEnemyEntity = entityEnemy;
    }
    
	@Override
	public boolean shouldExecute() {
		return true;
	}
	
	public void updateTask()
    {
        if ((theEnemyEntity.isEntityAlive()) && (theEntity.isEntityAlive()))
        {
        	theEntity.setAttackTarget(theEnemyEntity);
        }else{
        	theEntity.setDead();
        }
    }

}
