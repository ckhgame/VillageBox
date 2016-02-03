package ckhbox.villagebento.common;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.common.block.ModBlocks;
import ckhbox.villagebento.common.entity.ModEntities;
import ckhbox.villagebento.common.gui.GuiHandler;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.village.profession.Profession;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent e) {
		ModBlocks.init();
		ModEntities.init();
		
		//gui
		NetworkRegistry.INSTANCE.registerGuiHandler(VillageBentoMod.instance, new GuiHandler());
		
		//messages
		ModNetwork.init();
		
		//profession
		Profession.init();
    }

    public void init(FMLInitializationEvent e) {
    	
    	
    	
    }

    public void postInit(FMLPostInitializationEvent e) {
    	
    }
}
