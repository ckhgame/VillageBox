package ckhbox.villagebox.client;

import ckhbox.villagebox.client.renderer.ModBlockRenderers;
import ckhbox.villagebox.client.renderer.ModEntityRenderers;
import ckhbox.villagebox.client.renderer.ModItemRenderers;
import ckhbox.villagebox.common.CommonProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		ModEntityRenderers.init();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
		ModBlockRenderers.init();
		ModItemRenderers.init();
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
	
}

