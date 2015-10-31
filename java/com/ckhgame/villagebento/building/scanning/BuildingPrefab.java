package com.ckhgame.villagebento.building.scanning;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BuildingPrefab {
	
	public ArrayList<BlockTypePosMetadata> blocks = new ArrayList<BlockTypePosMetadata>();
	
	public void addblock(BlockTypePosMetadata b){
		blocks.add(b);
	}
	
	public void sort(){
		if(BuildingPrefab.delayList.size() == 0)
			BuildingPrefab.initDelayList();
		
		ArrayList<BlockTypePosMetadata> delayBlocks = new ArrayList<BlockTypePosMetadata>();
		
		for(int i =0;i<blocks.size();i++){
			if(delayList.contains(blocks.get(i).block)){
				delayBlocks.add(blocks.remove(i));
				i--;
			}
		}
		
		//add all delay blocks to the tail
		blocks.addAll(delayBlocks);
	}
	
	//which block should be delayed to add (if they are added with the scanning orders, they will drop, such as torch) 
	public static ArrayList<Block> delayList = new ArrayList<Block>();
	public static void initDelayList(){
		delayList.add(Blocks.torch);
	}
}
