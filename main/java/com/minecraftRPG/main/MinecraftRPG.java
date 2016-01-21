package com.minecraftRPG.main;

import com.minecraftRPG.GUI.GUILimiter_Def;
import com.minecraftRPG.armor.MinecraftRPGArmor;
import com.minecraftRPG.blocks.MinecraftRPGBlocks;
import com.minecraftRPG.items.MinecraftRPGitems;
import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.mobs.entity.MinecraftRPGEntitys;
import com.minecraftRPG.structures.Structures;
import com.minecraftRPG.tileEntity.MinecraftRPGtileEntity;
import com.minecraftRPG.world.MinecraftRPGWorldGenOre;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Strings.MODID, name = Strings.NAME, version = Strings.VERSION)
public class MinecraftRPG
{
    public static final String MODID = Strings.MODID;
    public static final String VERSION = Strings.VERSION;
    
    @SidedProxy(clientSide = "com.minecraftRPG.main.ClientProxy", serverSide = "com.minecraftRPG.ServerProxy")
    public static ServerProxy proxy;
    
    @Metadata
    public static ModMetadata meta;
    
    @Mod.Instance(Strings.MODID)
    public static MinecraftRPG instance;
    
    @Mod.EventHandler
    public void PreLoad(FMLPreInitializationEvent  PreEvent) {
    	GameRegistry.registerWorldGenerator(new Structures(), 0);
    	MinecraftRPGWorldGenOre.mainRegistry();
    	
    	EventsRegister.RegisterEvents();
    	
    	MinecraftRPGitems.mainRegistry();
    	MinecraftRPGBlocks.mainRegistry();
    	CraftingManager.mainRegistry();
    	
    	MinecraftRPGtileEntity.mainRegistry();
    	MinecraftRPGEntitys.mainRegistry();
    	MinecraftRPGArmor.mainRegistry();
    	
    	proxy.registerRenderThings();
    }
    
    
    @Mod.EventHandler
    public void load(FMLInitializationEvent event) 
    {
    	proxy.registerNetworkStuff();
    }
 
    @Mod.EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent) {
    	MinecraftForge.EVENT_BUS.register(new GUILimiter_Def(Minecraft.getMinecraft()));
    }
}
