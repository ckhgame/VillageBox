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

/**
 * 
 * params: 1.bet (int)
 */
public class VillagerActionBet extends VillagerAction {

	public VillagerActionBet(String text, int minLevel, Object[] vaParams) {
		super(text, minLevel, vaParams);
	}
	
	@Override
	public VBCompResult doAction(EntityPlayer player, EntityVBVillager villager, VillagerCompAction component, Object[] params) {
		int bet = (Integer) params[0];

		if (HelperPlayer.addCurrency(player, -bet)) {

			villager.addExp(ConfigVillager.BetExp);

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
			
			String title = "null";
			String content = "null";
			if(times < 0){
				title = "Hmmm...";
				content = String.format("You need %d for this bet...",bet);
			}
			else if(times == 0){
				title = "Unfortunately...";
				content = String.format("You are not lucky this time... You Totally lost %d.",bet);
			}
			else if(times == 1){
				title = "All good..";
				content = String.format("You spend %d and just won it back..",bet);
			}
			else if(times == 2){
				title = "Winning!!";
				content = String.format("You spend %d and won %d from it.",bet,bet * times);
			}
			else if(times == 4){
				title = "A Big Win!";
				content = String.format("You spend %d and won %d from it.",bet,bet * times);
			}
			else if(times == 8){
				title = "Oh God!";
				content = String.format("You spend %d and won %d from it!!",bet,bet * times);
			}
			
			component.setResult(title, content, null);
			
			if(times == 0){
				return new VBCompResult(VBResult.SUCCESS,"I'm sorry....");
			}	
			else if(times == 1){
				return new VBCompResult(VBResult.SUCCESS,"Ok...");
			}
			else{
				return new VBCompResult(VBResult.SUCCESS,"Congratulations!!!");
			}			
			
		}
		return new VBCompResult(VBResult.FAILED_UNAFFORDABLE,"It's too expensive for you..");
	}
}
