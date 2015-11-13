package com.ckhgame.villagebento.building.scanning;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class HelperScanning {
	public static String getInstancePath(Block block){
		String path = getInstancePathFromClass(Blocks.class,block,"Blocks.");
		
		if(path == null)
			path = getInstancePathFromClass(ModBlocks.class,block,"ModBlocks.");
		
		if(path == null)
			path = "NOT FOUND!";
		
		return path;
	}
	
	public static String getInstancePath(Item item){
		String path = getInstancePathFromClass(Items.class,item,"Items.");
		
		if(path == null)
			path = getInstancePathFromClass(ModItems.class,item,"ModItems.");
		
		if(path == null)
			path = "NOT FOUND!";
		
		return path;
	}
	
	private static String getInstancePathFromClass(Class c, Object obj, String prefix){
		Field[] fs = c.getFields();
		for(Field f: fs){
			if(Modifier.isStatic(f.getModifiers())){
				try {
					if(f.get(null) == obj){
						return prefix + f.getName();
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
