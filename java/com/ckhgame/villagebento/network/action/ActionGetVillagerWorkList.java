package com.ckhgame.villagebento.network.action;

import java.util.ArrayList;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;
import com.ckhgame.villagebento.gui.GuiVillagerWork;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (int)
 * result:
 * 1. procession(int)
 * 2. workIdxList (int[])
 */
public class ActionGetVillagerWorkList extends Action {
	
	public ActionGetVillagerWorkList() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerID = (int)info[0];
		buf.writeInt(villagerID);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		return new Object[]{villagerID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (int)info[0];
		
		DataVillager dvr = HelperDataVB.findVillagerByID(DataVillageBento.get(), villagerID);
		
		int[] workList = HelperDataVrComp.getWorkList(dvr);
	
		return new Object[]{dvr.profession,workList};
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int profession = (int)info[0];
		int[] workList = (int[])info[1];	
		
		buf.writeInt(profession);
		buf.writeInt(workList.length);
		for(int i =0;i<workList.length;i++)
			buf.writeInt(workList[i]);
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {

		int profession = buf.readInt();
		int workListLength = buf.readInt();
		int[] workList = new int[workListLength];
		for(int i =0;i<workListLength;i++)
			workList[i] = buf.readInt();
		
		return new Object[]{profession,workList};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (int)result[0];	
		int[] workList = (int[])result[1];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompWork vcWork = (VillagerCompWork)vr.findVillagerComponentByClass(VillagerCompWork.class);
		if(vcWork != null){
			((GuiVillagerWork)vcWork.getGui()).setWorkList(workList);
		}
	}

}
