package ckhbox.villagebox.common.block;

import ckhbox.villagebox.VillageBoxMod;
import ckhbox.villagebox.common.block.decoration.BlockBench;
import ckhbox.villagebox.common.block.decoration.BlockCarpet;
import ckhbox.villagebox.common.block.decoration.BlockChair;
import ckhbox.villagebox.common.block.decoration.BlockFlowerInPot;
import ckhbox.villagebox.common.block.decoration.BlockTable;
import ckhbox.villagebox.common.block.tool.BlockBuildBox;
import ckhbox.villagebox.common.block.tool.BlockMailBox;
import ckhbox.villagebox.common.block.totem.BlockTotem;
import ckhbox.villagebox.common.block.totem.BlockTotemPole;
import ckhbox.villagebox.common.item.totem.ItemBlockWithInfo;
import ckhbox.villagebox.common.tileentity.totem.TileEntityFireTotem;
import ckhbox.villagebox.common.tileentity.totem.TileEntityNatureTotem;
import ckhbox.villagebox.common.tileentity.totem.TileEntityWaterTotem;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {
	
	public static BlockMailBox mailbox;
	//public static BlockAlchemyPot alchemyPot;
	//public static BlockMagicTrashCan magicTrashCan;
	
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
	
	public static BlockBench benchOak;
	public static BlockBench benchJungle;
	public static BlockBench benchBirch;
	public static BlockBench benchSpruce;
	public static BlockBench benchAcacia;
	public static BlockBench benchDarkOak;
	
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
	
	//totems
	public static BlockTotem fireTotem;
	public static BlockTotem waterTotem;
	public static BlockTotem natureTotem;
	public static BlockTotemPole totempole0;
	public static BlockTotemPole totempole1;
	public static BlockTotemPole totempole2;
	
	public static void init(){
		register(mailbox=new BlockMailBox(),"mailbox");
		//register(alchemyPot=new BlockAlchemyPot(),"alchemypot");
		//register(magicTrashCan=new BlockMagicTrashCan(),"magic_trash_can");
		
		register(buildboxSmall=new BlockBuildBox(BlockBuildBox.BuildSize.Small),"buildbox_small");
		register(buildboxMedium=new BlockBuildBox(BlockBuildBox.BuildSize.Medium),"buildbox_medium");
		register(buildboxLarge=new BlockBuildBox(BlockBuildBox.BuildSize.Large),"buildbox_large");
		register(buildboxExLarge=new BlockBuildBox(BlockBuildBox.BuildSize.ExLarge),"buildbox_exlarge");
		
		//tables
		register(tableOak=new BlockTable("tableOak"),"table_oak");
		register(tableJungle=new BlockTable("tableJungle"),"table_jungle");
		register(tableBirch=new BlockTable("tableBirch"),"table_birch");
		register(tableSpruce=new BlockTable("tableSpruce"),"table_spruce");
		register(tableAcacia=new BlockTable("tableAcacia"),"table_acacia");
		register(tableDarkOak=new BlockTable("tableBigOak"),"table_big_oak");
		
		//chairs
		register(chairOak=new BlockChair("chairOak"),"chair_oak");
		register(chairJungle=new BlockChair("chairJungle"),"chair_jungle");
		register(chairBirch=new BlockChair("chairBirch"),"chair_birch");
		register(chairSpruce=new BlockChair("chairSpruce"),"chair_spruce");
		register(chairAcacia=new BlockChair("chairAcacia"),"chair_acacia");
		register(chairDarkOak=new BlockChair("chairBigOak"),"chair_big_oak");
		
		//benches
		register(benchOak=new BlockBench("benchOak"),"bench_oak");
		register(benchJungle=new BlockBench("benchJungle"),"bench_jungle");
		register(benchBirch=new BlockBench("benchBirch"),"bench_birch");
		register(benchSpruce=new BlockBench("benchSpruce"),"bench_spruce");
		register(benchAcacia=new BlockBench("benchAcacia"),"bench_acacia");
		register(benchDarkOak=new BlockBench("benchBigOak"),"bench_big_oak");
		
		//carpets
		register(carpet0=new BlockCarpet("carpet0"),"carpet_0");
		register(carpet1=new BlockCarpet("carpet1"),"carpet_1");
		register(carpet2=new BlockCarpet("carpet2"),"carpet_2");
		register(carpet3=new BlockCarpet("carpet3"),"carpet_3");
		register(carpet4=new BlockCarpet("carpet4"),"carpet_4");
		register(carpet5=new BlockCarpet("carpet5"),"carpet_5");
		register(carpet6=new BlockCarpet("carpet6"),"carpet_6");
		register(carpet7=new BlockCarpet("carpet7"),"carpet_7");
		register(carpet8=new BlockCarpet("carpet8"),"carpet_8");
		register(carpet9=new BlockCarpet("carpet9"),"carpet_9");
		register(carpet10=new BlockCarpet("carpet10"),"carpet_10");
		register(carpet11=new BlockCarpet("carpet11"),"carpet_11");
		register(carpet12=new BlockCarpet("carpet12"),"carpet_12");
		register(carpet13=new BlockCarpet("carpet13"),"carpet_13");
		register(carpet14=new BlockCarpet("carpet14"),"carpet_14");
		register(carpet15=new BlockCarpet("carpet15"),"carpet_15");
		register(carpet16=new BlockCarpet("carpet16"),"carpet_16");
		register(carpet17=new BlockCarpet("carpet17"),"carpet_17");
		register(carpet18=new BlockCarpet("carpet18"),"carpet_18");
		register(carpet19=new BlockCarpet("carpet19"),"carpet_19");
		register(carpet20=new BlockCarpet("carpet20"),"carpet_20");
		register(carpet21=new BlockCarpet("carpet21"),"carpet_21");
		register(carpet22=new BlockCarpet("carpet22"),"carpet_22");
		register(carpet23=new BlockCarpet("carpet23"),"carpet_23");
		register(carpet24=new BlockCarpet("carpet24"),"carpet_24");
		register(carpet25=new BlockCarpet("carpet25"),"carpet_25");
		register(carpet26=new BlockCarpet("carpet26"),"carpet_26");
		register(carpet27=new BlockCarpet("carpet27"),"carpet_27");
		register(carpet28=new BlockCarpet("carpet28"),"carpet_28");
		register(carpet29=new BlockCarpet("carpet29"),"carpet_29");
		register(carpet30=new BlockCarpet("carpet30"),"carpet_30");
		register(carpet31=new BlockCarpet("carpet31"),"carpet_31");
		register(carpetWool0=new BlockCarpet("carpetWool0"),"carpet_wool_0");
		register(carpetWool1=new BlockCarpet("carpetWool1"),"carpet_wool_1");
		register(carpetWool2=new BlockCarpet("carpetWool2"),"carpet_wool_2");
		register(carpetWool3=new BlockCarpet("carpetWool3"),"carpet_wool_3");
		register(carpetWool4=new BlockCarpet("carpetWool4"),"carpet_wool_4");
		register(carpetWool5=new BlockCarpet("carpetWool5"),"carpet_wool_5");
		register(carpetWool6=new BlockCarpet("carpetWool6"),"carpet_wool_6");
		register(carpetWool7=new BlockCarpet("carpetWool7"),"carpet_wool_7");
		register(carpetWool8=new BlockCarpet("carpetWool8"),"carpet_wool_8");
		register(carpetWool9=new BlockCarpet("carpetWool9"),"carpet_wool_9");
		register(carpetWool10=new BlockCarpet("carpetWool10"),"carpet_wool_10");
		register(carpetWool11=new BlockCarpet("carpetWool11"),"carpet_wool_11");
		register(carpetWool12=new BlockCarpet("carpetWool12"),"carpet_wool_12");
		register(carpetWool13=new BlockCarpet("carpetWool13"),"carpet_wool_13");
		register(carpetWool14=new BlockCarpet("carpetWool14"),"carpet_wool_14");
		register(carpetWool15=new BlockCarpet("carpetWool15"),"carpet_wool_15");
		
		register(flowerGardenia=new BlockFlowerInPot("flowerGardenia"),"flower_gardenia");
		register(flowerHeartMushroom=new BlockFlowerInPot("flowerHeartMushroom"),"flower_heartmushroom");
		register(flowerRanunculus=new BlockFlowerInPot("flowerRanunculus"),"flower_ranunculus");
		register(flowerRedRose=new BlockFlowerInPot("flowerRedRose"),"flower_redrose");
		register(flowerRosySpiraea=new BlockFlowerInPot("flowerRosySpiraea"),"flower_rosyspiraea");
		register(flowerPlumBlossom=new BlockFlowerInPot("flowerPlumBlossom"),"flower_plumblossom");
		register(flowerHydrangeas=new BlockFlowerInPot("flowerHydrangeas"),"flower_hydrangeas");
		register(bonsai=new BlockFlowerInPot("bonsai"),"bonsai");
		
		register(fireTotem=new BlockTotem("fireTotem", TileEntityFireTotem.class), "fire_totem", new ItemBlockWithInfo(fireTotem));
		register(waterTotem=new BlockTotem("waterTotem",TileEntityWaterTotem.class), "water_totem", new ItemBlockWithInfo(waterTotem));
		register(natureTotem=new BlockTotem("natureTotem",TileEntityNatureTotem.class), "nature_totem", new ItemBlockWithInfo(natureTotem));
		register(totempole0=new BlockTotemPole("totempole0"), "totempole_0", new ItemBlockWithInfo(totempole0));
		register(totempole1=new BlockTotemPole("totempole1"), "totempole_1", new ItemBlockWithInfo(totempole1));
		register(totempole2=new BlockTotemPole("totempole2"), "totempole_2", new ItemBlockWithInfo(totempole2));
	}
	
	public static void register(Block block, String name){
		register(block, name, new ItemBlock(block));
	}
	
	public static void register(Block block, String name, ItemBlock item){
		GameRegistry.register(block,new ResourceLocation(VillageBoxMod.MODID,name));
		GameRegistry.register(item, new ResourceLocation(VillageBoxMod.MODID,name));
	}
}
