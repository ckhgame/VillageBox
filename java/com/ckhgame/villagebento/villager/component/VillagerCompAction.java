package com.ckhgame.villagebento.villager.component;

import java.util.ArrayList;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.gui.GuiVillagerAction;
import com.ckhgame.villagebento.network.action.Action;

public class VillagerCompAction extends VillagerComponent {

	public VillagerCompAction() {
		super(new GuiVillagerAction());
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataVillagerComp getNewDataInstance() {
		return null;
	}
	
	private class VillagerAction{
		public String text;
		public Class<? extends Action> classAction;
		public Object[] params;
		public int minLevel;
	}
	
	private ArrayList<VillagerAction> actions = new ArrayList<VillagerAction>();
	
	public void addAction(String text, Class<? extends Action> classAction,Object[] params,int minLevel){
		VillagerAction action = new VillagerAction();
		action.text = text;
		action.classAction = classAction;
		action.params = params;
		action.minLevel = minLevel;
		actions.add(action);
	}
	
	public int getActionSize(){
		return actions.size();
	}
	
	public String getActionText(int idx){
		if(idx >= actions.size())
			return null;
		return actions.get(idx).text;
	}
	
	public int getActionMinLevel(int idx){
		if(idx >= actions.size())
			return 0;
		return actions.get(idx).minLevel;
	}
	
	public Object[] getActionParam(int idx){
		if(idx >= actions.size())
			return null;
		return actions.get(idx).params;
	}
	
	public Class getActionClass(int idx){
		if(idx >= actions.size())
			return null;
		return actions.get(idx).classAction;
	}
}
