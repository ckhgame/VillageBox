package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerSell;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (int)
 * 2.EntiryPlayerID (int)
 * 3.itemSell (ItemStack)
 * 
 *  result:
 * 1. ItemStack[]
 */
public class ActionDoVillagerSell extends Action {
	
	@Override
	public void onClientSend(ByteBuf buf, Object[] info) {
		int villagerID = (int)info[0];
		int entityPlayerID = (int)info[1];
		ItemStack itemStack = (ItemStack)info[2];
		buf.writeInt(villagerID);
		buf.writeInt(entityPlayerID);
		ByteBufUtils.writeItemStack(buf, itemStack);
	}

	@Override
	public Object[] onServerReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		int entityPlayerID = buf.readInt();
		ItemStack itemStack = ByteBufUtils.readItemStack(buf);
		
		return new Object[]{villagerID,entityPlayerID,itemStack};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (int)info[0];
		int entityPlayerID = (int)info[1];
		ItemStack itemSell = (ItemStack)info[2];
		
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);

		int sellResult = HelperDataVrComp.sellItem(dvr, entityPlayer, itemSell);
		
		if(sellResult == VBResult.SUCCESS)
			dataVB.markDirty();
		ItemStack[] itemStacks = HelperDataVrComp.getSellList(dvr);
		
		return new Object[]{dvr.profession,itemStacks,sellResult};
	}
	
	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int profession = (int)info[0];
		ItemStack[] itemStacks = (ItemStack[])info[1];	
		int sellResult = (int)info[2];
		
		buf.writeInt(profession);
		buf.writeInt(itemStacks.length);
		for(int i =0;i<itemStacks.length;i++){
			ByteBufUtils.writeItemStack(buf, itemStacks[i]);
		}
		buf.writeInt(sellResult);
	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		int profession = buf.readInt();
		int l = buf.readInt();
		ItemStack[] itemStacks = new ItemStack[l];
		for(int i =0;i<l;i++){
			itemStacks[i] = ByteBufUtils.readItemStack(buf);
		}
		int sellResult = buf.readInt();
		
		
		return new Object[]{profession,itemStacks,sellResult};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (int)result[0];	
		ItemStack[] itemStacks = (ItemStack[])result[1];	
		int sellResult = (int)result[2];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompSell vcSell = (VillagerCompSell)vr.findVillagerComponentByClass(VillagerCompSell.class);
		if(vcSell != null){
			GuiVillagerSell gui = (GuiVillagerSell)vcSell.getGui();
			gui.setSellList(itemStacks);
			gui.updateWithData(sellResult);
		}
	}

}
