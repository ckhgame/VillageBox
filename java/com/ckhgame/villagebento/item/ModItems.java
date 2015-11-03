package com.ckhgame.villagebento.item;


import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {
  
	public static Item itemVillageStick;
	public static Item itemVillageCurrency;
	
	public static final void init() {
        GameRegistry.registerItem(itemVillageStick = new ItemVillageStick(), "ItemVillageStick");
        GameRegistry.registerItem(itemVillageCurrency = new ItemVillageCurrency(), "ItemVillageCurrency");
    }
}
