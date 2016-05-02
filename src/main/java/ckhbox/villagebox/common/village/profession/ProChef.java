package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProChef extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,1),
						new ItemStack(Items.porkchop,1),
						new ItemStack(ModItems.wheatFlour,1),
						new ItemStack(ModItems.soySauce,1)
						},
				new ItemStack(ModItems.porkRamen)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,1),
						new ItemStack(Items.beef,1),
						new ItemStack(ModItems.wheatFlour,1)
						},
				new ItemStack(ModItems.beefNoodleSoup)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,1),
						new ItemStack(ModItems.wheatFlour,1),
						new ItemStack(ModItems.salt,1)
						},
				new ItemStack(ModItems.noodleSoup)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,50),
						new ItemStack(Items.beef,1),
						new ItemStack(ModItems.cheese,1),
						new ItemStack(ModItems.cabbage,1)
						},
				new ItemStack(ModItems.hambuger)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,40),
						new ItemStack(ModItems.rice,1),
						new ItemStack(ModItems.salt,1)},
				new ItemStack(ModItems.congee)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,1),
						new ItemStack(ModItems.chili,1),
						new ItemStack(Items.fish,1),
						new ItemStack(ModItems.cookingOil,1)
						},
				new ItemStack(ModItems.boiledFish)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,30),
						new ItemStack(Items.potato,1),
						new ItemStack(ModItems.cookingOil,1)
						},
				new ItemStack(ModItems.fries)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,1),
						new ItemStack(ModItems.tofu,1),
						new ItemStack(ModItems.chili,1),
						new ItemStack(ModItems.soySauce,1)},
				new ItemStack(ModItems.mapoTofu)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,30),
						new ItemStack(ModItems.corn,1),
						new ItemStack(ModItems.salt,1),
						new ItemStack(ModItems.cookingOil,1)
						},
				new ItemStack(ModItems.cornChips)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,1),
						new ItemStack(Items.mutton,1),
						new ItemStack(ModItems.cookingWine,1),
						new ItemStack(ModItems.cookingOil,1)
						},
				new ItemStack(ModItems.roastedLamb)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,50),
						new ItemStack(ModItems.rice,1),
						new ItemStack(ModItems.soySauce,1),
						new ItemStack(Items.fish,1)},
				new ItemStack(ModItems.nigiri)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,80),
						new ItemStack(ModItems.riceFlour,1),
						new ItemStack(ModItems.salt,1)},
				new ItemStack(ModItems.udon)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("chef");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.chef");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.cookingOil,5),
				new ItemStack(ModItems.cookingWine,5),
				new ItemStack(ModItems.silverCoin,12)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.cookingOil),
				new ItemStack(ModItems.cookingWine)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
	}
}
