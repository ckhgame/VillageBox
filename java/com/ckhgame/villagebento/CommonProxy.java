package com.ckhgame.villagebento;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.ModBuildings;
import com.ckhgame.villagebento.entity.ModEntities;
import com.ckhgame.villagebento.event.EventItemPickup;
import com.ckhgame.villagebento.event.EventRenderVillageOutlines;
import com.ckhgame.villagebento.event.EventVillageBentoTick;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.misc.ItemPrice;
import com.ckhgame.villagebento.network.ModMessages;
import com.ckhgame.villagebento.network.action.ModActions;
import com.ckhgame.villagebento.recipe.ModRecipes;
import com.ckhgame.villagebento.renderer.ModRenderers;
import com.ckhgame.villagebento.villager.ModVillagers;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.init();
		ModItems.init();
		ModEntities.init();
		ModRenderers.init();
		ModMessages.init();		
		ModRecipes.init();
		ModBuildings.init();
		ModVillagers.init();
		ModActions.init();
		
		ItemPrice.init();
	}

	public void init(FMLInitializationEvent e) {
		
		 FMLCommonHandler.instance().bus().register(EventVillageBentoTick.getInstance());
		 MinecraftForge.EVENT_BUS.register(EventRenderVillageOutlines.getInstance());
		 MinecraftForge.EVENT_BUS.register(new EventItemPickup());
	}
	

	public void postInit(FMLPostInitializationEvent e) {

	}
}
