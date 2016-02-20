package ckhbox.villagebento.common.entity;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.entity.painting.EntityPainting;
import ckhbox.villagebento.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModEntities {
	
	public static void init(){
		int id = 0;
		EntityRegistry.registerModEntity(EntityVillager.class, "Villager", id++, VillageBentoMod.instance, 80, 3, true);
		
		//flameball
		EntityRegistry.registerModEntity(EntityFlameBall.class, "flameball", id++, VillageBentoMod.instance, 64, 10, true);
		
		//painting
		EntityRegistry.registerModEntity(EntityPainting.class, "painting", id++, VillageBentoMod.instance, 160, Integer.MAX_VALUE, false);
		
		//eggs
		EntityRegistry.registerEgg(EntityVillager.class, 0xFFFFFFFF, 0xFFFF6666);
		
	}
}
