package com.ckhgame.villagebento.building.builder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;

public class BuildingEntityList {
	private static Class[] list = null;
	public static void init(){
		if(list != null)
			return;
		
		list = new Class[]{
			EntityPainting.class,
			EntityItemFrame.class
		};
	}
	
	public static Class[] get(){
		init();
		return list;
	}
	
}
