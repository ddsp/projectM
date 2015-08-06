package com.minecraftRPG.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MinecraftRPGBlocks {
	
	public static void mainRegistry(){
    	initBlocks();
    	registerBlocks();
    }
    
    public static Block spawner;
    
    public static void initBlocks(){
    	spawner = new spawner(Material.rock).setHardness(1.5F).setBlockName("spawner").setCreativeTab(MinecraftRPGTab);
    }
    
    public static void registerBlocks(){    	
    	GameRegistry.registerBlock(spawner, "spawner");    	
    }
    
    public static CreativeTabs MinecraftRPGTab = new CreativeTabs("MinecraftRPG"){
    	public Item getTabIconItem(){
    		return Item.getItemFromBlock(spawner);
    	}
    };
}
