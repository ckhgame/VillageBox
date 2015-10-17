package com.ckhgame.villagebento;

import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.rendering.ModRenderers;
import com.ckhgame.villagebento.rendering.VillageOutlines;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        
        ModRenderers.init();
       
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        
        MinecraftForge.EVENT_BUS.register(VillageOutlines.getInstance());
        
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);        
        

    }

}
