package com.ckhgame.villagebento.util.village;

import java.util.List;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.util.AxisAlignedBB;

public class HelperVillagerAI {
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
}
