package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoVillagerAction;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.tool.VBRandom;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiVillagerAction extends GuiVillager {
	
	private int rows = 1;
	private int actionWaitingTime = 0;
	private Random rand = VBRandom.getRand();
	
	private VillagerCompAction villagerCompAction;
	
	private boolean isResultScreen = false;
	private ArrayList<GuiButton> buttonActionList = new ArrayList<GuiButton>();
	private GuiButton buttonBack;
	private boolean justSwitch = false;
	
	boolean initedActionList = false;
	boolean receivedResult = false;
	
	@Override
	public String getButtonText() {
		// TODO Auto-generated method stub
		return "Action";
	}
	
	int lastSelected = -1;
	
	@Override
	public void onDrawScreen() {		
		
		if(isResultScreen){
			if(actionWaitingTime > 0){
				int yPos = (actionWaitingTime % 24 - 12)/4;
				this.drawCenteredString(fontRendererObj, "Waiting...", fieldCompLeft + 100, fieldCompTop + 40 + yPos, 0xFFFFFF00);
				buttonBack.visible = false;
			}
			else if(receivedResult){
				this.drawCenteredString(fontRendererObj, this.villagerCompAction.resultTitle, fieldCompLeft + 100, fieldCompTop + 10, 0xFFFFFF00);
				this.drawWrappedString(fontRendererObj, this.villagerCompAction.resultContent, fieldCompLeft + 20, fieldCompTop + 25, 0xFFDDDDDD, 160);
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
			receivedResult = false;
		}
		
		//button visibilities
		for(GuiButton btn : buttonActionList){
			btn.visible = !isResultScreen;
		}
	}
	
	@Override
	public void onInitGui() {
		setChatContent("Can I help you?");
		this.villagerCompAction = (VillagerCompAction)villagerComponent;
		
		actionWaitingTime = 0;
		
		buttonActionList.clear();
		initedActionList = false;
		
		//buttons
		int id = compStartButtonID;
		
		buttonBack = new GuiButton(id++,fieldCompLeft + 80,fieldCompTop + 70,40,20,"Back");
		this.buttonList.add(buttonBack);
		
		setResultScreen(false);
	}
	
	public void initActionList(){
		
		int[] actionIdxList = this.villagerCompAction.actionIdxListCurrent;
		
		int id = compStartButtonID + 10;
		for(int i =0;i<actionIdxList.length;i++){
			addActionButton(id++,this.villagerCompAction.getAction(actionIdxList[i]).text);
		}
		refreshActionButtonPositions();
		
		//move the back button to the bottom
		this.buttonList.remove(buttonBack);
		this.buttonList.add(buttonBack);
		
		initedActionList = true;
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
	
	private void sendAction(){

		int[] actionIdxList = this.villagerCompAction.actionIdxListCurrent;
		
		if(actionIdxList != null && lastSelected >= 0 &&lastSelected < actionIdxList.length){
			int actionIdx = actionIdxList[lastSelected];


		int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
		if(compIdx < 0)
			System.out.println("Can not find the village component! idx < 0");
		else
			Action.send(ActionDoVillagerAction.class, new Object[]{	this.entityVBVillager.getEntityId(),
																	compIdx, 
																	Minecraft.getMinecraft().thePlayer.getEntityId(),
																	new Object[]{actionIdx}});
		}
		
	}

	
	
	@Override
	public void updateWithVBCompResult(VBCompResult vbCompResult) {
		super.updateWithVBCompResult(vbCompResult);
		if(!VBResult.isSuccess(vbCompResult.vbResult))
			this.setResultScreen(false);
	}

	@Override
	public void onSyncCompleted() {
		if(initedActionList){
			receivedResult = true;
		}
		else{
			initActionList();
		}
	}
	
}
