package com.ckhgame.villagebento.blocks;

import java.util.ArrayList;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.data.BuildingData;
import com.ckhgame.villagebento.data.VillageBentoData;
import com.ckhgame.villagebento.rendering.BlockVillageViewerRenderer;
import com.ckhgame.villagebento.rendering.VillageOutlines;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockVillageViewer extends Block {

    protected BlockVillageViewer() {
        super(Material.wood);
        this.setBlockName("BlockVillageViewer");
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":BlockVillageViewer");
      //  this.setHardness(2.0F);
       // this.setResistance(6.0F);
        this.setLightLevel(1.0F);
        //this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeWood);
    }

    @SideOnly(Side.CLIENT)
    private VillageBentoData villageBentoData = null;
    
    @SideOnly(Side.CLIENT)
    private boolean villageOutlinesEnabled = false;
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(world.isRemote) return true;
		else{
			villageBentoData = VillageBentoData.get(world);
			
			System.out.println("Current Buildings:");
			for(BuildingData bd:villageBentoData.buildings){
				System.out.println("===========");
				System.out.println("X:"+bd.x);
				System.out.println("Z:"+bd.z);
				System.out.println("W:"+(bd.sizeX * 2 + 1));
				System.out.println("H:"+(bd.sizeZ * 2 + 1));
				System.out.println("Y:"+bd.y);
				System.out.println("T:"+bd.type);
			}
			
			VillageOutlines.getInstance().setVillageBentoData(villageOutlinesEnabled?null:villageBentoData);
			villageOutlinesEnabled = !villageOutlinesEnabled;
			
			
			return true;
		}	
	}
}