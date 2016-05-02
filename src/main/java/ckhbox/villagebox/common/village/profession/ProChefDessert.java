package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;

public class ProChefDessert extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,20),
						new ItemStack(Items.carrot,1),
						new ItemStack(ModItems.wheatFlour,1)
						},
				new ItemStack(ModItems.carrotCake)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(Items.apple,1),
						new ItemStack(Items.sugar,1)
						},
				new ItemStack(ModItems.appleCandy)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.corn,1),
						new ItemStack(ModItems.cheese,1)
						},
				new ItemStack(ModItems.creamyCorn)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,15),
						new ItemStack(Items.dye, 1, EnumDyeColor.BROWN.getDyeDamage()),
						new ItemStack(ModItems.banana,1)},
				new ItemStack(ModItems.chocolateBanana)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.silverCoin,20),
						new ItemStack(ModItems.orange,1),
						new ItemStack(Items.sugar,1)
						},
				new ItemStack(ModItems.cannedOranges)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,30),
						new ItemStack(ModItems.mayonnaise,1),
						new ItemStack(ModItems.strawberry,1),
						new ItemStack(Items.snowball,2)},
				new ItemStack(ModItems.strawberryIcecream)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(Items.sugar,1),
						new ItemStack(ModItems.lemon,1)
						},
				new ItemStack(ModItems.honeyTea)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,10),
						new ItemStack(ModItems.pineapple,1),
						new ItemStack(Items.sugar,1)
						},
				new ItemStack(ModItems.pineappleCanday)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,30),
						new ItemStack(Items.melon,1),
						new ItemStack(ModItems.mayonnaise,1),
						new ItemStack(Items.snowball,2)},
				new ItemStack(ModItems.melonIcecream)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{
						new ItemStack(ModItems.bronzeCoin,15),
						new ItemStack(ModItems.melon,1),
						new ItemStack(Items.sugar,1)},
				new ItemStack(ModItems.melonIcebar)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("chefdessert");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.chefdessert");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.sugar,20),
				new ItemStack(ModItems.wheatFlour,5),
				new ItemStack(ModItems.silverCoin,10),
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.sugar),
				new ItemStack(ModItems.wheatFlour)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
	}
}
