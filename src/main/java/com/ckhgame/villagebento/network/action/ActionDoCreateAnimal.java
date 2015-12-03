package com.ckhgame.villagebento.network.action;

import org.apache.http.message.BufferedHeader;

import com.ckhgame.villagebento.block.BlockVillageAnimal;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

/**
 * 
 * @author ckhgame
 * params:
 * 1.entityPlayerID (Integer)
 * 2.x(Integer)
 * 3.y(Integer)
 * 4.z(Integer)
 */
public class ActionDoCreateAnimal extends Action {
	
	public ActionDoCreateAnimal() {
		super(true);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int entityPlayerID = (Integer)info[0];
		int x = (Integer)info[1];
		int y = (Integer)info[2];
		int z = (Integer)info[3];
		String name = (String)info[4];
		buf.writeInt(entityPlayerID);
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
		ByteBufUtils.writeUTF8String(buf, name);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int entityPlayerID = buf.readInt();
		int x = buf.readInt();
		int y = buf.readInt();
		int z = buf.readInt();
		String name = ByteBufUtils.readUTF8String(buf);
		return new Object[]{entityPlayerID,x,y,z,name};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int entityPlayerID = (Integer)info[0];
		int x = (Integer)info[1];
		int y = (Integer)info[2];
		int z = (Integer)info[3];
		String name = (String)info[4];
		
		EntityPlayer entityPlayer = (EntityPlayer)MinecraftServer.getServer().worldServerForDimension(0).getEntityByID(entityPlayerID);
		
	    if(!entityPlayer.worldObj.isRemote && entityPlayer.worldObj.provider.dimensionId == 0){
	    	Block b = entityPlayer.worldObj.getBlock(x, y, z);
	    	if(b instanceof BlockVillageAnimal){
	    		((BlockVillageAnimal) b).createAnimal(entityPlayer.worldObj, entityPlayer, x, y, z, name);
	    	}
	    }
		
		return null;
	}

	@Override
	public void onTargetSend(ByteBuf buf, Object[] info) {
	}

	@Override
	public Object[] onSelfReceived(ByteBuf buf) {	
		return null;
	}


	@Override
	public void onActionCompleted(Object[] result) {

	}

}
