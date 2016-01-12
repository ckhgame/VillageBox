package com.ckhgame.villagebento.item;

import com.ckhgame.villagebento.Main;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFoodVB extends ItemFood{
	
	private PotionEffect[] effects;
	
	public ItemFoodVB(int healAmount, float saturationModifier, String name, PotionEffect... effects){
		super(healAmount,saturationModifier,false);
		this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + name);
		this.effects = effects;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
	    super.onFoodEaten(stack, world, player);
	        
	    for (int i = 0; i < effects.length; i ++) {
	        if (!world.isRemote && effects[i] != null && effects[i].getPotionID() > 0)
	            player.addPotionEffect(new PotionEffect(this.effects[i].getPotionID(), this.effects[i].getDuration(), this.effects[i].getAmplifier(), this.effects[i].getIsAmbient()));
	    }
	}
}
