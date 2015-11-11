package com.ckhgame.villagebento.network.action;

import java.util.ArrayList;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerAction;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;
import com.ckhgame.villagebento.gui.GuiVillagerWork;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompAction;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (Integer)
 * result:
 * 1. procession(Integer)
 * 2. actionIdxList (int[])
 */
public class ActionGetVillagerActionList extends Action {
	
	public ActionGetVillagerActionList() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerID = (Integer)info[0];
		buf.writeInt(villagerID);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		return new Object[]{villagerID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (Integer)info[0];
		
		DataVillager dvr = HelperDataVB.findVillagerByID(DataVillageBento.get(), villagerID);
		
		int[] actionList = HelperDataVrComp.getActionList(dvr);
	
		return new Object[]{dvr.profession,actionList};
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int profession = (Integer)info[0];
		int[] actionList = (int[])info[1];	
		
		buf.writeInt(profession);
		buf.writeInt(actionList.length);
		for(int i =0;i<actionList.length;i++)
			buf.writeInt(actionList[i]);
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {

		int profession = buf.readInt();
		int actionListLength = buf.readInt();
		int[] actionList = new int[actionListLength];
		for(int i =0;i<actionListLength;i++)
			actionList[i] = buf.readInt();
		
		return new Object[]{profession,actionList};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (Integer)result[0];	
		int[] actionList = (int[])result[1];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompAction vcAction = (VillagerCompAction)vr.findVillagerComponentByClass(VillagerCompAction.class);
		if(vcAction != null){
			((GuiVillagerAction)vcAction.getGui()).setActionList(actionList);
		}
	}

}
