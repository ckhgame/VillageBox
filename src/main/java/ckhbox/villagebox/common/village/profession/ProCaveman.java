package ckhbox.villagebox.common.village.profession;

import java.util.ArrayList;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ProCaveman extends Profession{

	@Override
	protected void initTradingRecipeList() {
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.cobblestone,10)},
				new ItemStack(Items.bone)));
		this.tradingRecipeList.add(new TradingRecipe(
				new ItemStack[]{new ItemStack(Blocks.cobblestone,64)},
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
	
	@Override
	protected void initQuests() {
		this.quests = new ArrayList<Quest>();
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.cooked_chicken,1)},
				new ItemStack[]{new ItemStack(Blocks.cobblestone,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.cooked_fish,1)},
				new ItemStack[]{new ItemStack(Blocks.cobblestone,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.cooked_porkchop,1)},
				new ItemStack[]{new ItemStack(Blocks.cobblestone,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.cooked_rabbit,1)},
				new ItemStack[]{new ItemStack(Blocks.cobblestone,16)}));
		this.quests.add(new Quest(
				new ItemStack[]{new ItemStack(Items.beef,1)},
				new ItemStack[]{new ItemStack(Blocks.cobblestone,16)}));
	}
}
