package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public abstract class ProVillager extends Profession{
	
	@Override
	protected void initAttributes() {
		this.maxEnegy = 45;
		this.maxProficiency = 30;
	}

	@Override
	protected String getUnlocalized() {
		return PathHelper.full("profession.villager");
	}

	@Override
	protected void initUpgradeOptions() {
		this.upgradeToCurentNeeds = null;
		this.upgradeToNextOptionClasses = new Class[]{
				ProFarmer.class,
				ProMiner.class,
				ProWoodcutter.class,
				ProScholar.class
				};
	}

}
