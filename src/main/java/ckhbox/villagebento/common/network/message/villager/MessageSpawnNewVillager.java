package ckhbox.villagebento.common.network.message.villager;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.player.ExtendedPlayerProperties;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.Rand;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ChatComponentTranslationFormatException;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSpawnNewVillager implements IMessage {
	
	public MessageSpawnNewVillager(){
	}

	
	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	public static class Handler implements IMessageHandler<MessageSpawnNewVillager, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageSpawnNewVillager message, MessageContext ctx) {
        	
        	ExtendedPlayerProperties properties = ExtendedPlayerProperties.get(ctx.getServerHandler().playerEntity);
        	if(properties.newVillagerTimer <= 0){
        		//spawn villager
        		EntityPlayer player = ctx.getServerHandler().playerEntity;
        		EntityVillager villager = new EntityVillager(player.worldObj);
        		
        		double d = 2.0F;
        		double x = player.posX - Math.sin(player.rotationYaw / 180.0F * (float)Math.PI) * d;
        		double z = player.posZ + Math.cos(player.rotationYaw / 180.0F * (float)Math.PI) * d;
        		double y = player.posY;
        		
        		villager.setLocationAndAngles(x, y, z, player.rotationYaw + 180, 0);
        		ctx.getServerHandler().playerEntity.worldObj.spawnEntityInWorld(villager);
        		
        		//refresh timer
        		properties.newVillagerTimer = (int)(ExtendedPlayerProperties.NewVillagerTimerTotal * (Rand.get().nextFloat() * 0.3F + 0.7F));
        		
        		ExtendedPlayerProperties.get(player).SyncToClient();
        		
        		player.addChatMessage(
        			new ChatComponentTranslation(PathHelper.full("message.villager.newjoined"),villager.getName())
        		);
        	}

            return null;
        }
    }
}
