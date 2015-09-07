package com.minecraftRPG.main;

import com.minecraftRPG.items.MinecraftRPGitems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class AttackingEvent {
	
	@SubscribeEvent
	public void LivingDeathEvent(LivingDeathEvent event) {
		DamageSource source = event.source;
		
		if (source.getDamageType() == "player"){
		 	EntityPlayer sourcePlayer = (EntityPlayer) source.getEntity();
			if(sourcePlayer.inventory.getCurrentItem().getItem() == MinecraftRPGitems.QuishaTianling){
				sourcePlayer.heal((event.entityLiving.getMaxHealth()-event.entityLiving.prevHealth)/5);
				System.out.println((event.entityLiving.getMaxHealth()-event.entityLiving.prevHealth)/5);
			}
		}
	}
}
