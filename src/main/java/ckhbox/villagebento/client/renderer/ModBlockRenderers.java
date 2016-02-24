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
		registerModel(ModBlocks.alchemyPot, 0, "alchemypot");
		registerModel(ModBlocks.buildboxSmall, 0, "buildbox_small");
		registerModel(ModBlocks.buildboxMedium, 0, "buildbox_medium");
		registerModel(ModBlocks.buildboxLarge, 0, "buildbox_large");
		registerModel(ModBlocks.buildboxExLarge, 0, "buildbox_exlarge");
		
		registerModel(ModBlocks.solidWood, 0, "solid_wood");
		
		registerModel(ModBlocks.tableOak, 0, "table_oak");
		registerModel(ModBlocks.tableJungle, 0, "table_jungle");
		registerModel(ModBlocks.tableBirch, 0, "table_birch");
		registerModel(ModBlocks.tableSpruce, 0, "table_spruce");
		registerModel(ModBlocks.tableAcacia, 0, "table_acacia");
		registerModel(ModBlocks.tableDarkOak, 0, "table_big_oak");
		
		registerModel(ModBlocks.chairOak, 0, "chair_oak");
		registerModel(ModBlocks.chairJungle, 0, "chair_jungle");
		registerModel(ModBlocks.chairBirch, 0, "chair_birch");
		registerModel(ModBlocks.chairSpruce, 0, "chair_spruce");
		registerModel(ModBlocks.chairAcacia, 0, "chair_acacia");
		registerModel(ModBlocks.chairDarkOak, 0, "chair_big_oak");
		
		registerModel(ModBlocks.carpet0, 0, "carpet_0");
		registerModel(ModBlocks.carpet1, 0, "carpet_1");
		registerModel(ModBlocks.carpet2, 0, "carpet_2");
		registerModel(ModBlocks.carpet3, 0, "carpet_3");
		registerModel(ModBlocks.carpet4, 0, "carpet_4");
		registerModel(ModBlocks.carpet5, 0, "carpet_5");
		registerModel(ModBlocks.carpet6, 0, "carpet_6");
		registerModel(ModBlocks.carpet7, 0, "carpet_7");
		registerModel(ModBlocks.carpet8, 0, "carpet_8");
		registerModel(ModBlocks.carpet9, 0, "carpet_9");
		registerModel(ModBlocks.carpet10, 0, "carpet_10");
		registerModel(ModBlocks.carpet11, 0, "carpet_11");
		registerModel(ModBlocks.carpet12, 0, "carpet_12");
		registerModel(ModBlocks.carpet13, 0, "carpet_13");
		registerModel(ModBlocks.carpet14, 0, "carpet_14");
		registerModel(ModBlocks.carpet15, 0, "carpet_15");
		registerModel(ModBlocks.carpet16, 0, "carpet_16");
		registerModel(ModBlocks.carpet17, 0, "carpet_17");
		registerModel(ModBlocks.carpet18, 0, "carpet_18");
		registerModel(ModBlocks.carpet19, 0, "carpet_19");
		registerModel(ModBlocks.carpet20, 0, "carpet_20");
		registerModel(ModBlocks.carpet21, 0, "carpet_21");
		registerModel(ModBlocks.carpet22, 0, "carpet_22");
		registerModel(ModBlocks.carpet23, 0, "carpet_23");
		registerModel(ModBlocks.carpet24, 0, "carpet_24");
		registerModel(ModBlocks.carpet25, 0, "carpet_25");
		registerModel(ModBlocks.carpet26, 0, "carpet_26");
		registerModel(ModBlocks.carpet27, 0, "carpet_27");
		registerModel(ModBlocks.carpet28, 0, "carpet_28");
		registerModel(ModBlocks.carpet29, 0, "carpet_29");
		registerModel(ModBlocks.carpet30, 0, "carpet_30");
		registerModel(ModBlocks.carpet31, 0, "carpet_31");
		registerModel(ModBlocks.carpetWool0, 0, "carpet_wool_0");
		registerModel(ModBlocks.carpetWool1, 0, "carpet_wool_1");
		registerModel(ModBlocks.carpetWool2, 0, "carpet_wool_2");
		registerModel(ModBlocks.carpetWool3, 0, "carpet_wool_3");
		registerModel(ModBlocks.carpetWool4, 0, "carpet_wool_4");
		registerModel(ModBlocks.carpetWool5, 0, "carpet_wool_5");
		registerModel(ModBlocks.carpetWool6, 0, "carpet_wool_6");
		registerModel(ModBlocks.carpetWool7, 0, "carpet_wool_7");
		registerModel(ModBlocks.carpetWool8, 0, "carpet_wool_8");
		registerModel(ModBlocks.carpetWool9, 0, "carpet_wool_9");
		registerModel(ModBlocks.carpetWool10, 0, "carpet_wool_10");
		registerModel(ModBlocks.carpetWool11, 0, "carpet_wool_11");
		registerModel(ModBlocks.carpetWool12, 0, "carpet_wool_12");
		registerModel(ModBlocks.carpetWool13, 0, "carpet_wool_13");
		registerModel(ModBlocks.carpetWool14, 0, "carpet_wool_14");
		registerModel(ModBlocks.carpetWool15, 0, "carpet_wool_15");
	}
	
	private static void registerModel(Block block, int meta, String resource){
		registerModel(Item.getItemFromBlock(block), meta, resource);
	}
	
	private static void registerModel(Item item, int meta, String resource){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, meta, new ModelResourceLocation(PathHelper.full(resource), "inventory"));
	}
}
