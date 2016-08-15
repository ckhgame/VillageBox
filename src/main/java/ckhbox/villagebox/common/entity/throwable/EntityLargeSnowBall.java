package ckhbox.villagebox.common.entity.throwable;

import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;

public class EntityLargeSnowBall extends EntityThrowable
{
	public EntityLargeSnowBall(World worldIn)
    {
        super(worldIn);
    }

    public EntityLargeSnowBall(World worldIn, EntityLivingBase throwerIn)
    {
        super(worldIn, throwerIn);
    }

    public EntityLargeSnowBall(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
    	if (!this.worldObj.isRemote){
            if (result.entityHit != null)
            {
                int i = 0;

                if (result.entityHit instanceof EntityBlaze)
                {
                    i = 3;
                }

                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)i);
            }

            
            if(result.typeOfHit != Type.MISS){
                BlockPos pos;
                if(result.typeOfHit == Type.BLOCK){
                	pos = result.getBlockPos();
                }
                else{
                	pos = new BlockPos(result.entityHit);
                }
                updateNearbyBlocks(pos);
            }
    	}
        
        for (int j = 0; j < 16; ++j)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
    
    private void updateNearbyBlocks(BlockPos center){
    	int s = 3;
    	int h = 2;
    	float r2 = (s + 1.0F) * (s + 1.0F);
    	for(int x = -s; x <= s; x++){
    		for(int z = -s; z <= s; z++){
    			float dx = Math.abs(x) + 0.5F;
    			float dz = Math.abs(z) + 0.5F;
    			if(dx * dx + dz * dz <= r2){
            		for(int y = h; y >= -h; y--){
            			BlockPos p = new BlockPos(center.getX() + x, center.getY() + y, center.getZ() + z);
            			if (worldObj.getBlockState(p).getMaterial() == Material.AIR && Blocks.SNOW_LAYER.canPlaceBlockAt(worldObj, p))
            	        {
            	            worldObj.setBlockState(p, Blocks.SNOW_LAYER.getDefaultState());           
            	        }
            			else if (worldObj.getBlockState(p).getMaterial() == Material.WATER)
            	        {
            	            worldObj.setBlockState(p, Blocks.ICE.getDefaultState());           
            	        }
            			else if (worldObj.getBlockState(p).getBlock() == Blocks.LAVA)
            	        {
            	            worldObj.setBlockState(p, Blocks.OBSIDIAN.getDefaultState());           
            	        }
            			else if (worldObj.getBlockState(p).getMaterial() == Material.FIRE)
            	        {
            				this.worldObj.setBlockState(p, Blocks.AIR.getDefaultState());
            	        }
            		}
    			}
        	}
    	}
    }  
}