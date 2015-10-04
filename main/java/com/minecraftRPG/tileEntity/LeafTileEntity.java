package com.minecraftRPG.tileEntity;

import com.minecraftRPG.blocks.SoulessLeaves;

import net.minecraft.tileentity.TileEntity;

public class LeafTileEntity extends TileEntity{
	
	private int index = 0;
	
	public boolean changeLeave(){
		SoulessLeaves l = (SoulessLeaves)this.getBlockType();
		if(index++ <= 3){
			index++;
			l.setIcon(index);
			System.out.println(index);
			return true;
		}else{
			return false;
		}
	}

}
