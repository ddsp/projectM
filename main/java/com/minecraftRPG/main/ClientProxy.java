package com.minecraftRPG.main;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

import com.minecraftRPG.armor.MinecraftRPGArmor;
import com.minecraftRPG.items.MinecraftRPGitems;
import com.minecraftRPG.mobs.EntityBlackWolf;
import com.minecraftRPG.mobs.EntityFlyingTest;
import com.minecraftRPG.mobs.EntityFlyingTestC;
import com.minecraftRPG.mobs.EntitySpiritWolf;
import com.minecraftRPG.mobs.RenderBlackWolf;
import com.minecraftRPG.mobs.RenderSpiritWolf;
import com.minecraftRPG.mobs.RenderTestFlyingEntity;
import com.minecraftRPG.mobs.RenderTestFlyingEntityC;
import com.minecraftRPG.models.BlackWolf;
import com.minecraftRPG.models.ModelBlackPendragonArmorV5_2;
import com.minecraftRPG.particles.SwordSouls;
import com.minecraftRPG.renderItems.swordQinshaRender;
import com.minecraftRPG.tileEntity.AlterPedestalRenderer;
import com.minecraftRPG.tileEntity.AlterPedestalTileEntity;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends ServerProxy{
	
	public static final Map<Item, ModelBiped> armorModels = new HashMap<Item, ModelBiped>();
	
	public void registerRenderThings(){
		registerAmorRen();
		registerItemRenderers();
				
		RenderingRegistry.registerEntityRenderingHandler(EntityBlackWolf.class, new RenderBlackWolf(new BlackWolf(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntitySpiritWolf.class, new RenderSpiritWolf(new BlackWolf(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingTest.class, new RenderTestFlyingEntity(new BlackWolf(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingTestC.class, new RenderTestFlyingEntityC(new BlackWolf(), 0));
		ClientRegistry.bindTileEntitySpecialRenderer(AlterPedestalTileEntity.class, new AlterPedestalRenderer());
	}
	
	public void registerAmorRen(){
		ModelBlackPendragonArmorV5_2 custom_armor = new ModelBlackPendragonArmorV5_2(1F);
		ModelBlackPendragonArmorV5_2 custom_legs = new ModelBlackPendragonArmorV5_2(0.5F);
		
		armorModels.put(MinecraftRPGArmor.first_helm, custom_armor);
		armorModels.put(MinecraftRPGArmor.first_body, custom_armor);
		armorModels.put(MinecraftRPGArmor.first_legs, custom_legs);
		armorModels.put(MinecraftRPGArmor.first_boots, custom_armor);
	}	
	
	public void registerItemRenderers(){
	      MinecraftForgeClient.registerItemRenderer(MinecraftRPGitems.QuishaTianling, (IItemRenderer)new swordQinshaRender());
	}
	
	@Override
	public void generateMysteriousParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    EntityFX particleMysterious = new SwordSouls(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() 
	                * theEntity.height, 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious);        
	}
}