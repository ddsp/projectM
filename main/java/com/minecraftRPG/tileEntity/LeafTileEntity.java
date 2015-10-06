package com.minecraftRPG.tileEntity;

import com.minecraftRPG.blocks.SoulessLeaves;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class LeafTileEntity extends TileEntity{
	
	private int index = 100;
	
	public int changeLeave(int n){
		if(n > 0){
			index -= n;
		}
		System.out.println("Number " + index);
		return index;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt)
    {
		super.readFromNBT(nbt);
        
		index = nbt.getInteger("index");
    }

	@Override
    public void writeToNBT(NBTTagCompound nbt)
    {
    	super.writeToNBT(nbt);
    	
    	nbt.setInteger("index", index);
    }

	@Override
    public void updateEntity() {
    	
    }

}
