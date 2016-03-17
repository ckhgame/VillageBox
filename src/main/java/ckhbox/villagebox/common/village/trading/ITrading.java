package ckhbox.villagebox.common.village.trading;

public interface ITrading {
	TradingRecipeList getTradingRecipeList();
	void onTrade();
}
