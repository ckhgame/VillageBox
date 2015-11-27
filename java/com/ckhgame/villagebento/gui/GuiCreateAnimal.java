package com.ckhgame.villagebento.gui;

import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionDoCreateAnimal;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;

public class GuiCreateAnimal extends GuiScreen {

	// pass in
	private int x, y, z;
	private boolean created = false;
	private int playerEntityID;

	public GuiCreateAnimal(int playerEntityID,int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.playerEntityID = playerEntityID;
	}

	private GuiTextField textField;
	private GuiButton buttonOK;

	private void drawFieldBackground(int left, int top, int width, int height) {

		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF333333);
		drawRect(left - 1, top - 1, left + width + 1, top + height + 1, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFF555555);
	}

	int yOffset = 0;
	String text = "Give the new baby a name:";
	int textColor = 0xFFFFFF;


	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {

		this.drawDefaultBackground();

		if (yOffset < 0)
			yOffset += 1;

		// GUI LAYOUT: Right Top Chat Field
		drawFieldBackground(this.width / 2 - 80, this.height / 2 - 40, 160, 80);
		this.drawCenteredString(this.fontRendererObj, text, this.width / 2,
				this.height / 2 - 30 + yOffset, textColor);
		textField.drawTextBox();

		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@Override
	public void updateScreen() {

		this.textField.updateCursorCounter();

		super.updateScreen();
	}

	@Override
	protected void keyTyped(char p_73869_1_, int p_73869_2_) {

		if (this.textField.isFocused()) {
			this.textField.textboxKeyTyped(p_73869_1_, p_73869_2_);
		}

		super.keyTyped(p_73869_1_, p_73869_2_);
	}

	private boolean isOnlyLettersAndNumbers(String str) {
		return str.matches("^[a-zA-Z0-9]*$");
	}

	@Override
	protected void actionPerformed(GuiButton button) {

		// leave
		if (button.id == buttonOK.id) {
			if(created)
				return;
			
			this.yOffset = -5;
			
			String name = this.textField.getText().trim();

			if(name.length() <= 0 || name.length() >= 10)
			{
				text = "name must have 1-10 characters";
				textColor = 0xFFAAAA;
			}
			else if(!isOnlyLettersAndNumbers(name)){
				text = "please only use letters and numbers";
				textColor = 0xFFAAAA;
			}
			else{
				Action.send(ActionDoCreateAnimal.class, new Object[]{playerEntityID,x,y,z,name});
				created = true;
			}
			
		}
		
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {

		buttonOK = new GuiButton(0, this.width / 2 - 20, this.height / 2 + 15, 40, 20, "OK");
		this.buttonList.clear();
		this.buttonList.add(buttonOK);

		textField = new GuiTextField(this.fontRendererObj, this.width / 2 - 40, this.height / 2 - 10, 80, 20);
		textField.setFocused(true);

		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}

}
