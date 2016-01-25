package ckhbox.villagebento.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTextButton extends GuiButton{
	
	public GuiTextButton(Minecraft mc,int id, int x, int y, String text) {
		super(id, x, y,mc.fontRendererObj.getStringWidth(text),mc.fontRendererObj.FONT_HEIGHT,text);
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
            int l = 14737632;

            if (packedFGColour != 0)
            {
                l = packedFGColour;
            }
            else if (!this.enabled)
            {
                l = 10526880;
            }
            else if (this.hovered)
            {
                l = 16777120;
            }

            this.drawString(fontrenderer, this.displayString, this.xPosition,  this.yPosition, l);
        }
	}
	
}
