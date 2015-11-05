package com.ckhgame.villagebento.villager.component;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompSell;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompWork;
import com.ckhgame.villagebento.gui.GuiVillagerWork;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class VillagerCompWork extends VillagerComponent {
	
	public VillagerCompWork() {
		super(new GuiVillagerWork());
		// TODO Auto-generated constructor stub
	}
	
	//------------Villager Sell List Generation-------------
	private class Work{
		public String name;
		public String remark;
		public int minLevel;
		public int hours;
		public int price;
		public ArrayList<WorkOutput> outputs = new ArrayList<WorkOutput>();
	}
	
	private class WorkOutput{
		public Item item;
		public int min;
		public int max;
		public int meta;
	}
	
	private ArrayList<Work> workListAll = new ArrayList<Work>();
	
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
		
		workListAll.add(w);
		return workListAll.size() - 1;
	}
	
	public void addWorkOutput(int workIdx, Item item,int min,int max,int meta){
		WorkOutput output = new WorkOutput();
		output.item = item;
		output.min = min;
		output.max = max;
		output.meta = meta;
		workListAll.get(workIdx).outputs.add(output);
	}
	
	public void addWorkOutput(int workIdx, Block block,int min,int max,int meta){
		addWorkOutput(workIdx,Item.getItemFromBlock(block),min,max,meta);
	}
	
	public void addWorkOutput(int workIdx, Block block,int min,int max){
		addWorkOutput(workIdx,Item.getItemFromBlock(block),min,max,0);
	}
	
	public void addWorkOutput(int workIdx, Item item,int min,int max){
		addWorkOutput(workIdx,item,min,max,0);
	}
	
	public int getWorkMinLevel(int workIdx){
		if(workIdx >= workListAll.size())
			return -1;
		else
			return workListAll.get(workIdx).minLevel;
	}
	
	public String getWorkName(int workIdx){
		if(workIdx >= workListAll.size())
			return null;
		else
			return workListAll.get(workIdx).name;
	}
	
	public String getWorkRemark(int workIdx){
		if(workIdx >= workListAll.size())
			return null;
		else
			return workListAll.get(workIdx).remark;
	}
	
	public int getWorkHours(int workIdx){
		if(workIdx >= workListAll.size())
			return -1;
		else
			return workListAll.get(workIdx).hours;
	}
	
	public int getWorkPrice(int workIdx){
		if(workIdx >= workListAll.size())
			return -1;
		else
			return workListAll.get(workIdx).price;
	}
	
	public int getWorksSize(){
		return workListAll.size();
	}
	
	public ItemStack generateOutput(int workIdx){

		Random rand = new Random();
		Work w = workListAll.get(workIdx);
		if(w == null || w.outputs.size() == 0)
			return null;	
		
		WorkOutput output = w.outputs.get(rand.nextInt(w.outputs.size()));
		ItemStack itemStack = new ItemStack(output.item,rand.nextInt(output.max - output.min + 1) + output.min,output.meta);
		
		return itemStack;
	}

	@Override
	public DataVillagerComp getNewDataInstance() {
		return new DataVillagerCompWork();
	}

}
