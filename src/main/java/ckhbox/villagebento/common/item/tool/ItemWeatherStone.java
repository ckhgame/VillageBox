package ckhbox.villagebento.common.item.tool;

import java.util.Random;

import ckhbox.villagebento.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class ItemWeatherStone extends Item{
	
	private boolean sunny;
	
	public ItemWeatherStone(boolean sunny){
		
		this.sunny = sunny;
			
		this.setUnlocalizedName(PathHelper.full(sunny?"sunStone":"rainStone"));
		this.setCreativeTab(CreativeTabs.tabTools);
		this.maxStackSize = 1;
        this.setMaxDamage(1);
	}
	
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
        	if(this.sunny == worldIn.isRaining()){
        		itemStackIn.damageItem(2, playerIn);
        	}
        }

        playerIn.swingItem();
        
        worldIn.playSoundAtEntity(playerIn, "random.levelup", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        
      //changes weather
        if(!worldIn.isRemote){       	
            if(this.sunny && !worldIn.isRaining()){
            	playerIn.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.player.weatherstone.alreadysunny")));
            }
            else if(!this.sunny && worldIn.isRaining()){
            	playerIn.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.player.weatherstone.alreadyraining")));
            }
            else{
            	WorldInfo worldinfo = worldIn.getWorldInfo();
            	 int t = (300 + (new Random()).nextInt(600)) * 20;
            	 if(this.sunny){
            		 worldinfo.setCleanWeatherTime(t);
                     worldinfo.setRainTime(0);
                     worldinfo.setThunderTime(0);
                     worldinfo.setRaining(false);
                     worldinfo.setThundering(false); 
            	 }
            	 else{
            		 worldinfo.setCleanWeatherTime(0);
                     worldinfo.setRainTime(t);
                     worldinfo.setThunderTime(t);
                     worldinfo.setRaining(true);
                     worldinfo.setThundering(false);
            	 }
            	 playerIn.addChatMessage(new ChatComponentTranslation(PathHelper.full("message.player.weatherstone.changed")));
            }
           
        }

        return itemStackIn;
    }
}
