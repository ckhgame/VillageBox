package com.ckhgame.villagebento.item;

import java.util.List;

import com.ckhgame.villagebento.block.BlockVillageBuilding;
import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.config.ConfigBuilding;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockVillageBuilding extends ItemBlock{

	BlockVillageBuilding blockVillageBuilding;
	
	public ItemBlockVillageBuilding(Block block) {
		super(block);

		blockVillageBuilding = (BlockVillageBuilding)block;
	}

	@Override
	public void addInformation(ItemStack p_77624_1_, EntityPlayer p_77624_2_, List list, boolean p_77624_4_) {
		// TODO Auto-generated method stub
		super.addInformation(p_77624_1_, p_77624_2_, list, p_77624_4_);
		
		Building b = Building.registry.get(blockVillageBuilding.getBuildingClass());
		if(b != null){
			int sizeType = b.getSizeType();
			int xs = 0;
			int zs = 0;
			switch(sizeType){
			case ConfigBuilding.SizeType_Small:
				xs = ConfigBuilding.GroundWorkSmallSizeX;
				zs = ConfigBuilding.GroundWorkSmallSizeZ;
				break;
			case ConfigBuilding.SizeType_Medium:
				xs = ConfigBuilding.GroundWorkMediumSizeX;
				zs = ConfigBuilding.GroundWorkMediumSizeZ;
				break;
			case ConfigBuilding.SizeType_Large:
				xs = ConfigBuilding.GroundWorkLargeSizeX;
				zs = ConfigBuilding.GroundWorkLargeSizeZ;
				break;
			}
			xs = xs * 2 + 1;
			zs = zs * 2 + 1;
			list.add("Size: " + xs +" x " + zs);
		}
	}
	
	
}
