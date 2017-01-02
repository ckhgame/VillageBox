package ckhbox.villagebox.common.entity;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.entity.painting.EntityPainting;
import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.entity.throwable.EntityLargeSnowBall;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {
	
	public static void init(){
		int id = 0;

		//villager
		EntityRegistry.registerModEntity(new ResourceLocation(VillageBoxMod.MODID,"villager"), EntityVillager.class, "villager", id++, VillageBoxMod.instance, 80, 3, true, 0xFFFFFFFF, 0xFFFF6666);
		
		//throwable
		EntityRegistry.registerModEntity(new ResourceLocation(VillageBoxMod.MODID,"flameball"), EntityFlameBall.class, "flameball", id++, VillageBoxMod.instance, 64, 10, true);
		EntityRegistry.registerModEntity(new ResourceLocation(VillageBoxMod.MODID,"largesnowball"), EntityLargeSnowBall.class, "largesnowball", id++, VillageBoxMod.instance, 64, 10, true);
		
		//painting
		EntityRegistry.registerModEntity(new ResourceLocation(VillageBoxMod.MODID,"painting"), EntityPainting.class, "painting", id++, VillageBoxMod.instance, 160, Integer.MAX_VALUE, false);		
	}
	
	private static void register(Class entityClass, String name, int id, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(VillageBoxMod.MODID,name), entityClass, name, id, VillageBoxMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}
