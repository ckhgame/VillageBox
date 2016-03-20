package ckhbox.villagebox.common.village.profession;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProBlacksmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1),new ItemStack(Items.iron_ingot,3)},
				new ItemStack(ModItems.steelIngot)));
	}

	@Override
	protected void initTexture() {
		this.createTextures("blacksmith");
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.blacksmith");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = new ItemStack[]{
				new ItemStack(Items.coal,10),
				new ItemStack(Items.iron_ingot,2),
				new ItemStack(ModItems.silverCoin, 2)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProArmorsmith.class,
				ProWeaponsmith.class,
				ProToolsmith.class
				};
	}

}
