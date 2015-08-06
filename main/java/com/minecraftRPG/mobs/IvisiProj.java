package com.minecraftRPG.mobs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class IvisiProj extends EntityThrowable
{
	EntityBlackWolf wolf1;
	EntityBlackWolf wolf2;
	
	public IvisiProj(World par1World)
	{
		super(par1World);
	}

	public IvisiProj(World par1World, EntityLivingBase par2EntityLivingBase, EntityBlackWolf wolf12, EntityBlackWolf wolf22)
	{
		super(par1World, par2EntityLivingBase);
		wolf1 = wolf12;
		wolf2 = wolf22;		
	}

	public IvisiProj(World par1World, double par2, double par4, double par6)
	{
		super(par1World, par2, par4, par6);
	}
	
	@Override
	protected void entityInit() {
		super.entityInit();
		setSize(0, 0);
	}

	@Override
	protected float getGravityVelocity()
	{
		return 0.0F;
	}

	private void explode()
	{
		float f = 0.9F;
		this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
	}
	
	@Override
	protected void onImpact(MovingObjectPosition par1) {
		if (par1.entityHit instanceof EntityLivingBase)
		{
			byte b0 = 9;
			b0 = 15;		
			if(wolf1 != null){
				wolf1.setAttackTarget((EntityLivingBase)par1.entityHit);
				wolf2.setAttackTarget((EntityLivingBase)par1.entityHit);
			}
		}
		
		setDead();
	}
}
