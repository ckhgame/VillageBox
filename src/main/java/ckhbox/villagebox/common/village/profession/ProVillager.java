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
				new ItemStack(Items.APPLE)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)},
				new ItemStack(Items.EGG)));
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.villager");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.BOOK)
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
				new ItemStack(Items.APPLE),
				new ItemStack(Items.EGG)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.BREAD,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.COOKED_CHICKEN,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,4)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.COOKED_FISH,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,3)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.COOKED_FISH,1)},
				new ItemStack[]{new ItemStack(Items.APPLE,2)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.COOKED_CHICKEN,1)},
				new ItemStack[]{new ItemStack(Items.APPLE,2)}));
	}

}
