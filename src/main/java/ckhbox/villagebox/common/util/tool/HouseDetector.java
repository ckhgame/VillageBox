package ckhbox.villagebox.common.util.tool;

import java.util.ArrayList;

import ckhbox.villagebox.common.util.math.IntBoundary;
import ckhbox.villagebox.common.util.math.IntVec3;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class HouseDetector {
	
	private static final int[] Dirs = new int[]{-1,0,		1,0,	0,-1,	0,1};
	private static final int SearchRadius = 15;
	private static final int SearchHeight = 30;
	
	/**
	 * get the closed field that contains the start position
	 * @param world
	 * @param start
	 */
	public static IntBoundary getClosedField(World world, IntVec3 start){
		
		ArrayList<IntVec3> closeList = new ArrayList<IntVec3>();
		IntBoundary bound = new IntBoundary(start.x, start.y, start.z, start.x, start.y, start.z);
		if(checkPoint(world,closeList,bound,start,start) == false)
			return null;
		return bound;
	}
	
	private static boolean checkPoint(World world, ArrayList<IntVec3> closeList, IntBoundary bound, IntVec3 pos, IntVec3 start){
		closeList.add(pos);
		//check 4 directions
		for(int i =0;i<8;i+=2){
			IntVec3 dpos = new IntVec3(pos.x + Dirs[i], pos.y, pos.z + Dirs[i + 1]);
			
			//out of max distance
			if(isOutOfRadius(pos,start)){
				if(isEnd(world,dpos))
					continue;
				else
					return false;
			}
			
			//skip if has already checked
			if(hasChecked(closeList, dpos)){
				continue;
			}
			
			if(isEnd(world,dpos)){
				//compare the end point to the bound
				if(dpos.x < bound.minx) bound.minx = dpos.x;
				else if(dpos.x > bound.maxx) bound.maxx = dpos.x;
				if(dpos.z < bound.minz) bound.minz = dpos.z;
				else if(dpos.z > bound.maxz) bound.maxz = dpos.z;
			}
			else{
				if(checkPoint(world, closeList, bound, dpos, start) == false)
					return false;
			}
		}
		
		return checkHeight(world, bound, pos);
	}
	
	private static boolean isOutOfRadius(IntVec3 pos, IntVec3 start){
		if(Math.abs(pos.x - start.x) > SearchRadius ||
		   Math.abs(pos.z - start.z) > SearchRadius)
			return true;
		return false;
	}
	
	private static boolean isEnd(World world, IntVec3 pos){
		return world.getBlockState(new BlockPos(pos.x, pos.y, pos.z)).getBlock().getMaterial().blocksMovement();
	}
	
	private static boolean hasChecked(ArrayList<IntVec3> closeList, IntVec3 pos){
		for(IntVec3 other : closeList){
			if(other.x == pos.x && other.z == pos.z){
				return true;
			}
		}
		return false;
	}	
	
	private static boolean checkHeight(World world, IntBoundary bound, IntVec3 pos){
		IntVec3 dpos = new IntVec3(pos.x,pos.y,pos.z);
		for(int i = 0; i<SearchHeight; i++){
			dpos.y++;
			if(isEnd(world,dpos)){
				if(dpos.y > bound.maxy){
					bound.maxy = dpos.y;
				}
				return true;
			}
		}
		return false;
	}
}
