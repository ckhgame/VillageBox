package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProBowmaker extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin, 25)},
				new ItemStack(ModItems.efficientBow,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)},
				new ItemStack(Items.arrow,20)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("bowmaker");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.bowmaker");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.string,10),
				new ItemStack(ModItems.silverCoin,12)
		};
		
		this.upgradeToNextOptions = null;
	}

	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.string)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.string,5)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.stick,20)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.feather,5)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)}));
	}
}
