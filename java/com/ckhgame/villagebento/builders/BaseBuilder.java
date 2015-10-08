package com.ckhgame.villagebento.builders;

import com.ckhgame.villagebento.data.BuildingData;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BaseBuilder {
	
	public static void buildGroundwork(World world,BuildingData data){

		//basic sets of village
		int xfrom = data.x - data.sizeX;
		int xto = data.x + data.sizeX;
		int zfrom = data.z - data.sizeZ;
		int zto = data.z + data.sizeZ;
		int y = data.y;
		int deep = BuildingConfig.GroundWorkDepth;
		
		for(int x = xfrom;x <= xto;x++){
			for(int z = zfrom;z<= zto;z++){	
				buildGroundworkPerColumn(world, x, z, y, deep);
			}
		}
	}

	
	//helper classes
	
	private static void buildGroundworkPerColumn(World world, int x, int z, int y, int deep ){
		int top = world.getHeight();
		for(int y_i = y - deep + 1; y_i <=y; y_i++){
			world.setBlock(x, y_i, z, BuildingConfig.GroundWorkBlock);
		}
		for(int y_i = y + 1; y_i <=top; y_i++){
			if (world.getBlock(x, y_i, z).getMaterial() != Material.air){
				//destroy block
				world.func_147480_a(x,y_i,z,false);
			}
		}
	}
	
}
