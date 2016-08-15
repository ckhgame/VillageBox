package ckhbox.villagebox.common.item.common;

import ckhbox.villagebox.common.item.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDrink extends ItemFood{

	private int drunkticks;
	
	public ItemDrink(int amount, float saturation, int drunktime) {
		super(amount, saturation, false);
		this.setCreativeTab(ModItems.tabVB);
		this.drunkticks = drunktime * 20;
		this.setAlwaysEdible();
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
		super.onFoodEaten(stack, worldIn, player);
		player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA,this.drunkticks));
	}
	
	

}
