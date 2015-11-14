package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.util.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockVillagerHomeTP extends Block {

    protected BlockVillagerHomeTP() {
        super(Material.wood);
        this.setBlockName("BlockVillagerHomeTP");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":"+"BlockVillagerHomeTP");
        this.setStepSound(soundTypeWood);
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(!world.isRemote && world.provider.dimensionId ==0){
			
			DataBuilding db = HelperDataVB.findBuildingByPos(DataVillageBento.get(), x, y, z);
			if(db != null){
				world.setBlockToAir(x, y, z);			
				HelperDataVB.tpEntityVillagersInbuildingToInitPos(DataVillageBento.get(), db);
			}
			else{
				PlayerMsg.send(player, "You can't use it here!");
			}
		}	
		return true;
	}
}