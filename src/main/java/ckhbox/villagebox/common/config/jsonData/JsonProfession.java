package ckhbox.villagebox.common.config.jsonData;

import java.util.ArrayList;
import java.util.List;

public class JsonProfession {
	
	public int ID;
	
	public ArrayList<JsonTradingRecipe> tradingRecipes;
	public ArrayList<JsonQuest> quests;
	
	public int[] UpgradeProfessionIDs;
	public String[] upgradeRequirements;
	public String[] holdItems;
	public String texture;
	
	public JsonProfession()
	{
		tradingRecipes = new ArrayList<JsonTradingRecipe>();
		quests = new ArrayList<JsonQuest>();
	}
	
}
