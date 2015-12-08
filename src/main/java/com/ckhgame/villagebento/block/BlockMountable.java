package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.misc.EntityBlockMountable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockMountable extends BlockCustom{
		
		protected BlockMountable(String name, ModelBase model, String mcTexture) {
			super(name, model, mcTexture);
			this.setBlockBounds(0.125F, 0.0F, 0.125F, 0.875F, 0.5F, 0.875F);
		}

		@Override
		public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
			
			if(!world.isRemote){ // server only
				EntityBlockMountable entityBlockMountable = new EntityBlockMountable(world);
				entityBlockMountable.setPosition(x + 0.5D, y + 0.5D, z + 0.5D);
				world.spawnEntityInWorld(entityBlockMountable);
				player.mountEntity(entityBlockMountable);
				//entityBlockMountable.setMountTileEntity(this.getTileEntityBlockCustom());
			}
		
			return true;
		}
}
