package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProCarpetMakerCartoony extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet0)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet1)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet2)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet3)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet4)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet5)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet6)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet7)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet8)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet9)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet10)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet11)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet12)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet13)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet14)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet15)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet16)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet17)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet18)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,40),new ItemStack(ModItems.ballOfWool,2)},new ItemStack(ModBlocks.carpet19)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("carpetmakercartoony");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.carpetmakercartoony");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.ballOfWool,10),
				new ItemStack(ModItems.silverCoin,10)
		};
		
		this.upgradeToNextOptions = null;
	}
	
}
