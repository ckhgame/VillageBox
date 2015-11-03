package com.ckhgame.villagebento.player;

import com.ckhgame.villagebento.config.ConfigPlayerVBProperty;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.IExtendedEntityProperties;

public class PlayerVBProperty implements IExtendedEntityProperties{

	public int currency;
	
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		System.out.println("CSave");
		compound.setInteger(ConfigPlayerVBProperty.KeyCurrency, currency);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		System.out.println("CLoad");
		currency = compound.getInteger(ConfigPlayerVBProperty.KeyCurrency);
	}

	@Override
	public void init(Entity entity, World world) {
		// TODO Auto-generated method stub
		
	}
	
	public static PlayerVBProperty get(String playerName){
		EntityPlayer p = MinecraftServer.getServer().worldServerForDimension(0).getPlayerEntityByName(playerName);
		if(p != null){
			return (PlayerVBProperty)p.getExtendedProperties(ConfigPlayerVBProperty.KeyPlayerVBProperty);
		}
		return null;
	}

}
