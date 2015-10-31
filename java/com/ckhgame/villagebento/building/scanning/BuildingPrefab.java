package com.ckhgame.villagebento.building.scanning;

import java.util.ArrayList;

import net.minecraft.world.World;

public class BuildingPrefab {
	
	public ArrayList<BlockTypePosMetadata> blocks = new ArrayList<BlockTypePosMetadata>();
	
	public void build(World world,int x, int y,int z){
		
	}
	
	public void addblock(BlockTypePosMetadata b){
		blocks.add(b);
	}
}
