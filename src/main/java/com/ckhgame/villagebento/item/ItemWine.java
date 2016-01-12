package com.ckhgame.villagebento.item;

import com.ckhgame.villagebento.Main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemPotion;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWine extends ItemFoodVB{

	private int healingHP;
	
	public ItemWine(int healingHP, String name, PotionEffect... effects) {
		super(0, 0, name, effects);
		this.healingHP = healingHP;
	}
	
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.drink;
    }
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
	    super.onFoodEaten(stack, world, player);
	    if(!world.isRemote){
	    	player.heal(healingHP);
	    }
	}

}
