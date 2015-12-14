package com.ckhgame.villagebento.entity;


import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBChicken;
import com.ckhgame.villagebento.entity.animal.EntityVBCow;
import com.ckhgame.villagebento.entity.animal.EntityVBSheep;
import com.ckhgame.villagebento.entity.misc.EntityBlockMountable;
import com.ckhgame.villagebento.entity.villager.EntityVBGuard;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static final void init() {
		int id = 0;
        EntityRegistry.registerModEntity(EntityVBVillager.class, "EntityVBVillager", id++, Main.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityVBGuard.class, "EntityVBGuard", id++, Main.instance, 80, 3, true);
        
        EntityRegistry.registerModEntity(EntityVBChicken.class, "EntityVBChicken", id++, Main.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityVBSheep.class, "EntityVBSheep", id++, Main.instance, 80, 3, true);
        EntityRegistry.registerModEntity(EntityVBCow.class, "EntityVBCow", id++, Main.instance, 80, 3, true);
        
        EntityRegistry.registerModEntity(EntityBlockMountable.class, "EntityBlockMountable", id++, Main.instance, 64, 1, true);
        
        //entity manager
        VBVillagerMgr.get().init();
    }
}
