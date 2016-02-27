package ckhbox.villagebento.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTextButton extends GuiButton{
	
	private Minecraft mc;
	
	private int colorNormal = 0xFFFFFF;
	private int colorHover = 0xFFFF55;
	private boolean shadow = true;
	
	public GuiTextButton(Minecraft mc,int id, int x, int y, String text) {
		super(id, x, y,mc.fontRendererObj.getStringWidth(text),mc.fontRendererObj.FONT_HEIGHT,text);
		this.mc = mc;
	}
	
	public void setText(String text){
		this.displayString = text;
		this.width = this.mc.fontRendererObj.getStringWidth(text);
	}
	
	public void setShadow(boolean shadow){
		this.shadow = shadow;
	}
	
	public void setColors(int normal, int hover){
		this.colorHover = hover;
		this.colorNormal = normal;
	}
	
	public boolean isMouseOn(){
		return this.hovered;
	}
	
	@Override
	public void drawButton(Minecraft mc, int p_146112_2_, int p_146112_3_) {
		 if (this.visible)
        {
            FontRenderer fontrenderer = mc.fontRendererObj;
            this.hovered = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
            int k = this.getHoverState(this.hovered);
            this.mouseDragged(mc, p_146112_2_, p_146112_3_);
            int l = this.colorNormal;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 0xAAAAAA;
            }
            else if (this.hovered)
            {
                l = this.colorHover;
            }

            fontrenderer.drawString(this.displayString, this.xPosition, this.yPosition, l, this.shadow);
        }
	}
	
}
