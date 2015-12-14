package com.ckhgame.villagebento.util.village;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.profession.Profession;

import net.minecraft.world.World;

public class VillagerSpawner {
	public static EntityVBVillager spawn(World world, Class<? extends Profession> proClass,int buildingID, int initX,int initY, int initZ, String name){
		
		//server side only
		if(world.isRemote)
			return null;
		
		Profession profession = Profession.registry.get(proClass);
		
		EntityVBVillager villager = null;
		try {
			villager = profession.getEntityClass().getDeclaredConstructor(World.class).newInstance(world);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(villager == null)
			return null;
		
		//init villager
		villager.setProfession(profession);
		villager.setInitPos(initX, initY, initZ);
		villager.moveToInitPos();
		villager.setName(name);
		villager.setBuildingID(buildingID);
		villager.firstTimeInitComponents();
		
		world.spawnEntityInWorld(villager);
		
		return villager;
	}
}
