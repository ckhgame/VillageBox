package ckhbox.villagebox.common.block.tool;

import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoublePlant;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockBuildBox extends Block{

	public static enum BuildSize{
		
		ExLarge("buildboxExLarge",5, 5),
		Large("buildboxLarge",4, 5),
		Medium("buildboxMedium",3, 4),
		Small("buildboxSmall",2, 4);
		
		public final String name;
		public final int radius;
		public final int height;
		private BuildSize(String name, int radius, int height){
			this.name = name;
			this.radius = radius;
			this.height = height;
		}
	}
	
	private BuildSize size;
	
	public BlockBuildBox(BuildSize size) {
		super(Material.wood);
		this.size = size;
		this.setUnlocalizedName(PathHelper.full(size.name));
		this.setHardness(1.0F);
		this.setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		
		if(!worldIn.isRemote){
			//remove buildbox
			worldIn.setBlockToAir(pos);
			
			build(worldIn, pos, false);
		}
		
		return true;
	}
	
	private void build(World world, BlockPos pos, boolean removeOld){
		
		int xmin = pos.getX() - size.radius - 1;
		int xmax = pos.getX() + size.radius + 1;
		int zmin = pos.getZ() - size.radius - 1;
		int zmax = pos.getZ() + size.radius + 1;
		int ymin = pos.getY() - 1;
		int ymax = pos.getY() - 1 + size.height;
		
		IBlockState bsp = Blocks.planks.getDefaultState();
		IBlockState bss = Blocks.stonebrick.getDefaultState();
		IBlockState bsw = Blocks.glass_pane.getDefaultState();
//		BlockPlanks.EnumType ptRoof = BlockPlanks.EnumType.DARK_OAK;
//		BlockPlanks.EnumType ptWall = BlockPlanks.EnumType.BIRCH;
//		BlockPlanks.EnumType ptFloor = BlockPlanks.EnumType.OAK;
		
		int flags = 1|2;
		
		for(int x = xmin;x <= xmax; x++){
			for(int z = zmin; z <= zmax; z++){
				for(int y = ymin; y <= ymax; y++){
					if(y == ymin){//floor
						if(world.isAirBlock(new BlockPos(x,y,z)) || removeOld) world.setBlockState(new BlockPos(x,y,z), bsp);
					}
					else if(y == ymax)//roof
					{
						if(world.isAirBlock(new BlockPos(x,y,z)) || removeOld) world.setBlockState(new BlockPos(x,y,z), bsp);
					}
					else if(x != xmin && z != zmin && x != xmax && z != zmax){//empty space
						if(world.isAirBlock(new BlockPos(x,y,z)) || removeOld) world.setBlockToAir(new BlockPos(x,y,z));
					}
					else{//wall
						if((y == ymin + 2 || y == ymin + 3) && (x == pos.getX() || z == pos.getZ())){//window
							if(world.isAirBlock(new BlockPos(x,y,z)) || removeOld) world.setBlockState(new BlockPos(x,y,z),bsw);
						}
						else if( y == ymin + 1){//walls (first layer)
							if(world.isAirBlock(new BlockPos(x,y,z)) || removeOld) world.setBlockState(new BlockPos(x,y,z),bss);
						}
						else{//walls (the rest)
							if(world.isAirBlock(new BlockPos(x,y,z)) || removeOld) world.setBlockState(new BlockPos(x,y,z),bsp);
						}
					}
					
				}
			}
		}
		
	}
}
