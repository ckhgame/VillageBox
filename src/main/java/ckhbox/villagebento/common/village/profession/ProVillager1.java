package ckhbox.villagebento.common.village.profession;

import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class ProVillager1 extends ProVillager{

	@Override
	protected void initTexture() {
		this.texture = new ResourceLocation(PathHelper.full("textures/entity/villager/villager1.png"));
	}


}
