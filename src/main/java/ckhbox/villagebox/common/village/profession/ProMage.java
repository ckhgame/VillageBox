package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.block.ModBlocks;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProMage extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,10)},
				new ItemStack(ModItems.flameStaff)));
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
				new ItemStack(Items.stick,1),
				new ItemStack(Items.book,1),
				new ItemStack(ModItems.silverCoin,3)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProAlchemist.class,
				ProShaman.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.stick)
		};
	}

}
