package com.ckhgame.villagebento.data.villagercomp;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class DataVillagerCompWork extends DataVillagerComp{

	//workIdx >=0 && hoursLeft > 0   ---->    in working..
	//workIdx >=0 && hoursLeft <= 0  ---->    waiting for player to take the output, hoursLeft means the expiration time 
	//workIdx <0 && hoursLeft <0     ---->    waiting for next work...
	
	public String playerName = "";
	public int workIdx = -1;
	public int hoursLeft = -1;
	public ItemStack output = null; 
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {
		
		compound.setString(ConfigData.KeyVillagerCompWorkPlayerName, playerName);
		compound.setInteger(ConfigData.KeyVillagerCompWorkWorkIdx, workIdx);
		compound.setInteger(ConfigData.KeyVillagerCompWorkHoursLeft, hoursLeft);
		
		if(output != null){
			NBTTagCompound tag = new NBTTagCompound();
			output.writeToNBT(tag);
			
			compound.setTag(ConfigData.KeyVillagerCompWorkOutput, tag);
		}
		else{
			if(compound.hasKey(ConfigData.KeyVillagerCompWorkOutput))
				compound.removeTag(ConfigData.KeyVillagerCompWorkOutput);
		}			
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {

		playerName = compound.getString(ConfigData.KeyVillagerCompWorkPlayerName);
		workIdx = compound.getInteger(ConfigData.KeyVillagerCompWorkWorkIdx);
		hoursLeft = compound.getInteger(ConfigData.KeyVillagerCompWorkHoursLeft);
		
		if(compound.hasKey(ConfigData.KeyVillagerCompWorkOutput))
			output = ItemStack.loadItemStackFromNBT(compound.getCompoundTag(ConfigData.KeyVillagerCompWorkOutput));
		else
			output = null;
	}
	
}
