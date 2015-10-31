package com.ckhgame.villagebento.building.fixdirection;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockTorch;
import net.minecraft.init.Blocks;

public class BlockDirection {
	
	private static HashMap<Block,int[][]> mapClassDirArray = new HashMap<Block,int[][]>();
	
	public static int fix(Block b, int metadata, int facing){
		//init the map before using
		if(mapClassDirArray.size() == 0){
			init();
		}
		
		int convertedMetadata;
		
		if(mapClassDirArray.containsKey(b)){
			int[][] datas = mapClassDirArray.get(b);
			
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
	
	private static void init(){
		//block directions should follow this order: [E,S,W,N]...
		mapClassDirArray.put(Blocks.torch, new int[][]{{1,3,2,4}});
		mapClassDirArray.put(Blocks.chest, new int[][]{{5,3,4,2}});
		mapClassDirArray.put(Blocks.log, new int[][]{{4,8,4,8},{5,9,5,9},{6,10,6,10},{7,11,7,11}});
		mapClassDirArray.put(Blocks.anvil, new int[][]{{0,1,2,3}});
		mapClassDirArray.put(Blocks.bed, new int[][]{{9,10,11,8},{1,2,3,0}});
		mapClassDirArray.put(Blocks.oak_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapClassDirArray.put(Blocks.brick_stairs, new int[][]{{1,3,0,2},{5,7,4,6}});
		mapClassDirArray.put(Blocks.pumpkin, new int[][]{{3,0,1,2}});
		mapClassDirArray.put(Blocks.lit_pumpkin, new int[][]{{3,0,1,2}});
		mapClassDirArray.put(Blocks.wooden_door, new int[][]{{2,3,0,1},{6,7,4,5}});
		mapClassDirArray.put(Blocks.iron_door, new int[][]{{2,3,0,1},{6,7,4,5}});
		mapClassDirArray.put(Blocks.furnace, new int[][]{{5,3,4,2}});
	}
}
