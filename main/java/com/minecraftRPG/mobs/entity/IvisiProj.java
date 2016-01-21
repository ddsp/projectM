package com.minecraftRPG.mobs.entity;

import com.minecraftRPG.items.SpiritWolfStaff;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.Direction;
import net.minecraft.util.MathHelper;
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
			int heading = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			
			//String test = String.format("f: %d (%s) / %f", heading, Direction.directions[heading], MathHelper.wrapAngleTo180_float(player.rotationYaw));
			
			EntitySpiritWolf wolf = new EntitySpiritWolf(world, (EntityLiving)par1.entityHit);
			EntitySpiritWolf wolf2 = new EntitySpiritWolf(world, (EntityLiving)par1.entityHit);
			
			switch(heading){
				
				case 1:
				case 3:
					wolf.setLocationAndAngles(player.posX, player.posY+1, player.posZ+1,world.rand.nextFloat() * 360.0F, 0.0F); 
					wolf2.setLocationAndAngles(player.posX, player.posY+1, player.posZ-1,world.rand.nextFloat() * 360.0F, 0.0F);
				break;
				
				case 0:
				case 2:
					wolf.setLocationAndAngles(player.posX+1, player.posY+1, player.posZ,world.rand.nextFloat() * 360.0F, 0.0F); 
					wolf2.setLocationAndAngles(player.posX-1, player.posY+1, player.posZ,world.rand.nextFloat() * 360.0F, 0.0F);
				break;
				
				default:
					System.out.println("error");
					break;
			}
			
			world.spawnEntityInWorld(wolf);
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
