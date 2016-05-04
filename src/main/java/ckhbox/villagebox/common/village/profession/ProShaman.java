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

public class ProShaman extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,15),new ItemStack(ModItems.fireShard,5),new ItemStack(Blocks.log,1)},
				new ItemStack(ModBlocks.fireTotem)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,15),new ItemStack(ModItems.waterShard,5),new ItemStack(Blocks.log,1)},
				new ItemStack(ModBlocks.waterTotem)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,15),new ItemStack(ModItems.natureShard,5),new ItemStack(Blocks.log,1)},
				new ItemStack(ModBlocks.natureTotem)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3),new ItemStack(Blocks.log,1)},
				new ItemStack(ModBlocks.totempole0)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3),new ItemStack(Blocks.log,1)},
				new ItemStack(ModBlocks.totempole1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3),new ItemStack(Blocks.log,1)},
				new ItemStack(ModBlocks.totempole2)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3),new ItemStack(ModItems.fireShard)},
				new ItemStack(ModItems.sunStone,3)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,3),new ItemStack(ModItems.waterShard)},
				new ItemStack(ModItems.rainStone,3)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("shaman");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.shaman");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.lava_bucket),
				new ItemStack(Items.water_bucket),
				new ItemStack(ModItems.silverCoin,12)
		};
		
		this.upgradeToNextOptionClasses = null;
	}

	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.sunStone),
				new ItemStack(ModItems.rainStone)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.log,8)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
	}
}
