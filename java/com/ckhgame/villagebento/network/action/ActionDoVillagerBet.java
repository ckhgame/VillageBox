package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerAction;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompAction;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.villagerID (Integer)
 * 2.EntiryPlayerID (Integer)
 * 3.bet (int)
 * 
 *  result:
 * 1. win times
 */
public class ActionDoVillagerBet extends Action {
	
	public ActionDoVillagerBet() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerID = (Integer)info[0];
		int entityPlayerID = (Integer)info[1];
		int bet = (Integer)info[2];
		buf.writeInt(villagerID);
		buf.writeInt(entityPlayerID);
		buf.writeInt(bet);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		int entityPlayerID = buf.readInt();
		int bet = buf.readInt();
		
		return new Object[]{villagerID,entityPlayerID,bet};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (Integer)info[0];
		int entityPlayerID = (Integer)info[1];
		int bet = (Integer)info[2];
		
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);

		int times = HelperDataVrComp.bet(entityPlayer,dvr,bet);
		
		return new Object[]{dvr.profession,bet,times};
	}
	
	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int profession = (Integer)info[0];
		int bet = (Integer)info[1];
		int times = (Integer)info[2];
		
		buf.writeInt(profession);
		buf.writeInt(bet);
		buf.writeInt(times);
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {

		int profession = buf.readInt();
		int bet = buf.readInt();
		int times = buf.readInt();
		
		return new Object[]{profession,bet,times};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (Integer)result[0];
		int bet = (Integer)result[1];
		int times = (Integer)result[2];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompAction vcAction = (VillagerCompAction)vr.findVillagerComponentByClass(VillagerCompAction.class);
		if(vcAction != null){
			GuiVillagerAction gui = (GuiVillagerAction)vcAction.getGui();
			setFinalResult(bet,times,gui);
		}
	}
	
	private void setFinalResult(int bet,int times,GuiVillagerAction gui ){
		String title = "";
		String content = "";
		String chat = "";
		
		if(times < 0){
			title = "Hmmm...";
			content = String.format("You need %d for this bet...",bet);
			chat = "Please check your money..";
		}
		else if(times == 0){
			title = "Unfortunately...";
			content = String.format("You are not lucky this time... You Totally lost %d.",bet);
			chat = "I'm sorry...";
		}
		else if(times == 1){
			title = "All good..";
			content = String.format("You spend %d and just won it back..",bet);
			chat = "OK...OK...";
		}
		else if(times == 2){
			title = "Winning!!";
			content = String.format("You spend %d and won %d from it.",bet,bet * times);
			chat = "Contrats..";
		}
		else if(times == 4){
			title = "A Big Win!";
			content = String.format("You spend %d and won %d from it.",bet,bet * times);
			chat = "You are so lucky!";
		}
		else if(times == 8){
			title = "Oh God!";
			content = String.format("You spend %d and won %d from it!!",bet,bet * times);
			chat = "That's.... AMAZING!!";
		}
		
		gui.setActionResult(title, content,chat);
	}

}
