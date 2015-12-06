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
	public static final String KeyDataBuildingOwner		= "dbo";
	
	//village
	public static final String KeyDataVillageID			= "dvid";
	public static final String KeyDataVillageVillagerMapSize		= "dvvrs";
	public static final String KeyDataVillageBuildingMapSize 		= "dvbs";
	public static final String KeyDataVillageVillagerMapPrefix		= "dvvr_";
	public static final String KeyDataVillageBuildingMapPrefix 		= "dvb_";
	
	//dead villager
	public static final String KeyDataDeadVillagerList			= "ddvrl";
	public static final String KeyDataDeadVillagerName			= "ddvrn";
	public static final String KeyDataDeadVillagerBuildingID	= "ddvrbid";
	public static final String KeyDataDeadVillagerProfessionID	= "ddvrpid";
	public static final String KeyDataDeadVillagerInitX			= "ddvrix";
	public static final String KeyDataDeadVillagerInitY			= "ddvriy";
	public static final String KeyDataDeadVillagerInitZ			= "ddvriz";
	public static final String KeyDataDeadVillagerExp			= "ddvre";
	public static final String KeyDataDeadVillagerTimer			= "ddvrt";
	
	//id
	public static final String KeyDataIDLastVillage		= "didlv";
	public static final String KeyDataIDLastBuilding	= "didlb";
	
	//village bento (main)
	public static final String KeyDataVillageBentoMapStorage		= "vbdata";
	public static final String KeyDataVillageBentoVillageMapSize	= "dvbvs";
	public static final String KeyDataVillageBentoVillageMapPrefix	= "dvbv_";
	public static final String KeyDataVillageBentoIDs				= "dvbids";
	
	//villager entity
	public static final String KeyVillagerSleeping					= "vrs";
	public static final String KeyVillagerProfessionID				= "vrpid";
	public static final String KeyVillagerBuildingID				= "vrbid";
	public static final String KeyVillagerExp						= "vre";
	public static final String KeyVillagerInitX						= "vrix";
	public static final String KeyVillagerInitY						= "vriy";
	public static final String KeyVillagerInitZ						= "vriz";
	public static final String KeyVillagerVisitingBuildingID	= "vrvbid";
	public static final String KeyVillagerVisitingSkipSleep	= "vrvss";
	
	//villager component
	public static final String KeyVillagerComps						= "vc";
	
	//villager components item list
	public static final String KeyVillagerCompItemList				= "vcil";
	
	//villager component work
	public static final String KeyVillagerCompWorkCurrentIdxList	= "vcwcl";
	public static final String KeyVillagerCompWorkPlayerName		= "vcwpn";
	public static final String KeyVillagerCompWorkWorkIdx			= "vcwwi";
	public static final String KeyVillagerCompWorkHoursLeft			= "vcwhl";
	public static final String KeyVillagerCompWorkOutput			= "vcwo";
	
	//villager component quest
	public static final String KeyVillagerCompQuestLastQuestID		= "vcqlqid";
	public static final String KeyVillagerCompQuestListCurrent		= "vcqlc";
	public static final String KeyVillagerCompQuestQuestID			= "vcqqid";
	public static final String KeyVillagerCompQuestTitle			= "vcqt";
	public static final String KeyVillagerCompQuestDescription		= "vcqd";
	public static final String KeyVillagerCompQuestNeed				= "vcqn";
	public static final String KeyVillagerCompQuestReward			= "vcqr";
	public static final String KeyVillagerCompQuestTimeLeft			= "vcqtl";
	
	//villager component action
	public static final String KeyVillagerCompActionCurrentIdxList	= "vcacl";
	
	//village animal entity
	public static final String KeyAnimalHunger						= "vah";
	public static final String KeyAnimalState						= "vas";
	public static final String KeyAnimalProducts					= "vap";
	public static final String KeyAnimalProductTimer				= "vapt";
	public static final String KeyAnimalLove						= "val";
	
	//tile entity crops
	public static final String KeyCropsGrowingTimer					= "cgt";
	public static final String KeyCropsUpdateTimer					= "cut";
}
