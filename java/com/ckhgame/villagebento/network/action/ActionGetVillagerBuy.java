package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (int)
 * result:
 * 1. ItemStack[]
 */
public class ActionGetVillagerBuy extends Action {
	
	@Override
	public void onClientSend(ByteBuf buf, Object[] info) {
		int villagerID = (int)info[0];
		buf.writeInt(villagerID);
	}

	@Override
	public Object[] onServerReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		return new Object[]{villagerID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (int)info[0];
		
		DataVillager dvr = HelperDataVB.findVillagerByID(DataVillageBento.get(), villagerID);
		
		ItemStack[] itemStacks = HelperDataVrComp.getBuyList(dvr);
		
		return new Object[]{dvr.profession,itemStacks};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int profession = (int)info[0];
		ItemStack[] itemStacks = (ItemStack[])info[1];	
		
		buf.writeInt(profession);
		buf.writeInt(itemStacks.length);
		for(int i =0;i<itemStacks.length;i++){
			ByteBufUtils.writeItemStack(buf, itemStacks[i]);
		}
	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		int profession = buf.readInt();
		int l = buf.readInt();
		ItemStack[] itemStacks = new ItemStack[l];
		for(int i =0;i<l;i++){
			itemStacks[i] = ByteBufUtils.readItemStack(buf);
		}
		
		return new Object[]{profession,itemStacks};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (int)result[0];	
		ItemStack[] itemStacks = (ItemStack[])result[1];	
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompBuy vcBuy = (VillagerCompBuy)vr.findVillagerComponentByClass(VillagerCompBuy.class);
		if(vcBuy != null){
			((GuiVillagerBuy)vcBuy.getGui()).setBuyList(itemStacks);
		}
	}

}
