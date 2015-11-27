package com.ckhgame.villagebento.villagercomponent;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.GuiVillagerAbout;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;

public class VillagerCompAbout extends VillagerComponent {

	public VillagerCompAbout(EntityVBVillager entityVillager) {
		super(entityVillager,new GuiVillagerAbout());
	}

	@Override
	public void syneWrite(ByteBuf buf) {
		
	}

	@Override
	public void syneRead(ByteBuf buf) {
		
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {	
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
	}

	@Override
	public void firstTimeInit() {
		
	}

	@Override
	public void update(int time) {
		
	}
}
