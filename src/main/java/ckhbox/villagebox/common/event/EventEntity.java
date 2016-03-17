package ckhbox.villagebox.common.event;

import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

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
    public void livingSpawnEvent(LivingSpawnEvent event) {
		
		Class ec = event.entityLiving.getClass();
		
		if(ec == EntityZombie.class){
			EntityZombie entity = (EntityZombie)event.entityLiving;
			entity.tasks.addTask(4, new EntityAIAttackOnCollide(entity, EntityVillager.class, 1.0D, true));
			entity.targetTasks.addTask(2, new EntityAINearestAttackableTarget(entity, EntityVillager.class, false));
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
