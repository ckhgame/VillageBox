package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.tool.VBRandom;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork.Work;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuest;
import com.ckhgame.villagebento.villagercomponent.villagerquest.VillagerQuestDesign;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class VillagerCompQuest extends VillagerComponent {
	
	public VillagerCompQuest(EntityVBVillager entityVillager) {
		super(entityVillager,new GuiVillagerQuest());
	}
	
	private ArrayList<VillagerQuestDesign> questDesignList = new ArrayList<VillagerQuestDesign>();
	
	/**
	 * return the index of this work
	 */
	public void addQuestDesign(VillagerQuestDesign questDesign){
		if(questDesign != null)
			this.questDesignList.add(questDesign);
	}
	
	//-------------------------------------------------------
	//--------------------Data-------------------------------
	//-------------------------------------------------------
	
	//workIdx >=0 && hoursLeft > 0   ---->    in working..
	//workIdx >=0 && hoursLeft <= 0  ---->    waiting for player to take the output, hoursLeft means the expiration time 
	//workIdx <0 && hoursLeft <0     ---->    waiting for next work...
	
	private ArrayList<VillagerQuest> questListCurrent = new ArrayList<VillagerQuest>();

	public void refreshQuestListCurrent(int time){		
		//update the left hours of all quests
		ArrayList<VillagerQuest> removes = new ArrayList<VillagerQuest>();
		for(VillagerQuest quest : this.questListCurrent){
			quest.timeLeft--;
			if(quest.timeLeft <= 0){
				removes.add(quest);
			}
		}
		//remove the quest ran out of its life
		for(VillagerQuest remove : removes){
			this.questListCurrent.remove(remove);
		}
		
		//occasionally generate random quest on the beginning of a day...
		if(time == 0){
			if(VBRandom.getRand().nextInt(7) == 0){ //chance to create a new quest
				ArrayList<VillagerQuestDesign> designs = new  ArrayList<VillagerQuestDesign>();
				for(VillagerQuestDesign design : this.questDesignList){
					if(design.getMinLevel() <= this.getVillager().getLevel()){
						designs.add(design);
					}
				}
				if(designs.size() > 0){
					VillagerQuestDesign selected = designs.get(VBRandom.getRand().nextInt(designs.size()));
					VillagerQuest quest = selected.generateRandomQuest();
					if(quest != null)
						questListCurrent.add(quest);
				}
			}
		}
	}
	
	@Override
	public void syneWrite(ByteBuf buf) {		
		buf.writeInt(this.questListCurrent.size());		
		for(VillagerQuest quest : this.questListCurrent){
			quest.syneWrite(buf);
		}
	}

	@Override
	public void syneRead(ByteBuf buf) {
		int size = buf.readInt();
		for(int i =0;i<size;i++){
			VillagerQuest quest = new VillagerQuest();
			quest.syneRead(buf);
			this.questListCurrent.add(quest);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound tag;
		
		for(VillagerQuest quest : this.questListCurrent){
			tag = new NBTTagCompound();
			quest.writeToNBT(tag);
			tagList.appendTag(tag);
		}
		
		compound.setTag(ConfigData.KeyVillagerCompQuestListCurrent, tagList);	
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagCompound tag;
		NBTTagList tagList = compound.getTagList(ConfigData.KeyVillagerCompQuestListCurrent, Constants.NBT.TAG_COMPOUND);	
		this.questListCurrent.clear();
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			tag = tagList.getCompoundTagAt(i);
			VillagerQuest quest = new VillagerQuest();
			quest.readFromNBT(tag);
			questListCurrent.add(quest);
		}
	}

	@Override
	public void firstTimeInit() {

	}

	@Override
	public void update(int time) {
		this.refreshQuestListCurrent(time);
	} 
	
	
	//-------------------------------------------------------
	//--------------------Methods----------------------------
	//-------------------------------------------------------
	
	public VBCompResult completeQuest(int qIdx, EntityPlayer player){
		
		
		
		return VBCompResult.getDefaultSuccess();
		
	}
	
	public VBCompResult acceptQuest(int qIdx, EntityPlayer player){
		
		return VBCompResult.getDefaultSuccess();
	}
	
	
	
}
