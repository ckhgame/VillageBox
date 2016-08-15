package ckhbox.villagebox.common.item.tool;

import java.util.Random;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.storage.WorldInfo;

public class ItemWeatherStone extends Item{
	
	private boolean sunny;
	
	public ItemWeatherStone(boolean sunny){
		
		this.sunny = sunny;
			
		this.setUnlocalizedName(PathHelper.full(sunny?"sunStone":"rainStone"));
		this.setCreativeTab(ModItems.tabVB);
		this.maxStackSize = 1;
        this.setMaxDamage(1);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
        	if(this.sunny == worldIn.isRaining()){
        		itemStackIn.damageItem(2, playerIn);
        	}
        }
        
        playerIn.playSound(SoundEvents.entity_player_levelup, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        
      //changes weather
        if(!worldIn.isRemote){       	
            if(this.sunny && !worldIn.isRaining()){
            	playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.player.weatherstone.alreadysunny")));
            }
            else if(!this.sunny && worldIn.isRaining()){
            	playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.player.weatherstone.alreadyraining")));
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
            	 playerIn.addChatMessage(new TextComponentTranslation(PathHelper.full("message.player.weatherstone.changed")));
            }
           
        }

        return new ActionResult(EnumActionResult.PASS, itemStackIn);
    }
}
