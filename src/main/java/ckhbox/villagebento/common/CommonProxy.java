package ckhbox.villagebento.common;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.block.ModBlocks;
import ckhbox.villagebento.common.entity.ModEntities;
import ckhbox.villagebento.common.event.EventBow;
import ckhbox.villagebento.common.event.EventCoinsFound;
import ckhbox.villagebento.common.event.EventEntity;
import ckhbox.villagebento.common.event.EventWorld;
import ckhbox.villagebento.common.gui.GuiHandler;
import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.recipe.ModRecipes;
import ckhbox.villagebento.common.village.profession.Profession;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.init();
		ModItems.init();
		ModEntities.init();
		ModRecipes.init();
		
		//gui
		NetworkRegistry.INSTANCE.registerGuiHandler(VillageBentoMod.instance, new GuiHandler());
		
		//messages
		ModNetwork.init();
		
		//profession
		Profession.init();
		
		//events
		MinecraftForge.EVENT_BUS.register(new EventEntity());
		MinecraftForge.EVENT_BUS.register(new EventCoinsFound());
		MinecraftForge.EVENT_BUS.register(new EventBow());
		MinecraftForge.EVENT_BUS.register(new EventWorld());
    }

    public void init(FMLInitializationEvent e) {
    	
    	
    	
    }

    public void postInit(FMLPostInitializationEvent e) {
    	
    }
}
