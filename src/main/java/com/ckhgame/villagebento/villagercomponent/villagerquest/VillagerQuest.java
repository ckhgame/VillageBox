package com.ckhgame.villagebento.villagercomponent.villagerquest;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.util.IData;
import com.ckhgame.villagebento.util.ISync;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VillagerQuest implements IData, ISync{
	
	public int id;
	public String title;
	public String description;
	public ItemStack need;
	public ItemStack reward;
	public int timeLeft;
	
	public VillagerQuest(int id,String title,String description,ItemStack need,ItemStack reward){
		this.id = id;
		this.title = (title == null?"<empty>":title);
		this.description = (description == null?"<empty>":description);
		this.need = need;
		this.reward = reward;
		this.timeLeft = 48; // the player has 48 hours (mc time) to complete the quest
	}
	
	public VillagerQuest(){
	}

	@Override
	public void syneWrite(ByteBuf buf) {
		buf.writeInt(this.id);
		ByteBufUtils.writeUTF8String(buf, this.title);
		ByteBufUtils.writeUTF8String(buf, this.description);
		ByteBufUtils.writeItemStack(buf, this.need);
		ByteBufUtils.writeItemStack(buf, this.reward);
		buf.writeInt(this.timeLeft);
	}

	@Override
	public void syneRead(ByteBuf buf) {
		this.id = buf.readInt();
		this.title = ByteBufUtils.readUTF8String(buf);
		this.description = ByteBufUtils.readUTF8String(buf);
		this.need = ByteBufUtils.readItemStack(buf);
		this.reward = ByteBufUtils.readItemStack(buf);
		this.timeLeft = buf.readInt();
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		compound.setInteger(ConfigData.KeyVillagerCompQuestQuestID, this.id);
		compound.setString(ConfigData.KeyVillagerCompQuestTitle, this.title);
		compound.setString(ConfigData.KeyVillagerCompQuestDescription, this.description);
		NBTTagCompound tag = new NBTTagCompound();
		this.need.writeToNBT(tag);
		compound.setTag(ConfigData.KeyVillagerCompQuestNeed, tag);
		tag = new NBTTagCompound();
		this.reward.writeToNBT(tag);
		compound.setTag(ConfigData.KeyVillagerCompQuestReward, tag);
		compound.setInteger(ConfigData.KeyVillagerCompQuestTimeLeft, this.timeLeft);
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.id = compound.getInteger(ConfigData.KeyVillagerCompQuestQuestID);
		this.title = compound.getString(ConfigData.KeyVillagerCompQuestTitle);
		this.description = compound.getString(ConfigData.KeyVillagerCompQuestDescription);
		this.need = ItemStack.loadItemStackFromNBT(compound.getCompoundTag(ConfigData.KeyVillagerCompQuestNeed));
		this.reward = ItemStack.loadItemStackFromNBT(compound.getCompoundTag(ConfigData.KeyVillagerCompQuestReward));
		this.timeLeft = compound.getInteger(ConfigData.KeyVillagerCompQuestTimeLeft);
	}
}
