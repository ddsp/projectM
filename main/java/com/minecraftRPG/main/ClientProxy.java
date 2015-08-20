package com.minecraftRPG.main;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

import com.minecraftRPG.armor.MinecraftRPGArmor;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntitySpiritWolf;
import com.minecraftRPG.mobs.RenderBlackWolf;
import com.minecraftRPG.mobs.RenderSpiritWolf;
import com.minecraftRPG.models.BlackWolf;
import com.minecraftRPG.models.ModelBlackPendragonArmorV3;
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
	
	public void registerAmorRen(){
		ModelBlackPendragonArmorV3 custom_armor = new ModelBlackPendragonArmorV3(1F);
		ModelBlackPendragonArmorV3 custom_legs = new ModelBlackPendragonArmorV3(0.5F);
		
		armorModels.put(MinecraftRPGArmor.first_helm, custom_armor);
		armorModels.put(MinecraftRPGArmor.first_body, custom_armor);
		armorModels.put(MinecraftRPGArmor.first_legs, custom_legs);
		armorModels.put(MinecraftRPGArmor.first_boots, custom_armor);

	}	
}