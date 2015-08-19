package com.minecraftRPG.tileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class DarkRitual extends TileEntity {
    private boolean hasMaster, isMaster;
    private int masterX, masterY, masterZ;

    @Override
    public void updateEntity() {
    	super.updateEntity();
        if (!worldObj.isRemote) {
            if (hasMaster()) { 
                if (isMaster()) {
                    // Put stuff you want the multiblock to do here!
                }
            } else {
                // Constantly check if structure is formed until it is.
                if (checkMultiBlockForm()){
                	System.out.println("cheguei");
                    setupStructure();
                }
            }
        }
    }
    
    /** Check that structure is properly formed */
   	public boolean checkMultiBlockForm() {
   		int i = 0;
   		int y = yCoord; 
   		// Scan a 3x3x3 area, starting with the bottom left corner
   		for (int x = xCoord - 1; x < xCoord + 2; x++)
   				for (int z = zCoord - 1; z < zCoord + 2; z++) {
   					TileEntity tile = worldObj.getTileEntity(x, y, z);
   					String h = x + "  " + y + "  " + "   " + z;
   					// Make sure tile isn't null, is an instance of the same Tile, and isn't already a part of a multiblock
   					if (tile != null && (tile instanceof DarkRitual)) {
   						if (this.isMaster()) {
   							if (((DarkRitual)tile).hasMaster())
   								i++;
   						} else if (!((DarkRitual)tile).hasMaster())
   							i++;
   					}
   			}
   		boolean t = false;
   		// check if there are 26 blocks present ((3*3*3) - 1) and check that center block is empty
   		TileEntity tile = worldObj.getTileEntity(xCoord, y+1, zCoord);
        if (tile != null && (tile instanceof DarkRitual)){
            t = true;
        }
        System.out.println(i + "   " + t);
   		return i > 9 && t;
   	}
   	
   	/** Setup all the blocks in the structure*/
    public void setupStructure() {
    	int y = yCoord; 
        for (int x = xCoord - 1; x < xCoord + 2; x++)
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    // Check if block is bottom center block
                    boolean master = (x == xCoord && y == yCoord && z == zCoord);
                    if (tile != null && (tile instanceof DarkRitual)) {
                        ((DarkRitual) tile).setMasterCoords(xCoord, yCoord, zCoord);
                        ((DarkRitual) tile).setHasMaster(true);
                        ((DarkRitual) tile).setIsMaster(master);
                    }
                }
    }
    
    /** Reset method to be run when the master is gone or tells them to */
    public void reset() {
        masterX = 0;
        masterY = 0;
        masterZ = 0;
        hasMaster = false;
        isMaster = false;
    }
 
    /** Check that the master exists */
    public boolean checkForMaster() {
        TileEntity tile = worldObj.getTileEntity(masterX, masterY, masterZ);
        return (tile != null && (tile instanceof DarkRitual));
    }
    
    /** Reset all the parts of the structure */
    public void resetStructure() {
    	int y = yCoord; 
        for (int x = xCoord - 1; x < xCoord + 2; x++){
                for (int z = zCoord - 1; z < zCoord + 2; z++) {
                    TileEntity tile = worldObj.getTileEntity(x, y, z);
                    if (tile != null && (tile instanceof DarkRitual)){
                        ((DarkRitual) tile).reset();
                    }
                }
        }
        
        TileEntity tile = worldObj.getTileEntity(xCoord, y+1, zCoord);
        if (tile != null && (tile instanceof DarkRitual)){
            ((DarkRitual) tile).reset();
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound data) {
        super.writeToNBT(data);
        data.setInteger("masterX", masterX);
        data.setInteger("masterY", masterY);
        data.setInteger("masterZ", masterZ);
        data.setBoolean("hasMaster", hasMaster);
        data.setBoolean("isMaster", isMaster);
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE SAVED TO THE MASTER
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound data) {
        super.readFromNBT(data);
        masterX = data.getInteger("masterX");
        masterY = data.getInteger("masterY");
        masterZ = data.getInteger("masterZ");
        hasMaster = data.getBoolean("hasMaster");
        isMaster = data.getBoolean("isMaster");
        if (hasMaster() && isMaster()) {
            // Any other values should ONLY BE READ BY THE MASTER
        }
    }

    public boolean hasMaster() {
        return hasMaster;
    }

    public boolean isMaster() {
        return isMaster;
    }

    public int getMasterX() {
        return masterX;
    }

    public int getMasterY() {
        return masterY;
    }

    public int getMasterZ() {
        return masterZ;
    }

    public void setHasMaster(boolean bool) {
        hasMaster = bool;
    }

    public void setIsMaster(boolean bool) {
        isMaster = bool;
    }

    public void setMasterCoords(int x, int y, int z) {
        masterX = x;
        masterY = y;
        masterZ = z;
    }
}
