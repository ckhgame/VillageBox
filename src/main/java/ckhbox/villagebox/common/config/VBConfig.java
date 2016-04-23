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
	public static boolean freeUpgrading;				//set to ture when you want nothing be cunsumed on upgrading villagers
	public static int reviveTicks;						//how many ticks to revive a villager
	public static boolean oneVillagerPerRoom;			//don't allow more than one villagers live in the same room
	
	public static void load(File file){
		Configuration conf = new Configuration(file, VillageBoxMod.VERSION);
		Property pt = null;
		
		conf.load();
		
		//profession ban list
		pt = conf.get(Configuration.CATEGORY_GENERAL, "BannedProIDList", new int[0]);
		pt.comment = "Banned profession IDs. One id per line, empty means no banned professions";
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
		
		//villager revive ticks
		pt = conf.get(Configuration.CATEGORY_GENERAL, "ReviveTicks", 24000);
		pt.comment = "How many ticks until a dead villager revives again";
		reviveTicks = pt.getInt();
		
		//free upgrading
		pt = conf.get(Configuration.CATEGORY_GENERAL, "FreeUpgrading", false);
		pt.comment = "Set to true when you want nothing be consumed on upgrading villagers";
		freeUpgrading = pt.getBoolean();
		
		//one villager one room
		pt = conf.get(Configuration.CATEGORY_GENERAL, "OneVillagerPerRoom", false);
		pt.comment = "Set to true to disallow more than one villagers live in the same room";
		oneVillagerPerRoom = pt.getBoolean();
		
		conf.save();
	}
}
