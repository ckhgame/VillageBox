package com.ckhgame.villagebento.building;

import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class BuilderGroundWrok {
	
	public static void buildGroundwork(World world,DataBuilding db){

		//basic sets of village
		int xfrom = db.x - db.sizeX;
		int xto = db.x + db.sizeX;
		int zfrom = db.z - db.sizeZ;
		int zto = db.z + db.sizeZ;
		int y = db.y;
		int depth = ConfigBuilding.BuildingGroundWorkDepth;
		int height = ConfigBuilding.BuildingMaxHeight; // building center includes in height
		
		
		for(int x = xfrom;x <= xto;x++){
			for(int z = zfrom;z<= zto;z++){	
				buildGroundworkPerColumn(world, x, z, y, depth, height);
			}
		}
		
	}

	
	//helper classes
	
	private static void buildGroundworkPerColumn(World world, int x, int z, int y, int depth, int height ){
		
		for(int dy = -depth; dy < 0;dy++){
			world.setBlock(x, y + dy, z, ConfigBuilding.GroundWorkBlock);
		}
		
		for(int dy = 0;dy<height;dy++){
			if (world.getBlock(x, dy+y, z).getMaterial() != Material.air){
				world.func_147480_a(x,dy+y,z,false);//destroy block
			}
		}
		
	}
	
}
