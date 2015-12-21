package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerUpgrade;
import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.data.VillagerSchedule;
import com.ckhgame.villagebento.util.village.VBDataTime;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAbout;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.item.ItemStack;

public class GuiVillagerAbout extends GuiVillager {
	
	private static final int screenBasicInfo = 0;
	private static final int screenWorkHours = 1;
	private static final int screenUpgrading = 2;
	
	private int  screenCurrent = screenBasicInfo;
	private VillagerCompAbout villagerCompAbout;
	
	private GuiButton btnSwitch;
	private GuiButton btnUpgradeScreen;
	private GuiButton btnUpgrade;
	private String textBtnSwitchWorkHours;
	private String textBtnSwitchBasicInfo;
	
	@Override
	public String getButtonText() {
		
		return "> Tell me about you";
	}
	@Override
	public void onDrawScreen() {		

		Profession profession = this.entityVBVillager.getProfession();
		
		if(this.screenCurrent == screenWorkHours){
			this.btnUpgrade.visible = false;
			this.btnUpgradeScreen.visible = false;
			String[] worktimes = this.entityVBVillager.getProfession().getTimeSchedule().getWorkTimeText();
			String[] weekdays = new String[]{"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
			//this.drawCenteredString(this.fontRendererObj, "--Hours--", fieldCompLeft + 100,fieldCompTop + 8, 0xFFFFFFEE);
			for(int i =0;i<worktimes.length;i++){
				int c = 0xFFEEEEEE;
				int today = VBDataTime.getDayInWeek();
				int prev = today == 0?6:today - 1; 
				int h =VBDataTime.getHourOfDay();
				if(i == today || i == prev){
					int result = this.entityVBVillager.getProfession().getTimeSchedule().isWorkTimeNowResult();
					if(result == VillagerSchedule.YesToday && i ==today ||result == VillagerSchedule.YesYesterday && i == prev){
						c = 0xFF99FF99;
					}
					
					if(result == VillagerSchedule.No && i == today){
						c = 0xFFFF9999;
					}
				}
				
				this.fontRendererObj.drawString(weekdays[i], fieldCompLeft + 14,fieldCompTop + 4 + i * 10 , 0xFFFFFFAA);	
				this.fontRendererObj.drawString(worktimes[i], fieldCompLeft + 48,fieldCompTop + 4 + i * 10 , c);		
			}
		}
		else if(this.screenCurrent == screenBasicInfo){
			this.btnUpgrade.visible = false;
			this.btnUpgradeScreen.visible = true;
			
			int vrLvl = this.entityVBVillager.getLevel();
			
			String info = "Lv" + (vrLvl +1 ) + " " + 
								profession.getProfessionName();
			
			this.drawCenteredString(this.fontRendererObj, info, fieldCompLeft + 100,fieldCompTop + 8, 0xFFFFFFFF);
			this.drawCenteredString(this.fontRendererObj, this.villagerCompAbout.getCurrentlyDoing(), fieldCompLeft+100, fieldCompTop+60, 0xFFAAFFAA);
		}
		else if(this.screenCurrent == screenUpgrading){
			
			this.btnUpgradeScreen.visible = false;
			
			
			ItemStack[] requirements = this.entityVBVillager.getProfession().getNextLevelRequirements(this.entityVBVillager.getLevel());
			this.drawCenteredString(this.fontRendererObj, "Requirements:", fieldCompLeft+100, fieldCompTop+4, 0xFFFFFF00);
			if(requirements != null){
				this.btnUpgrade.visible = true;
				int dx = - 32 * requirements.length / 2;
				for(int i = requirements.length - 1;i>=0;i--){ // to prevent the tool tip from being under others...rendering it from right to left 
					this.drawItem(fieldCompLeft + 106 + dx + i * 32, fieldCompTop + 24, requirements[i]);
				}
			}
			else{
				this.btnUpgrade.visible = false;
				this.drawCenteredString(this.fontRendererObj, "Already reached the max level", fieldCompLeft + 100,fieldCompTop + 32, 0xFFFFFFFF);
			}
			
		}
	}

	@Override
	public void onInitGui() {
		setChatContent(this.entityVBVillager.getProfession().getVillagerChat().getRandom(this.entityVBVillager.getLevel()));
		
		this.villagerCompAbout = (VillagerCompAbout)villagerComponent;
		
		this.textBtnSwitchWorkHours = "Work Hours";
		this.textBtnSwitchBasicInfo = "Basic Infomation";

		this.screenCurrent = screenBasicInfo;
		
		this.btnSwitch = new GuiButton(this.compStartButtonID++,fieldCompLeft + 20,fieldCompTop + 76,160,20,this.textBtnSwitchWorkHours);
		this.buttonList.add(this.btnSwitch);
		
		this.btnUpgradeScreen = new GuiButton(this.compStartButtonID++,fieldCompLeft + 60,fieldCompTop + 24,80,20,"Upgrade");
		this.buttonList.add(this.btnUpgradeScreen);
		
		this.btnUpgrade = new GuiButton(this.compStartButtonID++,fieldCompLeft + 60,fieldCompTop + 50,80,20,"Upgrade");
		this.buttonList.add(this.btnUpgrade);
		
	}

	@Override
	public void onActionPerformed(GuiButton button) {
		if(button.id == btnSwitch.id){
			if(this.screenCurrent == screenBasicInfo){
				this.screenCurrent = screenWorkHours;
				btnSwitch.displayString = this.textBtnSwitchBasicInfo;
			}
			else{
				this.screenCurrent = screenBasicInfo;
				btnSwitch.displayString = this.textBtnSwitchWorkHours;
			}
		}
		else if(button.id == btnUpgradeScreen.id){
			this.screenCurrent = screenUpgrading;
			btnSwitch.displayString = this.textBtnSwitchBasicInfo;
		}
		else if(button.id == btnUpgrade.id){
			//upgrade
			int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
			if(compIdx < 0)
				System.out.println("Can not find the village component! idx < 0");
			else
				Action.send(ActionDoVillagerUpgrade.class, new Object[]{	this.entityVBVillager.getEntityId(),
																		compIdx, 
																		Minecraft.getMinecraft().thePlayer.getEntityId(),
																		null});
		}
		
	}

	@Override
	public void onSyncCompleted() {
		
	}
	@Override
	public void updateWithVBCompResult(VBCompResult vbCompResult) {
		super.updateWithVBCompResult(vbCompResult);
		
		if(VBResult.isSuccess(vbCompResult.vbResult)){
			this.screenCurrent = screenBasicInfo;
		}
		
	}
	
	
	
	
	
}
