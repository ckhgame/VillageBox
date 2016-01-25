package ckhbox.villagebento.common.network.message;

import ckhbox.villagebento.VillageBentoMod;
import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGuiActionPerformed implements IMessage {

	private int guiID;
	private int buttonID;
	
	public MessageGuiActionPerformed(){
	}
	
	public MessageGuiActionPerformed(int guiID, int buttonID){
		this.guiID = guiID;
		this.buttonID = buttonID;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.guiID = buf.readInt();
		this.buttonID = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(guiID);
		buf.writeInt(buttonID);
	}

	public static class Handler implements IMessageHandler<MessageGuiActionPerformed, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageGuiActionPerformed message, MessageContext ctx) {
            ctx.getServerHandler().playerEntity.openGui(VillageBentoMod.instance, message.buttonID, ctx.getServerHandler().playerEntity.worldObj, 0, 0, 0);
            return null;
        }
    }
}
