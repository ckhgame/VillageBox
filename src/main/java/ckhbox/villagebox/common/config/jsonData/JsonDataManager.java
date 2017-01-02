package ckhbox.villagebox.common.config.jsonData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.GsonBuilder;

public class JsonDataManager {
	
	private static final String jsonDataFileName = "VillageBoxData.json";
	
	private static JsonVBData vbData;
	
	public static JsonVBData GetVBData()
	{
		return vbData;
	}
	
	public static void LoadData(File dir)
	{
		File file = new File(dir, jsonDataFileName);
		if(file.exists())
		{
			try {
				loadDataFromFile(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				createDefaultDataFile(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}		
	}
	
	private static void loadDataFromFile(File file) throws IOException
	{
		FileReader reader = new FileReader(file);		
		vbData = new GsonBuilder().setPrettyPrinting().create().fromJson(reader, JsonVBData.class);		
		reader.close();
	}
	
	private static void createDefaultDataFile(File file) throws IOException
	{
		//create default data
		vbData = createDefaultData();
		//save to file
		FileWriter writter = new FileWriter(file);
		String json = new GsonBuilder().setPrettyPrinting().create().toJson(vbData);
		System.out.println(json);
		writter.write(json);
		writter.close();
	}
	
	private static JsonVBData createDefaultData()
	{
		JsonVBData data = new JsonVBData();
		
		JsonProfession profession = null;
		
		//====== villager ======
		profession = new JsonProfession();
		profession.id = 0;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,apple,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,egg,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,bread,1,0"}, new String[]{"villagebox,bronze_coin,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"villagebox,bronze_coin,4,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"villagebox,bronze_coin,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"minecraft,apple,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"minecraft,apple,2,0"}));
		profession.upgradeProfessionIDs = new int[]{3, 25, 29, 21};
		profession.upgradeRequirements = new String[]{"minecraft,book,1,0"};
		profession.holdItems = new String[]{"minecraft,apple,1,0", "minecraft,egg,1,0"};
		profession.texture = "villager0";
		profession.name = "villager0";
		data.professions.add(profession);

		//====== villager ======
		profession = new JsonProfession();
		profession.id = 1;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,apple,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,egg,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,bread,1,0"}, new String[]{"villagebox,bronze_coin,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"villagebox,bronze_coin,4,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"villagebox,bronze_coin,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"minecraft,apple,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"minecraft,apple,2,0"}));
		profession.upgradeProfessionIDs = new int[]{3, 25, 29, 21};
		profession.upgradeRequirements = new String[]{"minecraft,book,1,0"};
		profession.holdItems = new String[]{"minecraft,apple,1,0", "minecraft,egg,1,0"};
		profession.texture = "villager1";
		profession.name = "villager1";
		data.professions.add(profession);

		//====== villager ======
		profession = new JsonProfession();
		profession.id = 2;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,apple,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,egg,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,bread,1,0"}, new String[]{"villagebox,bronze_coin,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"villagebox,bronze_coin,4,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"villagebox,bronze_coin,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"minecraft,apple,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"minecraft,apple,2,0"}));
		profession.upgradeProfessionIDs = new int[]{3, 25, 29, 21};
		profession.upgradeRequirements = new String[]{"minecraft,book,1,0"};
		profession.holdItems = new String[]{"minecraft,apple,1,0", "minecraft,egg,1,0"};
		profession.texture = "villager2";
		profession.name = "villager2";
		data.professions.add(profession);

		//====== peasant ======
		profession = new JsonProfession();
		profession.id = 3;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0"}, "minecraft,wheat,10,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0"}, "minecraft,carrot,3,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0"}, "minecraft,potato,3,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0"}, "minecraft,pumpkin,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,iron_hoe,1,0"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,wheat_seeds,16,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.upgradeProfessionIDs = new int[]{16, 18, 20, 15, 27, 26};
		profession.upgradeRequirements = new String[]{"villagebox,bronze_coin,20,0", "minecraft,iron_hoe,1,0"};
		profession.holdItems = new String[]{"minecraft,iron_hoe,1,0"};
		profession.texture = "peasant";
		profession.name = "peasant";
		data.professions.add(profession);

		//====== worker ======
		profession = new JsonProfession();
		profession.id = 25;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,16,0"}, "minecraft,iron_sword,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,15,0"}, "minecraft,iron_pickaxe,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,15,0"}, "minecraft,iron_axe,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "minecraft,iron_hoe,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "minecraft,iron_shovel,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,crafting_table,1,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.upgradeProfessionIDs = new int[]{32, 11, 8, 4, 14};
		profession.upgradeRequirements = new String[]{"villagebox,bronze_coin,25,0", "minecraft,crafting_table,1,0"};
		profession.holdItems = new String[]{"minecraft,crafting_table,1,0"};
		profession.texture = "worker";
		profession.name = "worker";
		data.professions.add(profession);

		//====== banker ======
		profession = new JsonProfession();
		profession.id = 29;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,64,0"}, "villagebox,silver_coin,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,64,0"}, "villagebox,gold_coin,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bronze_coin,64,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,gold_coin,1,0"}, "villagebox,silver_coin,64,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,diamond,1,0"}, new String[]{"villagebox,silver_coin,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,emerald,1,0"}, new String[]{"villagebox,silver_coin,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,diamond,1,0"}, new String[]{"minecraft,ender_pearl,1,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,bronze_coin,32,0"};
		profession.holdItems = new String[]{"villagebox,silver_coin,1,0", "villagebox,gold_coin,1,0"};
		profession.texture = "banker";
		profession.name = "banker";
		data.professions.add(profession);

		//====== scholar ======
		profession = new JsonProfession();
		profession.id = 21;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0"}, "minecraft,book,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,3,0"}, "minecraft,paper,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "minecraft,paper,1,0"}, "villagebox,reset_scroll,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,book,1,0"}, new String[]{"villagebox,bronze_coin,5,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,book,5,0"}, new String[]{"villagebox,reset_scroll,1,0"}));
		profession.upgradeProfessionIDs = new int[]{28, 24, 19};
		profession.upgradeRequirements = new String[]{"minecraft,book,1,0", "villagebox,silver_coin,1,0"};
		profession.holdItems = new String[]{"minecraft,book,1,0", "villagebox,reset_scroll,1,0"};
		profession.texture = "scholar";
		profession.name = "scholar";
		data.professions.add(profession);

		//====== carpenter ======
		profession = new JsonProfession();
		profession.id = 11;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0"}, "villagebox,wooden_helmet,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,30,0"}, "villagebox,wooden_chestplate,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,25,0"}, "villagebox,wooden_leggings,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0"}, "villagebox,wooden_boots,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,log,5,0", "villagebox,bronze_coin,2,0"}, "minecraft,planks,30,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,log,5,1", "villagebox,bronze_coin,2,0"}, "minecraft,planks,30,1"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,log,5,2", "villagebox,bronze_coin,2,0"}, "minecraft,planks,30,2"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,log,5,3", "villagebox,bronze_coin,2,0"}, "minecraft,planks,30,3"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,log2,5,0", "villagebox,bronze_coin,2,0"}, "minecraft,planks,30,4"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,log2,5,1", "villagebox,bronze_coin,2,0"}, "minecraft,planks,30,5"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,iron_axe,1,0"}, new String[]{"villagebox,wooden_chestplate,1,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,iron_axe,1,0"}, new String[]{"villagebox,bronze_coin,20,0"}));
		profession.upgradeProfessionIDs = new int[]{10, 17};
		profession.upgradeRequirements = new String[]{"minecraft,iron_axe,1,0", "villagebox,silver_coin,2,0"};
		profession.holdItems = new String[]{"minecraft,log,1,0"};
		profession.texture = "carpenter";
		profession.name = "carpenter";
		data.professions.add(profession);

		//====== carpetmaker ======
		profession = new JsonProfession();
		profession.id = 14;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_0,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_1,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_2,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_3,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_4,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_5,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_6,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_7,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_8,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_9,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_10,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_11,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_12,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_13,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_14,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,wool,1,0"}, "villagebox,carpet_wool_15,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,wool,6,0"}, new String[]{"villagebox,bronze_coin,20,0"}));
		profession.upgradeProfessionIDs = new int[]{12, 13};
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,2,0", "minecraft,wool,16,0"};
		profession.holdItems = new String[]{"minecraft,wool,1,0"};
		profession.texture = "carpetmaker";
		profession.name = "carpetmaker";
		data.professions.add(profession);

		//====== builder ======
		profession = new JsonProfession();
		profession.id = 32;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,buildbox_small,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,buildbox_medium,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,4,0"}, "villagebox,buildbox_large,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,6,0"}, "villagebox,buildbox_exlarge,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,0"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cobblestone,32,0"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,glass,10,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,stonebrick,32,0", "minecraft,planks,32,0", "villagebox,silver_coin,2,0"};
		profession.holdItems = new String[]{"minecraft,planks,1,0", "minecraft,stonebrick,1,0"};
		profession.texture = "builder";
		profession.name = "builder";
		data.professions.add(profession);

		//====== blacksmith ======
		profession = new JsonProfession();
		profession.id = 8;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "minecraft,iron_ingot,3,0"}, "villagebox,steel_ingot,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,coal,8,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,furnace,1,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,furnace,1,0"}, new String[]{"villagebox,steel_ingot,1,0"}));
		profession.upgradeProfessionIDs = new int[]{7, 23, 9};
		profession.upgradeRequirements = new String[]{"minecraft,coal,10,0", "minecraft,iron_ingot,2,0", "villagebox,silver_coin,2,0"};
		profession.holdItems = new String[]{"minecraft,coal,1,0", "minecraft,lava_bucket,1,0"};
		profession.texture = "blacksmith";
		profession.name = "blacksmith";
		data.professions.add(profession);

		//====== miner ======
		profession = new JsonProfession();
		profession.id = 4;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0"}, "minecraft,coal,8,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,8,0"}, "minecraft,iron_ore,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,32,0"}, "minecraft,gold_ore,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "minecraft,redstone,8,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,3,0"}, "minecraft,diamond,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,iron_pickaxe,1,0"}, new String[]{"villagebox,bronze_coin,20,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,torch,16,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,minecart,1,0"}, new String[]{"villagebox,bronze_coin,20,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,iron_pickaxe,1,0", "minecraft,torch,12,0", "villagebox,silver_coin,2,0"};
		profession.holdItems = new String[]{"minecraft,iron_pickaxe,1,0"};
		profession.texture = "miner";
		profession.name = "miner";
		data.professions.add(profession);

		//====== fisherman ======
		profession = new JsonProfession();
		profession.id = 15;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0"}, "villagebox,salt,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,seaweed,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0"}, "villagebox,shrimp,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0"}, "villagebox,crab,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,fishing_rod,1,0"}, new String[]{"villagebox,bronze_coin,12,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,fishing_rod,1,0"}, new String[]{"villagebox,crab,1,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,2,0", "minecraft,fishing_rod,1,0"};
		profession.holdItems = new String[]{"minecraft,fishing_rod,1,0", "minecraft,fish,1,0"};
		profession.texture = "fisherman";
		profession.name = "fisherman";
		data.professions.add(profession);

		//====== florist ======
		profession = new JsonProfession();
		profession.id = 16;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bonsai,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_heartmushroom,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_gardenia,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_hydrangeas,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_plumblossom,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_ranunculus,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_redrose,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,flower_rosyspiraea,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,flower_pot,1,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,dirt,3,0"}, new String[]{"villagebox,bronze_coin,5,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,flower_pot,1,0", "minecraft,dirt,3,0"}, new String[]{"villagebox,bonsai,1,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,flower_pot,2,0", "minecraft,dirt,16,0", "villagebox,silver_coin,2,0"};
		profession.holdItems = new String[]{"minecraft,flower_pot,1,0", "villagebox,bonsai,1,0", "villagebox,flower_redrose,1,0"};
		profession.texture = "florist";
		profession.name = "florist";
		data.professions.add(profession);

		//====== farmer ======
		profession = new JsonProfession();
		profession.id = 27;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,cabbage,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,chili,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,corn,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,soybean,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,riceplant,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,golden_hoe,1,0"}, new String[]{"villagebox,bronze_coin,24,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,golden_hoe,1,0"}, new String[]{"villagebox,corn,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,golden_hoe,1,0"}, new String[]{"villagebox,soybean,3,0"}));
		profession.upgradeProfessionIDs = new int[]{22};
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,1,0", "minecraft,golden_hoe,1,0"};
		profession.holdItems = new String[]{"minecraft,golden_hoe,1,0"};
		profession.texture = "farmer";
		profession.name = "farmer";
		data.professions.add(profession);

		//====== orchardist ======
		profession = new JsonProfession();
		profession.id = 18;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,lemon,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,orange,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,banana,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,strawberry,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,melon,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,grape,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,pineapple,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,golden_shovel,1,0"}, new String[]{"villagebox,bronze_coin,24,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,golden_shovel,1,0"}, new String[]{"villagebox,orange,3,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,golden_shovel,1,0"}, new String[]{"villagebox,strawberry,3,0"}));
		profession.upgradeProfessionIDs = new int[]{22};
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,1,0", "minecraft,golden_shovel,1,0"};
		profession.holdItems = new String[]{"minecraft,golden_shovel,1,0"};
		profession.texture = "orchardist";
		profession.name = "orchardist";
		data.professions.add(profession);

		//====== rancher ======
		profession = new JsonProfession();
		profession.id = 20;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,cheese,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,mayonnaise,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,ball_of_wool,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0", "minecraft,wool,1,0"}, "villagebox,ball_of_wool,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,bucket,1,0"}, new String[]{"villagebox,bronze_coin,12,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,shears,1,0"}, new String[]{"villagebox,bronze_coin,12,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,wheat_seeds,10,0"}, new String[]{"villagebox,bronze_coin,6,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,wheat,10,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,bucket,1,0"}, new String[]{"villagebox,mayonnaise,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,shears,1,0"}, new String[]{"villagebox,ball_of_wool,3,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,1,0", "minecraft,bucket,1,0", "minecraft,shears,1,0"};
		profession.holdItems = new String[]{"minecraft,bucket,1,0", "minecraft,shears,1,0"};
		profession.texture = "rancher";
		profession.name = "rancher";
		data.professions.add(profession);

		//====== cookassistant ======
		profession = new JsonProfession();
		profession.id = 26;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,corn,1,0"}, "villagebox,cooking_oil,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,riceplant,2,0"}, "villagebox,rice,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,riceplant,3,0"}, "villagebox,rice_flour,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "minecraft,wheat,5,0"}, "villagebox,wheat_flour,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,soybean,3,0"}, "villagebox,soy_sauce,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0", "minecraft,egg,1,0"}, "villagebox,boiled_egg,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,soybean,5,0"}, "villagebox,tofu,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,wheat,3,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,chicken,1,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.upgradeProfessionIDs = new int[]{30, 31};
		profession.upgradeRequirements = new String[]{"minecraft,wheat,10,0", "minecraft,chicken,3,0", "villagebox,silver_coin,2,0"};
		profession.holdItems = new String[]{"minecraft,chicken,1,0", "minecraft,wheat,1,0"};
		profession.texture = "cookassistant";
		profession.name = "cookassistant";
		data.professions.add(profession);

		//====== bookseller ======
		profession = new JsonProfession();
		profession.id = 28;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,50,0"}, "villagebox,treasure_hunt_book_0,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0"}, "villagebox,treasure_hunt_book_1,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,30,0"}, "villagebox,treasure_hunt_book_2,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,reset_scroll,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,reset_scroll,3,0", "villagebox,silver_coin,2,0"}, "villagebox,dismissal_scroll,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,15,0"}, "villagebox,village_book,1,0"));
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,1,0", "minecraft,book,10,0"};
		profession.holdItems = new String[]{"minecraft,book,1,0"};
		profession.texture = "bookseller";
		profession.name = "bookseller";
		data.professions.add(profession);

		//====== mage ======
		profession = new JsonProfession();
		profession.id = 24;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,blaze_rod,3,0", "villagebox,silver_coin,1,0"}, "villagebox,fire_shard,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,snowball,16,0", "minecraft,snowball,16,0", "villagebox,silver_coin,1,0"}, "villagebox,water_shard,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,wheat_seeds,32,0", "villagebox,silver_coin,1,0"}, "villagebox,nature_shard,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,glowstone_dust,32,0", "villagebox,silver_coin,1,0"}, "villagebox,light_shard,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,obsidian,5,0", "villagebox,silver_coin,1,0"}, "villagebox,dark_shard,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,sand,16,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,book,1,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.upgradeProfessionIDs = new int[]{5, 6, 33};
		profession.upgradeRequirements = new String[]{"minecraft,book,1,0", "villagebox,silver_coin,3,0"};
		profession.holdItems = new String[]{"villagebox,fire_shard,1,0", "villagebox,water_shard,1,0"};
		profession.texture = "mage";
		profession.name = "mage";
		data.professions.add(profession);

		//====== painter ======
		profession = new JsonProfession();
		profession.id = 19;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,painting,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,paper,16,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,silver_coin,2,0", "minecraft,paper,64,0"};
		profession.holdItems = new String[]{"minecraft,dye,1,10", "minecraft,dye,1,11", "minecraft,dye,1,14"};
		profession.texture = "painter";
		profession.name = "painter";
		data.professions.add(profession);

		//====== alchemist ======
		profession = new JsonProfession();
		profession.id = 5;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "minecraft,potion,1,8193"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "minecraft,potion,1,8194"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "minecraft,potion,1,8197"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "minecraft,potion,1,8201"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "minecraft,potion,1,8203"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "minecraft,potion,1,8205"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,glass_bottle,16,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,cauldron,1,0", "villagebox,silver_coin,15,0"};
		profession.holdItems = new String[]{"minecraft,glass_bottle,1,0", "minecraft,spider_eye,1,0"};
		profession.texture = "alchemist";
		profession.name = "alchemist";
		data.professions.add(profession);

		//====== shaman ======
		profession = new JsonProfession();
		profession.id = 6;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,15,0", "villagebox,fire_shard,5,0", "minecraft,log,1,0"}, "villagebox,fire_totem,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,15,0", "villagebox,water_shard,5,0", "minecraft,log,1,0"}, "villagebox,water_totem,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,15,0", "villagebox,nature_shard,5,0", "minecraft,log,1,0"}, "villagebox,nature_totem,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,3,0", "minecraft,log,1,0"}, "villagebox,totempole_0,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,3,0", "minecraft,log,1,0"}, "villagebox,totempole_1,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,3,0", "minecraft,log,1,0"}, "villagebox,totempole_2,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,3,0", "villagebox,fire_shard,1,0"}, "villagebox,sun_stone,3,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,3,0", "villagebox,water_shard,1,0"}, "villagebox,rain_stone,3,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,log,8,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,lava_bucket,1,0", "minecraft,water_bucket,1,0", "villagebox,silver_coin,12,0"};
		profession.holdItems = new String[]{"villagebox,sun_stone,1,0", "villagebox,rain_stone,1,0"};
		profession.texture = "shaman";
		profession.name = "shaman";
		data.professions.add(profession);

		//====== armorsmith ======
		profession = new JsonProfession();
		profession.id = 7;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_helmet,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_chestplate,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_leggings,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_boots,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,anvil,1,0"}, new String[]{"villagebox,silver_coin,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,coal,16,0"}, new String[]{"villagebox,bronze_coin,20,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,anvil,1,0"}, new String[]{"villagebox,steel_boots,1,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,steel_ingot,2,0", "villagebox,silver_coin,12,0"};
		profession.holdItems = new String[]{"minecraft,coal,1,0", "minecraft,lava_bucket,1,0"};
		profession.texture = "armorsmith";
		profession.name = "armorsmith";
		data.professions.add(profession);

		//====== toolsmith ======
		profession = new JsonProfession();
		profession.id = 9;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_axe,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_pickaxe,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_hoe,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,3,0"}, "villagebox,steel_shovel,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,crafting_table,1,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,coal,8,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,furnace,1,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,steel_ingot,1,0", "villagebox,silver_coin,12,0"};
		profession.holdItems = new String[]{"minecraft,coal,1,0", "minecraft,lava_bucket,1,0"};
		profession.texture = "toolsmith";
		profession.name = "toolsmith";
		data.professions.add(profession);

		//====== bowmaker ======
		profession = new JsonProfession();
		profession.id = 10;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,25,0"}, "villagebox,bow,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,15,0"}, "minecraft,arrow,20,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,string,5,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,stick,20,0"}, new String[]{"villagebox,bronze_coin,10,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,feather,5,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,string,10,0", "villagebox,silver_coin,12,0"};
		profession.holdItems = new String[]{"minecraft,string,1,0"};
		profession.texture = "bowmaker";
		profession.name = "bowmaker";
		data.professions.add(profession);

		//====== carpetmakeradv ======
		profession = new JsonProfession();
		profession.id = 12;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_20,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_21,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_22,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_23,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_24,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_25,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_26,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_27,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_28,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_29,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_30,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_31,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"villagebox,ball_of_wool,3,0"}, new String[]{"villagebox,bronze_coin,24,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,ball_of_wool,10,0", "villagebox,silver_coin,10,0"};
		profession.holdItems = new String[]{"villagebox,ball_of_wool,1,0"};
		profession.texture = "carpetmakeradv";
		profession.name = "carpetmakeradv";
		data.professions.add(profession);

		//====== carpetmakercartoony ======
		profession = new JsonProfession();
		profession.id = 13;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_0,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_1,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_2,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_3,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_4,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_5,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_6,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_7,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_8,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_9,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_10,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_11,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_12,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_13,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_14,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_15,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_16,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_17,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_18,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,ball_of_wool,2,0"}, "villagebox,carpet_19,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"villagebox,ball_of_wool,3,0"}, new String[]{"villagebox,bronze_coin,24,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,ball_of_wool,10,0", "villagebox,silver_coin,10,0"};
		profession.holdItems = new String[]{"villagebox,ball_of_wool,1,0"};
		profession.texture = "carpetmakercartoony";
		profession.name = "carpetmakercartoony";
		data.professions.add(profession);

		//====== furnituremaker ======
		profession = new JsonProfession();
		profession.id = 17;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,table_acacia,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,table_birch,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,table_big_oak,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,table_jungle,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,table_oak,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,2,0"}, "villagebox,table_spruce,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,chair_acacia,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,chair_birch,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,chair_big_oak,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,chair_jungle,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,chair_oak,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,chair_spruce,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bench_acacia,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bench_birch,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bench_big_oak,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bench_jungle,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bench_oak,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0"}, "villagebox,bench_spruce,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,0"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,1"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,2"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,3"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,4"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,5"}, new String[]{"villagebox,bronze_coin,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,32,0"}, new String[]{"villagebox,chair_oak,1,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,planks,64,0", "villagebox,silver_coin,10,0"};
		profession.holdItems = new String[]{"minecraft,planks,1,0", "villagebox,chair_oak,1,0"};
		profession.texture = "furnituremaker";
		profession.name = "furnituremaker";
		data.professions.add(profession);

		//====== vintner ======
		profession = new JsonProfession();
		profession.id = 22;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,cooking_wine,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,grape,1,0"}, "villagebox,grape_wine,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,cocktail,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,5,0", "villagebox,riceplant,1,0"}, "villagebox,beer,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,whisky,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0"}, "villagebox,vodka,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,planks,16,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,glass_bottle,8,0"}, new String[]{"villagebox,bronze_coin,5,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,glass_bottle,8,0"}, new String[]{"villagebox,beer,1,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,grape,5,0", "villagebox,riceplant,5,0", "villagebox,silver_coin,1,0"};
		profession.holdItems = new String[]{"villagebox,grape,1,0", "villagebox,grape_wine,1,0"};
		profession.texture = "vintner";
		profession.name = "vintner";
		data.professions.add(profession);

		//====== weaponsmith ======
		profession = new JsonProfession();
		profession.id = 23;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,5,0", "villagebox,steel_ingot,4,0"}, "villagebox,steel_sword,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,fire_shard,2,0", "villagebox,steel_sword,1,0"}, "villagebox,fire_sword,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,water_shard,2,0", "villagebox,steel_sword,1,0"}, "villagebox,water_sword,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,nature_shard,2,0", "villagebox,steel_sword,1,0"}, "villagebox,nature_sword,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,light_shard,2,0", "villagebox,steel_sword,1,0"}, "villagebox,light_sword,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,dark_shard,2,0", "villagebox,steel_sword,1,0"}, "villagebox,dark_sword,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,anvil,1,0"}, new String[]{"villagebox,silver_coin,2,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,coal,16,0"}, new String[]{"villagebox,bronze_coin,20,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,steel_ingot,1,0", "villagebox,silver_coin,15,0"};
		profession.holdItems = new String[]{"minecraft,coal,1,0", "minecraft,lava_bucket,1,0"};
		profession.texture = "weaponsmith";
		profession.name = "weaponsmith";
		data.professions.add(profession);

		//====== chef ======
		profession = new JsonProfession();
		profession.id = 30;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "minecraft,porkchop,1,0", "villagebox,wheat_flour,1,0", "villagebox,soy_sauce,1,0"}, "villagebox,pork_ramen,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "minecraft,beef,1,0", "villagebox,wheat_flour,1,0"}, "villagebox,beef_noodle_soup,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "villagebox,wheat_flour,1,0", "villagebox,salt,1,0"}, "villagebox,noodle_soup,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,50,0", "minecraft,beef,1,0", "villagebox,cheese,1,0", "villagebox,cabbage,1,0"}, "villagebox,hamburger,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,40,0", "villagebox,rice,1,0", "villagebox,salt,1,0"}, "villagebox,congee,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "villagebox,chili,1,0", "minecraft,fish,1,0", "villagebox,cooking_oil,1,0"}, "villagebox,boiled_fish,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,30,0", "minecraft,potato,1,0", "villagebox,cooking_oil,1,0"}, "villagebox,fries,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "villagebox,tofu,1,0", "villagebox,chili,1,0", "villagebox,soy_sauce,1,0"}, "villagebox,mapo_tofu,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,30,0", "villagebox,corn,1,0", "villagebox,salt,1,0", "villagebox,cooking_oil,1,0"}, "villagebox,corn_chips,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,1,0", "minecraft,mutton,1,0", "villagebox,cooking_wine,1,0", "villagebox,cooking_oil,1,0"}, "villagebox,roasted_lamb,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,50,0", "villagebox,rice,1,0", "villagebox,soy_sauce,1,0", "minecraft,fish,1,0"}, "villagebox,nigiri,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,80,0", "villagebox,rice_flour,1,0", "villagebox,salt,1,0"}, "villagebox,udon,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"villagebox,cooking_oil,1,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"villagebox,cooking_wine,1,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"villagebox,cooking_wine,1,0"}, new String[]{"villagebox,pork_ramen,1,0"}));
		profession.upgradeRequirements = new String[]{"villagebox,cooking_oil,5,0", "villagebox,cooking_wine,5,0", "villagebox,silver_coin,12,0"};
		profession.holdItems = new String[]{"villagebox,cooking_oil,1,0", "villagebox,cooking_wine,1,0"};
		profession.texture = "chef";
		profession.name = "chef";
		data.professions.add(profession);

		//====== chefdessert ======
		profession = new JsonProfession();
		profession.id = 31;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,20,0", "minecraft,carrot,1,0", "villagebox,wheat_flour,1,0"}, "villagebox,carrot_cake,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "minecraft,apple,1,0", "minecraft,sugar,1,0"}, "villagebox,apple_candy,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,corn,1,0", "villagebox,cheese,1,0"}, "villagebox,creamy_corn,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,15,0", "minecraft,dye,1,3", "villagebox,banana,1,0"}, "villagebox,chocolate_banana,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,20,0", "villagebox,orange,1,0", "minecraft,sugar,1,0"}, "villagebox,canned_oranges,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,30,0", "villagebox,mayonnaise,1,0", "villagebox,strawberry,1,0", "minecraft,snowball,2,0"}, "villagebox,strawberry_icecream,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "minecraft,sugar,1,0", "villagebox,lemon,1,0"}, "villagebox,honey_tea,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,10,0", "villagebox,pineapple,1,0", "minecraft,sugar,1,0"}, "villagebox,pineapple_canday,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,30,0", "minecraft,melon,1,0", "villagebox,mayonnaise,1,0", "minecraft,snowball,2,0"}, "villagebox,melon_icecream,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,bronze_coin,15,0", "villagebox,melon,1,0", "minecraft,sugar,1,0"}, "villagebox,melon_icebar,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,sugar,3,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"villagebox,wheat_flour,1,0"}, new String[]{"villagebox,bronze_coin,15,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,sugar,3,0"}, new String[]{"villagebox,strawberry_icecream,1,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,sugar,20,0", "villagebox,wheat_flour,5,0", "villagebox,silver_coin,10,0"};
		profession.holdItems = new String[]{"minecraft,sugar,1,0", "villagebox,wheat_flour,1,0"};
		profession.texture = "chefdessert";
		profession.name = "chefdessert";data.professions.add(profession);

		//====== staffcrafter ======
		profession = new JsonProfession();
		profession.id = 33;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "minecraft,stick,1,0", "minecraft,glass,1,0"}, "villagebox,staff,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,staff,1,0", "villagebox,fire_shard,2,0"}, "villagebox,fire_staff,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,staff,1,0", "villagebox,water_shard,2,0"}, "villagebox,water_staff,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,staff,1,0", "villagebox,nature_shard,2,0"}, "villagebox,nature_staff,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,staff,1,0", "villagebox,light_shard,2,0"}, "villagebox,light_staff,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"villagebox,silver_coin,10,0", "villagebox,staff,1,0", "villagebox,dark_shard,2,0"}, "villagebox,dark_staff,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,stick,16,0"}, new String[]{"villagebox,bronze_coin,8,0"}));
		profession.upgradeRequirements = new String[]{"minecraft,stick,1,0", "villagebox,silver_coin,15,0"};
		profession.holdItems = new String[]{"villagebox,staff,1,0"};
		profession.texture = "staffcrafter";
		profession.name = "staffcrafter";
		data.professions.add(profession);

		//====== caveman ======
		profession = new JsonProfession();
		profession.id = 99999;
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,cobblestone,10,0"}, "minecraft,bone,1,0"));
		profession.tradingRecipes.add(new JsonTradingRecipe(new String[]{"minecraft,cobblestone,64,0"}, "villagebox,wooden_club,1,0"));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_chicken,1,0"}, new String[]{"minecraft,cobblestone,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_fish,1,0"}, new String[]{"minecraft,cobblestone,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_porkchop,1,0"}, new String[]{"minecraft,cobblestone,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,cooked_rabbit,1,0"}, new String[]{"minecraft,cobblestone,16,0"}));
		profession.quests.add(new JsonQuest(new String[]{"minecraft,beef,1,0"}, new String[]{"minecraft,cobblestone,16,0"}));
		profession.upgradeProfessionIDs = new int[]{0, 1, 2};
		profession.holdItems = new String[]{"villagebox,wooden_club,1,0"};
		profession.texture = "caveman";
		profession.name = "caveman";
		data.professions.add(profession);
		
		return data;
	}
}
