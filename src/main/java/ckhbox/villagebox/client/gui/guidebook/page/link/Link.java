package ckhbox.villagebox.client.gui.guidebook.page.link;

import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.page.Page;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;

public abstract class Link {
	public int left;
	public int top;
	public int width;
	public int height;
	public String link;
	public Page page;
	public Minecraft mc;
	public List<String> tooltips;
	
	public Link(Page page, String link, List<String> tooltips){
		this.link = link;
		this.page = page;
		this.tooltips = tooltips;
		this.mc = this.page.guiGuideBook.mc;
	}
	
	public boolean isMouseHover(int mouseX, int mouseY){
		if(mouseX <= this.left ||
			mouseX >= this.left + this.width ||
			mouseY <= this.top ||
			mouseY >= this.top + this.height)
			return false;
		return true;
	}
	
	public void onDraw(int mouseX, int mouseY){
		
	}
	
	public void onDrawHover(int mouseX, int mouseY){
		
	}
	
	public void onDrawToolTip(int mouseX, int mouseY){
		if(this.tooltips != null){
			this.page.guiGuideBook.drawHoveringText(this.tooltips, mouseX, mouseY);
		}
	}
}
