package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.util.registry.IRegistrable;
import ckhbox.villagebento.common.util.registry.Registry;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;

public abstract class Profession implements IRegistrable{
	
	private int regID;
	
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
	}
	
	//trading recipe list
	protected TradingRecipeList tradingRecipeList = new TradingRecipeList();
	
	public TradingRecipeList getTradingRecipeList(){
		return this.tradingRecipeList;
	}
	
	
	//abstract functions
	protected abstract void initTradingRecipeList();
	
	
	//---------------------------------
	//registry
	public static Registry<Profession> registry = new Registry<Profession>();
	
	public static void init(){
		int id = 0;
		registry.register(id++, new ProFolk());
	}

}
