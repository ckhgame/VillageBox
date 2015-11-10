package com.ckhgame.villagebento.building.scanning;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

public class BlockTypePosMetadata {
	public Block block;
	public int x;
	public int y;
	public int z;
	public int metadata;
	public TileEntity tileEntity;
	public BlockTypePosMetadata(Block b,int x, int y,int z,int mt,TileEntity te){
		this.block = b;
		this.x = x;
		this.y = y;
		this.z = z;
		this.metadata = mt;
		this.tileEntity = te;
	}
}
