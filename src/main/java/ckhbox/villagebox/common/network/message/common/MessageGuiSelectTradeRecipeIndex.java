package ckhbox.villagebox.common.network.message.common;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.gui.common.ContainerTrading;
import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGuiSelectTradeRecipeIndex implements IMessage {

	private int currentRecipeIndex;
	
	public MessageGuiSelectTradeRecipeIndex(){
	}
	
	public MessageGuiSelectTradeRecipeIndex(int currentRecipeIndex){
		this.currentRecipeIndex = currentRecipeIndex;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.currentRecipeIndex = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(currentRecipeIndex);
	}

	public static class Handler implements IMessageHandler<MessageGuiSelectTradeRecipeIndex, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageGuiSelectTradeRecipeIndex message, MessageContext ctx) {
        	
        	Container container = ctx.getServerHandler().playerEntity.openContainer;
        	if(container instanceof ContainerTrading){
        		((ContainerTrading)container).setCurrentRecipeIndex(message.currentRecipeIndex);
        	}

            return null;
        }
    }
}
