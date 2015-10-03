package com.minecraftRPG.items;

import java.util.List;

import com.minecraftRPG.GUI.GUILimiter_Def;
import com.minecraftRPG.GUI.ritualsGUI;
import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntityFlyingTestC;
import com.minecraftRPG.mobs.MultiMobTest;
import com.minecraftRPG.models.BlackWolf;
import com.minecraftRPG.structures.test;
import com.minecraftRPG.tileEntity.LeafTileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class Tester_Items extends Item{
	
	public Tester_Items(){
		super();
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon(Strings.IMGMODID + ":TesterItems");
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) {
		/*if(!world.isRemote){
			int x = MathHelper.floor_double(player.posX);
	        int y = MathHelper.floor_double(player.posY);
	        int z = MathHelper.floor_double(player.posZ);
	        
	        int LastposX = stack.stackTagCompound.getInteger("LastPosX");
	        int LastposZ = stack.stackTagCompound.getInteger("LastPosZ");
	        
	        Chunk chunk = world.getChunkFromBlockCoords(x, z);
	        
	        String biome = chunk.getBiomeGenForWorldCoords(x & 15, z & 15, world.getWorldChunkManager()).biomeName;
	        
			if((LastposX != x) || (LastposZ != z)){
				
				stack.stackTagCompound.setInteger("LastPosX", x);
				stack.stackTagCompound.setInteger("LastPosZ", z);
				
				if(biome == "Plains"){
					EntityPlayer p = (EntityPlayer) player;
					p.addChatMessage(new ChatComponentText("IT WORKED"));
				}
			}
		}*/
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
    	 if (stack.stackTagCompound == null) {    		 
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setInteger("Steps", 0);
    		 stack.stackTagCompound.setInteger("LastPosX", MathHelper.floor_double(player.posX));
    		 stack.stackTagCompound.setInteger("LastPosZ", MathHelper.floor_double(player.posZ));
    	 }
     }
	
	@Override
	
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		int x = MathHelper.floor_double(player.posX);
        int y = MathHelper.floor_double(player.posY);
        int z = MathHelper.floor_double(player.posZ);
        
        x -= 2;
        y += 20;
        z -= 2;
        
        for(int y2 = y; y2 >= y - 20; y2--){
        	if(y2 > y - 100){
        	}
        	for(int x2 = x; x2 <= x + 5; x2++){
        		for(int z2 = z; z2 <= z + 5; z2++){
        			TileEntity TE = world.getTileEntity(x2, y2, z2);
            		if(TE != null){
            			if(TE instanceof LeafTileEntity){
            				LeafTileEntity LTE = (LeafTileEntity) TE;
            				System.out.println(LTE.exists());
            			}
            		}
            	}
        	}
        }
        
        return stack;
    }
}
