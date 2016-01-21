package com.minecraftRPG.tileEntity;

import com.jcraft.jogg.Packet;
import com.minecraftRPG.blocks.spawner;
import com.minecraftRPG.mobs.entity.EntityBlackWolf;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntitySpawnerB extends TileEntity{
	
	spawner Spawner;
	
	public TileEntitySpawnerB(spawner s2){
		Spawner = s2;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1)
	{
		super.writeToNBT(par1);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1)
	{
		super.readFromNBT(par1);
	}
	
	/*@Override
	public Packet getDescriptionPacket()
	{
	NBTTagCompound var1 = new NBTTagCompound();
	writeToNBT(var1);
	return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, var1);
	}
	
	@Override
	public void onDataPacket(INetworkManager net, Packet132TileEntityData pkt) {readFromNBT(pkt.customParam1);}*/
	
	public boolean anyPlayerInRange()
	{
		return this.worldObj.getClosestPlayer((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D, 16) != null;
	}
	
	@Override
	public void updateEntity(){
		if(this.anyPlayerInRange()){
			if (!this.worldObj.isRemote)
			{
				EntityBlackWolf var2 = new EntityBlackWolf(this.worldObj);
				var2.setLocationAndAngles(this.xCoord+3, this.yCoord, this.zCoord+3,this.worldObj.rand.nextFloat() * 360.0F, 0.0F);
				worldObj.spawnEntityInWorld(var2);
				
				worldObj.setBlock(this.xCoord, this.yCoord, this.zCoord, Blocks.air, 0, 1 | 2);
			}
		}
	}
}
