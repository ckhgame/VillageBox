package com.ckhgame.villagebento.items;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.rendering.VillageOutlines;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVillageStick extends Item {
	public ItemVillageStick(){
		super();
		this.setUnlocalizedName("ItemVillageStick");
		this.setTextureName(Main.MODID + ":itemvillagestick");
		this.setCreativeTab(CreativeTabs.tabTools);
	}

	@SideOnly(Side.CLIENT)
	private static boolean villageOutlinesEnabled = false;
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer p_77659_3_) {
				
		if(!world.isRemote){		
		
			//enable or disable outlines
			DataVillageBento villageBentoData = DataVillageBento.get(world);
			VillageOutlines.getInstance().setVillageBentoData(villageOutlinesEnabled?null:villageBentoData);
			villageOutlinesEnabled = !villageOutlinesEnabled;
			
			/*
			System.out.println("Current Buildings:");
			for(BuildingData bd:villageBentoData.buildings){
				System.out.println("===========");
				System.out.println("X:"+bd.x);
				System.out.println("Z:"+bd.z);
				System.out.println("W:"+(bd.sizeX * 2 + 1));
				System.out.println("H:"+(bd.sizeZ * 2 + 1));
				System.out.println("Y:"+bd.y);
				System.out.println("T:"+bd.type);
			}
			*/

		}
		
		return itemStack;
	}	
}
