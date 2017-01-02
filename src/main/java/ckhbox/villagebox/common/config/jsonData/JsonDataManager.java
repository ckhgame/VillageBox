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

		JsonProfession profession;		
		//villager 0
		profession = new JsonProfession();
		profession.tradingRecipes.add(new JsonTradingRecipe(
				new String[]{"minecraft,log,2,1","minecraft,log,2,1"},
				"minecraft,log,2,1"));
		data.professions.put("villager", profession);
		profession.texture = "villager0";
		
		return data;
	}
}
