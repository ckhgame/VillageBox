package com.ckhgame.villagebento.data;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.villager.Villager;

import net.minecraft.nbt.NBTTagCompound;

public class DataVillager extends Data{

	public int id;
	public String name;
	public String skin;
	public int profession;
	public int buildingID;
	public int death;	// > 0 means the villager has to wait for [death] days to revive again, <=0 means the villager is alive now.
	public int level;
	public int exp;
	
	public ArrayList<DataVillagerComp> dataComponents = new ArrayList<DataVillagerComp>();
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger(ConfigData.KeyDataVillagerID, this.id);
		compound.setString(ConfigData.KeyDataVillagerName, this.name);
		compound.setString(ConfigData.KeyDataVillagerSkin, this.skin);
		compound.setInteger(ConfigData.KeyDataVillagerProfession, this.profession);
		compound.setInteger(ConfigData.KeyDataVillagerBuildingID, this.buildingID);
		compound.setInteger(ConfigData.KeyDataVillagerDeath, this.death);
		compound.setInteger(ConfigData.KeyDataVillagerLevel,this.level);
		compound.setInteger(ConfigData.KeyDataVillagerExp,this.exp);
		
		//Villager v = Villager.registry.get(profession);
		//for(VillagerComponent vc : v.
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.id = compound.getInteger(ConfigData.KeyDataVillagerID);
		this.name = compound.getString(ConfigData.KeyDataVillagerName);
		this.skin = compound.getString(ConfigData.KeyDataVillagerSkin);
		this.profession = compound.getInteger(ConfigData.KeyDataVillagerProfession);
		this.buildingID = compound.getInteger(ConfigData.KeyDataVillagerBuildingID);	
		this.death = compound.getInteger(ConfigData.KeyDataVillagerDeath);	
		this.level = compound.getInteger(ConfigData.KeyDataVillagerLevel);
		this.exp = compound.getInteger(ConfigData.KeyDataVillagerExp);
	}
	
}
