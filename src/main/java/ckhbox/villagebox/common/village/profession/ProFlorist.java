package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProFlorist extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.bonsai)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerHeartMushroom)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerGardenia)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerHydrangeas)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerPlumBlossom)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerRanunculus)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerRedRose)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModBlocks.flowerRosySpiraea)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("florist");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.florist");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.FLOWER_POT,2),
				new ItemStack(Blocks.DIRT,16),
				new ItemStack(ModItems.silverCoin,2)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.FLOWER_POT),
				new ItemStack(ModBlocks.bonsai),
				new ItemStack(ModBlocks.flowerRedRose)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.FLOWER_POT,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.DIRT,3)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.FLOWER_POT,1),new ItemStack(Blocks.DIRT,3)},
				new ItemStack[]{new ItemStack(ModBlocks.bonsai,1)}));
	}

}
