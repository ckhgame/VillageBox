package com.ckhgame.villagebento.entity;


import com.ckhgame.villagebento.Main;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;

public class ModEntities {
  
	public static Entity entityVBVillager;
	
	public static final void init() {
		int id = 0;
        EntityRegistry.registerModEntity(EntityVBVillager.class, "EntityVBVillager", id++, Main.instance, 80, 1, false);
    }
}
