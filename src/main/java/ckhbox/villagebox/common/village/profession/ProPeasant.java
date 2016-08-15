package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProPeasant extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.WHEAT,10)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.CARROT,3)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.POTATO,3)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Blocks.PUMPKIN,1)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("peasant");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.peasant");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.bronzeCoin,20),
				new ItemStack(Items.IRON_HOE,1)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProFlorist.class,
				ProOrchardist.class,
				ProRancher.class,
				ProFisherman.class,
				ProFarmer.class,
				ProCookAssistant.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.IRON_HOE)
		};
	}

	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.IRON_HOE,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.WHEAT_SEEDS,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
	}
}
