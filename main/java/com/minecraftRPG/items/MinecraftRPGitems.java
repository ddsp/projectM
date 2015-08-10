package com.minecraftRPG.items;

import com.minecraftRPG.blocks.MinecraftRPGBlocks;
import net.minecraftforge.common.util.EnumHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class MinecraftRPGitems {
	
	public static ToolMaterial enumToolMaterialMinecraftRPG = EnumHelper.addToolMaterial("MinecraftRPG", 3, 3000, 11.0F, 5.0F, 30);
	
	public static void mainRegistry(){
		initItems();
		registerItems();
	}
	
	//items
	public static Item strucFab;
	public static Item spiritWStaff;
	public static Item ReloadedSword;
	public static Item SilverSword;
	public static Item SilverIngot;
	
	public static void initItems(){
		SilverIngot = new SilverIngot().setUnlocalizedName("SilverIngot").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		strucFab = new StrucFab().setUnlocalizedName("StrucFab").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		spiritWStaff = new SpiritWolfStaff(enumToolMaterialMinecraftRPG, 3).setUnlocalizedName("SpiritWolfStaff").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		ReloadedSword = new ReloadedSword(enumToolMaterialMinecraftRPG, 1).setUnlocalizedName("ReloadedSword").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		SilverSword = new SilverSword(enumToolMaterialMinecraftRPG, 1).setUnlocalizedName("SilverSword").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
	}
	
	public static void registerItems(){
		GameRegistry.registerItem(SilverSword, "SilverSword");
		GameRegistry.registerItem(strucFab, "StrucFab");
		GameRegistry.registerItem(spiritWStaff, "SpiritWolfStaff");
		GameRegistry.registerItem(ReloadedSword, "ReloadedSword");
		GameRegistry.registerItem(SilverSword, "SilverSword");
	}
}
