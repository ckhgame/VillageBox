package ckhbox.villagebento;

import ckhbox.villagebento.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = VillageBentoMod.MODID, name = VillageBentoMod.MODNAME, version = VillageBentoMod.VERSION)
public class VillageBentoMod {

    public static final String MODID = "villagebento";
    public static final String MODNAME = "Village Bento";
    public static final String VERSION = "0.0.1";

    @Instance
    public static VillageBentoMod instance = new VillageBentoMod();

    @SidedProxy(clientSide="ckhbox.villagebento.client.ClientProxy", serverSide="ckhbox.villagebento.common.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
    	this.proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
    	this.proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
    	this.proxy.postInit(e);
    }
}
