package com.ckhgame.villagebento.network.action;

import com.ckhgame.villagebento.network.VBNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequestC2S;
import com.ckhgame.villagebento.network.message.MessageVillageActionRequestS2C;
import com.ckhgame.villagebento.network.message.MessageVillageActionResponseC2S;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;

import io.netty.buffer.ByteBuf;

/**
 * 
 * @author ckhgame
 *	process of actions
 *	1.onSelfSend will be called on the Self side  => (on the place the Action.send() be called)
 *  2.ontargetReceived, resolveRequest and ontargetSend will be called on the target side  => (in MessageHandlerActionRequest)
 *  3.onCientReceived will be called on the Self side  => (in MessageHandlerActionResponse)
 *  4.onActionCompleted will be called after 3, the info onSelfReceived returned will be the final result of the whole process
 *  
 *  the parameter(or info) will be passed into onSelfSend, a specific action knows how to convert and package that info
 *  
 *  ontargetRecived receives data from the Self and returns a result(Object[])
 *  the result will be passed to ontargetSend as the second parameter
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
	
	/*
	 * true: client -> server
	 * false server -> client
	 */
	private boolean isClientToServer;
	public boolean isClientToServer(){
		return isClientToServer;
	}
	
	public Action(boolean isClientToServer){
		this.isClientToServer = isClientToServer;
	}
	
	//step1
	public abstract void onSelfSend(ByteBuf buf,Object[] info);
	
	//step2
	public abstract Object[] onTargetReceived(ByteBuf buf);
	
	//step3
	public abstract Object[] resolveRequest(Object[] info);
	
	//step4
	public abstract void onTargetSend(ByteBuf buf,Object[] info);
	
	//step5
	public abstract Object[] onSelfReceived(ByteBuf buf);
	
	//finally the action completed and we get the result
	public abstract void onActionCompleted(Object[] result);

	public static Registry<Action> registry = new Registry<Action>();

	public static void send(Class<? extends Action> ca, Object[] info){
		Action action = registry.get(ca);
		if(action != null){

			if(action.isClientToServer){
				//resolve and send info back to the Self in a new message
				MessageVillageActionRequestC2S msg = new MessageVillageActionRequestC2S();
				msg.info = info;
				msg.action = action;
				VBNetwork.networkWrapper.sendToServer(msg);
			}	
			else{
				MessageVillageActionRequestS2C msg = new MessageVillageActionRequestS2C();
				msg.info = info;
				msg.action = action;
				VBNetwork.networkWrapper.sendToAll(msg);
			}
		}
	}
	
	
}
