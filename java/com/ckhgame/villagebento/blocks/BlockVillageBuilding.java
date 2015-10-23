package com.ckhgame.villagebento.blocks;

import java.util.Random;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.BuilderBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helpers.HelperDataVB;
import com.ckhgame.villagebento.network.VBNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;

public class BlockVillageBuilding extends Block {

    protected BlockVillageBuilding(int buildingType,String name) {
        super(Material.wood);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":"+name);
      //  this.setHardness(2.0F);
       // this.setResistance(6.0F);
        this.setLightLevel(1.0F);
        //this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeWood);
        
        this.buildingType = buildingType;
    }

    private final int buildingType;
    
    private DataVillageBento villageBentoData = null;
    
    private boolean villageOutlinesEnabled = false;
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(world.isRemote || world.provider.dimensionId !=0) return true;
		else{
			//destroy the village block
			world.func_147480_a(x, y, z, false);
			
			if(BuilderBuilding.build(world, player, x, y, z, this.buildingType)){
				//refresh village outlines
				DataVillageBento dataVB = DataVillageBento.get(world);			
				MessageVillageOutlinesChanged msg = new MessageVillageOutlinesChanged();
				msg.listOutlines = HelperDataVB.getVillageOutlines(dataVB);			
				VBNetwork.networkWrapper.sendToAll(msg);
			}
			 
			return true;
		}	
	}
}