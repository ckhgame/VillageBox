package com.ckhgame.villagebento.item;

import java.util.Arrays;
import java.util.List;

import com.ckhgame.villagebento.util.data.WRChestItem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

public class ItemVBChest extends ItemVB {
	
	public static final List randChestWood		= Arrays.asList(new WRChestItem[] {
			new WRChestItem(5,Blocks.log, 5, 10, 0),
			new WRChestItem(5,Blocks.log, 5, 10, 1),
			new WRChestItem(5,Blocks.log, 5, 10, 2),
			new WRChestItem(5,Blocks.log, 5, 10, 3)
	});
    public static final List randChestIron 		= Arrays.asList(new WRChestItem[] {
    		new WRChestItem(10,Items.iron_axe, 1, 1),
			new WRChestItem(5,Items.iron_ingot, 1, 1)
    });
    public static final List randChestGolden	= Arrays.asList(new WRChestItem[] {
    		new WRChestItem(10,Items.golden_axe, 1, 1),
			new WRChestItem(5,Items.gold_ingot, 1, 1)
    });
	
    private List itemList;
    
	public ItemVBChest(String name,String info, CreativeTabs tab, List itemList){
		super(name,info,tab);
		this.itemList = itemList;
	}

	
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		
		if(!world.isRemote){	
			if(this.itemList != null){
				--itemStack.stackSize;
				ItemStack newItem = ((WRChestItem)WeightedRandom.getRandomItem(world.rand, this.itemList)).getItemStack();
				world.playSoundAtEntity(player, "random.pop", 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				if(!player.inventory.addItemStackToInventory(newItem)){
					player.dropPlayerItemWithRandomChoice(newItem, false);
				}
			}
		}
		return super.onItemRightClick(itemStack, world, player);
	}
	
	
}
