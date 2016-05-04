package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProAlchemist extends Profession{

	@Override
	protected void initTradingRecipeList() {
//		this.tradingRecipeList.add(new TradingRecipe(
//				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.steelIngot,10)},
//				new ItemStack(ModBlocks.alchemyPot)));
		
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(Items.potionitem,1,8193)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(Items.potionitem,1,8194)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(Items.potionitem,1,8197)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(Items.potionitem,1,8201)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(Items.potionitem,1,8203)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(Items.potionitem,1,8205)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("alchemist");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.alchemist");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.cauldron,1),
				new ItemStack(ModItems.silverCoin,15)
		};
		
		this.upgradeToNextOptionClasses = null;
	}

	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.glass_bottle),
				new ItemStack(Items.spider_eye)
		};
	}

	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.glass_bottle,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
	}
}
