package com.ckhgame.villagebento.item;

import java.util.Arrays;
import java.util.List;

import com.ckhgame.villagebento.util.data.WRChestItem;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import cpw.mods.fml.common.toposort.ModSorter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

public class ItemVBChest extends ItemVB {
	
	public static final List randChestIron		= Arrays.asList(new WRChestItem[] {
			new WRChestItem(2,ModItems.itemCabbageSeed, 1, 2),
			new WRChestItem(2,ModItems.itemRiceSeed, 1, 2),
			new WRChestItem(2,ModItems.itemCornSeed, 1, 2),
			new WRChestItem(4,Items.coal, 1, 2),
			new WRChestItem(4,Items.iron_ingot, 1, 2),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 13),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 19),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 22),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 24),
			new WRChestItem(1,Items.iron_boots, 1,1),
			new WRChestItem(1,Items.iron_helmet, 1,1),
			new WRChestItem(1,Items.iron_sword, 1,1),
			new WRChestItem(3,Items.arrow, 5,10),
			new WRChestItem(6,ModItems.itemSeaweed, 1, 3, 1)
	});
    public static final List randChestGolden 		= Arrays.asList(new WRChestItem[] {
    		new WRChestItem(6,ModItems.itemGrapeSeed, 1, 2),
			new WRChestItem(6,ModItems.itemChiliSeed, 1, 2),
			new WRChestItem(6,ModItems.itemSoybeanSeed, 1, 2),
			new WRChestItem(8,Items.iron_ingot, 2, 4),
			new WRChestItem(8,Items.gold_ingot, 1, 2),
			new WRChestItem(4,ModItems.itemVillageCurrency, 1,1, 27),
			new WRChestItem(4,ModItems.itemVillageCurrency, 1,1, 34),
			new WRChestItem(4,ModItems.itemVillageCurrency, 1,1, 55),
			new WRChestItem(4,ModItems.itemVillageCurrency, 1,1, 43),
			new WRChestItem(1,Items.potionitem, 1,1,8193),
			new WRChestItem(1,Items.potionitem, 1,1,8194),
			new WRChestItem(1,Items.potionitem, 1,1,8195),
			new WRChestItem(1,Items.potionitem, 1,1,8197),
			new WRChestItem(1,Items.potionitem, 1,1,8198),
			new WRChestItem(1,Items.potionitem, 1,1,8201),
			new WRChestItem(1,Items.potionitem, 1,1,8203),
			new WRChestItem(1,Items.potionitem, 1,1,8205),
			new WRChestItem(12,ModItems.itemSeaweed, 1, 5, 1)
    });
    public static final List randChestDiamond	= Arrays.asList(new WRChestItem[] {
    		new WRChestItem(2,Items.diamond, 1, 2),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 202),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 168),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 233),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 184),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 247),
			new WRChestItem(2,ModItems.itemVillageCurrency, 1,1, 171),
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
				ItemStack newItem = ((WRChestItem)WeightedRandom.getRandomItem(world.rand, this.itemList)).getItemStack().copy();
				world.playSoundAtEntity(player, "random.pop", 0.2F, ((world.rand.nextFloat() - world.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
				
				int num = 0;				
				
				if(newItem.getItem() == ModItems.itemVillageCurrency){
					num = newItem.getItemDamage();
					HelperPlayer.addCurrency(player, newItem.getItemDamage());
				}
				else{
					num = newItem.stackSize;
					if(!player.inventory.addItemStackToInventory(newItem)){
						player.dropPlayerItemWithRandomChoice(newItem, false);
					}
				}			
				
				PlayerMsg.sendTranslation(player, "villagebento.msg.openFishingChest",  new ChatComponentTranslation(newItem.getUnlocalizedName() + ".name"), num);
				
			}
		}
		return super.onItemRightClick(itemStack, world, player);
	}
	
	
}
