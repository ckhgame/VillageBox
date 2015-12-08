package com.ckhgame.villagebento.villagercomponent;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperPlayer;

import net.minecraft.entity.player.EntityPlayer;

public class VillagerCompActionBet extends VillagerCompAction {

	public VillagerCompActionBet(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}
	
	/**
	 * return times, <0 means not enough money, =0 means lose money, >0 means the final times
	 */
	public int bet(String pname, int bet){
		
		EntityPlayer player = HelperPlayer.getPlayer(pname);
		if(player == null)
			return VBResult.FAILED;
		
		if(HelperPlayer.addCurrency(player,-bet)){

			//this.getVillager().addExp(ConfigVillager.BetExp);
			
			Random rand = new Random();
			int r = rand.nextInt(100);
			int times = 0;
			if(r < 50){
				times = 0;//50%
			}
			else if(r >= 50 && r < 84)
				times = 1;//34%
			else if(r >= 84 && r < 94){
				times = 2;//10%
			}
			else if(r >= 94 && r < 99){
				times = 4;//5%
			}
			else{
				times = 8;//1%
			}
			
			HelperPlayer.addCurrency(player,bet * times);
			
			return times;
		}
		return -1;
	}
}
