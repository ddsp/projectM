package com.minecraftRPG.main;

import com.minecraftRPG.items.MinecraftRPGitems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CraftingManager {
	public static void mainRegistry(){
		addCraftingRecipes();
	}
	
	public static void addCraftingRecipes(){
		
		GameRegistry.addShapedRecipe(new ItemStack(MinecraftRPGitems.ReloadedSword), "   ", " S ", "   ", 'S', Items.apple);
		GameRegistry.addShapedRecipe(new ItemStack(MinecraftRPGitems.SilverSword), "I", "I", "S", 'I', MinecraftRPGitems.SilverIngot, 'S', Items.stick);
	}
}
