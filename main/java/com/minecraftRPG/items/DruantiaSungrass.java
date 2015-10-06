package com.minecraftRPG.items;

import java.util.List;
import java.util.Random;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Multimap;
import com.minecraftRPG.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class DruantiaSungrass extends ItemSword{
	protected float weaponDamage;
	
	public DruantiaSungrass(ToolMaterial mat, float damage) {
		super(mat);
		weaponDamage = damage; 
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg){
		this.itemIcon = reg.registerIcon(Strings.IMGMODID + ":OberonsWind");
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
    {
		
    }
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity player, int par4, boolean par5) {
		super.onUpdate(stack, world, player, par4, par5);
		
		EntityPlayer p = (EntityPlayer) player;
		
		String Naturalist = stack.stackTagCompound.getString("Naturalist");
		Boolean GotElderSeed = stack.stackTagCompound.getBoolean("GotElderSeed");
		
		if(!world.isRemote)
		{
			if(Naturalist == "")
			{
				p.addChatMessage(new ChatComponentText("I'm sorry to bestow on you this quest but you must help me find the Elder Tree Seed"));
				stack.stackTagCompound.setString("Naturalist", p.getDisplayName());
			}
			
			if((p.inventory.hasItem(MinecraftRPGitems.SilverSword)) && (!GotElderSeed))
			{
				stack.stackTagCompound.setBoolean("GotElderSeed", true);
				p.addChatMessage(new ChatComponentText("That's it, that's the Elder Tree Seed."));
			}
		}
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) 
	{	
		
		return true;
	}
	
	@Override
	public Multimap getAttributeModifiers(ItemStack stack)
    {
		int DamageBoost = stack.stackTagCompound.getInteger("DamageBoost");
		
        Multimap multimap = super.getItemAttributeModifiers(); 
        multimap.clear();
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", 10, 0));
        return multimap;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        //p_77659_3_.setItemInUse(p_77659_1_, this.getMaxItemUseDuration(p_77659_1_));
		if(!world.isRemote)
		{
			int Virus = 3;
			Random rand = new Random();
			
			if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT))
			{
				player.addChatMessage(new ChatComponentText("That's it, that's the Elder Tree Seed."));
			}
			
			List mobs = world.getEntitiesWithinAABB(EntityMob.class, player.boundingBox.expand(10, 10, 10));
			
			for(int PlantVirus = Virus; PlantVirus > 0; PlantVirus--){
				int value = rand.nextInt(mobs.size());
				
				EntityMob m = (EntityMob) mobs.get(value);
				
				((EntityLiving)m).addPotionEffect(new PotionEffect(Potion.poison.id, 200, 30));
				System.out.println(m.getActivePotionEffect(Potion.poison));
			}
		}
        
		return stack;
    }
		
	@Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 72000;
    }
	
	// adds 'tooltip' text
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean p_77624_4_) {
		//stack.getTooltip(player, false);
		
		EnumChatFormatting[] colorChar = 
	    {
	        EnumChatFormatting.RED,
	        EnumChatFormatting.GOLD,
	        EnumChatFormatting.YELLOW,
	        EnumChatFormatting.GREEN,
	        EnumChatFormatting.AQUA,
	        EnumChatFormatting.DARK_GRAY,
	        EnumChatFormatting.LIGHT_PURPLE,
	        EnumChatFormatting.DARK_PURPLE
	    }; 
		
		if (stack.stackTagCompound != null) {
			float NatureEnergie = stack.stackTagCompound.getInteger("LifeEnergie");
			float NatureEnergieMax = stack.stackTagCompound.getInteger("LifeEnergieMax");
			float NatureEnergiePerc = (NatureEnergie * 100) / NatureEnergieMax;
			
			String Naturalist = stack.stackTagCompound.getString("Naturalist");
			
			list.add("");
			if((NatureEnergiePerc % 1) == 0)
			{
				
				int NatureEnergiePercInt = Math.round(NatureEnergiePerc);
				list.add(colorChar[3%8] + "Life Energie: " + NatureEnergiePercInt + "%     Naturalist:" + Naturalist);
			}
			else
			{
				list.add(colorChar[3%8] + "Life Energie: " + String.format("%.2f", NatureEnergiePerc) + "%     Naturalist: " + Naturalist);
			}
			
			
		
   		 				
    		 
    	 }else{
    		 stack.stackTagCompound = new NBTTagCompound(); 
    		 stack.stackTagCompound.setString("Naturalist", "");
    		 stack.stackTagCompound.setInteger("LifeEnergie", 500);
    		 stack.stackTagCompound.setInteger("LifeEnergieMax", 50000);
    		 
    		 stack.stackTagCompound.setBoolean("GotElderSeed", false);
    	 }
     }
}
