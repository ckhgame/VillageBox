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
		public int minLevel;
		public int meta;
	}
	
	private ArrayList<ItemRecord> itemRecords = new ArrayList<ItemRecord>();
	
	public void addItem(Item item,int minLevel,int meta){
		ItemRecord records = new ItemRecord();
		records.item = item;
		records.minLevel = minLevel;
		records.meta = meta;
		itemRecords.add(records);
	}
	
	public void addItem(Block block,int minLevel,int meta){
		addItem(Item.getItemFromBlock(block),minLevel,meta);
	}
	
	public void addItem(Block block,int minLevel){
		addItem(Item.getItemFromBlock(block),minLevel,0);
	}
	
	public void addItem(Item item,int minLevel){
		addItem(item,minLevel,0);
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
				this.itemListCurrent.add(new ItemStack(record.item, 1, record.meta));
			}
		}
	}

	@Override
	public void syneWrite(ByteBuf buf) {
	}

	@Override
	public void syneRead(ByteBuf buf) {
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
	}

	public abstract String getNBTTagPostfix();
	
	@Override
	public void firstTimeInit() {
		refreshItemListCurrent();
	}

	@Override
	public void update(int time) {
	}
	


}
