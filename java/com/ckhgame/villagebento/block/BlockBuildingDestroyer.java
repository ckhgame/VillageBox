package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.network.VBNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockBuildingDestroyer extends Block {

    protected BlockBuildingDestroyer() {
        super(Material.wood);
        this.setBlockName("BlockBuildingDestroyer");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":"+"BlockBuildingDestroyer");
        this.setStepSound(soundTypeWood);
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(!world.isRemote || world.provider.dimensionId !=0){
			
			if(Building.destroy(world, x, y, z)){
				//refresh village outlines
				DataVillageBento dataVB = DataVillageBento.get();			
				MessageVillageOutlinesChanged msg = new MessageVillageOutlinesChanged();
				msg.listOutlines = HelperDataVB.getVillageOutlines(dataVB,player.getDisplayName());			
				VBNetwork.networkWrapper.sendToAll(msg);
			}
		}	
		return true;
	}
}