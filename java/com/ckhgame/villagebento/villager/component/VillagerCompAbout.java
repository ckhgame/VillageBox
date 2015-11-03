package com.ckhgame.villagebento.villager.component;

import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.gui.GuiVillager;
import com.ckhgame.villagebento.gui.GuiVillagerAbout;

public class VillagerCompAbout extends VillagerComponent {

	public VillagerCompAbout() {
		super(new GuiVillagerAbout());
		// TODO Auto-generated constructor stub
	}

	@Override
	public DataVillagerComp getNewDataInstance() {
		return null;
	}
}
