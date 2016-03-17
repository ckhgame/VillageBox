package ckhbox.villagebox.common;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.entity.ModEntities;
import ckhbox.villagebox.common.event.EventBow;
import ckhbox.villagebox.common.event.EventCoinsFound;
import ckhbox.villagebox.common.event.EventEntity;
import ckhbox.villagebox.common.event.EventWorld;
import ckhbox.villagebox.common.gui.GuiHandler;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.recipe.ModRecipes;
import ckhbox.villagebox.common.village.profession.Profession;
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
		NetworkRegistry.INSTANCE.registerGuiHandler(VillageBoxMod.instance, new GuiHandler());
		
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
