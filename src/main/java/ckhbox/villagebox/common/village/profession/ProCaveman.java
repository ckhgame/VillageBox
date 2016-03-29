package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProCaveman extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.stone,15)},
				new ItemStack(Items.bone)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.stone,64)},
				new ItemStack(ModItems.woodenClub)));
	}


	@Override
	protected void initTexture() {
		this.createTextures("caveman");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.caveman");
	}
	
	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = null;
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProVillager0.class,
				ProVillager1.class,
				ProVillager2.class,
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(ModItems.woodenClub)
		};
	}
}
