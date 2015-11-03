package com.ckhgame.villagebento.data.helper;

import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerComp;
import com.ckhgame.villagebento.data.villagercomp.DataVillagerCompBuy;
import com.ckhgame.villagebento.villager.Villager;
import com.ckhgame.villagebento.villager.component.VillagerCompBuy;

public class HelperDataVgrComp {
	
	public static DataVillagerComp findDataVillagerComp(DataVillager dvr,Class<? extends DataVillagerComp> c){
		for(DataVillagerComp vrc : dvr.dataComponents){
			if(vrc.getClass() == c)
				return vrc;
		}
		return null;
	}
	
	public static void refreshBuyList(DataVillager dvr){
		
		DataVillagerCompBuy dataCompBuy = (DataVillagerCompBuy)findDataVillagerComp(dvr,DataVillagerCompBuy.class);
		if(dataCompBuy == null)
			return;
		
		Villager vr = Villager.registry.get(dvr.profession);
		if(vr == null)
			return;
		
		VillagerCompBuy compBuy = (VillagerCompBuy)vr.findVillagerComponentByClass(VillagerCompBuy.class);
		if(compBuy == null)
			return;

		dataCompBuy.buyList = compBuy.generateBuyList(dvr.level);
		
	}
}
