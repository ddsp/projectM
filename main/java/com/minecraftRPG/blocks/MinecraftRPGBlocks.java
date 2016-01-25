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
    public static Block SilverOre;
    public static Block TeleporterWall;
    public static Block AltarPedestal;
    public static Block SoullessLeaves;
    
    public static void initBlocks(){
    	spawner = new Spawner(Material.rock).setHardness(1.5F).setBlockName("spawner");
    	
    	//Ores
    	SilverOre = new SilverOre(Material.rock).setHardness(1.5F).setBlockName("SilverOre").setCreativeTab(MinecraftRPGTab);
    	
    	//Functionality
    	AltarPedestal = new AlterPedestal(Material.rock).setHardness(1.5F).setBlockName("AltarPedestal").setCreativeTab(MinecraftRPGTab);
    	TeleporterWall = new AlterPedestal(Material.rock).setHardness(-1F).setBlockName("TeleporterWall").setCreativeTab(MinecraftRPGTab);
    	
    	//Trees
    	SoullessLeaves = new SoulessLeaves(Material.leaves).setHardness(0F).setBlockName("SoullessLeaves").setCreativeTab(MinecraftRPGTab);
    }
    
    public static void registerBlocks(){    	
    	GameRegistry.registerBlock(spawner, "spawner");
    	GameRegistry.registerBlock(SilverOre, "SilverOre");
    	GameRegistry.registerBlock(TeleporterWall, "TeleporterWall");  
    	GameRegistry.registerBlock(AltarPedestal, "AlterPedestal");
    	GameRegistry.registerBlock(SoullessLeaves, "SoulessLeaves");  
    }
    
    public static CreativeTabs MinecraftRPGTab = new CreativeTabs("MinecraftRPG"){
    	public Item getTabIconItem(){
    		return Item.getItemFromBlock(spawner);
    	}
    };
}
