package com.minecraftRPG.main;

import com.minecraftRPG.items.MinecraftRPGitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

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
				
				int CurrentHD = sourcePlayer.inventory.getCurrentItem().getTagCompound().getInteger("healingDivider");
				int CurrentSouls = sourcePlayer.inventory.getCurrentItem().getTagCompound().getInteger("Souls");
				int CurrentDB = sourcePlayer.inventory.getCurrentItem().getTagCompound().getInteger("DamageBoost");
				String CurrentSS = sourcePlayer.inventory.getCurrentItem().getTagCompound().getString("SoulSlave");
				
				if((CurrentSS == sourcePlayer.getDisplayName()) || (CurrentSS == ""))
				{
					sourcePlayer.inventory.getCurrentItem().getTagCompound().setString("SoulSlave", sourcePlayer.getDisplayName());
					
					if(sourcePlayer.inventory.getCurrentItem().getTagCompound().getBoolean("SoulEaterActive") == true)
					{
						sourcePlayer.heal((event.entityLiving.getMaxHealth()-event.entityLiving.getHealth())/5);
					}				
							
					sourcePlayer.inventory.getCurrentItem().getTagCompound().setInteger("Souls", CurrentSouls + 1);
					
					if(sourcePlayer.inventory.getCurrentItem().getTagCompound().getInteger("Souls") == 10)
					{
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setString("SoulSlave", sourcePlayer.getDisplayName());
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setBoolean("SoulEaterActive", true);
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setInteger("SoulEaterLVL", 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageSoulEaterActivate));
					}
					
					if(sourcePlayer.inventory.getCurrentItem().getTagCompound().getInteger("Souls") == 25)
					{
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setBoolean("DamageBoostActive", true);
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setInteger("DamageBoostLVL", 1);
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setInteger("DamageBoost", CurrentDB + 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageDamageBoostActivate));
					}

				}
				else
				{
					if(CurrentDB > 0)
					{
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setInteger("DamageBoost", CurrentDB - 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageNotMySlave));
					}
					
					if(CurrentDB == 1)
					{
						sourcePlayer.inventory.getCurrentItem().getTagCompound().setString("SoulSlave", sourcePlayer.getDisplayName());
						sourcePlayer.addChatMessage(new ChatComponentText("I know longer have a slave!"));
					}
				}
				
				//Check healing factor
				//System.out.println((event.entityLiving.getMaxHealth()-event.entityLiving.getHealth())/5);
			}
		}
	}
}
