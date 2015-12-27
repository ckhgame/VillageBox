package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.guiold.GuiVillagerWork;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.tool.VBRandom;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VillagerCompWork extends VillagerComponent {
	
	public VillagerCompWork(EntityVBVillager entityVillager) {
		super(entityVillager,new GuiVillagerWork());
	}
	
	//------------Villager Sell List Generation-------------
	public class Work{
		public String name;
		public String remark;
		public int minLevel;
		public int hours;
		public int price;
		public ArrayList<WorkOutput> outputs = new ArrayList<WorkOutput>();
	}
	
	public class WorkOutput{
		public Item item;
		public int min;
		public int max;
		public int meta;
	}
	
	private ArrayList<Work> workListTotal = new ArrayList<Work>();
	
	/**
	 * return the index of this work
	 */
	public int createWork(String name, String remark, int minLevel,int hours,int price){
		Work w = new Work();
		w.name = name;
		w.remark = remark;
		w.minLevel = minLevel;
		w.hours = Math.max(0, hours);
		w.price = Math.max(0, price);
		
		workListTotal.add(w);
		return this.workListTotal.size() - 1;
	}
	
	public void addWorkOutput(int widx, Item item,int min,int max,int meta){
		WorkOutput output = new WorkOutput();
		output.item = item;
		output.min = min;
		output.max = max;
		output.meta = meta;
		this.workListTotal.get(widx).outputs.add(output);
	}
	
	public void addWorkOutput(int widx, Block block,int min,int max,int meta){
		addWorkOutput(widx,Item.getItemFromBlock(block),min,max,meta);
	}
	
	public void addWorkOutput(int widx, Block block,int min,int max){
		addWorkOutput(widx,Item.getItemFromBlock(block),min,max,0);
	}
	
	public void addWorkOutput(int widx, Item item,int min,int max){
		addWorkOutput(widx,item,min,max,0);
	}

	public Work getWork(int idx){
		return this.workListTotal.get(idx);
	}
	
	//-------------------------------------------------------
	//--------------------Data-------------------------------
	//-------------------------------------------------------
	
	//workIdx >=0 && hoursLeft > 0   ---->    in working..
	//workIdx >=0 && hoursLeft <= 0  ---->    waiting for player to take the output, hoursLeft means the expiration time 
	//workIdx <0 && hoursLeft <0     ---->    waiting for next work...
	
	public String playerName = "";
	public int workIdx = -1;
	public int hoursLeft = -1;
	public ItemStack output = null;
	public int[] workIdxListCurrent = null;

	public void refreshOutput(){

		Random rand = VBRandom.getRand();
		
		if(workIdx < 0 || workIdx >= this.workListTotal.size()){
			output = null;
			return;
		}
		
		Work w = this.workListTotal.get(workIdx);	
		WorkOutput workOutput = w.outputs.get(rand.nextInt(w.outputs.size()));
		this.output = new ItemStack(workOutput.item,rand.nextInt(workOutput.max - workOutput.min + 1) + workOutput.min,workOutput.meta);
	}
	
	public void refreshWorkIdxListCurrent(){
		int vrLvl = this.getVillager().getLevel();
		int[] tempArr = new int[this.workListTotal.size()];
		int count = 0;
		Work work;
		for(int i =0;i<this.workListTotal.size();i++){
			work = this.workListTotal.get(i);
			if(work.minLevel <= vrLvl){
				tempArr[count++] = i;
			}
		}
		
		if(count == 0)
			this.workIdxListCurrent = null;
		else{
			this.workIdxListCurrent = new int[count];
			for(int i=0;i<count;i++){
				workIdxListCurrent[i] = tempArr[i];
			}
		}
	}
	
	public void workTimeStep(){		
		if(this.workIdx >= 0){
			this.hoursLeft -= 1;
			if(this.hoursLeft <= -ConfigVillager.WorkOutputExpirationHours)
				this.removeWorkOutput();
		}
	}
	
	@Override
	public void syneWrite(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.playerName);
		buf.writeInt(this.workIdx);
		buf.writeInt(this.hoursLeft);
		
		boolean hasOutput = (this.output != null);
		buf.writeBoolean(hasOutput);
		if(hasOutput){
			ByteBufUtils.writeItemStack(buf, output);
		}
		
		int workIdxSize = (this.workIdxListCurrent == null?0:this.workIdxListCurrent.length);
		buf.writeInt(workIdxSize);
		for(int i =0;i<workIdxSize;i++){
			buf.writeInt(this.workIdxListCurrent[i]);
		}
	}

	@Override
	public void syneRead(ByteBuf buf) {
		this.playerName = ByteBufUtils.readUTF8String(buf);
		this.workIdx = buf.readInt();
		this.hoursLeft = buf.readInt();
		
		boolean hasOutput = buf.readBoolean();
		if(hasOutput){
			this.output = ByteBufUtils.readItemStack(buf);
		}
		
		int workIdxSize = buf.readInt();
		this.workIdxListCurrent = (workIdxSize>0?new int[workIdxSize]:null);
		for(int i =0;i<workIdxSize;i++){
			this.workIdxListCurrent[i] = buf.readInt();
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {

		compound.setString(ConfigData.KeyVillagerCompWorkPlayerName, this.playerName);
		compound.setInteger(ConfigData.KeyVillagerCompWorkWorkIdx, this.workIdx);
		compound.setInteger(ConfigData.KeyVillagerCompWorkHoursLeft, this.hoursLeft);
		
		if(this.output != null){
			NBTTagCompound tag = new NBTTagCompound();
			this.output.writeToNBT(tag);		
			compound.setTag(ConfigData.KeyVillagerCompWorkOutput, tag);
		}
		else{
			if(compound.hasKey(ConfigData.KeyVillagerCompWorkOutput))
				compound.removeTag(ConfigData.KeyVillagerCompWorkOutput);
		}
		
		if(this.workIdxListCurrent != null){
			compound.setIntArray(ConfigData.KeyVillagerCompWorkCurrentIdxList, this.workIdxListCurrent);
		}
		else{
			if(compound.hasKey(ConfigData.KeyVillagerCompWorkCurrentIdxList))
				compound.removeTag(ConfigData.KeyVillagerCompWorkCurrentIdxList);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		this.playerName = compound.getString(ConfigData.KeyVillagerCompWorkPlayerName);
		this.workIdx = compound.getInteger(ConfigData.KeyVillagerCompWorkWorkIdx);
		this.hoursLeft = compound.getInteger(ConfigData.KeyVillagerCompWorkHoursLeft);
		
		if(compound.hasKey(ConfigData.KeyVillagerCompWorkOutput))
			this.output = ItemStack.loadItemStackFromNBT(compound.getCompoundTag(ConfigData.KeyVillagerCompWorkOutput));
		else
			this.output = null;
		
		if(compound.hasKey(ConfigData.KeyVillagerCompWorkCurrentIdxList))
			this.workIdxListCurrent = compound.getIntArray(ConfigData.KeyVillagerCompWorkCurrentIdxList);
		else
			this.workIdxListCurrent = null;
	}

	@Override
	public void firstTimeInit() {
		playerName = "";
		workIdx = -1;
		hoursLeft = -1;
		ItemStack output = null;
		refreshWorkIdxListCurrent();
	}

	@Override
	public void update(int time) {
		if(time == 0){
			refreshWorkIdxListCurrent();
		}
		
		workTimeStep();
	} 
	
	
	//-------------------------------------------------------
	//--------------------Methods----------------------------
	//-------------------------------------------------------
	
	public VBCompResult startWork(int wIdx, EntityPlayer player){
		
		//if is working or is waiting for taking the output...
		if(workIdx >= 0)
			return VBCompResult.getDefaultFailed();
		
		if(workIdx >= this.workListTotal.size())
			return VBCompResult.getDefaultFailed();
			
		if(!HelperPlayer.addCurrency(player, -this.workListTotal.get(wIdx).price))
			return new VBCompResult(VBResult.FAILED_UNAFFORDABLE,"You don't have enough money..");
		
		this.workIdx = wIdx;
		this.playerName = player.getDisplayName();
		this.hoursLeft = this.workListTotal.get(wIdx).hours;
		refreshOutput();
		
		//this.getVillager().addExp(ConfigVillager.WorkExpPerHour * this.workListTotal.get(wIdx).hours);//
		
		return VBCompResult.getDefaultSuccess();
		
	}
	
	public VBCompResult takeWorkOutput(EntityPlayer player){
		
		//if it's waiting for taking the output
		if(this.workIdx >=0 && this.hoursLeft <= 0){
			if(this.output != null){
				
				String name1 = this.playerName;
				String name2 = player.getDisplayName();
				
				if(!name1.equals(name2)){
					
					return new VBCompResult(VBResult.FAILED_WRONGNAME,"I'm not yours...");
				}
					
				
				player.inventory.addItemStackToInventory(this.output);
				this.output = null;
				this.workIdx = -1;
				
				return VBCompResult.getDefaultSuccess();
			}
		}
		
		return VBCompResult.getDefaultFailed();
	}
	
	public void removeWorkOutput(){		
		//if it's waiting for taking the output
		if(this.workIdx >=0 && this.hoursLeft <= 0){
			if(this.output != null){
				this.output = null;
				this.workIdx = -1;
			}
		}
	}
	
}
