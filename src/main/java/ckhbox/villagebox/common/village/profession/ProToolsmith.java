package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProToolsmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelAxe)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelPickaxe)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelHoe)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelShovel)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("toolsmith");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.toolsmith");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.steelIngot,1),
				new ItemStack(ModItems.silverCoin,12)
		};
		
		this.upgradeToNextOptions = null;
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.coal),
				new ItemStack(Items.lava_bucket)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
	}

}
