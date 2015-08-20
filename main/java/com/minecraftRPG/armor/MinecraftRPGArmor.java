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

	public static ArmorMaterial enumArmorMaterialMinecraftRPG = EnumHelper.addArmorMaterial("MinecraftRPGArmor", 0, new int[]{0, 0, 0, 0}, 0);
	
	public static void mainRegistry(){
    	initArmor();
    	registerArmor();
    }
    
    public static Item first_helm;
    public static Item first_body;
    public static Item first_legs;
    public static Item first_boots;
    
    public static void initArmor(){
    	first_helm = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 0).setUnlocalizedName("first_helm");
    	first_body = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 1).setUnlocalizedName("first_body");
    	first_legs = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 2).setUnlocalizedName("first_legs");
    	first_boots = new MinecraftRPGFirstArmor(enumArmorMaterialMinecraftRPG, 1, 3).setUnlocalizedName("first_boots");
    }
    
    public static void registerArmor(){    	
    	  GameRegistry.registerItem(first_helm, "first_helm");
    	  GameRegistry.registerItem(first_body, "first_body");
    	  GameRegistry.registerItem(first_legs, "first_legs");
    	  GameRegistry.registerItem(first_boots, "first_boots");
    }
}
