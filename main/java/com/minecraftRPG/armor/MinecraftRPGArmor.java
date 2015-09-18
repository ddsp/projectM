package com.minecraftRPG.armor;

import com.minecraftRPG.blocks.AlterPedestal;
import com.minecraftRPG.blocks.BaseBlock;
import com.minecraftRPG.blocks.SilverOre;
import com.minecraftRPG.blocks.spawner;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MinecraftRPGArmor {

	public static ArmorMaterial enumArmorMaterialMinecraftRPG = EnumHelper.addArmorMaterial("MinecraftRPGArmor", 69, new int[]{3, 8, 6, 3}, 6);
	
	public static void mainRegistry(){
    	initArmor();
    	registerArmor();
    }
    
    public static Item PendragonHelmet;
    public static Item PendragonChestplate;
    public static Item PendragonLeggins;
    public static Item PendragonBoots;
    
    public static void initArmor(){
    	PendragonHelmet = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 0).setUnlocalizedName("Pendragon_Helmet");
    	PendragonChestplate = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 1).setUnlocalizedName("Pendragon_Chestplate");
    	PendragonLeggins = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 2).setUnlocalizedName("Pendragon_Leggins");
    	PendragonBoots = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 3).setUnlocalizedName("Pendragon_Boots");
    }
    
    public static void registerArmor(){    	
    	  GameRegistry.registerItem(PendragonHelmet, "Pendragon_Helmet");
    	  GameRegistry.registerItem(PendragonChestplate, "Pendragon_Chestplate");
    	  GameRegistry.registerItem(PendragonLeggins, "Pendragon_Leggins");
    	  GameRegistry.registerItem(PendragonBoots, "Pendragon_Boots");
    }
}
