package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockVillageWool extends BlockMeta{

	public BlockVillageWool() {
		super("BlockVillageWool",Main.MODID + ":" + "villagewool",Material.cloth,16);
		this.setHardness(0.8F);
		this.setStepSound(Block.soundTypeCloth);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
}
