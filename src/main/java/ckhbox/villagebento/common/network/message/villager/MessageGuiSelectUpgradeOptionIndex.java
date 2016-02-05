package ckhbox.villagebento.common.network.message.villager;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.gui.common.ContainerTrading;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerUpgrading;
import io.netty.buffer.ByteBuf;
import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageGuiSelectUpgradeOptionIndex implements IMessage {

	private int currentUpgradeOptionIndex;
	
	public MessageGuiSelectUpgradeOptionIndex(){
	}
	
	public MessageGuiSelectUpgradeOptionIndex(int currentUpgradeOptionIndex){
		this.currentUpgradeOptionIndex = currentUpgradeOptionIndex;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.currentUpgradeOptionIndex = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(currentUpgradeOptionIndex);
	}

	public static class Handler implements IMessageHandler<MessageGuiSelectUpgradeOptionIndex, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageGuiSelectUpgradeOptionIndex message, MessageContext ctx) {
        	
        	Container container = ctx.getServerHandler().playerEntity.openContainer;
        	if(container instanceof ContainerVillagerUpgrading){
        		((ContainerVillagerUpgrading)container).setCurrentUpgradeOptionIndex(message.currentUpgradeOptionIndex);
        	}

            return null;
        }
    }
}
