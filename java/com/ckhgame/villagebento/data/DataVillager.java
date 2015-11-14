package com.ckhgame.villagebento.data;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class DataVillager extends Data{

	public int id;
	public String name;
	public int profession;
	public int buildingID;
	public int death;	// > 0 means the villager has to wait for [death] days to revive again, <=0 means the villager is alive now.
	public int level;
	public int exp;
	public int initX;
	public int initZ;
	
	public ArrayList<DataVillagerComp> dataComponents = new ArrayList<DataVillagerComp>();
	
	public int cacheEntityVillagerID;
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger(ConfigData.KeyDataVillagerID, this.id);
		compound.setString(ConfigData.KeyDataVillagerName, this.name);
		compound.setInteger(ConfigData.KeyDataVillagerProfession, this.profession);
		compound.setInteger(ConfigData.KeyDataVillagerBuildingID, this.buildingID);
		compound.setInteger(ConfigData.KeyDataVillagerDeath, this.death);
		compound.setInteger(ConfigData.KeyDataVillagerLevel,this.level);
		compound.setInteger(ConfigData.KeyDataVillagerExp,this.exp);
		compound.setInteger(ConfigData.KeyDataVillagerInitX,this.initX);
		compound.setInteger(ConfigData.KeyDataVillagerInitZ,this.initZ);
		
		//save components
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound tag = null;
		for(DataVillagerComp dataComp : dataComponents){
			tag = new NBTTagCompound();
			dataComp.writeToNBT(tag);		
			tagList.appendTag(tag);
		}
		compound.setTag(ConfigData.KeyVillagerComps, tagList);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.id = compound.getInteger(ConfigData.KeyDataVillagerID);
		this.name = compound.getString(ConfigData.KeyDataVillagerName);
		this.profession = compound.getInteger(ConfigData.KeyDataVillagerProfession);
		this.buildingID = compound.getInteger(ConfigData.KeyDataVillagerBuildingID);	
		this.death = compound.getInteger(ConfigData.KeyDataVillagerDeath);	
		this.level = compound.getInteger(ConfigData.KeyDataVillagerLevel);
		this.exp = compound.getInteger(ConfigData.KeyDataVillagerExp);
		this.initX = compound.getInteger(ConfigData.KeyDataVillagerInitX);
		this.initZ = compound.getInteger(ConfigData.KeyDataVillagerInitZ);
		
		//load components
		NBTTagList tagList = compound.getTagList(ConfigData.KeyVillagerComps, Constants.NBT.TAG_COMPOUND);
		Villager v = Villager.registry.get(profession);
		DataVillagerComp dataComp;
		dataComponents.clear();
		int idx = 0;
		for(VillagerComponent comp : v.getVillagerComponents()){
			dataComp = comp.getNewDataInstance();
			if(dataComp != null){//needs data for the current component				
				NBTTagCompound tag = tagList.getCompoundTagAt(idx++);
				dataComp.readFromNBT(tag);
				dataComponents.add(dataComp);
			}
		}
	}
	
}
