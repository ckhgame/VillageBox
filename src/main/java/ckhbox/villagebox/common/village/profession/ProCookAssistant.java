package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProCookAssistant extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.corn,1),
						},
				new ItemStack(ModItems.cookingOil)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.riceplant,2)
						},
				new ItemStack(ModItems.rice)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.riceplant,3)
						},
				new ItemStack(ModItems.riceFlour)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(Items.wheat,5)
						},
				new ItemStack(ModItems.wheatFlour)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.soybean,3)
						},
				new ItemStack(ModItems.soySauce)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,5),
						new ItemStack(Items.egg,1)
						},
				new ItemStack(ModItems.boiledEgg)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.soybean,5)},
				new ItemStack(ModItems.tofu)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("cookassistant");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.cookassistant");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.wheat,10),
				new ItemStack(Items.chicken,3),
				new ItemStack(ModItems.silverCoin,2),
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProChef.class,
				ProChefDessert.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.chicken),
				new ItemStack(Items.wheat)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.wheat,3)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.chicken,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)}));
	}
}
