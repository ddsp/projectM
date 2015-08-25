package com.minecraftRPG.blocks;

import java.util.Random;

import com.minecraftRPG.lib.Strings;
import com.minecraftRPG.main.MinecraftRPG;
import com.minecraftRPG.tileEntity.AlterPedestalTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class AlterPedestal extends BlockContainer{
	
	private static boolean isBurning;
	private final boolean isBurning2 = false;
	private final Random random = new Random();
	
	//Treat it like a normal block here. The Block Bounds are a good idea - the first three are X Y and Z of the botton-left corner,
    //And the second three are the top-right corner.
    public AlterPedestal(Material mat) {
            super(mat);
    }

    //Make sure you set this as your TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
            return new AlterPedestalTileEntity();
    }
    
    //You don't want the normal render type, or it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
    
    //It's not an opaque cube, so you need this.
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    //It's not a normal block, so you need this too.
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    //This is the icon to use for showing the block in your hand.
    public void registerIcons(IIconRegister icon) {
            this.blockIcon = icon.registerIcon(Strings.IMGMODID+":AlterPedestalV1");
    }
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(MinecraftRPG.instance, 0, world, x, y, z);
		return true;
	}
    
    public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(MinecraftRPGBlocks.AlterPedestal);
	}
    
    public Item getItem(World world, int par2, int par3, int par4) {
    	return Item.getItemFromBlock(MinecraftRPGBlocks.AlterPedestal);
	}    
    
    public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!isBurning) {
			AlterPedestalTileEntity tileentitytutfurnace = (AlterPedestalTileEntity) world.getTileEntity(x, y, z);

			if (tileentitytutfurnace != null) {
				for (int i = 0; i < tileentitytutfurnace.getSizeInventory(); ++i) {
					ItemStack itemstack = tileentitytutfurnace.getStackInSlot(i);

					if (itemstack != null) {
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0) {
							int j = this.random.nextInt(21) + 10;

							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}

							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}
}
