package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.village.VBDataTime;

import net.minecraft.client.gui.GuiButton;

public class GuiVillagerAbout extends GuiVillager {
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "General";
	}
	@Override
	public void onDrawScreen() {		

		Profession profession = this.entityVBVillager.getProfession();
		
		int vrLvl = this.entityVBVillager.getLevel();
		int levelexp = profession.getNextLevelExp(vrLvl);	
		
		String info = "Lv" + (vrLvl +1 ) + " " + 
							profession.getProfessionName() + 
							" (Exp: " + (levelexp>=0?(this.entityVBVillager.getExp() + " / " + levelexp):"--/--") + ")";
		
		this.fontRendererObj.drawString(info, fieldCompLeft + 4,fieldCompTop + 4, 0xFFFFFFFF);
		
		String[] worktimes = this.entityVBVillager.getProfession().getTimeSchedule().getWorkTimeText();
		String[] weekdays = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
		this.drawCenteredString(this.fontRendererObj, "--Hours--", fieldCompLeft + 100,fieldCompTop + 18, 0xFFFFFFEE);
		for(int i =0;i<worktimes.length;i++){
			int c = 0xFFEEEEEE;
			if(i == VBDataTime.getDayInWeek()){
				if(this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNow()){
					c = 0xFF99FF99;
				}
				else{
					c = 0xFFFF9999;
				}
			}
			
			this.fontRendererObj.drawString(weekdays[i], fieldCompLeft + 14,fieldCompTop + 30 + i * 10 , 0xFFFFFFAA);	
			this.fontRendererObj.drawString(worktimes[i], fieldCompLeft + 48,fieldCompTop + 30 + i * 10 , c);		
		}
	}

	@Override
	public void onInitGui() {
		setChatContent(this.entityVBVillager.getProfession().getVillagerChat().getRandom(this.entityVBVillager.getLevel()));
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSyncCompleted() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
