package com.minecraftRPG.main;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

import com.minecraftRPG.mobs.BlackWolf;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntitySpiritWolf;
import com.minecraftRPG.mobs.RenderBlackWolf;
import com.minecraftRPG.mobs.RenderSpiritWolf;
import com.minecraftRPG.tileEntity.AlterPedestalRenderer;
import com.minecraftRPG.tileEntity.AlterPedestalTileEntity;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraft.item.Item;

public class ClientProxy extends ServerProxy{
	
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	public void registerRenderThings(){
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackWolf.class, new RenderBlackWolf(new BlackWolf(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritWolf.class, new RenderSpiritWolf(new BlackWolf(), 0));
		ClientRegistry.bindTileEntitySpecialRenderer(AlterPedestalTileEntity.class, new AlterPedestalRenderer());
	}
	
	public ModelBiped getArmorModel(int id){ 
		return null; 
	}
	
	
}