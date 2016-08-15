package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProStaffCrafter extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(Items.STICK), new ItemStack(Blocks.GLASS)},
				new ItemStack(ModItems.staff)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.staff), new ItemStack(ModItems.fireShard,2)},
				new ItemStack(ModItems.fireStaff)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.staff), new ItemStack(ModItems.waterShard,2)},
				new ItemStack(ModItems.waterStaff)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.staff), new ItemStack(ModItems.natureShard,2)},
				new ItemStack(ModItems.natureStaff)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.staff), new ItemStack(ModItems.lightShard,2)},
				new ItemStack(ModItems.lightStaff)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10), new ItemStack(ModItems.staff), new ItemStack(ModItems.darkShard,2)},
				new ItemStack(ModItems.darkStaff)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("staffcrafter");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.staffcrafter");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.STICK,1),
				new ItemStack(ModItems.silverCoin,15)
		};
		
		this.upgradeToNextOptionClasses = null;
	}

	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.staff)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();	
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.STICK,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
	}
	
}
