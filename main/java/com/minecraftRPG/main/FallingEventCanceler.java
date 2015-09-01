package com.minecraftRPG.main;

import com.minecraftRPG.mobs.EntitySpiritWolf;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
public class FallingEventCanceler {

	@SubscribeEvent
	public void LivingFallEvent(LivingFallEvent event)
	{
		if(event.entity instanceof EntitySpiritWolf){
			EntitySpiritWolf wolf = (EntitySpiritWolf) event.entity;
			
			if(wolf.father != null){
				event.setCanceled(true);
			}
		}
	}
}
