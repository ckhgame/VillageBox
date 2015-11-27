package com.ckhgame.villagebento;

import com.ckhgame.villagebento.block.ModBlocks;
import com.ckhgame.villagebento.building.ModBuildings;
import com.ckhgame.villagebento.config.ConfigDev;
import com.ckhgame.villagebento.entity.ModEntities;
import com.ckhgame.villagebento.event.EventEntity;
import com.ckhgame.villagebento.event.EventPlayer;
import com.ckhgame.villagebento.event.EventPlayerBedSleep;
import com.ckhgame.villagebento.event.EventRenderVillageOutlines;
import com.ckhgame.villagebento.event.EventVillageBentoTick;
import com.ckhgame.villagebento.event.EventVillageProtection;
import com.ckhgame.villagebento.event.EventWorld;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.ModMessages;
import com.ckhgame.villagebento.network.action.ModActions;
import com.ckhgame.villagebento.profession.ModProfessions;
import com.ckhgame.villagebento.recipe.ModRecipes;
import com.ckhgame.villagebento.renderer.ModRenderers;
import com.ckhgame.villagebento.tileentity.ModTileEntities;
import com.ckhgame.villagebento.util.village.ItemPrice;

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
		ModTileEntities.init();
		ModRenderers.init();
		ModMessages.init();		
		ModRecipes.init();
		ModBuildings.init();
		ModProfessions.init();
		ModActions.init();
		
		ItemPrice.init();
	}

	public void init(FMLInitializationEvent e) {
		
		 FMLCommonHandler.instance().bus().register(EventVillageBentoTick.getInstance());
		 MinecraftForge.EVENT_BUS.register(EventRenderVillageOutlines.getInstance());
		 MinecraftForge.EVENT_BUS.register(new EventPlayer());
		 MinecraftForge.EVENT_BUS.register(new EventPlayerBedSleep());
		 MinecraftForge.EVENT_BUS.register(new EventEntity());
		 MinecraftForge.EVENT_BUS.register(new EventWorld());
		 
		 //if it's in development, we don't want to restrict block placing&breaking, all items are avaliable to use as well...
		 if(!ConfigDev.IsDevMod){
			 MinecraftForge.EVENT_BUS.register(new EventVillageProtection());
		 }
	}
	

	public void postInit(FMLPostInitializationEvent e) {

	}
}
