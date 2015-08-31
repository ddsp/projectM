package com.minecraftRPG.mobs;

import com.minecraftRPG.items.SpiritWolfStaff;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class IvisiProj extends EntityThrowable
{
	EntityPlayer player;
	World world;
	SpiritWolfStaff father;
	
	public IvisiProj(World par1World)
	{
		super(par1World);
	}

	public IvisiProj(World par1World, EntityLivingBase par2EntityLivingBase, SpiritWolfStaff p)
	{
		super(par1World, par2EntityLivingBase);
		player = (EntityPlayer) par2EntityLivingBase;
		world = par1World;
		if(p  != null){
			father = p;
		}
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
	
	@Override
	protected void onImpact(MovingObjectPosition par1) {
		if (par1.entityHit instanceof EntityLivingBase)
		{		
			
			EntitySpiritWolf wolf = new EntitySpiritWolf(world, (EntityLiving)par1.entityHit);
			wolf.setLocationAndAngles(player.posX, player.posY+1, player.posZ+1,world.rand.nextFloat() * 360.0F, 0.0F);
			world.spawnEntityInWorld(wolf); 
			
			EntitySpiritWolf wolf2 = new EntitySpiritWolf(world, (EntityLiving)par1.entityHit);
			wolf2.setLocationAndAngles(player.posX, player.posY+1, player.posZ-1,world.rand.nextFloat() * 360.0F, 0.0F);
			world.spawnEntityInWorld(wolf2);
			
			wolf.setTarget(par1.entityHit);
			wolf2.setTarget(par1.entityHit);
			wolf.setAttackTarget((EntityLivingBase)par1.entityHit);
			wolf2.setAttackTarget((EntityLivingBase)par1.entityHit);
		}
		
		if(father != null){
			father.increaseCooldown();
		}
		
		setDead();
	}
}
