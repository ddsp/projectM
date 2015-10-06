package com.minecraftRPG.items;

import java.util.List;

import com.minecraftRPG.blocks.SoulessLeaves;
import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.tileEntity.LeafTileEntity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Tester_Items extends Item{
	
	private boolean using = false;
	
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
		if (stack.stackTagCompound == null) {    		 
			 stack.stackTagCompound = new NBTTagCompound(); 
			 stack.stackTagCompound.setInteger("Steps", 0);
			 stack.stackTagCompound.setInteger("LastPosX", MathHelper.floor_double(player.posX));
			 stack.stackTagCompound.setInteger("LastPosZ", MathHelper.floor_double(player.posZ));
			 stack.stackTagCompound.setBoolean("Using", using);
			 stack.stackTagCompound.setInteger("TickU", 0);
			 stack.stackTagCompound.setInteger("Click", 0);
		}
		
		using = stack.stackTagCompound.getBoolean("Using");
		//System.out.println("sxd " + using);
		if(using){
			if(!world.isRemote){
				int num = stack.stackTagCompound.getInteger("TickU") + 1;
				stack.stackTagCompound.setInteger("TickU", num);
				int n = (num/20);
				System.out.println(n);
				int x = MathHelper.floor_double(player.posX);
		        int y = MathHelper.floor_double(player.posY);
		        int z = MathHelper.floor_double(player.posZ);
		        
		        x -= 2;
		        y += 20;
		        z -= 2;
		        
		        for(int y2 = y; y2 >= y - 20; y2--){
		        	for(int x2 = x; x2 <= x + 5; x2++){
		        		for(int z2 = z; z2 <= z + 5; z2++){	        			
		        			TileEntity TE = world.getTileEntity(x2, y2, z2);
		            		if(TE != null){
		            			if(TE instanceof LeafTileEntity){
		            				LeafTileEntity LTE = (LeafTileEntity) TE;
		            				int index = LTE.changeLeave(n);
		            				int meta = world.getBlockMetadata(x2, y2, z2);
				        			if(meta < 3){
				        				if(index < 75){
				        					meta = 1;
				        					if(index < 50){
				        						meta = 2;
				        						if(index < 25){
				        							meta = 3;
				        						}
				        					}
				        				}
				        				else
				        				{
				        					meta=0;
				        				}
				        				world.setBlockMetadataWithNotify(x2, y2, z2, meta, 2);
				        			}	            				
		            			}
		            		}
		            	}
		        	}
		        }
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
    	 if (stack.stackTagCompound == null) {    		 
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setInteger("Steps", 0);
    		 stack.stackTagCompound.setInteger("LastPosX", MathHelper.floor_double(player.posX));
    		 stack.stackTagCompound.setInteger("LastPosZ", MathHelper.floor_double(player.posZ));
    		 stack.stackTagCompound.setBoolean("Using", false);
    		 stack.stackTagCompound.setInteger("TickU", 0);
    		 stack.stackTagCompound.setInteger("Click", 0);
    	 }
     }
	
	@Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {       
		if(!world.isRemote){
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
			if(stack.stackTagCompound.getInteger("Click") < 2){
				stack.stackTagCompound.setBoolean("Using", true);
				stack.stackTagCompound.setInteger("TickU", 0);
			}
		}
        return stack;
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack item, World world, EntityPlayer player, int count)
    {
		item.stackTagCompound.setBoolean("Using", false);
		item.stackTagCompound.setInteger("TickU", 0);
		item.stackTagCompound.setInteger("Click", 0);
    }
}
