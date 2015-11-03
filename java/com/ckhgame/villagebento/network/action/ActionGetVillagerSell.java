package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerSell;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompSell;

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
public class ActionGetVillagerSell extends Action {
	
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
		
		ItemStack[] itemStacks = HelperDataVrComp.getSellList(dvr);
		
		return new Object[]{villagerID,itemStacks};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int villagerID = (int)info[0];
		ItemStack[] itemStacks = (ItemStack[])info[1];	
		
		buf.writeInt(villagerID);
		buf.writeInt(itemStacks.length);
		for(int i =0;i<itemStacks.length;i++){
			ByteBufUtils.writeItemStack(buf, itemStacks[i]);
		}
	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

		int villagerID = buf.readInt();
		int l = buf.readInt();
		ItemStack[] itemStacks = new ItemStack[l];
		for(int i =0;i<l;i++){
			itemStacks[i] = ByteBufUtils.readItemStack(buf);
		}
		
		return new Object[]{villagerID,itemStacks};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int villagerID = (int)result[0];	
		ItemStack[] itemStacks = (ItemStack[])result[1];	
		
		DataVillager dvr = HelperDataVB.findVillagerByID(DataVillageBento.get(), villagerID); 
		Villager vr = Villager.registry.get(dvr.profession);
		VillagerCompSell vcSell = (VillagerCompSell)vr.findVillagerComponentByClass(VillagerCompSell.class);
		if(vcSell != null){
			((GuiVillagerSell)vcSell.getGui()).setSellList(itemStacks);
		}
	}

}
