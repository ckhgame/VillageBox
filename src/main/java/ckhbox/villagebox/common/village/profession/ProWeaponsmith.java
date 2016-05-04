package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProWeaponsmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,4)},
				new ItemStack(ModItems.steelSword)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10),new ItemStack(ModItems.fireShard,2),new ItemStack(ModItems.steelSword)},
				new ItemStack(ModItems.fireSword)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10),new ItemStack(ModItems.waterShard,2),new ItemStack(ModItems.steelSword)},
				new ItemStack(ModItems.waterSword)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10),new ItemStack(ModItems.natureShard,2),new ItemStack(ModItems.steelSword)},
				new ItemStack(ModItems.natureSword)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10),new ItemStack(ModItems.lightShard,2),new ItemStack(ModItems.steelSword)},
				new ItemStack(ModItems.lightSword)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10),new ItemStack(ModItems.darkShard,2),new ItemStack(ModItems.steelSword)},
				new ItemStack(ModItems.darkSword)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("weaponsmith");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.weaponsmith");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.steelIngot,1),
				new ItemStack(ModItems.silverCoin,15)
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
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.anvil,1)},
				new ItemStack[]{new ItemStack(ModItems.silverCoin,2)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.coal,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)}));
	}
}
