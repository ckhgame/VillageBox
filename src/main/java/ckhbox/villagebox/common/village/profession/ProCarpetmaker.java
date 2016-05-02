package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ProCarpetmaker extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool0)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool1)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool2)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool3)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool4)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool5)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool6)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool7)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool8)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool9)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool10)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool11)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool12)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool13)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool14)));
		this.tradingRecipeList.add(new TradingRecipe(new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20),new ItemStack(Blocks.wool,1)},new ItemStack(ModBlocks.carpetWool15)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("carpetmaker");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.carpetmaker");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.silverCoin,2),
				new ItemStack(Blocks.wool,16)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProCarpetMakerAdevanced.class,
				ProCarpetMakerCartoony.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Blocks.wool)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
	}
	
}
