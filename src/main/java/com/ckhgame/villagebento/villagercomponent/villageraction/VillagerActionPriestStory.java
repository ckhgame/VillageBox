package com.ckhgame.villagebento.villagercomponent.villageraction;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;
import com.ckhgame.villagebento.util.tool.VBRandom;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

public class VillagerActionPriestStory extends VillagerAction {

	public VillagerActionPriestStory(String text, String info, int minLevel, Object[] vaParams) {
		super(text, info, minLevel, vaParams);
	}
	
	@Override
	public VBCompResult doAction(EntityPlayer player, EntityVBVillager villager, VillagerCompAction component, Object[] params) {

		int vbResult = 0;
		String dialog = "villager.priest.actionStory.result.dialog";
		String content = "villager.priest.actionStory.result.content" + VBRandom.getRand().nextInt(3);
		
		component.setResult(content, null);
		return new VBCompResult(VBResult.SUCCESS,dialog);
	}
}
