package com.ckhgame.villagebento.block;

import java.util.List;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.misc.EntityBuildingIndicator;
import com.ckhgame.villagebento.entity.misc.EntityBuildingIndicatorLarge;
import com.ckhgame.villagebento.entity.misc.EntityBuildingIndicatorMedium;
import com.ckhgame.villagebento.entity.misc.EntityBuildingIndicatorSmall;
import com.ckhgame.villagebento.network.VBNetwork;
import com.ckhgame.villagebento.network.message.MessageVillageOutlinesChanged;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
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
	public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_,
			float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
		
		if(!p_149660_1_.isRemote){
			EntityBuildingIndicator indicator = null;
			
			int sizeType = Building.registry.get(this.buildingClass).getSizeType();
			int xs = 0;
			int zs = 0;
			switch(sizeType){
			case ConfigBuilding.SizeType_Small:
				indicator = new EntityBuildingIndicatorSmall(p_149660_1_);
				break;
			case ConfigBuilding.SizeType_Medium:
				indicator = new EntityBuildingIndicatorMedium(p_149660_1_);
				break;
			case ConfigBuilding.SizeType_Large:
				indicator = new EntityBuildingIndicatorLarge(p_149660_1_);
				break;
			}
			if(indicator != null){
				indicator.setPosition(p_149660_2_ + 0.5D, p_149660_3_+ 1.0D, p_149660_4_+ 0.5D);
				p_149660_1_.spawnEntityInWorld(indicator);
			}
		}
		
		return super.onBlockPlaced(p_149660_1_, p_149660_2_, p_149660_3_, p_149660_4_, p_149660_5_, p_149660_6_, p_149660_7_,
				p_149660_8_, p_149660_9_);
	}

	@Override
	public void onBlockPreDestroy(World world, int x, int y, int z,
			int oldmeta) {
		
		List l = world.getEntitiesWithinAABB(EntityBuildingIndicator.class, AxisAlignedBB.getBoundingBox(x, y, z, x + 1.0D, y + 1.5D, z + 1.0D));
		if(l != null){
			for(Object obj : l){
				world.removeEntity(((EntityBuildingIndicator)obj));
			}
		}
		
		super.onBlockPreDestroy(world, x, y, z, oldmeta);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(!world.isRemote || world.provider.dimensionId !=0){
			//the player must be very close to the block to use it
			if(player.getDistance(x, y, z) < 2.5){
				
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
				if(Math.abs(lv.xCoord) >= Math.abs(lv.zCoord)){
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
					PlayerMsg.sendTranslation(player, "villagebento.msg.buildingCantBuild");
				}
			} 
			else{
				PlayerMsg.sendTranslation(player, "villagebento.msg.buildingCloserToBlock");
			}
		}	
		return true;
	}
}