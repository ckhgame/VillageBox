package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.util.data.VBParticles;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * 
 * @author ckhgame
 * params:
 * 1. fx id (from VBParticles)
 * 2. x
 * 3. y
 * 4. z
 * 5.entityID
 */
public class SActionDoSpawnParticles extends Action {
	
	public SActionDoSpawnParticles() {
		super(false);
	}

	@Override
	public void onSelfSend(ByteBuf buf, Object[] info) {
		int fxid = (Integer)info[0];
		double x = (Double)info[1];
		double y = (Double)info[2];
		double z = (Double)info[3];
		int entityID = (Integer)info[4];
		buf.writeInt(fxid);
		buf.writeDouble(x);
		buf.writeDouble(y);
		buf.writeDouble(z);
		buf.writeInt(entityID);
	}

	@Override
	public Object[] onTargetReceived(ByteBuf buf) {
		int fxid = buf.readInt();
		double x = buf.readDouble();
		double y = buf.readDouble();
		double z = buf.readDouble();
		int entityID = buf.readInt();
		return new Object[]{fxid,x,y,z,entityID};
	}
	
	@Override
	public Object[] resolveRequest(Object[] info) {

		int fxid = (Integer)info[0];
		double x = (Double)info[1];
		double y = (Double)info[2];
		double z = (Double)info[3];
		int entityID = (Integer)info[4];
		
		World world = Minecraft.getMinecraft().theWorld;
		
		Entity entity = world.getEntityByID(entityID);
		
		if(entity != null)
			VBParticles.spawnParticle(world,entity, fxid, x, y, z);
		
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
