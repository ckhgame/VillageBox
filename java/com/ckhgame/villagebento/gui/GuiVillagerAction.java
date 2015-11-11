package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionGetVillagerActionList;
import com.ckhgame.villagebento.network.action.ActionGetVillagerLevel;
import com.ckhgame.villagebento.network.action.ActionGetVillagerWorkList;
import com.ckhgame.villagebento.villager.component.VillagerCompAction;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiVillagerAction extends GuiVillager {
	
	private int rows = 1;
	private int actionWaitingTime = 0;
	private Random rand = new Random();
	
	private boolean isResultScreen = false;
	private ArrayList<GuiButton> buttonActionList = new ArrayList<GuiButton>();
	private GuiButton buttonBack;
	private boolean justSwitch = false;
	
	private String resultTitle;
	private String resultContent;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Action";
	}
	
	int[] actionList = null;
	int lastSelected = -1;
	
	public void setActionList(int[] actionList){
		
		this.actionList = actionList;
		
		VillagerCompAction compAction = (VillagerCompAction)villager.findVillagerComponentByClass(VillagerCompAction.class);
		
		int id = compStartButtonID + 10;
		for(int i =0;i<actionList.length;i++){
			addActionButton(id++,compAction.getActionText(actionList[i]));
		}
		refreshActionButtonPositions();
		
		//move the back button to the bottom
		this.buttonList.remove(buttonBack);
		this.buttonList.add(buttonBack);
	}
	
	@Override
	public void onDrawScreen() {		
		
		if(isResultScreen){
			if(actionWaitingTime > 0){
				int yPos = (actionWaitingTime % 24 - 12)/4;
				this.drawCenteredString(fontRendererObj, "Waiting...", fieldCompLeft + 100, fieldCompTop + 40 + yPos, 0xFFFFFF00);
				buttonBack.visible = false;
			}
			else{
				this.drawCenteredString(fontRendererObj, resultTitle, fieldCompLeft + 100, fieldCompTop + 10, 0xFFFFFF00);
				this.drawWrappedString(fontRendererObj, resultContent, fieldCompLeft + 20, fieldCompTop + 25, 0xFFDDDDDD, 160);
				buttonBack.visible = true;
			}
		}
		else{
			buttonBack.visible = false;
		}
		
	}

	private void setResultScreen(boolean enable){
		isResultScreen = enable;		
		
		if(isResultScreen){
			actionWaitingTime = rand.nextInt(24) + 12;
			resultTitle = "";
			resultContent = "";
		}
		
		//button visibilities
		for(GuiButton btn : buttonActionList){
			btn.visible = !isResultScreen;
		}
	}
	
	@Override
	public void onInitGui() {
		actionList = null;
		Action.send(ActionGetVillagerActionList.class, new Object[]{this.entityVillager.dataVillagerID});
		setChatContent("Can I help you?");
		
		actionWaitingTime = 0;
		
		buttonActionList.clear();
		//buttons
		int id = compStartButtonID;
		
		buttonBack = new GuiButton(id++,fieldCompLeft + 80,fieldCompTop + 70,40,20,"Back");
		this.buttonList.add(buttonBack);
		
		resultTitle = "";
		resultContent = "";
		
		setResultScreen(false);
		
	}
	
	private void addActionButton(int id, String text){
		GuiButton btnAction = new GuiButton(id,fieldCompLeft + 10, 0,180,20,text);
		buttonActionList.add(btnAction);
		this.buttonList.add(btnAction);	
	}
	
	private void refreshActionButtonPositions(){
		int idx = 0;
		int cellHeight = 100 / buttonActionList.size();
		int cellOffset = (cellHeight - 20) / 2;
		
		for(GuiButton btn : buttonActionList){
			btn.yPosition = fieldCompTop + idx * cellHeight + cellOffset;
			idx++;
		}
	}

	@Override
	public void onActionPerformed(GuiButton button) {

		if(button.id == buttonBack.id){
			setResultScreen(false);
		}
		else{
			for(int i=0;i<buttonActionList.size();i++){
				if(button.id == buttonActionList.get(i).id){
					setResultScreen(true);
					lastSelected = i;
				}
			}
		}
		
	}
	
	
	
	@Override
	public void updateScreen() {
		super.updateScreen();
		
		if(actionWaitingTime > 0){
			actionWaitingTime--;
			if(actionWaitingTime <= 0){
				sendAction();
			}
		}
		
	}
	public void setActionResult(String title, String content, String chat){
		resultTitle = title;
		resultContent = content;
		this.setChatContent(chat);
	}
	@Override
	public void updateWithData(int data) {
		// TODO Auto-generated method stub
	}
	
	private void sendAction(){

		if(actionList != null && lastSelected >= 0 &&lastSelected < actionList.length){
			int actionIdx = actionList[lastSelected];
			VillagerCompAction compAction = (VillagerCompAction)villager.findVillagerComponentByClass(VillagerCompAction.class);
			Object[] params = compAction.getActionParam(actionIdx);
			Object[] fullParams = new Object[2 + params.length];
			fullParams[0] = this.entityVillager.dataVillagerID;
			fullParams[1] = Minecraft.getMinecraft().thePlayer.getEntityId();
			for(int i =0;i<params.length;i++){
				fullParams[2 + i] = params[i];
			}
			Action.send(compAction.getActionClass(actionIdx),fullParams);
		}
		
	}
	
}
