package com.ckhgame.villagebento;

import com.ckhgame.villagebento.blocks.ModBlocks;
import com.ckhgame.villagebento.entity.ModEntities;
import com.ckhgame.villagebento.event.EventVillageBentoTick;
import com.ckhgame.villagebento.event.EventRenderVillageOutlines;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.ModMessages;
import com.ckhgame.villagebento.renderer.ModRenderers;

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
	}

	public void init(FMLInitializationEvent e) {
		
		 FMLCommonHandler.instance().bus().register(EventVillageBentoTick.getInstance());
		 MinecraftForge.EVENT_BUS.register(EventRenderVillageOutlines.getInstance());
	}
	

	public void postInit(FMLPostInitializationEvent e) {

	}
}
