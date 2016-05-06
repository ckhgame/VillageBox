package ckhbox.villagebox.common.network.message.player;

import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties.Collections;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageSyncCollections implements IMessage {
	
	public NBTTagCompound tagcollections;
	
	public MessageSyncCollections(){
	}
	
	public MessageSyncCollections(Collections collections){
		this.tagcollections = new NBTTagCompound();
		collections.saveNBTData(this.tagcollections);
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.tagcollections = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeTag(buf, this.tagcollections);
	}

	public static class Handler implements IMessageHandler<MessageSyncCollections, IMessage> {
        /**
         * This gets called when the packet is read and received.
         */
        @Override
        public IMessage onMessage(MessageSyncCollections message, MessageContext ctx) {
        	ExtendedPlayerProperties properties = ExtendedPlayerProperties.get(Minecraft.getMinecraft().thePlayer);
        	properties.collections.loadNBTData(message.tagcollections);
            return null;
        }
    }
}
