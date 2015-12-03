package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.GuiVillagerAction;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerAction;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VillagerCompAction extends VillagerComponent {

	public VillagerCompAction(EntityVBVillager entityVBVillager) {
		super(entityVBVillager, new GuiVillagerAction());
	}

	private ArrayList<VillagerAction> actionListTotal = new ArrayList<VillagerAction>();

	public void addAction(VillagerAction action) {
		this.actionListTotal.add(action);
	}

	public VillagerAction getAction(int idx) {
		return this.actionListTotal.get(idx);
	}

	// -------------------------------------------------------
	// --------------------Data-------------------------------
	// -------------------------------------------------------

	public int[] actionIdxListCurrent = null;
	public String resultTitle = "<empty>";
	public String resultContent = "<empty>";
	public ItemStack resultItem = null;
	
	public void setResult(String title, String content, ItemStack item){
		this.resultTitle = title;
		this.resultContent = content;
		this.resultItem = item;
	}
	
	public void refreshActionIdxListCurrent() {
		int vrLvl = this.getVillager().getLevel();
		int[] tempArr = new int[this.actionListTotal.size()];
		int count = 0;
		VillagerAction action;
		for (int i = 0; i < this.actionListTotal.size(); i++) {
			action = this.actionListTotal.get(i);
			if (action.minLevel <= vrLvl) {
				tempArr[count++] = i;
			}
		}

		if (count == 0)
			this.actionIdxListCurrent = null;
		else {
			this.actionIdxListCurrent = new int[count];
			for (int i = 0; i < count; i++) {
				actionIdxListCurrent[i] = tempArr[i];
			}
		}
	}

	@Override
	public void syneWrite(ByteBuf buf) {
		int workIdxSize = (this.actionIdxListCurrent == null ? 0 : this.actionIdxListCurrent.length);
		buf.writeInt(workIdxSize);
		for (int i = 0; i < workIdxSize; i++) {
			buf.writeInt(this.actionIdxListCurrent[i]);
		}
		//results
		ByteBufUtils.writeUTF8String(buf, this.resultTitle);
		ByteBufUtils.writeUTF8String(buf, this.resultContent);
		boolean hasResultItem = (this.resultItem != null);
		buf.writeBoolean(hasResultItem);
		if(hasResultItem){
			ByteBufUtils.writeItemStack(buf, this.resultItem);
		}
	}

	@Override
	public void syneRead(ByteBuf buf) {
		int workIdxSize = buf.readInt();
		this.actionIdxListCurrent = (workIdxSize > 0 ? new int[workIdxSize] : null);
		for (int i = 0; i < workIdxSize; i++) {
			this.actionIdxListCurrent[i] = buf.readInt();
		}
		//results
		this.resultTitle = ByteBufUtils.readUTF8String(buf);
		this.resultContent = ByteBufUtils.readUTF8String(buf);
		boolean hasResultItem = buf.readBoolean();
		if(hasResultItem){
			this.resultItem = ByteBufUtils.readItemStack(buf);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		if (this.actionIdxListCurrent != null) {
			compound.setIntArray(ConfigData.KeyVillagerCompActionCurrentIdxList, this.actionIdxListCurrent);
		} else {
			if (compound.hasKey(ConfigData.KeyVillagerCompActionCurrentIdxList))
				compound.removeTag(ConfigData.KeyVillagerCompActionCurrentIdxList);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		if (compound.hasKey(ConfigData.KeyVillagerCompActionCurrentIdxList))
			this.actionIdxListCurrent = compound.getIntArray(ConfigData.KeyVillagerCompActionCurrentIdxList);
		else
			this.actionIdxListCurrent = null;
	}

	@Override
	public void firstTimeInit() {
		refreshActionIdxListCurrent();
	}

	@Override
	public void update(int time) {
		if (time == 0) {
			refreshActionIdxListCurrent();
		}
	}
}
