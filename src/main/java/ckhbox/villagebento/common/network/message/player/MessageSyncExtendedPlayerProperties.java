package ckhbox.villagebento.common.network.message.player;

import ckhbox.villagebento.common.gui.common.ContainerTrading;
import ckhbox.villagebento.common.network.message.common.MessageGuiSelectTradeRecipeIndex;
import ckhbox.villagebento.common.player.ExtendedPlayerProperties;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSyncExtendedPlayerProperties implements IMessage {
	
	public boolean hasNewVillager;
	
	public MessageSyncExtendedPlayerProperties(){
	}
	
	public MessageSyncExtendedPlayerProperties(ExtendedPlayerProperties properties){
		this.hasNewVillager = properties.hasNewVillager;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.hasNewVillager = buf.readBoolean();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(hasNewVillager);
	}

	public static class Handler implements IMessageHandler<MessageSyncExtendedPlayerProperties, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageSyncExtendedPlayerProperties message, MessageContext ctx) {
        	ExtendedPlayerProperties properties = ExtendedPlayerProperties.get(Minecraft.getMinecraft().thePlayer);
        	properties.hasNewVillager = message.hasNewVillager;

            return null;
        }
    }
}
