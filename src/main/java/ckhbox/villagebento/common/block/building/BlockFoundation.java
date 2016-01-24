package ckhbox.villagebento.common.block.building;

import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.IntBoundary;
import ckhbox.villagebento.common.util.math.IntVec3;
import ckhbox.villagebento.common.util.tool.HouseDetector;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockFoundation extends Block{

	public BlockFoundation() {
		super(Material.rock);
		this.setUnlocalizedName(PathHelper.full("fundation"));
		this.setBlockUnbreakable();
		this.setResistance(60000000.0F);
		this.disableStats();
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote){
			IntBoundary bound = HouseDetector.getClosedField(worldIn, new IntVec3(pos.getX(),pos.getY(),pos.getZ()));
			
			System.out.println(bound == null?"not a closed space":bound.toString());
		}

		return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
	}

	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		super.onBlockClicked(worldIn, pos, playerIn);
	}
	
	
	
}
