package com.ckhgame.villagebento.blocks;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.apache.commons.lang3.ObjectUtils;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.BlockTypePos;
import com.ckhgame.villagebento.building.BuildingPrefab;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helpers.HelperDataVB;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlockBuildingScanner extends Block {

    protected BlockBuildingScanner() {
        super(Material.wood);
        this.setBlockName("BlockBuildingScanner");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":BlockBuildingScanner");
      //  this.setHardness(2.0F);
       // this.setResistance(6.0F);
        this.setLightLevel(1.0F);
        //this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeWood);
    }
    
    @SideOnly(Side.CLIENT)
    private DataVillageBento villageBentoData = null;
    
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(world.isRemote) return true;
		else{
			villageBentoData = DataVillageBento.get(world);
			
			scanBuilding(world,x,y,z);		
			outputScanResults();
			outputCodes();
						
			return true;
		}	
	}
	
	@SideOnly(Side.CLIENT)
	private BuildingPrefab prefab;
	
	@SideOnly(Side.CLIENT)
	private void scanBuilding(World world,int x, int y,int z){
		
		prefab = null;		
		
		DataVillageBento dataVB = DataVillageBento.get(world);
		
		//get building data
		DataBuilding bd = HelperDataVB.findBuildingByPos(dataVB,x,z);
		int d = ConfigBuilding.BuildingGroundWorkDepth;
		int h = ConfigBuilding.BuildingMaxHeight;
		Block b;
		if(bd != null){
			prefab = new BuildingPrefab();
			for(int dy = -d;dy <= h;dy++){
				for(int dx= -bd.sizeX;dx<= bd.sizeX;dx++){
					for(int dz= -bd.sizeZ;dz<= bd.sizeZ;dz++){
						b = world.getBlock(bd.x + dx, bd.y + dy, bd.z + dz);
						
						if(dy >= 0){ //scan blocks above groundwork
							if(b != Blocks.air && b != ModBlocks.blockBuildingScanner)
								prefab.addblock(new BlockTypePos(b,dx,dy,dz));
						}					
						else{ //under center y,in other words inside of groundwork
							if(b != ConfigBuilding.GroundWorkBlock  && b != ModBlocks.blockBuildingScanner)
								prefab.addblock(new BlockTypePos(b,dx,dy,dz));
						}
						
					}
				}
			}			
		}
		else{
			System.out.println("Can not find the building data");
		}
		
		
	}
	
	@SideOnly(Side.CLIENT)
	private void outputScanResults(){
		
		if(prefab != null){
			
			System.out.println("Blocks of the current Building.....");
			System.out.println("===================================");
			for(BlockTypePos b:prefab.blocks){
				System.out.println("Block:" + b.block + ",X:" + b.x + ",Y:" + b.y + ",Z:" + b.z);
			}	
		}
		else{
			System.out.println("Prefab is null!");
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	private void outputCodes(){
		
		if(prefab != null){
			
			System.out.println("Codes of the current Building.....");
			System.out.println("===================================");
			int ln = 0;
			for(BlockTypePos b:prefab.blocks){
				System.out.format("buildOneBlock(%d,%d,%d,%s);" + (ln++%3 == 2?"\n":""), b.x,b.y,b.z, getBlockVariable(b.block));
			}
			
		}
		
	}
	
	@SideOnly(Side.CLIENT)
	private String getBlockVariable(Block b){
		Field[] fs = Blocks.class.getFields();
		for(Field f: fs){
			if(Modifier.isStatic(f.getModifiers())){
				try {
					if(f.get(null) == b){
						return "Blocks." + f.getName();
					}
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "can not find";
	}
}