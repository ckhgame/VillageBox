package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.data.helper.HelperDataVrComp;
import com.ckhgame.villagebento.gui.GuiVillagerBuy;
import com.ckhgame.villagebento.misc.VBResult;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;

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
 * 3.itemBuy (ItemStack)
 * 
 *  result:
 * 1. ItemStack[]
 */
public class ActionDoVillagerBuy extends Action {
	
	public ActionDoVillagerBuy() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int villagerID = (Integer)info[0];
		int entityPlayerID = (Integer)info[1];
		ItemStack itemStack = (ItemStack)info[2];
		buf.writeInt(villagerID);
		buf.writeInt(entityPlayerID);
		ByteBufUtils.writeItemStack(buf, itemStack);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int villagerID = buf.readInt();
		int entityPlayerID = buf.readInt();
		ItemStack itemStack = ByteBufUtils.readItemStack(buf);
		
		return new Object[]{villagerID,entityPlayerID,itemStack};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int villagerID = (Integer)info[0];
		int entityPlayerID = (Integer)info[1];
		ItemStack itemBuy = (ItemStack)info[2];
		
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		DataVillageBento dataVB = DataVillageBento.get();
		DataVillager dvr = HelperDataVB.findVillagerByID(dataVB, villagerID);

		int buyResult = HelperDataVrComp.buyItem(dvr, entityPlayer, itemBuy);
		if(buyResult == VBResult.SUCCESS){
			dataVB.markDirty();
		}
		ItemStack[] itemStacks = HelperDataVrComp.getBuyList(dvr);
		
		return new Object[]{dvr.profession,itemStacks,buyResult};
	}
	
	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		
		int profession = (Integer)info[0];
		ItemStack[] itemStacks = (ItemStack[])info[1];	
		int buyResult = (Integer)info[2];
		
		buf.writeInt(profession);
		buf.writeInt(itemStacks.length);
		for(int i =0;i<itemStacks.length;i++){
			ByteBufUtils.writeItemStack(buf, itemStacks[i]);
		}
		buf.writeInt(buyResult);
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {

		int profession = buf.readInt();
		int l = buf.readInt();
		ItemStack[] itemStacks = new ItemStack[l];
		for(int i =0;i<l;i++){
			itemStacks[i] = ByteBufUtils.readItemStack(buf);
		}
		int buyResult = buf.readInt();
		
		return new Object[]{profession,itemStacks,buyResult};
	}



	@Override
	public void onActionCompleted(Object[] result) {

		int profession = (Integer)result[0];	
		ItemStack[] itemStacks = (ItemStack[])result[1];	
		int buyResult = (Integer)result[2];
		
		Villager vr = Villager.registry.get(profession);
		VillagerCompBuy vcBuy = (VillagerCompBuy)vr.findVillagerComponentByClass(VillagerCompBuy.class);
		if(vcBuy != null){
			GuiVillagerBuy gui = (GuiVillagerBuy)vcBuy.getGui();
			gui.setBuyList(itemStacks);
			gui.updateWithData(buyResult);
		}
	}

}
