package ckhbox.villagebento.common.entity;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry.EntityRegistration;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModEntities {
	
	public static void init(){
		int id = 0;
		EntityRegistry.registerModEntity(EntityVillager.class, "Villager", id++, VillageBentoMod.instance, 80, 3, true);
		
		
		//eggs
		EntityRegistry.registerEgg(EntityVillager.class, 0xFFFFFFFF, 0xFFFF6666);
	}
}
