package ckhbox.villagebento.common.network.message.villager;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGuiSetInteracting implements IMessage {

	private int dimension;
	private int entityVillagerID;
	private boolean setPlayer;
	
	
	public MessageGuiSetInteracting(){
	}

	public MessageGuiSetInteracting(int entityVillagerID, int dimension, boolean setPlayer){
		this.entityVillagerID = entityVillagerID;
		this.setPlayer = setPlayer;
		this.dimension = dimension;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.entityVillagerID = buf.readInt();
		this.dimension = buf.readInt();
		this.setPlayer = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.entityVillagerID);
		buf.writeInt(this.dimension);
		buf.writeBoolean(this.setPlayer);
	}

	public static class Handler implements IMessageHandler<MessageGuiSetInteracting, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageGuiSetInteracting message, MessageContext ctx) {
        	
        	if(ctx.getServerHandler().playerEntity.worldObj.provider.getDimensionId() == message.dimension){
        		//get villager
        		Entity entity = ctx.getServerHandler().playerEntity.worldObj.getEntityByID(message.entityVillagerID);
        		if(entity != null && entity instanceof EntityVillager){
        			EntityVillager villager = (EntityVillager)entity;
        			villager.setInteracting(message.setPlayer?ctx.getServerHandler().playerEntity:null);
        		}
        	}

            return null;
        }
    }
}
