package com.minecraftRPG.main;

import com.minecraftRPG.blocks.MinecraftRPGBlocks;
import com.minecraftRPG.items.MinecraftRPGitems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingManager {
	
	static ItemStack SilverOre;
	static ItemStack SilverIngot;
	
	public static void mainRegistry(){
		SilverOre = new ItemStack(MinecraftRPGBlocks.SilverOre);
		SilverIngot = new ItemStack(MinecraftRPGitems.SilverIngot);
		
		addCraftingRecipes();
		addSmeltingRecipies();
	}
	
	public static void addCraftingRecipes(){		
		GameRegistry.addShapedRecipe(new ItemStack(MinecraftRPGitems.ReloadedSword), "   ", " S ", "   ", 'S', Items.apple);
		GameRegistry.addShapedRecipe(new ItemStack(MinecraftRPGitems.SilverSword), "I", "I", "S", 'I', MinecraftRPGitems.SilverIngot, 'S', Items.stick);
	}
	
	public static void addSmeltingRecipies() {
		GameRegistry.addSmelting(SilverOre, SilverIngot, 0.5f);
	}
}
