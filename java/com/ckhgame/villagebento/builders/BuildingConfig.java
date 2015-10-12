package com.ckhgame.villagebento.builders;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

public class BuildingConfig {
	//ground work size
	public static final int SizeType_Small = 0;
	public static final int SizeType_Medium = 1;
	public static final int SizeType_Large = 2;
	
	public static final int GroundWorkSmallSizeX = 3;
	public static final int GroundWorkSmallSizeZ = 3;
	public static final int GroundWorkMediumSizeX = 5;
	public static final int GroundWorkMediumSizeZ = 5;
	public static final int GroundWorkLargeSizeX = 7;
	public static final int GroundWorkLargeSizeZ = 7;
	public static final int GroundWorkDepth = 7;
	
	public static final Block GroundWorkBlock = Blocks.stonebrick; 
}
