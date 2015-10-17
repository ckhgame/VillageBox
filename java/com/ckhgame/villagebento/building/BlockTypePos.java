package com.ckhgame.villagebento.building;

import net.minecraft.block.Block;

public class BlockTypePos {
	public Block block;
	public int x;
	public int y;
	public int z;
	public BlockTypePos(Block b,int x, int y,int z){
		this.block = b;
		this.x = x;
		this.y = y;
		this.z = z;
	}
}
