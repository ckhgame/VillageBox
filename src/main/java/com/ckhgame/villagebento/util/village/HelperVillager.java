package com.ckhgame.villagebento.util.village;

import java.util.List;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class HelperVillager {
	public static EntityVBVillager findNearestVillagerWithinAABB(AxisAlignedBB aabb, EntityVBVillager entitySelf)
    {
        List list = entitySelf.worldObj.getEntitiesWithinAABB(EntityVBVillager.class, aabb);
        EntityVBVillager entity1 = null;
        double d0 = Double.MAX_VALUE;

        for (int i = 0; i < list.size(); ++i)
        {
        	EntityVBVillager entity2 = (EntityVBVillager)list.get(i);

            if (entity2 != entitySelf)
            {
            	//if the entity is visiting other buildings and the target entity is the owner of that building, the entity will watch that target entity for no reason...
            	if(entitySelf.isVisiting() && entitySelf.getVisitingBuildingID() == entity2.getBuildingID())
            	{
            		entity1 = entity2;
            		break;
            	}
            	
                double d1 = entitySelf.getDistanceSqToEntity(entity2);

                if (d1 <= d0)
                {
                    entity1 = entity2;
                    d0 = d1;
                }
            }
        }
        
        return entity1;
    }
	
	public static Vec3 findWalkableBlockNearPos(World world, int x, int y, int z){
		int[] dxz = new int[]{1,1, 1,0, 1,-1, 
				  0,1,	0,-1,
				  -1,1, -1,0, -1,-1,0,0};
		for(int i =0;i<dxz.length;i+=2){
			Block b = world.getBlock(x + dxz[i], y,z + dxz[i +1]);
			if(b == Blocks.air || b == Blocks.carpet){
				return Vec3.createVectorHelper(x+ dxz[i]  + 0.5D, 
								 y + 1.0D, 
								 z + dxz[i +1] + 0.5D);
			}
		}
		return null;
	}
}
