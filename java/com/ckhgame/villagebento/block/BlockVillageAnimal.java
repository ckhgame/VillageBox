package com.ckhgame.villagebento.block;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBAnimal;
import com.ckhgame.villagebento.gui.GuiCreateAnimal;
import com.ckhgame.villagebento.gui.GuiDropCoins;
import com.ckhgame.villagebento.util.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockVillageAnimal extends Block {

    protected BlockVillageAnimal(Class<? extends EntityVBAnimal> bc,String name) {
        super(Material.wood);
        this.setBlockName(name);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setBlockTextureName(Main.MODID + ":"+name);
        this.setStepSound(soundTypeWood);
        
        this.animalClass = bc;
    }

    private final Class<? extends EntityVBAnimal> animalClass;
    public Class<? extends EntityVBAnimal> getBuildingClass(){
    	return animalClass;
    }
    
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z,EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		
		if(world.provider.dimensionId !=0){
			return true;
		}
		
		
		if(!world.isRemote){
			//the player must be very close to the block to use it
			if(player.getDistance(x, y, z) < 1.5D){
				Minecraft.getMinecraft().displayGuiScreen(new GuiCreateAnimal(this,world,player,x,y,z));
				
			} 
			else{
				PlayerMsg.send(player, "Please get closer to the block");
			}
		}
		return true;
	}
	
	public void createAnimal(World world,EntityPlayer player,int x, int y, int z,String name){
		
		Minecraft.getMinecraft().displayGuiScreen(null);
		
		EntityVBAnimal entity = null;
		
		try {
			entity = animalClass.getDeclaredConstructor(World.class).newInstance(world);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		entity.setCustomNameTag(name);
		entity.setLocationAndAngles(x + 0.5F, y + 0.1F, z + 0.5F, 0.0F, 0.0F);

		if(world.spawnEntityInWorld(entity)){
			world.setBlockToAir(x, y, z);
		}
		else{
			PlayerMsg.send(player, "Sorry, You can't spawn it here!");
		}
	}
}