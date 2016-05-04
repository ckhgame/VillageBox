package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProCarpenter extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)},
				new ItemStack(ModItems.woodenHelmet)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,30)},
				new ItemStack(ModItems.woodenChestplate)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,25)},
				new ItemStack(ModItems.woodenLeggings)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)},
				new ItemStack(ModItems.woodenBoots)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.log,5,0),new ItemStack(ModItems.bronzeCoin,2)},
				new ItemStack(Blocks.planks,30,0)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.log,5,1),new ItemStack(ModItems.bronzeCoin,2)},
				new ItemStack(Blocks.planks,30,1)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.log,5,2),new ItemStack(ModItems.bronzeCoin,2)},
				new ItemStack(Blocks.planks,30,2)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.log,5,3),new ItemStack(ModItems.bronzeCoin,2)},
				new ItemStack(Blocks.planks,30,3)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.log2,5,0),new ItemStack(ModItems.bronzeCoin,2)},
				new ItemStack(Blocks.planks,30,4)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.log2,5,1),new ItemStack(ModItems.bronzeCoin,2)},
				new ItemStack(Blocks.planks,30,5)));
		
	}

	@Override
	protected void initTexture() {
		this.createTextures("carpenter");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.carpenter");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.iron_axe),
				new ItemStack(ModItems.silverCoin,2)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProBowmaker.class,
				ProFurnituremaker.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Blocks.log)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.iron_axe,1)},
				new ItemStack[]{new ItemStack(ModItems.woodenChestplate,1)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.iron_axe,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)}));
	}

}
