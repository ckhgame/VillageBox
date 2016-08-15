package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProMiner extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,5)},
				new ItemStack(Items.COAL,8)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)},
				new ItemStack(Blocks.IRON_ORE,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,32)},
				new ItemStack(Blocks.GOLD_ORE,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(Items.REDSTONE,8)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3)},
				new ItemStack(Items.DIAMOND,1)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("miner");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.miner");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.IRON_PICKAXE),
				new ItemStack(Blocks.TORCH,12),
				new ItemStack(ModItems.silverCoin,2)
		};
		
		this.upgradeToNextOptionClasses = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.IRON_PICKAXE)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.IRON_PICKAXE,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.TORCH,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.MINECART,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)}));
	}
}
