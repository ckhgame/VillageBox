package com.ckhgame.villagebento.builders;

import java.util.ArrayList;

import net.minecraft.world.World;

public class BuildingPrefab {
	
	public ArrayList<BlockTypePos> blocks = new ArrayList<BlockTypePos>();
	
	public void build(World world,int x, int y,int z){
		
	}
	
	public void addblock(BlockTypePos b){
		blocks.add(b);
	}
}
