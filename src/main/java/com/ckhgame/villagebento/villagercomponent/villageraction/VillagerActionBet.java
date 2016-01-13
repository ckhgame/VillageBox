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

/**
 * 
 * params: 1.bet (int)
 */
public class VillagerActionBet extends VillagerAction {

	public VillagerActionBet(String text, String info, int minLevel, Object[] vaParams) {
		super(text, info, minLevel, vaParams);
	}
	
	@Override
	public VBCompResult doAction(EntityPlayer player, EntityVBVillager villager, VillagerCompAction component, Object[] params) {
		int bet = (Integer) params[0];

		int vbResult = 0;
		String dialog = "null";
		String content = "null";
		
		if (HelperPlayer.addCurrency(player, -bet)) {

			//villager.addExp(ConfigVillager.BetExp);

			Random rand = VBRandom.getRand();
			int r = rand.nextInt(100);
			int times = 0;
			if (r < 50) {
				times = 0;// 50%
			} else if (r >= 50 && r < 84)
				times = 1;// 34%
			else if (r >= 84 && r < 94) {
				times = 2;// 10%
			} else if (r >= 94 && r < 99) {
				times = 4;// 5%
			} else {
				times = 8;// 1%
			}

			HelperPlayer.addCurrency(player, bet * times);
			
			if(times == 0){
				dialog = "villager.casinoMgr.actionBet.result1.dialog";
				content = format("villager.casinoMgr.actionBet.result1.content",String.valueOf(bet));
				vbResult = VBResult.SUCCESS;
			}
			else if(times == 1){
				dialog = "villager.casinoMgr.actionBet.result2.dialog";
				content = format("villager.casinoMgr.actionBet.result2.content",String.valueOf(bet));
				vbResult = VBResult.SUCCESS;
			}
			else if(times == 2){
				dialog = "villager.casinoMgr.actionBet.result3.dialog";
				content = format("villager.casinoMgr.actionBet.result345.content",String.valueOf(bet),String.valueOf(bet * times));
				vbResult = VBResult.SUCCESS;
			}
			else if(times == 4){
				dialog = "villager.casinoMgr.actionBet.result4.dialog";
				content = format("villager.casinoMgr.actionBet.result345.content",String.valueOf(bet),String.valueOf(bet * times));
				vbResult = VBResult.SUCCESS;
			}
			else if(times == 8){
				dialog = "villager.casinoMgr.actionBet.result5.dialog";
				content = format("villager.casinoMgr.actionBet.result345.content",String.valueOf(bet),String.valueOf(bet * times));
				vbResult = VBResult.SUCCESS;
			}		
			
		}
		else{
			dialog = "villager.casinoMgr.actionBet.result0.dialog";
			content = format("villager.casinoMgr.actionBet.result0.content", String.valueOf(bet));
			vbResult = VBResult.FAILED_UNAFFORDABLE;
		}
		
		component.setResult(content, null);
		return new VBCompResult(vbResult,dialog);
	}
}
