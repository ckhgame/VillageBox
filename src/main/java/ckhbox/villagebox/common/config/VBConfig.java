package ckhbox.villagebox.common.config;

import java.io.File;

import ckhbox.villagebox.VillageBoxMod;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class VBConfig {
	//properties
	public static int[] proIDBanList;					//banned profession IDs
	public static boolean destroyBlocksDropCoins;		//ture: destroy blocks can drop coins
	public static boolean killMobsDropCoins;			//true: kill mobs can drop coins
	public static boolean displayExtraInfo;				//true: will display extra information in game like the profession id
	
	public static void load(File file){
		Configuration conf = new Configuration(file, VillageBoxMod.VERSION);
		Property pt = null;
		
		conf.load();
		
		//profession ban list
		pt = conf.get(Configuration.CATEGORY_GENERAL, "BannedProIDList", new int[0]);
		pt.comment = "Banned profession IDs. one id per line, empty means no banned profession";
		proIDBanList = pt.getIntList();
		
		//coin earning options
		pt = conf.get(Configuration.CATEGORY_GENERAL, "DestroyBlocksDropCoins", true);
		pt.comment = "Does destroying blocks drop coins?";
		destroyBlocksDropCoins = pt.getBoolean();
		
		pt = conf.get(Configuration.CATEGORY_GENERAL, "KillMobsDropCoins", true);
		pt.comment = "Does killing mobs drop coins?";
		killMobsDropCoins = pt.getBoolean();
		
		//display extra information
		pt = conf.get(Configuration.CATEGORY_GENERAL, "displayExtraInfo", false);
		pt.comment = "Set to true when you want to view extra information such as the profession id of a villager";
		displayExtraInfo = pt.getBoolean();
		
		conf.save();
	}
}
