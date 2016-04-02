package ckhbox.villagebox.common.block.tool;

import java.util.List;
import java.util.Random;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
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

public class BlockMagicTrashCan extends Block {

    public BlockMagicTrashCan()
    {
        super(Material.iron);
        this.setUnlocalizedName(PathHelper.full("magicTrashCan"));
		this.setHardness(1.0F);
		this.setCreativeTab(ModItems.tabVB);
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
        if(!worldIn.isRemote  && entityIn instanceof EntityItem){
        	EntityItem entityItem = (EntityItem)entityIn;
        	Item item = entityItem.getEntityItem().getItem();
        	if(item != ModItems.bronzeCoin && item != ModItems.silverCoin && item != ModItems.goldCoin){
            	if(entityItem.getEntityItem().stackSize == 1 && Rand.get().nextInt(3) == 0){
            		entityIn.playSound("random.orb", 0.6F, Rand.get().nextFloat() * 0.4F + 0.8F);
                	this.dropCoin(worldIn,pos.getX(),pos.getY(),pos.getZ());
            	}
            	else{
            		//entityIn.playSound("dig.sand", 0.3F, Rand.get().nextFloat() * 0.4F + 0.8F);	
            	}
            	entityItem.setDead();
        	}
        }
        
    }
    
    private void dropCoin(World world, int x, int y, int z){
    	int count = Rand.get().nextInt(1) + 1;
        EntityItem entityitem = new EntityItem(world, x + 0.5F, y + 1.0F, z + 0.5F, new ItemStack(ModItems.bronzeCoin,count));
		entityitem.setDefaultPickupDelay();
		world.spawnEntityInWorld(entityitem);
    }

}
