package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class ProVillager extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)},
				new ItemStack(Items.apple)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)},
				new ItemStack(Items.egg)));
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.villager");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.book)
		};
		this.upgradeToNextOptionClasses = new Class[]{
				ProPeasant.class,
				ProWorker.class,
				ProBanker.class,
				ProScholar.class
				};
	} 
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.apple),
				new ItemStack(Items.egg)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.bread,3)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.cooked_chicken,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(ModItems.treasureHuntBookII,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
	}

}
