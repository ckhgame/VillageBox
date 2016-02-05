package ckhbox.villagebento.common.network.message.villager;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerUpgrading;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGuiVillagerUpgrade implements IMessage {

	
	public MessageGuiVillagerUpgrade(){
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {

	}

	@Override
	public void toBytes(ByteBuf buf) {

	}

	public static class Handler implements IMessageHandler<MessageGuiVillagerUpgrade, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageGuiVillagerUpgrade message, MessageContext ctx) {
            
        	//upgrade villager
        	if(ctx.getServerHandler().playerEntity.openContainer instanceof ContainerVillagerUpgrading){
        		((ContainerVillagerUpgrading)ctx.getServerHandler().playerEntity.openContainer).upgrade();
        	}
        	
            return null;
        }
    }
}
