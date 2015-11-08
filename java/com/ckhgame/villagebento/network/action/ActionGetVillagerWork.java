package com.ckhgame.villagebento.network.action;

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
 * 1. playerName(String)
 * 2. workIdx (int)
 * 3. hoursLeft (int)
 * 3. output ItemStack[] (int)
 */
public class ActionGetVillagerWork extends Action {
	
	public ActionGetVillagerWork() {
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
		
		Object[] work = HelperDataVrComp.getWork(dvr);
	
		return new Object[]{dvr.profession,work};
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int profession = (int)info[0];
		Object[] work = (Object[])info[1];	
		
		buf.writeInt(profession);
		
		boolean hasWork = (work != null);
		buf.writeBoolean(hasWork);
		
		if(hasWork){
			ByteBufUtils.writeUTF8String(buf,(String)work[0]);
			buf.writeInt((int)work[1]);
			buf.writeInt((int)work[2]);
			boolean hasOutput = (work[3] != null);
			buf.writeBoolean(hasOutput);
			if(hasOutput){
				ByteBufUtils.writeItemStack(buf,(ItemStack)work[3]);
			}
		}
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {

		int profession = buf.readInt();
		boolean hasWork = buf.readBoolean();
		if(hasWork){
			String playerName = ByteBufUtils.readUTF8String(buf);
			int workIdx = buf.readInt();
			int hoursLeft = buf.readInt();
			ItemStack output = null;
			boolean hasItemStack = buf.readBoolean();
			if(hasItemStack){
				output = ByteBufUtils.readItemStack(buf);
				
			}
			return new Object[]{profession,playerName,workIdx,hoursLeft,output}; 
		}
		
		return new Object[]{profession};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (int)result[0];	
		String playerName = result.length <= 1?null : (String)result[1];
		int workIdx = result.length <= 1?null : (int)result[2];
		int hoursLeft = result.length <= 1?null : (int)result[3];
		ItemStack output = result.length <= 1?null : (ItemStack)result[4];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompWork vcWork = (VillagerCompWork)vr.findVillagerComponentByClass(VillagerCompWork.class);
		if(vcWork != null){
			((GuiVillagerWork)vcWork.getGui()).setWork(playerName,workIdx,hoursLeft,output);
		}
	}

}
