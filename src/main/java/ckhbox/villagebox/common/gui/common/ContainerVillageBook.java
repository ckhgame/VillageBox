package ckhbox.villagebox.common.gui.common;

import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.player.MessageSyncCollections;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties.Collections;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;

public class ContainerVillageBook extends Container{
	
	public ContainerVillageBook(EntityPlayer player){
		if(player instanceof EntityPlayerMP){
			ExtendedPlayerProperties properties = ExtendedPlayerProperties.get(player);
			MessageSyncCollections msg = new MessageSyncCollections(properties.collections);
			ModNetwork.getInstance().sendTo(msg, (EntityPlayerMP)player);
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

}
