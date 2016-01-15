package com.ckhgame.villagebento.renderer.gui.element;

public abstract class GuiElement{
	public double x;
	public double y;
	public double width;
	public double height;
	public boolean isVisible;
	
	public GuiElement(double x, double y,double w, double h){
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		isVisible = true;
	}
	
	public abstract void renderBackground();
	public abstract void renderFront();
	public abstract void renderBack();
	public abstract void update();
}
