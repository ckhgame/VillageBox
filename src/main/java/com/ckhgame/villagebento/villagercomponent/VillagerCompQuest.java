package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.GuiVillagerQuest;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.tool.VBRandom;
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
	
	private ArrayList<VillagerQuest> questListCurrent = new ArrayList<VillagerQuest>();
	private int lastQuestID = 0;

	public ArrayList<VillagerQuest> getQuestListCurrent(){
		return this.questListCurrent;
	}
	
	private int getNextId(){
		return lastQuestID++;
	}
	
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
			if(this.questListCurrent.size() == 0){ // maximum 1 quest at the same time (12.22.2015)
				if(VBRandom.getRand().nextInt(ConfigVillager.QuestChance) == 0){ //chance to create a new quest
					ArrayList<VillagerQuestDesign> designs = new  ArrayList<VillagerQuestDesign>();
					for(VillagerQuestDesign design : this.questDesignList){
						if(design.getMinLevel() <= this.getVillager().getLevel()){
							designs.add(design);
						}
					}
					if(designs.size() > 0){
						VillagerQuestDesign selected = designs.get(VBRandom.getRand().nextInt(designs.size()));
						VillagerQuest quest = selected.generateRandomQuest(this.getNextId());
						if(quest != null){
							questListCurrent.add(quest);
						}
							
					}
				}
			}
		}
	}
	
	private VillagerQuest findQuestById(int id){
		for(VillagerQuest quest : this.questListCurrent){
			if(quest.id == id){
				return quest;
			}
		}
		return null;
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
		this.questListCurrent.clear();
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
		
		compound.setInteger(ConfigData.KeyVillagerCompQuestLastQuestID, this.lastQuestID);
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
		
		this.lastQuestID = compound.getInteger(ConfigData.KeyVillagerCompQuestLastQuestID);
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
	
	public VBCompResult completeQuest(int qid, EntityPlayer player){
			
		VillagerQuest quest = findQuestById(qid);
		if(quest == null)
			return new VBCompResult(VBResult.FALLED_RUNOUT,"The quest is not existed :(");
		
		if(!HelperPlayer.playerRemoveItemStack(player, quest.need)){
			return new VBCompResult(VBResult.FAILED_NOITEM,"You don't have what I need..");
		}
		
		if(quest.reward.getItem() == ModItems.itemVillageCurrency){
			HelperPlayer.addCurrency(player, quest.reward.getItemDamage());
		}
		else{
			player.inventory.addItemStackToInventory(quest.reward);
		}
		
		this.questListCurrent.remove(quest);
		
		return new VBCompResult(VBResult.SUCCESS,"Thanks, take your reward!");
		
	}
	
	public VBCompResult acceptQuest(int qid, EntityPlayer player){
		
		return VBCompResult.getDefaultSuccess();
	}
	
	@Override
	public boolean enabled() {
		//quest component should always be enabled...
		return true;
	}
	
}
