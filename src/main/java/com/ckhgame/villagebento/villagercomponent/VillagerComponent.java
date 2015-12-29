package com.ckhgame.villagebento.villagercomponent;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.IData;
import com.ckhgame.villagebento.util.ISync;

public abstract class VillagerComponent implements ISync, IData{
	
	private EntityVBVillager entityVillager; 
	
	public VillagerComponent(EntityVBVillager entityVillager){
		setVillager(entityVillager);
	}
	
	public abstract void firstTimeInit();
	
	/**
	 * update hourly...
	 */
	public abstract void update(int time);
	
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
