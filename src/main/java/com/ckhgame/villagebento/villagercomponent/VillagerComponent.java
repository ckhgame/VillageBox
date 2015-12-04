package com.ckhgame.villagebento.villagercomponent;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.util.IData;
import com.ckhgame.villagebento.util.ISync;

public abstract class VillagerComponent implements ISync, IData{
	
	private GuiVillager guiVillager;
	private EntityVBVillager entityVillager; 
	
	public VillagerComponent(EntityVBVillager entityVillager,GuiVillager guiVillager){
		setVillager(entityVillager);
		setGui(guiVillager);
	}
	
	public abstract void firstTimeInit();
	
	/**
	 * update hourly...
	 */
	public abstract void update(int time);
	
	private void setGui(GuiVillager guiVillager){
		this.guiVillager = guiVillager;
		this.guiVillager.setVillageComponent(this);
	}
	
	public GuiVillager getGui(){
		return guiVillager;
	}
	
	private void setVillager(EntityVBVillager entityVillager){
		this.entityVillager = entityVillager;
	}
	
	public EntityVBVillager getVillager(){
		return this.entityVillager;
	}
	
	public boolean enabled(){
		return this.entityVillager.getProfession().getTimeSchedule().isWorkTimeNow();
	}
}
