package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProBlacksmith extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(ModItems.silverCoin,1),new ItemStack(Items.IRON_INGOT,3)},
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
				new ItemStack(Items.COAL,10),
				new ItemStack(Items.IRON_INGOT,2),
				new ItemStack(ModItems.silverCoin, 2)
		};
		
		this.upgradeToNextOptionClasses = new Class[]{
				ProArmorsmith.class,
				ProWeaponsmith.class,
				ProToolsmith.class
				};
	}
	
	@Override
	protected void initHoldItems() {
		this.holdItems = new ItemStack[]{
				new ItemStack(Items.COAL),
				new ItemStack(Items.LAVA_BUCKET)
		};
	}
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.COAL,8)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,10)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.FURNACE,1)},
				new ItemStack[]{new ItemStack(ModItems.bronzeCoin,15)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Blocks.FURNACE,1)},
				new ItemStack[]{new ItemStack(ModItems.steelIngot)}));
	}

}
