package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.villagercomponent.VillagerCompWork.Work;
import com.ckhgame.villagebento.villagercomponent.villageraction.VillagerAction;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VillagerCompAction extends VillagerCompCustomDialog {

	public VillagerCompAction(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}

	private ArrayList<VillagerAction> actionListTotal = new ArrayList<VillagerAction>();

	public void addAction(VillagerAction action) {
		this.actionListTotal.add(action);
	}

	public VillagerAction getAction(int idx) {
		return this.actionListTotal.get(idx);
	}
	
	public int getActionListSize(){
		return this.actionListTotal.size();
	}
	
	public boolean isActionAvailable(VillagerAction action){
		return action.minLevel <= this.getVillager().getLevel();
	}

	// -------------------------------------------------------
	// --------------------Data-------------------------------
	// -------------------------------------------------------

	public String resultContent = "<empty>";
	public ItemStack resultItem = null;
	
	public void setResult(String content, ItemStack item){
		this.resultContent = content;
		this.resultItem = item;
	}
	
	public String getTranslatedResultContent(){
		return VillagerAction.translateFormatted(this.resultContent);
	}

	@Override
	public void syneWrite(ByteBuf buf) {
		//results
		ByteBufUtils.writeUTF8String(buf, this.resultContent);
		boolean hasResultItem = (this.resultItem != null);
		buf.writeBoolean(hasResultItem);
		if(hasResultItem){
			ByteBufUtils.writeItemStack(buf, this.resultItem);
		}
	}

	@Override
	public void syneRead(ByteBuf buf) {
		//results
		this.resultContent = ByteBufUtils.readUTF8String(buf);
		boolean hasResultItem = buf.readBoolean();
		if(hasResultItem){
			this.resultItem = ByteBufUtils.readItemStack(buf);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
	}

	@Override
	public void firstTimeInit() {
	}

	@Override
	public void update(int time) {
	}
}
