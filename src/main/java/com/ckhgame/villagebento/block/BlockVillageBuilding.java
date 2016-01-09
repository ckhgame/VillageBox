package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.network.VBNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class BlockVillageBuilding extends Block {

    protected BlockVillageBuilding(Class<? extends Building> bc,String name,boolean hasOwner) {
        super(Material.wood);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":"+name);
        this.setStepSound(soundTypeWood);
        
        this.hasOwner = hasOwner;
        
        this.buildingClass = bc;
    }
    
    protected BlockVillageBuilding(Class<? extends Building> bc,String name) {
    	this(bc,name,false);
    }

    private boolean hasOwner; //if hasOwner is true, the building has an player as its owner, which is used in buildings such as player custom fields 
    
    private final Class<? extends Building> buildingClass;
    public Class<? extends Building> getBuildingClass(){
    	return buildingClass;
    }
    
    private DataVillageBento villageBentoData = null;
    
    private boolean villageOutlinesEnabled = false;
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(!world.isRemote || world.provider.dimensionId !=0){
			//the player must be very close to the block to use it
			if(player.getDistance(x, y, z) < 1.5){
				
				int sizeType = Building.registry.get(this.buildingClass).getSizeType();
				int xs = 0;
				switch(sizeType){
				case ConfigBuilding.SizeType_Small:
					xs = ConfigBuilding.GroundWorkSmallSizeX;
					break;
				case ConfigBuilding.SizeType_Medium:
					xs = ConfigBuilding.GroundWorkMediumSizeX;
					break;
				case ConfigBuilding.SizeType_Large:
					xs = ConfigBuilding.GroundWorkLargeSizeX;
					break;
				}
				
				int bx = x;
				int by = y;
				int bz = z;
				
				Vec3 lv = player.getLookVec();
				if(Math.abs(lv.xCoord) >= Math.abs(lv.yCoord)){
					if(lv.xCoord < 0) bx -= xs;
					else bx += xs;
				}
				else{
					if(lv.zCoord < 0) bz -= xs;
					else bz += xs;
				}
				
				if(Building.build(world, player, bx, by, bz, this.buildingClass,hasOwner)){
					
					//refresh village outlines
					DataVillageBento dataVB = DataVillageBento.get();			
					MessageVillageOutlinesChanged msg = new MessageVillageOutlinesChanged();
					msg.listOutlines = HelperDataVB.getVillageOutlines(dataVB,player.getDisplayName());			
					VBNetwork.networkWrapper.sendToAll(msg);
				}
				else{
					PlayerMsg.send(player, "Sorry, You can't build it here!");
				}
			} 
			else{
				PlayerMsg.send(player, "Please get closer to the block");
			}
		}	
		return true;
	}
}