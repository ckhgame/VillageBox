package com.ckhgame.villagebento.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlockWithMetadata;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlockWithMetadata {

    public ItemBlockMeta(Block block) {
            super(block, block);
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + stack.getItemDamage();
    }
}

