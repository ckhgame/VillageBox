package com.ckhgame.villagebento.entities;


import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.items.ItemVillageStick;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.Entity;

public class ModEntities {
  
	public static Entity entityVBVillager;
	
	public static final void init() {
		int id = 0;
        EntityRegistry.registerModEntity(EntityVBVillager.class, "EntityVBVillager", id++, Main.instance, 80, 1, false);
    }
}
