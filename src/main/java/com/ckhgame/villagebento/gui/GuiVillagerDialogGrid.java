package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.Tessellator;

public abstract class GuiVillagerDialogGrid extends GuiVillagerDialog{

	protected int gridColumns = 10;
	protected int gridRows = 4;
	protected int gridCellWidth = 24;
	protected int gridCellHeight = 24;
	protected int gridXOffset = 8;
	protected int gridYOffset = 20;
	
	public GuiVillagerDialogGrid(EntityVBVillager entityVBVillager) {
		super(entityVBVillager);
	}	
	
	//-----------------------------
	//Draw Grid
	//-----------------------------
	protected void drawGrid(int mx, int my){
		for(int r = 0; r< gridRows; r++){
			for(int c = 0;c < gridColumns; c++){
				this.drawGridCell(r * gridColumns + c, mx, my,
										this.boundCenterContent.getIntX() + gridXOffset + gridCellWidth * c,
										this.boundCenterContent.getIntY() + gridYOffset + gridCellHeight * r);
			}
		}
	}
	
	protected void gridCellMouseClick(int mx, int my){
		int idx = getGridCellIdx(mx,my);
		if(idx <0)
			return;	
		this.onGridCellClicked(idx);
	}
	
	protected int getGridCellIdx(int mx, int my){
		int x = mx - this.boundCenterContent.getIntX() - gridXOffset;
		int y = my - this.boundCenterContent.getIntY() - gridYOffset;
		if(x < 0 || y < 0)
			return -1;
		
		x /= gridCellWidth;
		y /= gridCellHeight;
				
		if(x >= gridColumns || y >= gridRows)
			return -1;
		
		return y * gridColumns + x;
	}
	
	protected abstract void drawGridCell(int idx, int mx, int my, int x, int y);
	protected abstract void onGridCellClicked(int idx);
}
