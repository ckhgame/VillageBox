package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.village.VBDataTime;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;
import com.ckhgame.villagebento.villagercomponent.VillagerCompQuest;

import net.minecraft.client.gui.GuiButton;

public class GuiVillagerAbout extends GuiVillager {
	
	private boolean drawWorkHours = false;
	private VillagerCompAbout villagerCompAbout;
	
	private GuiButton btnSwitch;
	private String textBtnSwitchWorkHours;
	private String textBtnSwitchBasicInfo;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "General";
	}
	@Override
	public void onDrawScreen() {		

		Profession profession = this.entityVBVillager.getProfession();
		
		if(this.drawWorkHours){
			String[] worktimes = this.entityVBVillager.getProfession().getTimeSchedule().getWorkTimeText();
			String[] weekdays = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
			//this.drawCenteredString(this.fontRendererObj, "--Hours--", fieldCompLeft + 100,fieldCompTop + 8, 0xFFFFFFEE);
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
				
				this.fontRendererObj.drawString(weekdays[i], fieldCompLeft + 14,fieldCompTop + 4 + i * 10 , 0xFFFFFFAA);	
				this.fontRendererObj.drawString(worktimes[i], fieldCompLeft + 48,fieldCompTop + 4 + i * 10 , c);		
			}
		}
		else{
			int vrLvl = this.entityVBVillager.getLevel();
			int levelexp = profession.getNextLevelExp(vrLvl);	
			
			String info = "Lv" + (vrLvl +1 ) + " " + 
								profession.getProfessionName() + 
								" (Exp: " + (levelexp>=0?(this.entityVBVillager.getExp() + " / " + levelexp):"--/--") + ")";
			
			this.fontRendererObj.drawString(info, fieldCompLeft + 4,fieldCompTop + 4, 0xFFFFFFFF);
			this.drawCenteredString(this.fontRendererObj, this.villagerCompAbout.getCurrentlyDoing(), fieldCompLeft+100, fieldCompTop+40, 0xFFAAFFAA);
		}
	}

	@Override
	public void onInitGui() {
		setChatContent(this.entityVBVillager.getProfession().getVillagerChat().getRandom(this.entityVBVillager.getLevel()));
		
		this.villagerCompAbout = (VillagerCompAbout)villagerComponent;
		
		this.textBtnSwitchWorkHours = "Work Hours";
		this.textBtnSwitchBasicInfo = "Basic Infomation";

		this.drawWorkHours = false;
		
		this.btnSwitch = new GuiButton(this.compStartButtonID,fieldCompLeft + 20,fieldCompTop + 76,160,20,this.textBtnSwitchWorkHours);
		this.buttonList.add(this.btnSwitch);
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		if(button.id == btnSwitch.id){
			if(this.drawWorkHours){
				this.drawWorkHours = false;
				btnSwitch.displayString = this.textBtnSwitchWorkHours;
			}
			else{
				this.drawWorkHours = true;
				btnSwitch.displayString = this.textBtnSwitchBasicInfo;
			}
		}
		
	}

	@Override
	public void onSyncCompleted() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
