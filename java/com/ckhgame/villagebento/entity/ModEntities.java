package com.ckhgame.villagebento.entity;


import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBChicken;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;

public class ModEntities {
	
	public static final void init() {
		int id = 0;
        EntityRegistry.registerModEntity(EntityVBVillager.class, "EntityVBVillager", id++, Main.instance, 80, 1, false);
        EntityRegistry.registerModEntity(EntityVBChicken.class, "EntityVBChicken", id++, Main.instance, 80, 1, false);
    }
}
