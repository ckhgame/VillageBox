package ckhbox.villagebox.common.item.tool;

import java.util.Set;

import com.google.common.collect.Sets;

import ckhbox.villagebox.common.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ItemAxe extends net.minecraft.item.ItemTool{

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block, Blocks.ladder, Blocks.wooden_button, Blocks.wooden_pressure_plate});
	
	public ItemAxe(ToolMaterial material) {
		super(material, EFFECTIVE_ON);
		this.damageVsEntity = 8.0F;
        this.attackSpeed = -3.0F;
		this.setCreativeTab(ModItems.tabVB);
	}
	
    public float getStrVsBlock(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.wood && material != Material.plants && material != Material.vine ? super.getStrVsBlock(stack, state) : this.efficiencyOnProperMaterial;
    }

}
