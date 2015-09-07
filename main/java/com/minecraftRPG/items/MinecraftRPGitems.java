package com.minecraftRPG.items;

import com.minecraftRPG.blocks.MinecraftRPGBlocks;
import net.minecraftforge.common.util.EnumHelper;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class MinecraftRPGitems {
	
	public static ToolMaterial enumToolMaterialMinecraftRPG = EnumHelper.addToolMaterial("MinecraftRPGItems", 3, 3000, 11.0F, 5.0F, 30);
	public static ToolMaterial enumToolMaterialMinecraftRPGRS = EnumHelper.addToolMaterial("MinecraftRPGItems", 0, 3000, 0.0F, -3.0F, 30);
	
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
	public static Item QuishaTianling;
	public static Item CostumBook;
	
	public static void initItems(){
		SilverIngot = new SilverIngot().setUnlocalizedName("SilverIngot").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		strucFab = new StrucFab().setUnlocalizedName("StrucFab").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		spiritWStaff = new SpiritWolfStaff(enumToolMaterialMinecraftRPG, 3).setUnlocalizedName("SpiritWolfStaff").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		ReloadedSword = new ReloadedSword(enumToolMaterialMinecraftRPGRS, 16).setUnlocalizedName("ReloadedSword").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		QuishaTianling = new QuishaTianling(enumToolMaterialMinecraftRPGRS, 16).setUnlocalizedName("QuishaTianling").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		SilverSword = new SilverSword(enumToolMaterialMinecraftRPG, 5).setUnlocalizedName("SilverSword").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
		CostumBook = new CostumBook().setUnlocalizedName("CostumBook").setCreativeTab(MinecraftRPGBlocks.MinecraftRPGTab);
	}
	
	public static void registerItems(){
		GameRegistry.registerItem(SilverIngot, "SilverIngot");
		GameRegistry.registerItem(strucFab, "StrucFab");
		GameRegistry.registerItem(spiritWStaff, "SpiritWolfStaff");
		GameRegistry.registerItem(ReloadedSword, "ReloadedSword");
		GameRegistry.registerItem(SilverSword, "SilverSword");
		GameRegistry.registerItem(QuishaTianling, "QuishaTianling");
		GameRegistry.registerItem(CostumBook, "CostumBook");
	}
}
