package com.ckhgame.villagebento.blocks;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.builders.BaseBuilder;
import com.ckhgame.villagebento.builders.BuildingConfig;
import com.ckhgame.villagebento.data.BuildingData;
import com.ckhgame.villagebento.data.VillageBentoData;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockVillageBoxLarge extends Block {

    protected BlockVillageBoxLarge() {
        super(Material.wood);
        this.setBlockName("BlockVillageBoxLarge");
        this.setCreativeTab(CreativeTabs.tabBlock);
      //  this.setHardness(2.0F);
       // this.setResistance(6.0F);
        this.setLightLevel(1.0F);
        //this.setHarvestLevel("pickaxe", 3);
        this.setStepSound(soundTypeWood);
    }
    
    @SideOnly(Side.CLIENT)
    private IIcon frontIcon,topIcon;
    
    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister reg) {
    	 this.blockIcon = reg.registerIcon(Main.MODID + ":BlockVillageBoxLarge_Sides");
    	 this.frontIcon = reg.registerIcon(Main.MODID + ":BlockVillageBoxLarge_Front");
    	 this.topIcon = reg.registerIcon(Main.MODID + ":BlockVillageBoxLarge_Top");	
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
    	if(side == 1) return this.topIcon;
    	else if(side == 0) return this.blockIcon;
    	else{
    		if(side == meta) return this.frontIcon;
    		else return this.blockIcon;
    	}
    }

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,EntityLivingBase e, ItemStack s) {
		// TODO Auto-generated method stub
		int l = MathHelper.floor_double((double)(e.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        if (l == 1)world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        if (l == 2)world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        if (l == 3)world.setBlockMetadataWithNotify(x, y, z, 4, 2);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(world.isRemote) return true;
		else{
			//destroy the village block
			world.func_147480_a(x, y, z, false);
			
			//VillageBentoData data = VillageBentoData.get(world);
			//data.testInfo += 1;
			//data.markDirty();
			//System.out.println(data.testInfo);
			
			//VillageConfig vconf = new VillageConfig("MyVillage",40,50,x,y,z,5);
			
			//add data
			VillageBentoData data = VillageBentoData.get(world);
			int bx = x;							//x
			int bz = z;							//y
			int bsx =  BuildingConfig.GroundWorkLargeSizeX;						//size x
			int bsz = BuildingConfig.GroundWorkLargeSizeZ;							//size z
			int by = y - 1;						//y
			int bt = BuildingData.Type_GroundworkLarge;							//type
			BuildingData bd = new BuildingData(bx,bz,bsx,bsz,by,bt);
			boolean addedsuccess = data.addBuildingData(bd);
			data.markDirty();
			
			//make it
			if(addedsuccess)
				BaseBuilder.buildGroundwork(world, bd);;
			
			return true;
		}
		
	}


}