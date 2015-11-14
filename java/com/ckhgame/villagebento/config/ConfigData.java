package com.ckhgame.villagebento.config;

public class ConfigData {
	//building
	public static final String KeyDataBuildingID 		= "dbid";
	public static final String KeyDataBuildingX 		= "dbx";
	public static final String KeyDataBuildingY 		= "dby";
	public static final String KeyDataBuildingZ 		= "dbz";
	public static final String KeyDataBuildingSizeX 	= "dbsx";
	public static final String KeyDataBuildingSizeZ 	= "dbsz";
	public static final String KeyDataBuildingType 		= "dbt";
	
	//villager
	public static final String KeyDataVillagerID		= "dvrid";
	public static final String KeyDataVillagerName		= "dvrn";
	public static final String KeyDataVillagerProfession= "dvrp";
	public static final String KeyDataVillagerBuildingID= "dvrbid";
	public static final String KeyDataVillagerDeath		= "dvrd";
	public static final String KeyDataVillagerLevel		= "dvrl";
	public static final String KeyDataVillagerExp		= "dvre";
	public static final String KeyDataVillagerInitX		= "dvrix";
	public static final String KeyDataVillagerInitZ		= "dvriz";
	
	//village
	public static final String KeyDataVillageID			= "dvid";
	public static final String KeyDataVillageVillagerMapSize		= "dvvrs";
	public static final String KeyDataVillageBuildingMapSize 		= "dvbs";
	public static final String KeyDataVillageVillagerMapPrefix		= "dvvr_";
	public static final String KeyDataVillageBuildingMapPrefix 		= "dvb_";
	
	//id
	public static final String KeyDataIDLastVillage		= "didlv";
	public static final String KeyDataIDLastVillager	= "didlvr";
	public static final String KeyDataIDLastBuilding	= "didlb";
	
	//village bento (main)
	public static final String KeyDataVillageBentoMapStorage		= "vbdata";
	public static final String KeyDataVillageBentoVillageMapSize	= "dvbvs";
	public static final String KeyDataVillageBentoVillageMapPrefix	= "dvbv_";
	public static final String KeyDataVillageBentoIDs				= "dvbids";
	
	//villager entity
	public static final String KeyVillagerEntityDataVillagerID		= "vedvid";
	public static final String KeyVillagerEntityIsSleeping			= "veis";
	
	//villager component
	public static final String KeyVillagerComps						= "vc";
	
	//villager component buy
	public static final String KeyVillagerCompBuy					= "vcb";
	public static final String KeyVillagerCompBuyItemStackList		= "vcbisl";
	
	//villager component sell
	public static final String KeyVillagerCompSell					= "vcs";
	public static final String KeyVillagerCompSellItemStackList		= "vcsisl";
	
	//villager component work
	public static final String KeyVillagerCompWork					= "vcw";
	public static final String KeyVillagerCompWorkPlayerName		= "vcwpn";
	public static final String KeyVillagerCompWorkWorkIdx			= "vcwwi";
	public static final String KeyVillagerCompWorkHoursLeft			= "vcwhl";
	public static final String KeyVillagerCompWorkOutput			= "vcwo";
}
