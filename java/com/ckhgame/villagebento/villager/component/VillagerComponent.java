package com.ckhgame.villagebento.villager.component;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.util.registry.IRegistrable;

public class VillagerComponent implements IRegistrable {
	
	private int type;
	
	public int getType(){
		return type;
	}
	
	public int getRegID() {
		return type;
	}

	public void setRegID(int regID) {
		this.type = regID;
		
	}
	
	private GuiVillager guiVillager;
	
	public VillagerComponent(GuiVillager guiVillager){
		setGui(guiVillager);
	}
	
	private void setGui(GuiVillager guiVillager){
		this.guiVillager = guiVillager;
		this.guiVillager.setVillageComponent(this);
	}
	
	public GuiVillager getGui(){
		return guiVillager;
	}
}
