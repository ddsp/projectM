package com.minecraftRPG.GUI;

import com.minecraftRPG.inventory.CointainerAltarPedestal;
import com.minecraftRPG.tileEntity.AlterPedestalTileEntity;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class MinecraftRPGGuiHandler implements IGuiHandler {

	public MinecraftRPGGuiHandler (){
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			AlterPedestalTileEntity tileEntityFurnace = (AlterPedestalTileEntity) world.getTileEntity(x, y, z);
			return new CointainerAltarPedestal(player.inventory, tileEntityFurnace);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			AlterPedestalTileEntity tileEntityTestContainer = (AlterPedestalTileEntity) world.getTileEntity(x, y, z);
			return new GuiAltar(player.inventory, tileEntityTestContainer);
		}
		return null;
	}

}
