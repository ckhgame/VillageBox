package com.ckhgame.villagebento.blocks;

import java.util.Random;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.BuilderBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entities.EntityVBVillager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
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
    
    @SideOnly(Side.CLIENT)
    private DataVillageBento villageBentoData = null;
    
    @SideOnly(Side.CLIENT)
    private boolean villageOutlinesEnabled = false;
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(world.isRemote) return true;
		else{
			//destroy the village block
			world.func_147480_a(x, y, z, false);
			
			BuilderBuilding.build(world, player, x, y-1, z, this.buildingType);
			
			//test spawn a villager
			String[] before = new String[]{"AAA","BBB","CCCC","DDDd"};
			String[] after = new String[]{"EE","FFFFF","GG","HHHHHH"};
			Random rand = new Random();
			String name = before[(rand).nextInt(before.length)] + after[rand.nextInt(after.length)];
						
			EntityVBVillager entityvbvillager = new EntityVBVillager(world);
			
			entityvbvillager.setName(name);
			
			entityvbvillager.setLocationAndAngles((double)x,(double)y,(double)z, 0.0F, 0.0F);
            world.spawnEntityInWorld(entityvbvillager);
			 
			return true;
		}	
	}
}