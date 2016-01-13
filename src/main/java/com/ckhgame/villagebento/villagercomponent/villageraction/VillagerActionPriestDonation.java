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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;

/**
 * 
 * params: 1.donation
 */
public class VillagerActionPriestDonation extends VillagerAction {

	public VillagerActionPriestDonation(String text, String info, int minLevel, Object[] vaParams) {
		super(text, info, minLevel, vaParams);
	}
	
	@Override
	public VBCompResult doAction(EntityPlayer player, EntityVBVillager villager, VillagerCompAction component, Object[] params) {
		int donation = (Integer) params[0];

		int vbResult = 0;
		String dialog = "null";
		String content = "null";
		
		if (HelperPlayer.addCurrency(player, -donation)) {
			dialog = "villager.priest.actionDonation.result1.dialog";
			content = format("villager.priest.actionDonation.result1.content",String.valueOf(donation));
			vbResult = VBResult.SUCCESS;		
			//random effects
			int r = VBRandom.getRand().nextInt(3);
			if(r == 0) player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,60 * 20,0,false));
			else if(r == 1) player.addPotionEffect(new PotionEffect(Potion.regeneration.id,60 * 20,0,false));
			else if(r == 2) player.addPotionEffect(new PotionEffect(Potion.jump.id,60 * 20,0,false));
		}
		else{
			dialog = "villager.priest.actionDonation.result0.dialog";
			content = format("villager.priest.actionDonation.result0.content",String.valueOf(donation));
			vbResult = VBResult.FAILED_UNAFFORDABLE;
		}
		
		component.setResult(content, null);
		return new VBCompResult(vbResult,dialog);
	}
}
