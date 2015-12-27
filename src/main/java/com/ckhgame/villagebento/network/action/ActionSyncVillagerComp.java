package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.GuiVillagerDialog;
import com.ckhgame.villagebento.guiold.GuiVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

/**
 * 
 * @author ckhgame
 * Sync comp data from server to client
 * params:
 * 1.villager entity id
 * 2.villager comp idx
 * 3.player entity id
 * 4.sync params (Object[]), could be null
 * 
 * return:
 * 1.VBResult
 */
public class ActionSyncVillagerComp extends Action {
	
	public ActionSyncVillagerComp() {
		super(true);
	}

	protected void onSyncParamsSend(ByteBuf buf, Object[] params){
		
	}
	
	protected Object[] onSyncParamsReceived(ByteBuf buf){
		return null;
	}
	
	protected VBCompResult onResolveSync(EntityVBVillager villager, VillagerComponent component, EntityPlayer player, Object[] params){
		return VBCompResult.getDefaultSuccessNoChat();
	}

	
	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int entityVillagerID = (Integer)info[0];
		int compIdx = (Integer)info[1];
		int entityPlayerID = (Integer)info[2];
		Object[] params = (Object[])info[3];
		buf.writeInt(entityVillagerID);
		buf.writeInt(compIdx);
		buf.writeInt(entityPlayerID);
		onSyncParamsSend(buf,params);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int entityVillagerID = buf.readInt();
		int compIdx = buf.readInt();
		int entityPlayerID = buf.readInt();
		Object[] params = onSyncParamsReceived(buf);
		return new Object[]{entityVillagerID,compIdx,entityPlayerID,params};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int entityVillagerID = (Integer)info[0];
		int compIdx = (Integer)info[1];
		int entityPlayerID = (Integer)info[2];
		Object[] params = (Object[])info[3];
		
		VBCompResult vbCompresult = VBCompResult.getDefaultSuccess();
		
		//villager & component
		VillagerComponent comp = null;
		EntityVBVillager villager = null;
		Entity entity = MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityVillagerID);
		if(entity instanceof EntityVBVillager){
			comp = ((EntityVBVillager)entity).getVillagerComponent(compIdx);
			villager = (EntityVBVillager)entity;
		}
		else{
			vbCompresult = VBCompResult.getDefaultSuccessNoChat();
		}
		
		//player
		EntityPlayer player = null;
		entity = MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		if(entity instanceof EntityPlayer){
			player = (EntityPlayer)entity;
		}
		else{
			vbCompresult = VBCompResult.getDefaultSuccessNoChat();
		}
		
		if(vbCompresult.vbResult == VBResult.SUCCESS){
			vbCompresult = onResolveSync(villager,comp,player,params);
		}
		
		return new Object[]{entityVillagerID,compIdx,comp,vbCompresult};
	}
	
	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
		int entityVillagerID = (Integer)info[0];
		int compIdx = (Integer)info[1];
		VillagerComponent comp = (VillagerComponent)info[2];
		VBCompResult vbCompresult = (VBCompResult)info[3];
		boolean foundComp = (comp!=null);
		buf.writeInt(entityVillagerID);
		buf.writeInt(compIdx);
		buf.writeBoolean(foundComp);
		if(foundComp){
			comp.syneWrite(buf);
		}
		VBCompResult.writeByteBuf(buf, vbCompresult);
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {	
		int entityVillagerID = buf.readInt();
		int compIdx = buf.readInt();
		boolean foundComp = buf.readBoolean();
		if(foundComp){
			World world = Minecraft.getMinecraft().theWorld;
			if(world.provider.dimensionId == 0){
				Entity entity = world.getEntityByID(entityVillagerID);
				if(entity instanceof EntityVBVillager){
					VillagerComponent comp = ((EntityVBVillager)entity).getVillagerComponent(compIdx);
					comp.syneRead(buf);
				}
			}
			
		}
		VBCompResult vbCompresult = VBCompResult.readByteBuf(buf);
		return new Object[]{vbCompresult};
	}


	@Override
	public void onActionCompleted(Object[] result) {
		VBCompResult vbCompresult = (VBCompResult)result[0];
		if(Minecraft.getMinecraft().currentScreen instanceof GuiVillagerDialog){
			((GuiVillagerDialog)Minecraft.getMinecraft().currentScreen).updateWithVBCompResult(vbCompresult);
		}
	}

}
