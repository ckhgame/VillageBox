package com.ckhgame.villagebento.villagercomponent;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.ICustomGuiDialogOption;

import io.netty.buffer.ByteBuf;
import net.minecraft.nbt.NBTTagCompound;

public abstract class VillagerCompCustomDialog extends VillagerComponent implements ICustomGuiDialogOption{

	private String customGuiDialogOptionName = "<Empty>";
	
	public VillagerCompCustomDialog(EntityVBVillager entityVillager) {
		super(entityVillager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getDialogOptionText() {
		return this.customGuiDialogOptionName;
	}

	@Override
	public void setDialogOptionText(String optionText) {
		this.customGuiDialogOptionName = optionText;
	}

	
}
