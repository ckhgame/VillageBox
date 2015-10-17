package com.ckhgame.villagebento.config;

import com.ckhgame.villagebento.data.DataVillageBento;

public class ConfigVillager {
	public static int generateNextID(DataVillageBento dataVB){
		dataVB.dataID.idLastVillager += 1;
		dataVB.markDirty();
		return dataVB.dataID.idLastVillager;
	}
}
