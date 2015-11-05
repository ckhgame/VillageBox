package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;
import com.ckhgame.villagebento.gui.GuiVillagerWork;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;
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
 * 1.villagerID (int)
 * 2.EntiryPlayerID (int)
 * 3.WorkIdx (int)
 * result:
 * 1. playerName(String)
 * 2. workIdx (int)
 * 3. hoursLeft (int)
 * 3. output ItemStack[] (int)
 */
public class ActionDoVillagerStartWork extends Action {
	
	@Override
	public void onClientSend(ByteBuf buf, Object[] info) {
		int villagerID = (int)info[0];
		int entityPlayerID = (int)info[1];
		int workIdx = (int)info[2];
		buf.writeInt(villagerID);
		buf.writeInt(entityPlayerID);
		buf.writeInt(workIdx);
	}

	@Override
	public Object[] onServerReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		int entityPlayerID = buf.readInt();
		int workIdx = buf.readInt();
		return new Object[]{villagerID,entityPlayerID,workIdx};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (int)info[0];
		int entityPlayerID = (int)info[1];
		int workIdx = (int)info[2];
		
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		
		int startWorkResult = HelperDataVrComp.startWork(dvr, entityPlayer, workIdx);
		
		dataVB.markDirty();
		
		Object[] work = HelperDataVrComp.getWork(dvr);
	
		return new Object[]{dvr.profession,work,startWorkResult};
	}

	@Override
	public void onServerSend(ByteBuf buf, Object[] info) {
		
		int profession = (int)info[0];
		Object[] work = (Object[])info[1];	
		int startWorkResult = (int)info[2];
		
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
		
		buf.writeInt(startWorkResult);
	}

	@Override
	public Object[] onClientReceived(ByteBuf buf) {

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
			
			int startWorkResult = buf.readInt();
			
			return new Object[]{profession,playerName,workIdx,hoursLeft,output,startWorkResult}; 
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
		int startWorkResult = (int)result[5];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompWork vcWork = (VillagerCompWork)vr.findVillagerComponentByClass(VillagerCompWork.class);
		if(vcWork != null){
			GuiVillagerWork gui = (GuiVillagerWork)vcWork.getGui();
			gui.setWork(playerName,workIdx,hoursLeft,output);
			gui.updateWithData(startWorkResult);
		}
	}

}
