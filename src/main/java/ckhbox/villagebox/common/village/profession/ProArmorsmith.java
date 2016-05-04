package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProArmorsmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelHelmet)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelChestplate)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelLeggings)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,5),new ItemStack(ModItems.steelIngot,3)},
				new ItemStack(ModItems.steelBoots)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("armorsmith");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.armorsmith");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(ModItems.steelIngot,2),
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
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.anvil,1)},
				new ItemStack[]{new ItemStack(ModItems.silverCoin,2)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.coal,16)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,20)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.anvil,1)},
				new ItemStack[]{new ItemStack(ModItems.steelBoots,1)}));
	}
}
