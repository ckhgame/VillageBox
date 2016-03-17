package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProWorker extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,16)},
				new ItemStack(Items.iron_sword,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)},
				new ItemStack(Items.iron_pickaxe,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)},
				new ItemStack(Items.iron_axe,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(Items.iron_hoe,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)},
				new ItemStack(Items.iron_shovel,1)));
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
				new ItemStack(Blocks.crafting_table),
				new ItemStack(Blocks.furnace)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProBuilder.class,
				ProCarpenter.class,
				ProBlacksmith.class,
				ProMiner.class,
				ProCarpetmaker.class
				};
	}
	
}
