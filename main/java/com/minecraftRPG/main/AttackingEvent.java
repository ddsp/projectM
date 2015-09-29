package com.minecraftRPG.main;

import com.minecraftRPG.items.MinecraftRPGitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public class AttackingEvent {
	
	@SubscribeEvent
	public void LivingDeathEvent(LivingDeathEvent event) {
		DamageSource source = event.source;
		
		String MessageSoulEaterActivate = "Hum... You may be of use. Yes! I shall aid you with my power for as long as you feed my the souls of the ones u slay!";
		String MessageDamageBoostActivate = "Drink milk for stronger bones...Drink souls for POWER!";
		String MessageNotMySlave = "YOU ARE NOT MY SLAVE!! I WONT LEND YOU MY POWER!! Yet i won't refuse a soul.";
		
		if (source.getDamageType() == "player"){
		 	EntityPlayer sourcePlayer = (EntityPlayer) source.getEntity();
			if(sourcePlayer.inventory.getCurrentItem().getItem() == MinecraftRPGitems.QuishaTianling){
				
				NBTTagCompound playerStack = sourcePlayer.inventory.getCurrentItem().getTagCompound();
				
				int CurrentHD = playerStack.getInteger("healingDivider");
				int CurrentSouls = playerStack.getInteger("Souls");
				int CurrentDB = playerStack.getInteger("DamageBoost");
				int ReverseSoul = playerStack.getInteger("ReverseSoul");
				String CurrentSS = playerStack.getString("SoulSlave");
				
				if(event.entityLiving instanceof EntityWither)
				{
					sourcePlayer.addChatMessage(new ChatComponentText("THIS POWER.... I CANT CONTROLE SO MUCH POWER FLOWING TO ME!!!"));
				}
				
				if((CurrentSS == sourcePlayer.getDisplayName()) || (CurrentSS == ""))
				{
					
					if(playerStack.getBoolean("SoulEaterActive") == true)
					{
						int heal = (int) (sourcePlayer.getMaxHealth() * (CurrentHD / 100));
						
						heal = Math.round(heal);
						
						sourcePlayer.heal(heal);
					}				
					
					if(playerStack.getInteger("Souls") != 500)
					{
						playerStack.setInteger("Souls", CurrentSouls + 1);
					}
					
					if(playerStack.getInteger("Souls") == 10)
					{
						playerStack.setString("SoulSlave", sourcePlayer.getDisplayName());
						playerStack.setBoolean("SoulEaterActive", true);
						playerStack.setInteger("SoulEaterLVL", 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageSoulEaterActivate));
					}
					
					if(playerStack.getInteger("Souls") == 25)
					{
						playerStack.setBoolean("DamageBoostActive", true);
						playerStack.setInteger("DamageBoostLVL", 1);
						playerStack.setInteger("DamageBoost", CurrentDB + 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageDamageBoostActivate));
					}
					
					if(playerStack.getInteger("Souls") == 50)
					{
						playerStack.setInteger("DamageBoostLVL", 2);
						
						int boost = CurrentDB + (int)(CurrentDB * (5.f / 100.0f));
						
						boost = Math.round(boost);
						
						playerStack.setInteger("DamageBoost", CurrentDB + boost);
						
					}
					
					if(playerStack.getInteger("Souls") == 100)
					{
						playerStack.setInteger("SoulEaterLVL", 2);
						
						playerStack.setInteger("healingDivider", CurrentHD + 1);
					}
					
					if(playerStack.getInteger("Souls") == 250)
					{
						playerStack.setInteger("SoulEaterLVL", 3);
						playerStack.setInteger("DamageBoostLVL", 3);
						
						playerStack.setInteger("healingDivider", CurrentHD + 2);
						
						int boost = CurrentDB + (int)(CurrentDB * (10.f / 100.0f));
						boost = Math.round(boost);
						playerStack.setInteger("DamageBoost", CurrentDB + boost);
					}
					
					if(playerStack.getInteger("Souls") == 500)
					{
						playerStack.setInteger("SoulEaterLVL", 3);
						playerStack.setInteger("DamageBoostLVL", 3);
						
						playerStack.setInteger("healingDivider", CurrentHD + 2);
						
						int boost = CurrentDB + (int)(CurrentDB * (10.f / 100.0f));
						boost = Math.round(boost);
						playerStack.setInteger("DamageBoost", CurrentDB + boost);
					}

				}
				else
				{
					if(CurrentSouls > 0)
					{
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setInteger("Souls", CurrentSouls - 1);
						ReverseSoul++;
						System.out.println(ReverseSoul);
						playerStack.setInteger("ReverseSoul", ReverseSoul);
						if(ReverseSoul % 3 == 0){
							sourcePlayer.addChatMessage(new ChatComponentText(MessageNotMySlave));
						}
					}
					
					if(CurrentSouls == 1)
					{
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setString("SoulSlave", "");
						sourcePlayer.addChatMessage(new ChatComponentText("I no longer have a slave!"));
					}
				}
				
				//Check healing factor
				//System.out.println((event.entityLiving.getMaxHealth()-event.entityLiving.getHealth())/5);
			}
		}
	}
	
	@SubscribeEvent
	public void LivingHurtEvent (LivingHurtEvent event) {
		
		if(event.entity instanceof EntityPlayer ){
			EntityPlayer player = (EntityPlayer) event.entity;
			Boolean veri = false;
			for(ItemStack piece : player.inventory.armorInventory){
				if(piece == null){
					veri = true;
				}
			}
			if(!veri){
				player.heal(event.ammount/2);
			}
		}
	}
	
	@SubscribeEvent
	public void onEnterChunk(EntityEvent.EnteringChunk event)
	{
		
	}
}
