package ckhbox.villagebox.common.config.jsonData;

public class JsonTradingRecipe {
	
	//input & output item stack string format:
	//domain,itemID,amount,meta
	//example: minecraft,log,1,0 indicates a Oak Wood from Vanillia minecraft
	//the amount should be between 1 and 64
	//you can have up to 4 output item stacks
	
	public String[] inputs;
	public String output;	
	
	public JsonTradingRecipe(String[] inputs, String output)
	{
		this.inputs = inputs;
		this.output = output;
	}
}
