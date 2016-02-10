package ckhbox.villagebento.client.renderer;

import ckhbox.villagebento.client.renderer.villager.RenderFactoryVillager;
import ckhbox.villagebento.common.block.ModBlocks;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModBlockRenderers {
	public static void init(){
		registerModel(ModBlocks.mailbox, 0, "mailbox");
	}
	
	private static void registerModel(Block block, int meta, String resource){
		registerModel(Item.getItemFromBlock(block), meta, resource);
	}
	
	private static void registerModel(Item item, int meta, String resource){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, meta, new ModelResourceLocation(PathHelper.full(resource), "inventory"));
	}
}
