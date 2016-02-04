package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.util.registry.IRegistrable;
import ckhbox.villagebento.common.util.registry.Registry;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public abstract class Profession implements IRegistrable{
	
	private int regID;
	protected int[] attributesGrowing;
	protected int[] attributesNeeded;
	//trading recipe list
	protected TradingRecipeList tradingRecipeList = new TradingRecipeList();
	//texture
	protected ResourceLocation texture;
	
	@Override
	public int getRegID() {
		return regID;
	}

	@Override
	public void setRegID(int regID) {
		this.regID = regID;
	}
	
	public Profession(){
		this.initTradingRecipeList();
		this.initAttributes();
	}
	
	public int[] getAttributesNeeded(){
		return this.attributesNeeded;
	}
	
	public int[] getAttributesGrowing(){
		return this.attributesGrowing;
	}
	
	public TradingRecipeList getTradingRecipeList(){
		return this.tradingRecipeList;
	}
	
	public String getDisplayName(){
		return StatCollector.translateToLocal(this.getUnlocalizedName());
	}
	
	
	//abstract functions
	protected abstract void initTradingRecipeList();
	protected abstract void initAttributes();
	protected abstract void initTexture();
	protected abstract String getUnlocalizedName();
	
	
	//---------------------------------
	//registry
	public static Registry<Profession> registry = new Registry<Profession>();
	
	public static void init(){
		int id = 0;
		registry.register(id++, new ProVillager());
	}

}
