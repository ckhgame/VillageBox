package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProWorker extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,16)},
				new ItemStack(Items.IRON_SWORD,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)},
				new ItemStack(Items.IRON_PICKAXE,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)},
				new ItemStack(Items.IRON_AXE,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(Items.IRON_HOE,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(Items.IRON_SHOVEL,1)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("worker");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.worker");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.bronzeCoin,25),
				new ItemStack(Blocks.CRAFTING_TABLE)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProBuilder.class,
				ProCarpenter.class,
				ProBlacksmith.class,
				ProMiner.class,
				ProCarpetmaker.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Blocks.CRAFTING_TABLE)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.CRAFTING_TABLE,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
	}
}
