package com.ckhgame.villagebento.profession;

import java.util.ArrayList;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.RangeInt;
import com.ckhgame.villagebento.util.data.VillagerChat;
import com.ckhgame.villagebento.util.data.VillagerSchedule;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public abstract class Profession implements IRegistrable {
	
	private int professionID;
	public int getProfessionID(){
		return professionID;
	}
	
	public int getRegID() {
		
		return professionID;
	}

	public void setRegID(int regID) {
		professionID = regID;
	}
	
	//villager entity class
	public Class<? extends EntityVBVillager> getEntityClass(){
		return EntityVBVillager.class;
	}
	
	//gender
	public boolean isMale(){
		return true;
	}
	
	//skin
	private ResourceLocation skinTexture;
	private void setSkin(String skin){
		skinTexture = new ResourceLocation(Main.MODID + ":" + "textures/entity/villager/"+skin+".png");
	}
	public ResourceLocation getSkin(){
		return skinTexture;
	}

	//villager chat
	private VillagerChat villagerChat = new VillagerChat();
	public VillagerChat getVillagerChat(){
		return villagerChat;
	}
	
	public abstract String getProfessionName();
	public abstract String getProfessionDescription();
	public abstract String getSkinName();
	public abstract boolean canSpawn();
	/**
	 * 
	 * CompAbout must be placed on 0
	 * components don't have relation with work hours should be placed prior (such as CompQuest)
	 */
	public abstract void createVillagerComponents(ArrayList<VillagerComponent> components,EntityVBVillager villager);
	protected abstract void initVillagerChat(VillagerChat villagerChat);
	
	//time schedule
	protected VillagerSchedule timeSchedule = new VillagerSchedule();
	protected void setTimeSchedule(){
		timeSchedule.setWorkTime(0, new RangeInt(8,16));		//Monday
		timeSchedule.setWorkTime(1, new RangeInt(8,16));		//Tuesday
		timeSchedule.setWorkTime(2, new RangeInt(8,16));		//Wednesday
		timeSchedule.setWorkTime(3, new RangeInt(8,16));		//Thursday
		timeSchedule.setWorkTime(4, new RangeInt(8,16));		//Friday
																					//Saturday
																					//Sunday
		
		timeSchedule.setSleeptime(new RangeInt(22,30));
	}
	
	public VillagerSchedule getTimeSchedule(){
		return this.timeSchedule;
	}
	
	//leveling up requirements
	protected ItemStack[][] levelRequirements;
	protected void setILevelRequirements(){
	}
	
	public boolean isMaxLevel(int currentLevel){
		if(currentLevel < 0 || levelRequirements == null || currentLevel >= levelRequirements.length ){
			return true;
		}
		return false;
	}
	
	public ItemStack[] getNextLevelRequirements(int currentLevel){
		if(isMaxLevel(currentLevel)){
			return null;
		}
		
		return this.levelRequirements[currentLevel];
	}
	
	public Profession(){
		initVillagerChat(villagerChat);
		setILevelRequirements();
		setSkin(this.getSkinName());
		setTimeSchedule();
	}
	
	
	//---------------------------------
	public static Registry<Profession> registry = new Registry<Profession>();
}


