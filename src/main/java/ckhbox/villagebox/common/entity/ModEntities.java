package ckhbox.villagebox.common.entity;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.entity.painting.EntityPainting;
import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.entity.throwable.EntityLargeSnowBall;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static void init(){
		int id = 0;
		EntityRegistry.registerModEntity(EntityVillager.class, "villager", id++, VillageBoxMod.instance, 80, 3, true);
		
		//throwable
		EntityRegistry.registerModEntity(EntityFlameBall.class, "flameball", id++, VillageBoxMod.instance, 64, 10, true);
		EntityRegistry.registerModEntity(EntityLargeSnowBall.class, "largesnowball", id++, VillageBoxMod.instance, 64, 10, true);
		
		//painting
		EntityRegistry.registerModEntity(EntityPainting.class, "painting", id++, VillageBoxMod.instance, 160, Integer.MAX_VALUE, false);
		
		//eggs
		EntityRegistry.registerEgg(EntityVillager.class, 0xFFFFFFFF, 0xFFFF6666);
		
	}
}
