package ckhbox.villagebento.common.event;

import ckhbox.villagebento.common.player.ExtendedPlayerProperties;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.Rand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EventEntity {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		//register extended player properties
		if(event.entity instanceof EntityPlayer){
			ExtendedPlayerProperties.register((EntityPlayer)event.entity);
		}
	}
	
	public ExtendedPlayerProperties playerProperties;
	
	@SubscribeEvent
	public void onLivingUpdating(LivingUpdateEvent event)
	{
		if(!event.entity.worldObj.isRemote){
			//register extended player properties
			if(event.entity instanceof EntityPlayer){

				//someone wants to join your village.....
				if(playerProperties == null){
					playerProperties = ExtendedPlayerProperties.get((EntityPlayer)event.entity);
				}
				System.out.println(playerProperties.newMailTimer);
				if(playerProperties.newMailTimer > 0){
					if(--playerProperties.newMailTimer == 0){
						playerProperties.mailCount++;
						((EntityPlayer)event.entity).addChatMessage(new ChatComponentTranslation(PathHelper.full("message.mail.newmail")));
						playerProperties.resetMailTimer();
					}
				}
			}
		}

	}
}
