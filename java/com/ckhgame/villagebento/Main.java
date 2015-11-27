package com.ckhgame.villagebento;

import com.ckhgame.villagebento.data.DataVillageBento;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerAboutToStartEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

    public static final String MODID = "VillageBento";
    public static final String MODNAME = "Village Bento";
    public static final String VERSION = "0.0.1";
        
    @Instance
    public static Main instance = new Main();
    
     
    @SidedProxy(clientSide="com.ckhgame.villagebento.ClientProxy", 
    			serverSide="com.ckhgame.villagebento.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
    
    @EventHandler
	public void onServerAboutToStart(FMLServerAboutToStartEvent event) {
		DataVillageBento.resetInstance();	 
	}
}
