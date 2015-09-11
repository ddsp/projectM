package com.minecraftRPG.main;

import com.minecraftRPG.items.MinecraftRPGitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
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
				
				NBTTagCompound playerStack = sourcePlayer.inventory.getCurrentItem().getTagCompound();
				
				int CurrentHD = playerStack.getInteger("healingDivider");
				int CurrentSouls = playerStack.getInteger("Souls");
				int CurrentDB = playerStack.getInteger("DamageBoost");
				int ReverseSoul = playerStack.getInteger("ReverseSoul");
				String CurrentSS = playerStack.getString("SoulSlave");
				
				if((CurrentSS == sourcePlayer.getDisplayName()) || (CurrentSS == ""))
				{
					
					if(playerStack.getBoolean("SoulEaterActive") == true)
					{
						sourcePlayer.heal((event.entityLiving.getMaxHealth()-event.entityLiving.getHealth())/5);
					}				
							
					playerStack.setInteger("Souls", CurrentSouls + 1);
					
					if(playerStack.getInteger("Souls") == 10)
					{
						playerStack.setString("SoulSlave", sourcePlayer.getDisplayName());
						playerStack.setBoolean("SoulEaterActive", true);
						playerStack.setInteger("SoulEaterLVL", 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageSoulEaterActivate));
					}
					
					if(sourcePlayer.inventory.getCurrentItem().getTagCompound().getInteger("Souls") == 25)
					{
						playerStack.setBoolean("DamageBoostActive", true);
						playerStack.setInteger("DamageBoostLVL", 1);
						playerStack.setInteger("DamageBoost", CurrentDB + 1);
						sourcePlayer.addChatMessage(new ChatComponentText(MessageDamageBoostActivate));
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
}
