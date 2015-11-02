package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.network.VBNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequest;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponse;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author ckhgame
 *	process of actions
 *	1.onClientSend will be called on the client side  => (on the place the Action.send() be called)
 *  2.onServerReceived, resolveRequest and onServerSend will be called on the server side  => (in MessageHandlerActionRequest)
 *  3.onCientReceived will be called on the client side  => (in MessageHandlerActionResponse)
 *  4.onActionCompleted will be called after 3, the info onClientReceived returned will be the final result of the whole process
 *  
 *  the parameter(or info) will be passed into onClientSend, a specific action knows how to convert and package that info
 *  
 *  onServerRecived receives data from the client and returns a result(Object[])
 *  the result will be passed to onServerSend as the second parameter
 *  
 *  actions should be used after registering...
 */
public abstract class Action implements IRegistrable{
	
	private int actionID;
	
	public int getRegID() {
		// TODO Auto-generated method stub
		return actionID;
	}

	public void setRegID(int regID) {
		actionID = regID;
	}
	
	public int getActionID(){
		return actionID;
	}
	
	//step1
	public abstract void onClientSend(ByteBuf buf,Object[] info);
	
	//step2
	public abstract Object[] onServerReceived(ByteBuf buf);
	
	//step3
	public abstract Object[] resolveRequest(Object[] info);
	
	//step4
	public abstract void onServerSend(ByteBuf buf,Object[] info);
	
	//step5
	public abstract Object[] onClientReceived(ByteBuf buf);
	
	//finally the action completed and we get the result
	public abstract void onActionCompleted(Object[] result);

	public static Registry<Action> registry = new Registry<Action>();

	public static void send(Class<? extends Action> ca, Object[] info){
		Action action = registry.get(ca);
		if(action != null){
			//resolve and send info back to the client in a new message
			MessageVillageActionRequest msg = new MessageVillageActionRequest();
			msg.info = info;
			msg.action = action;
			
			VBNetwork.networkWrapper.sendToServer(msg);
		}
	}
	
	
}
