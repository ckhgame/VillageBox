package com.ckhgame.villagebento.villager.component;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.util.registry.IRegistrable;

public abstract class VillagerComponent {
	
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
	
	/**
	 * return null means this component doesn't need data...
	 */
	public abstract DataVillagerComp getNewDataInstance();
}
