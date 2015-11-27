package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.VBCompResult;

import net.minecraft.client.gui.GuiButton;

public class GuiVillagerAbout extends GuiVillager {
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "General";
	}
	@Override
	public void onDrawScreen() {		
		
		int vrLvl = this.entityVBVillager.getLevel();
		Profession profession = this.entityVBVillager.getProfession();
		String infoProfession = "Profession: " + profession.getProfessionName();
		String infoLevel = "Level: " + (vrLvl + 1) + (profession.isMaxLevel(vrLvl)?" (Max)":"");
		int levelexp = profession.getNextLevelExp(vrLvl);	
		String infoExp = "Exp: " + (levelexp>=0?(this.entityVBVillager.getExp() + " / " + levelexp):"--/--");
		String infoProDesction = profession.getProfessionDescription();
		
		this.fontRendererObj.drawString(infoProfession, fieldCompLeft + 4,fieldCompTop + 2, 0xFFFFFFFF);
		this.fontRendererObj.drawString(infoLevel, fieldCompLeft + 4,fieldCompTop + 17, 0xFFFFFFFF);
		this.fontRendererObj.drawString(infoExp, fieldCompLeft + 4,fieldCompTop + 32, 0xFFFFFFFF);
		
		this.fontRendererObj.drawString("-------", fieldCompLeft + 4,fieldCompTop + 47, 0xFFAAAAAA);		
		this.drawWrappedString(	this.fontRendererObj,infoProDesction,
								fieldCompLeft+4,fieldCompTop+62,0xFFFFFF66,196);	
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
