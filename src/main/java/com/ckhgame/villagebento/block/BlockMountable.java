package com.ckhgame.villagebento.block;

import java.util.List;

import com.ckhgame.villagebento.entity.misc.EntityBlockMountable;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockMountable extends BlockCustom{
		
		protected BlockMountable(String name, ModelBase model, String mcTexture) {
			super(name, model, mcTexture);
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.5F, 0.875F);
		}

		@Override
		public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
			
			if(!world.isRemote){ // server only
				if(isRiddenByEntity(world,x,y,z)){
					System.out.println("that one is ridden by someone..");
				}
				else{
					EntityBlockMountable entityBlockMountable = new EntityBlockMountable(world);
					entityBlockMountable.setPosition(x + 0.5D, y + 0.5D, z + 0.5D);
					world.spawnEntityInWorld(entityBlockMountable);
					player.mountEntity(entityBlockMountable);
				}
			}
		
			return true;
		}
		
		public boolean isRiddenByEntity(World world, int x, int y,int z){
			List l = world.getEntitiesWithinAABB(EntityBlockMountable.class, AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D));
			return !(l == null || l.size() == 0);
		}
		
		public boolean activedByEntityVBVillager(EntityVBVillager villager, int x, int y, int z){
							
			if(!villager.worldObj.isRemote){ // server only
				if(isRiddenByEntity(villager.worldObj,x,y,z)){
					System.out.println("that one is ridden by someone..");
					return false;
				}
				else{
					EntityBlockMountable entityBlockMountable = new EntityBlockMountable(villager.worldObj);
					entityBlockMountable.setPosition(x + 0.5D, y + 0.5D, z + 0.5D);
					villager.worldObj.spawnEntityInWorld(entityBlockMountable);
					villager.mountEntity(entityBlockMountable);
					return true;
				}
			}
			return false;
		}

		@Override
		public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	    {
	        return null;
	    }
		
		
}
