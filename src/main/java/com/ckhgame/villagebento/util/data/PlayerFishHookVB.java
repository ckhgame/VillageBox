package com.ckhgame.villagebento.util.data;

import com.ckhgame.villagebento.config.ConfigPlayer;
import com.ckhgame.villagebento.entity.misc.EntityFishHookVB;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerFishHookVB implements IExtendedEntityProperties{

	@Override
	public void saveNBTData(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub
		
	}
	
	private EntityFishHookVB entityFishHook = null;
	
	public static EntityFishHookVB get(EntityPlayer player){
		PlayerFishHookVB playerFishHook = (PlayerFishHookVB)player.getExtendedProperties(ConfigPlayer.KeyPlayerFishHookVB);
		if(playerFishHook == null) return null;
		else return playerFishHook.entityFishHook;
	}
	
	public static void set(EntityPlayer player, EntityFishHookVB entityFishHook){
		PlayerFishHookVB playerFishHook = (PlayerFishHookVB)player.getExtendedProperties(ConfigPlayer.KeyPlayerFishHookVB);
		if(playerFishHook == null){
			playerFishHook = new PlayerFishHookVB();
			player.registerExtendedProperties(ConfigPlayer.KeyPlayerFishHookVB,playerFishHook);
		}
		playerFishHook.entityFishHook = entityFishHook;
	}
}
