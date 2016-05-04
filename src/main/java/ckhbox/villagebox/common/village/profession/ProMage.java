package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProMage extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.blaze_rod,3),new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.fireShard)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.snowball,16),new ItemStack(Items.snowball,16),new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.waterShard)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.wheat_seeds,32),new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.natureShard)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.glowstone_dust,32),new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.lightShard)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.obsidian,5),new ItemStack(ModItems.silverCoin,1)},
				new ItemStack(ModItems.darkShard)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("mage");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.mage");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.book,1),
				new ItemStack(ModItems.silverCoin,3)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProAlchemist.class,
				ProShaman.class,
				ProStaffCrafter.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.fireShard),
				new ItemStack(ModItems.waterShard)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();		
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.sand,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.book,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,8)}));
	}

}
