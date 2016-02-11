package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProBlacksmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Items.emerald,20)},
				new ItemStack(ModItems.reinforcedIronIngot)));
	}

	@Override
	protected void initAttributes() {
		this.maxEnegy = 120;
		this.maxProficiency = 240;
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
				new ItemStack(Items.emerald,20)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProArmorsmith.class,
				ProWeaponsmith.class
				};
	}

}
