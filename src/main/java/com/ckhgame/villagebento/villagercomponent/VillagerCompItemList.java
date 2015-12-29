package com.ckhgame.villagebento.villagercomponent;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.config.ConfigData;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.tool.VBRandom;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public abstract class VillagerCompItemList extends VillagerComponent {
	
	public VillagerCompItemList(EntityVBVillager entityVillager) {
		super(entityVillager);
	}
	
	private class ItemRecord{
		public Item item;
		public int max;
		public int min;
		public int minLevel;
		public int meta;
	}
	
	private ArrayList<ItemRecord> itemRecords = new ArrayList<ItemRecord>();
	
	public void addItem(Item item,int min,int max,int minLevel,int meta){
		ItemRecord records = new ItemRecord();
		records.item = item;
		records.min = min;
		records.max = max;
		records.minLevel = minLevel;
		records.meta = meta;
		itemRecords.add(records);
	}
	
	public void addItem(Block block,int min,int max,int minLevel,int meta){
		addItem(Item.getItemFromBlock(block),min,max,minLevel,meta);
	}
	
	public void addItem(Block block,int min,int max,int minLevel){
		addItem(Item.getItemFromBlock(block),min,max,minLevel,0);
	}
	
	public void addItem(Item item,int min,int max,int minLevel){
		addItem(item,min,max,minLevel,0);
	}
	
	
	//-------------------------------------------------------
	//--------------------Data-------------------------------
	//-------------------------------------------------------
	
	public ArrayList<ItemStack> itemListCurrent = new ArrayList<ItemStack>();

	public void refreshItemListCurrent(){
		int vrLvl = this.getVillager().getLevel();
		this.itemListCurrent.clear();
		Random rand = VBRandom.getRand();
		for(ItemRecord record : this.itemRecords){
			if(record.minLevel <= vrLvl){
				this.itemListCurrent.add(new ItemStack(record.item,rand.nextInt(record.max - record.min + 1) + record.min,record.meta));
			}
		}
	}

	@Override
	public void syneWrite(ByteBuf buf) {
		buf.writeInt(this.itemListCurrent.size());
		for(ItemStack itemStack : this.itemListCurrent){
			ByteBufUtils.writeItemStack(buf, itemStack);
		}
	}

	@Override
	public void syneRead(ByteBuf buf) {
		itemListCurrent.clear();
		int size = buf.readInt();
		for(int i =0;i<size;i++){
			this.itemListCurrent.add(ByteBufUtils.readItemStack(buf));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList tagList = new NBTTagList();
		NBTTagCompound tag;
		if(itemListCurrent != null){
			for(ItemStack itemStack : itemListCurrent){
				tag = new NBTTagCompound();
				itemStack.writeToNBT(tag);
				tagList.appendTag(tag);
			}
		}		
		compound.setTag(ConfigData.KeyVillagerCompItemList + this.getNBTTagPostfix(), tagList);	
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		NBTTagCompound tag;
		NBTTagList tagList = compound.getTagList(ConfigData.KeyVillagerCompItemList + this.getNBTTagPostfix(), Constants.NBT.TAG_COMPOUND);	
		itemListCurrent.clear();
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			tag = tagList.getCompoundTagAt(i);
			itemListCurrent.add(ItemStack.loadItemStackFromNBT(tag));
		}
	}

	public abstract String getNBTTagPostfix();
	
	@Override
	public void firstTimeInit() {
		refreshItemListCurrent();
	}

	@Override
	public void update(int time) {
		if(time == 0)
			refreshItemListCurrent();
	}
	


}
