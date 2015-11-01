package com.ckhgame.villagebento.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.GuiScreen;

public abstract class GuiVillager extends GuiScreen {

	protected VillagerComponent villagerComponent;
	protected EntityVBVillager entityVillager;
	protected int buttonID;
	
	public void setVillageComponent(VillagerComponent villagerComponent){
		this.villagerComponent = villagerComponent;
	}
	
	public void setEntityVillager(EntityVBVillager entityVillager){
		this.entityVillager = entityVillager;
	}
	
	protected void drawWrappedString(FontRenderer renderer, String drawing, int x, int y, int color, int wrap)
    {
        List<String> lines = renderer.listFormattedStringToWidth(drawing, wrap);
        for (int i = 0; i < lines.size(); i++)
            renderer.drawString(lines.get(i), x, y + (i * 9), color, false);
    }
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		// TODO Auto-generated method stub
		this.drawDefaultBackground();
		this.fontRendererObj.drawString(this.entityVillager.getName() + ":", this.width / 2 - 97,this.height /2 - 60, 0xFFAAAAAA,true);
		
		onDrawScreen();
		
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		// TODO Auto-generated method stub
		
		//leave
		if(button.id == 99999){
			this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
            return;
		}
		
		ArrayList<VillagerComponent> carr = entityVillager.getVillagerComponents();
		for(VillagerComponent c : carr){
			if(c.getGui().buttonID == button.id){
				this.mc.displayGuiScreen(c.getGui());
				return;
			}
		}
		
        onActionPerformed();
        
		super.actionPerformed(button);
	}

	@Override
	public void initGui() {
		// TODO Auto-generated method stub
		//this.
		this.buttonList.clear();
		int id = 0;
		int count = 0;
		GuiButton btn;
		ArrayList<VillagerComponent> carr = null;
		if(entityVillager != null){
			carr = entityVillager.getVillagerComponents();
		}
		
		if(carr != null){
			for(VillagerComponent c : carr){
				c.getGui().buttonID = id++;
				btn = new GuiButton(c.getGui().buttonID, 
						this.width /2 - 150,this.height /2 - 50 + 25 * (count++),
						40,20,	
						c.getGui().getButtonText());
				if(c == villagerComponent)
					btn.enabled = false;
				this.buttonList.add(btn);
			}
		}

		//leave button
		this.buttonList.add(new GuiButton(99999, this.width /2 - 150,this.height /2 - 50 + 25 * count,40,20,"Leave"));
		
		onInitGui();
		
		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public abstract String getButtonText();
	public abstract void onDrawScreen();
	public abstract void onInitGui();
	public abstract void onActionPerformed();
	
}
