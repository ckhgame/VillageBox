package ckhbox.villagebox.common.network.message.player;

import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSyncExtendedPlayerProperties implements IMessage {
	
	public int mailCount;
	public int newMailTimer;
	
	public MessageSyncExtendedPlayerProperties(){
	}
	
	public MessageSyncExtendedPlayerProperties(ExtendedPlayerProperties properties){
		this.newMailTimer = properties.newMailTimer;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.newMailTimer = buf.readInt();
		this.mailCount = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.newMailTimer);
		buf.writeInt(this.mailCount);
	}

	public static class Handler implements IMessageHandler<MessageSyncExtendedPlayerProperties, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageSyncExtendedPlayerProperties message, MessageContext ctx) {
        	ExtendedPlayerProperties properties = ExtendedPlayerProperties.get(Minecraft.getMinecraft().thePlayer);
        	properties.newMailTimer = message.newMailTimer;
            return null;
        }
    }
}
