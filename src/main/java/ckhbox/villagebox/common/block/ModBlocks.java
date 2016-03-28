package ckhbox.villagebox.common.block;

import ckhbox.villagebox.common.block.decoration.BlockCarpet;
import ckhbox.villagebox.common.block.decoration.BlockChair;
import ckhbox.villagebox.common.block.decoration.BlockFlowerInPot;
import ckhbox.villagebox.common.block.decoration.BlockTable;
import ckhbox.villagebox.common.block.tool.BlockAlchemyPot;
import ckhbox.villagebox.common.block.tool.BlockBuildBox;
import ckhbox.villagebox.common.block.tool.BlockMagicTrashCan;
import ckhbox.villagebox.common.block.tool.BlockMailBox;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockMailBox mailbox;
	//public static BlockAlchemyPot alchemyPot;
	public static BlockMagicTrashCan magicTrashCan;
	
	public static BlockBuildBox buildboxSmall;
	public static BlockBuildBox buildboxMedium;
	public static BlockBuildBox buildboxLarge;
	public static BlockBuildBox buildboxExLarge;
	
	public static BlockTable tableOak;
	public static BlockTable tableJungle;
	public static BlockTable tableBirch;
	public static BlockTable tableSpruce;
	public static BlockTable tableAcacia;
	public static BlockTable tableDarkOak;

	public static BlockChair chairOak;
	public static BlockChair chairJungle;
	public static BlockChair chairBirch;
	public static BlockChair chairSpruce;
	public static BlockChair chairAcacia;
	public static BlockChair chairDarkOak;
	
	public static BlockCarpet carpet0;
	public static BlockCarpet carpet1;
	public static BlockCarpet carpet2;
	public static BlockCarpet carpet3;
	public static BlockCarpet carpet4;
	public static BlockCarpet carpet5;
	public static BlockCarpet carpet6;
	public static BlockCarpet carpet7;
	public static BlockCarpet carpet8;
	public static BlockCarpet carpet9;
	public static BlockCarpet carpet10;
	public static BlockCarpet carpet11;
	public static BlockCarpet carpet12;
	public static BlockCarpet carpet13;
	public static BlockCarpet carpet14;
	public static BlockCarpet carpet15;
	public static BlockCarpet carpet16;
	public static BlockCarpet carpet17;
	public static BlockCarpet carpet18;
	public static BlockCarpet carpet19;
	public static BlockCarpet carpet20;
	public static BlockCarpet carpet21;
	public static BlockCarpet carpet22;
	public static BlockCarpet carpet23;
	public static BlockCarpet carpet24;
	public static BlockCarpet carpet25;
	public static BlockCarpet carpet26;
	public static BlockCarpet carpet27;
	public static BlockCarpet carpet28;
	public static BlockCarpet carpet29;
	public static BlockCarpet carpet30;
	public static BlockCarpet carpet31;
	public static BlockCarpet carpetWool0;
	public static BlockCarpet carpetWool1;
	public static BlockCarpet carpetWool2;
	public static BlockCarpet carpetWool3;
	public static BlockCarpet carpetWool4;
	public static BlockCarpet carpetWool5;
	public static BlockCarpet carpetWool6;
	public static BlockCarpet carpetWool7;
	public static BlockCarpet carpetWool8;
	public static BlockCarpet carpetWool9;
	public static BlockCarpet carpetWool10;
	public static BlockCarpet carpetWool11;
	public static BlockCarpet carpetWool12;
	public static BlockCarpet carpetWool13;
	public static BlockCarpet carpetWool14;
	public static BlockCarpet carpetWool15;
	
	//flower
	public static BlockFlowerInPot flowerRedRose;
	public static BlockFlowerInPot flowerHeartMushroom;
	public static BlockFlowerInPot flowerHydrangeas;
	public static BlockFlowerInPot flowerPlumBlossom;
	public static BlockFlowerInPot flowerRanunculus;
	public static BlockFlowerInPot flowerRosySpiraea;
	public static BlockFlowerInPot flowerGardenia;
	public static BlockFlowerInPot bonsai;
	
	public static void init(){
		GameRegistry.registerBlock(mailbox=new BlockMailBox(),"mailbox");
		//GameRegistry.registerBlock(alchemyPot=new BlockAlchemyPot(),"alchemypot");
		GameRegistry.registerBlock(magicTrashCan=new BlockMagicTrashCan(),"magic_trash_can");
		
		GameRegistry.registerBlock(buildboxSmall=new BlockBuildBox(BlockBuildBox.BuildSize.Small),"buildbox_small");
		GameRegistry.registerBlock(buildboxMedium=new BlockBuildBox(BlockBuildBox.BuildSize.Medium),"buildbox_medium");
		GameRegistry.registerBlock(buildboxLarge=new BlockBuildBox(BlockBuildBox.BuildSize.Large),"buildbox_large");
		GameRegistry.registerBlock(buildboxExLarge=new BlockBuildBox(BlockBuildBox.BuildSize.ExLarge),"buildbox_exlarge");
		
		//tables
		GameRegistry.registerBlock(tableOak=new BlockTable("tableOak"),"table_oak");
		GameRegistry.registerBlock(tableJungle=new BlockTable("tableJungle"),"table_jungle");
		GameRegistry.registerBlock(tableBirch=new BlockTable("tableBirch"),"table_birch");
		GameRegistry.registerBlock(tableSpruce=new BlockTable("tableSpruce"),"table_spruce");
		GameRegistry.registerBlock(tableAcacia=new BlockTable("tableAcacia"),"table_acacia");
		GameRegistry.registerBlock(tableDarkOak=new BlockTable("tableBigOak"),"table_big_oak");
		
		//chairs
		GameRegistry.registerBlock(chairOak=new BlockChair("chairOak"),"chair_oak");
		GameRegistry.registerBlock(chairJungle=new BlockChair("chairJungle"),"chair_jungle");
		GameRegistry.registerBlock(chairBirch=new BlockChair("chairBirch"),"chair_birch");
		GameRegistry.registerBlock(chairSpruce=new BlockChair("chairSpruce"),"chair_spruce");
		GameRegistry.registerBlock(chairAcacia=new BlockChair("chairAcacia"),"chair_acacia");
		GameRegistry.registerBlock(chairDarkOak=new BlockChair("chairBigOak"),"chair_big_oak");
		
		//carpets
		GameRegistry.registerBlock(carpet0=new BlockCarpet("carpet0"),"carpet_0");
		GameRegistry.registerBlock(carpet1=new BlockCarpet("carpet1"),"carpet_1");
		GameRegistry.registerBlock(carpet2=new BlockCarpet("carpet2"),"carpet_2");
		GameRegistry.registerBlock(carpet3=new BlockCarpet("carpet3"),"carpet_3");
		GameRegistry.registerBlock(carpet4=new BlockCarpet("carpet4"),"carpet_4");
		GameRegistry.registerBlock(carpet5=new BlockCarpet("carpet5"),"carpet_5");
		GameRegistry.registerBlock(carpet6=new BlockCarpet("carpet6"),"carpet_6");
		GameRegistry.registerBlock(carpet7=new BlockCarpet("carpet7"),"carpet_7");
		GameRegistry.registerBlock(carpet8=new BlockCarpet("carpet8"),"carpet_8");
		GameRegistry.registerBlock(carpet9=new BlockCarpet("carpet9"),"carpet_9");
		GameRegistry.registerBlock(carpet10=new BlockCarpet("carpet10"),"carpet_10");
		GameRegistry.registerBlock(carpet11=new BlockCarpet("carpet11"),"carpet_11");
		GameRegistry.registerBlock(carpet12=new BlockCarpet("carpet12"),"carpet_12");
		GameRegistry.registerBlock(carpet13=new BlockCarpet("carpet13"),"carpet_13");
		GameRegistry.registerBlock(carpet14=new BlockCarpet("carpet14"),"carpet_14");
		GameRegistry.registerBlock(carpet15=new BlockCarpet("carpet15"),"carpet_15");
		GameRegistry.registerBlock(carpet16=new BlockCarpet("carpet16"),"carpet_16");
		GameRegistry.registerBlock(carpet17=new BlockCarpet("carpet17"),"carpet_17");
		GameRegistry.registerBlock(carpet18=new BlockCarpet("carpet18"),"carpet_18");
		GameRegistry.registerBlock(carpet19=new BlockCarpet("carpet19"),"carpet_19");
		GameRegistry.registerBlock(carpet20=new BlockCarpet("carpet20"),"carpet_20");
		GameRegistry.registerBlock(carpet21=new BlockCarpet("carpet21"),"carpet_21");
		GameRegistry.registerBlock(carpet22=new BlockCarpet("carpet22"),"carpet_22");
		GameRegistry.registerBlock(carpet23=new BlockCarpet("carpet23"),"carpet_23");
		GameRegistry.registerBlock(carpet24=new BlockCarpet("carpet24"),"carpet_24");
		GameRegistry.registerBlock(carpet25=new BlockCarpet("carpet25"),"carpet_25");
		GameRegistry.registerBlock(carpet26=new BlockCarpet("carpet26"),"carpet_26");
		GameRegistry.registerBlock(carpet27=new BlockCarpet("carpet27"),"carpet_27");
		GameRegistry.registerBlock(carpet28=new BlockCarpet("carpet28"),"carpet_28");
		GameRegistry.registerBlock(carpet29=new BlockCarpet("carpet29"),"carpet_29");
		GameRegistry.registerBlock(carpet30=new BlockCarpet("carpet30"),"carpet_30");
		GameRegistry.registerBlock(carpet31=new BlockCarpet("carpet31"),"carpet_31");
		GameRegistry.registerBlock(carpetWool0=new BlockCarpet("carpetWool0"),"carpet_wool_0");
		GameRegistry.registerBlock(carpetWool1=new BlockCarpet("carpetWool1"),"carpet_wool_1");
		GameRegistry.registerBlock(carpetWool2=new BlockCarpet("carpetWool2"),"carpet_wool_2");
		GameRegistry.registerBlock(carpetWool3=new BlockCarpet("carpetWool3"),"carpet_wool_3");
		GameRegistry.registerBlock(carpetWool4=new BlockCarpet("carpetWool4"),"carpet_wool_4");
		GameRegistry.registerBlock(carpetWool5=new BlockCarpet("carpetWool5"),"carpet_wool_5");
		GameRegistry.registerBlock(carpetWool6=new BlockCarpet("carpetWool6"),"carpet_wool_6");
		GameRegistry.registerBlock(carpetWool7=new BlockCarpet("carpetWool7"),"carpet_wool_7");
		GameRegistry.registerBlock(carpetWool8=new BlockCarpet("carpetWool8"),"carpet_wool_8");
		GameRegistry.registerBlock(carpetWool9=new BlockCarpet("carpetWool9"),"carpet_wool_9");
		GameRegistry.registerBlock(carpetWool10=new BlockCarpet("carpetWool10"),"carpet_wool_10");
		GameRegistry.registerBlock(carpetWool11=new BlockCarpet("carpetWool11"),"carpet_wool_11");
		GameRegistry.registerBlock(carpetWool12=new BlockCarpet("carpetWool12"),"carpet_wool_12");
		GameRegistry.registerBlock(carpetWool13=new BlockCarpet("carpetWool13"),"carpet_wool_13");
		GameRegistry.registerBlock(carpetWool14=new BlockCarpet("carpetWool14"),"carpet_wool_14");
		GameRegistry.registerBlock(carpetWool15=new BlockCarpet("carpetWool15"),"carpet_wool_15");
		
		GameRegistry.registerBlock(flowerGardenia=new BlockFlowerInPot("flowerGardenia"),"flower_gardenia");
		GameRegistry.registerBlock(flowerHeartMushroom=new BlockFlowerInPot("flowerHeartMushroom"),"flower_heartmushroom");
		GameRegistry.registerBlock(flowerRanunculus=new BlockFlowerInPot("flowerRanunculus"),"flower_ranunculus");
		GameRegistry.registerBlock(flowerRedRose=new BlockFlowerInPot("flowerRedRose"),"flower_redrose");
		GameRegistry.registerBlock(flowerRosySpiraea=new BlockFlowerInPot("flowerRosySpiraea"),"flower_rosyspiraea");
		GameRegistry.registerBlock(flowerPlumBlossom=new BlockFlowerInPot("flowerPlumBlossom"),"flower_plumblossom");
		GameRegistry.registerBlock(flowerHydrangeas=new BlockFlowerInPot("flowerHydrangeas"),"flower_hydrangeas");
		GameRegistry.registerBlock(bonsai=new BlockFlowerInPot("bonsai"),"bonsai");
	}
}
