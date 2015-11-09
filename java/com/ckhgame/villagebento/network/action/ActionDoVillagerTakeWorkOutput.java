package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerWork;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompWork;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (Integer)
 * 2.EntiryPlayerID (Integer)
 * result:
 * 1. playerName(String)
 * 2. workIdx (Integer)
 * 3. hoursLeft (Integer)
 * 3. output ItemStack[] (Integer)
 */
public class ActionDoVillagerTakeWorkOutput extends Action {
	
	public ActionDoVillagerTakeWorkOutput() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerID = (Integer)info[0];
		int entityPlayerID = (Integer)info[1];
		buf.writeInt(villagerID);
		buf.writeInt(entityPlayerID);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		int entityPlayerID = buf.readInt();
		return new Object[]{villagerID,entityPlayerID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (Integer)info[0];
		int entityPlayerID = (Integer)info[1];
		
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		
		int takeOutputResult = HelperDataVrComp.takeWorkOutput(dvr, entityPlayer);
		
		dataVB.markDirty();
		
		Object[] work = HelperDataVrComp.getWork(dvr);
	
		return new Object[]{dvr.profession,work,takeOutputResult};
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int profession = (Integer)info[0];
		Object[] work = (Object[])info[1];	
		int takeOutputResult = (Integer)info[2];
		
		buf.writeInt(profession);
		
		boolean hasWork = (work != null);
		buf.writeBoolean(hasWork);
		
		if(hasWork){
			ByteBufUtils.writeUTF8String(buf,(String)work[0]);
			buf.writeInt((Integer)work[1]);
			buf.writeInt((Integer)work[2]);
			boolean hasOutput = (work[3] != null);
			buf.writeBoolean(hasOutput);
			if(hasOutput){
				ByteBufUtils.writeItemStack(buf,(ItemStack)work[3]);
			}
		}
		
		buf.writeInt(takeOutputResult);
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
			
			int takeOutputResult = buf.readInt();
			
			return new Object[]{profession,playerName,workIdx,hoursLeft,output,takeOutputResult}; 
		}
		
		return new Object[]{profession};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (Integer)result[0];	
		String playerName = result.length <= 1?null : (String)result[1];
		int workIdx = result.length <= 1?null : (Integer)result[2];
		int hoursLeft = result.length <= 1?null : (Integer)result[3];
		ItemStack output = result.length <= 1?null : (ItemStack)result[4];
		int takeOutputResult = (Integer)result[5];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompWork vcWork = (VillagerCompWork)vr.findVillagerComponentByClass(VillagerCompWork.class);
		if(vcWork != null){
			GuiVillagerWork gui = (GuiVillagerWork)vcWork.getGui();
			gui.setWork(playerName,workIdx,hoursLeft,output);
			gui.updateWithData(takeOutputResult);
		}
	}

}
