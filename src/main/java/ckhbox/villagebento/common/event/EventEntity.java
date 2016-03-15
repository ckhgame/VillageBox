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
	
	@SubscribeEvent
	public void onLivingUpdating(LivingUpdateEvent event)
	{
		if(!event.entity.worldObj.isRemote){
			//register extended player properties
			if(event.entity instanceof EntityPlayer){

				ExtendedPlayerProperties playerProperties = ExtendedPlayerProperties.get((EntityPlayer)event.entity);

				if(playerProperties.hasSentInvitation && playerProperties.newMailTimer > 0){
					if(--playerProperties.newMailTimer == 0){
						((EntityPlayer)event.entity).addChatMessage(new ChatComponentTranslation(PathHelper.full("message.mail.newmail")));
					}
				}
			}
		}

	}
}
