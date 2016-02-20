package ckhbox.villagebento.common.block.tool;

import java.util.List;
import java.util.Random;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.Rand;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBanner;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntityBanner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAlchemyPot extends Block {
	public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 3);

    public BlockAlchemyPot()
    {
        super(Material.iron);
        this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
        this.setUnlocalizedName(PathHelper.full("alchemypot"));
		this.setHardness(1.0F);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    /**
     * Add all collision boxes of this Block to the list that intersect with the given mask.
     */
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List<AxisAlignedBB> list, Entity collidingEntity)
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        float f = 0.025F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
        this.setBlockBoundsForItemRender();
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }

    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        int i = ((Integer)state.getValue(LEVEL)).intValue();
        float f = (float)pos.getY() + (6.0F + (float)(3 * i)) / 16.0F;

        if (!worldIn.isRemote && entityIn.isBurning() && i > 0 && entityIn.getEntityBoundingBox().minY <= (double)f)
        {
            entityIn.extinguish();
            this.setWaterLevel(worldIn, pos, state, i - 1);
        }
        
        i = ((Integer)state.getValue(LEVEL)).intValue();
        
        if(!worldIn.isRemote  && i > 0 && entityIn instanceof EntityItem){
        	EntityItem entityItem = (EntityItem)entityIn;
        	Item item = entityItem.getEntityItem().getItem();
        	if(item != ModItems.bronzeCoin && item != ModItems.silverCoin && item != ModItems.goldCoin){
            	if(Rand.get().nextInt(30) == 0){
            		this.setWaterLevel(worldIn, pos, state, i - 1);
            	}
            	
            	if(entityItem.getEntityItem().stackSize == 1 && Rand.get().nextInt(5) == 0){
            		entityIn.playSound("random.orb", 0.6F, Rand.get().nextFloat() * 0.4F + 0.8F);
                	this.dropCoin(worldIn,pos.getX(),pos.getY(),pos.getZ());
            	}
            	else{
            		entityIn.playSound("game.neutral.swim.splash", 0.3F, Rand.get().nextFloat() * 0.4F + 0.8F);	
            	}
            	entityItem.setDead();
        	}
        }
        
    }
    
    private void dropCoin(World world, int x, int y, int z){
    	int count = Rand.get().nextInt(2) + 1;
        EntityItem entityitem = new EntityItem(world, x + 0.5F, y + 1.0F, z + 0.5F, new ItemStack(ModItems.bronzeCoin,count));
		entityitem.setDefaultPickupDelay();
		world.spawnEntityInWorld(entityitem);
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
            ItemStack itemstack = playerIn.inventory.getCurrentItem();

            if (itemstack == null)
            {
                return true;
            }
            else
            {
                int i = ((Integer)state.getValue(LEVEL)).intValue();
                Item item = itemstack.getItem();

                if (item == Items.water_bucket)
                {
                    if (i < 3)
                    {
                        if (!playerIn.capabilities.isCreativeMode)
                        {
                            playerIn.inventory.setInventorySlotContents(playerIn.inventory.currentItem, new ItemStack(Items.bucket));
                        }

                        playerIn.triggerAchievement(StatList.field_181725_I);
                        this.setWaterLevel(worldIn, pos, state, 3);
                    }

                    return true;
                }
                else{
                	return false;
                }
            }
        }
    }

    public void setWaterLevel(World worldIn, BlockPos pos, IBlockState state, int level)
    {
        worldIn.setBlockState(pos, state.withProperty(LEVEL, Integer.valueOf(MathHelper.clamp_int(level, 0, 3))), 2);
        worldIn.updateComparatorOutputLevel(pos, this);
    }

    /**
     * Called similar to random ticks, but only when it is raining.
     */
    public void fillWithRain(World worldIn, BlockPos pos)
    {
        if (worldIn.rand.nextInt(20) == 1)
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);

            if (((Integer)iblockstate.getValue(LEVEL)).intValue() < 3)
            {
                worldIn.setBlockState(pos, iblockstate.cycleProperty(LEVEL), 2);
            }
        }
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return ((Integer)worldIn.getBlockState(pos).getValue(LEVEL)).intValue();
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(LEVEL, Integer.valueOf(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((Integer)state.getValue(LEVEL)).intValue();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {LEVEL});
    }
}
