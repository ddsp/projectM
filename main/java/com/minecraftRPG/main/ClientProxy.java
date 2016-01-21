package com.minecraftRPG.main;

import java.util.HashMap;
import java.util.HashMap;
import java.util.Map;

import com.minecraftRPG.armor.MinecraftRPGArmor;
import com.minecraftRPG.items.MinecraftRPGitems;
import com.minecraftRPG.items.model.ModelBlackPendragonArmorV5_2;
import com.minecraftRPG.items.render.swordQinshaRender;
import com.minecraftRPG.mobs.entity.EntityBlackWolf;
import com.minecraftRPG.mobs.entity.EntityFlyingTest;
import com.minecraftRPG.mobs.entity.EntityFlyingTestC;
import com.minecraftRPG.mobs.entity.EntitySpiritWolf;
import com.minecraftRPG.mobs.model.BlackWolf;
import com.minecraftRPG.mobs.render.RenderBlackWolf;
import com.minecraftRPG.mobs.render.RenderSpiritWolf;
import com.minecraftRPG.mobs.render.RenderTestFlyingEntity;
import com.minecraftRPG.mobs.render.RenderTestFlyingEntityC;
import com.minecraftRPG.particles.SwordSouls;
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
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
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
		
		armorModels.put(MinecraftRPGArmor.PendragonHelmet, custom_armor);
		armorModels.put(MinecraftRPGArmor.PendragonChestplate, custom_armor);
		armorModels.put(MinecraftRPGArmor.PendragonLeggins, custom_legs);
		armorModels.put(MinecraftRPGArmor.PendragonBoots, custom_armor);
	}	
	
	public void registerItemRenderers(){
	      //MinecraftForgeClient.registerItemRenderer(MinecraftRPGitems.QuishaTianling, (IItemRenderer)new swordQinshaRender());
	}
	
	@Override
	public void generateMysteriousParticles(Entity theEntity)
	{
		Vec3 vec3 = theEntity.getLookVec();
		World world = theEntity.worldObj;
	    EntityFX particleMysterious = new SwordSouls(
	          theEntity.worldObj, 
	          theEntity.posX + vec3.xCoord, 
	          theEntity.posY + vec3.yCoord, 
	          theEntity.posZ + vec3.zCoord);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleMysterious); 
	}
}