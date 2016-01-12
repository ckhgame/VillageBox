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
	
	public class ItemRecord{
		public ItemStack itemStack;
		public int minLevel;
	}
	
	public ArrayList<ItemRecord> itemRecords = new ArrayList<ItemRecord>();
	
	public void addItem(Item item,int minLevel,int meta){
		ItemRecord records = new ItemRecord();
		records.itemStack = new ItemStack(item,1,meta);
		records.minLevel = minLevel;
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
	
	public ArrayList<ItemRecord> getItemList(){
		return this.itemRecords;
	}
	
	public boolean isItemRecoardAvailable(ItemRecord record){
		return (record.minLevel <= this.getVillager().getLevel());
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
		
	}

	@Override
	public void update(int time) {
	}
	


}
