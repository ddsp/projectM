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
    public static Block BaseBlock;
    public static Block AlterPedestal;
    public static Block SoulessLeaves;
    
    public static void initBlocks(){
    	spawner = new spawner(Material.rock).setHardness(1.5F).setBlockName("spawner").setCreativeTab(MinecraftRPGTab);
    	SilverOre = new SilverOre(Material.rock).setHardness(1.5F).setBlockName("SilverOre").setCreativeTab(MinecraftRPGTab);
    	BaseBlock = new BaseBlock(Material.rock).setHardness(1.5F).setBlockName("BaseBlock").setCreativeTab(MinecraftRPGTab);
    	AlterPedestal = new AlterPedestal(Material.rock).setHardness(1.5F).setBlockName("AlterPedestal").setCreativeTab(MinecraftRPGTab);
    	SoulessLeaves = new SoulessLeaves(Material.leaves).setHardness(0F).setBlockName("SoulessLeaves").setCreativeTab(MinecraftRPGTab);
    }
    
    public static void registerBlocks(){    	
    	GameRegistry.registerBlock(spawner, "spawner");
    	GameRegistry.registerBlock(SilverOre, "SilverOre");
    	GameRegistry.registerBlock(BaseBlock, "BaseBlock");  
    	GameRegistry.registerBlock(AlterPedestal, "AlterPedestal");
    	GameRegistry.registerBlock(SoulessLeaves, "SoulessLeaves");  
    }
    
    public static CreativeTabs MinecraftRPGTab = new CreativeTabs("MinecraftRPG"){
    	public Item getTabIconItem(){
    		return Item.getItemFromBlock(spawner);
    	}
    };
}
