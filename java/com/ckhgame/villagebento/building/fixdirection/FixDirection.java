package com.ckhgame.villagebento.building.fixdirection;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.init.Blocks;

public class FixDirection {
	
	private static HashMap<Block,int[][]> mapBlockDirArray = new HashMap<Block,int[][]>();
	private static HashMap<Class<? extends Entity>,int[][]> mapEntityDirArray = new HashMap<Class<? extends Entity>,int[][]>();
	
	public static int fix(Block b, int metadata, int facing){
		//init the map before using
		if(mapBlockDirArray.size() == 0){
			init();
		}
		
		int convertedMetadata;
		
		if(mapBlockDirArray.containsKey(b)){
			int[][] datas = mapBlockDirArray.get(b);
			
			//offset rotation
			int offset = facing - 0; 
			
			//find current direction index
			int idx=0;
			int state=0;
			boolean found = false;
			for(state=0;state<datas.length;state++ ){
				for(idx = 0;idx<datas[state].length;idx++){
					if(datas[state][idx] == metadata){	
						found = true;
						break;
					}			
				}
				if(found)
					break;
			}
	
			if(found){
				//find the direction , we get the rotated direction
				idx = (idx + offset) % datas[state].length;			
				convertedMetadata = datas[state][idx];
				System.out.println(b.getClass().getName() + "," + metadata + "=>" + convertedMetadata);
			}
			else{
				//not find the direction, it's probably because the block is facing top or bottom, so we just return the original metadata 
				convertedMetadata = metadata;
			}
		}
		else{
			convertedMetadata = metadata;
		}
		
		return convertedMetadata;
	}
	
	public static int fix(Class<? extends Entity> e, int metadata, int facing){
		//init the map before using
		if(mapEntityDirArray.size() == 0){
			init();
		}
		
		int convertedMetadata;
		
		if(mapEntityDirArray.containsKey(e)){
			int[][] datas = mapEntityDirArray.get(e);
			
			//offset rotation
			int offset = facing - 0; 
			
			//find current direction index
			int idx=0;
			int state=0;
			boolean found = false;
			for(state=0;state<datas.length;state++ ){
				for(idx = 0;idx<datas[state].length;idx++){
					if(datas[state][idx] == metadata){	
						found = true;
						break;
					}			
				}
				if(found)
					break;
			}
	
			if(found){
				//find the direction , we get the rotated direction
				idx = (idx + offset) % datas[state].length;			
				convertedMetadata = datas[state][idx];
				System.out.println(e.getClass().getName() + "," + metadata + "=>" + convertedMetadata);
			}
			else{
				//not find the direction, it's probably because the block is facing top or bottom, so we just return the original metadata 
				convertedMetadata = metadata;
			}
		}
		else{
			convertedMetadata = metadata;
		}
		
		return convertedMetadata;
	}
	
	private static void init(){
		//block directions should follow this order: [E,S,W,N]...
		mapBlockDirArray.put(Blocks.torch, new int[][]{{1,3,2,4}});
		mapBlockDirArray.put(Blocks.chest, new int[][]{{5,3,4,2}});
		mapBlockDirArray.put(Blocks.log, new int[][]{{4,8,4,8},{5,9,5,9},{6,10,6,10},{7,11,7,11}});
		mapBlockDirArray.put(Blocks.anvil, new int[][]{{0,1,2,3}});
		mapBlockDirArray.put(Blocks.bed, new int[][]{{9,10,11,8},{1,2,3,0}});
		//stairs
		mapBlockDirArray.put(Blocks.oak_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.brick_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.acacia_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.birch_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.dark_oak_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.jungle_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.quartz_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.sandstone_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.spruce_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.stone_brick_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapBlockDirArray.put(Blocks.stone_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		
		mapBlockDirArray.put(Blocks.pumpkin, new int[][]{{3,0,1,2}});
		mapBlockDirArray.put(Blocks.lit_pumpkin, new int[][]{{3,0,1,2}});
		mapBlockDirArray.put(Blocks.wooden_door, new int[][]{{2,3,0,1},{6,7,4,5}});
		mapBlockDirArray.put(Blocks.iron_door, new int[][]{{2,3,0,1},{6,7,4,5}});
		mapBlockDirArray.put(Blocks.furnace, new int[][]{{5,3,4,2}});
		mapBlockDirArray.put(Blocks.fence_gate, new int[][]{{3,0,1,2}});
		
		mapBlockDirArray.put(Blocks.ladder, new int[][]{{5,3,4,2},{13,11,12,10}});
		mapBlockDirArray.put(Blocks.vine, new int[][]{{8,1,2,4}});
		
		mapBlockDirArray.put(Blocks.wall_sign, new int[][]{{5,3,4,2}});
		mapBlockDirArray.put(Blocks.standing_sign, new int[][]{{12,0,4,8},{13,1,5,9},{14,2,6,10},{15,3,7,11}});
		
		//----------------- entities --------------
		mapEntityDirArray.put(EntityPainting.class, new int[][]{{3,0,1,2}});
		mapEntityDirArray.put(EntityItemFrame.class, new int[][]{{3,0,1,2}});
	}
}
