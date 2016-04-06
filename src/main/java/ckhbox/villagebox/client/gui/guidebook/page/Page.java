package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.Link;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public abstract class Page {
	public GuiGuideBook guiGuideBook;
	private ArrayList<Link> links = new ArrayList<Link>();
	
	//flow layout (not a real flow layout =P)
	private int flowLeft;
	private int flowTop;
	private int flowBot;
	
	public Page(GuiGuideBook guiGuideBook){
		this.guiGuideBook = guiGuideBook;
		this.flowLeft = this.guiGuideBook.getContentLeft();
		this.flowTop = this.guiGuideBook.getContentTop();
		this.flowBot = this.flowTop;
	}
	
	public void addLink(Link link, boolean newLine){
		
		if(this.flowLeft > 0 && (newLine || this.flowLeft + link.width > this.guiGuideBook.getContentRight())){
			this.flowLeft = this.guiGuideBook.getContentLeft();;
			this.flowTop = this.flowBot;
			this.flowBot = this.flowTop + link.height;
		}
		
		link.left = this.flowLeft;
		link.top = this.flowTop;
		this.flowLeft += link.width + 4;
		
		this.links.add(link);
	}
	
	private void gotoLink(String link){
		//reslove links
		//format: PAGETYPE:params, examples: 1. item:staff   2.  pro:cook   3. home:
		String[] arr = link.split(":");
		
		if(arr[0] == "home"){
			this.guiGuideBook.openPage(new PageHome(this.guiGuideBook));
		}
		else if(arr[0] == "itemlist"){
			this.guiGuideBook.openPage(new PageItemList(this.guiGuideBook));
		}
		
	}
	
	public abstract void onInit();
	
	public void onDrawScreen(int mouseX, int mouseY){		
		//links
		for(Link link : this.links){
			if(link.isMouseHover(mouseX, mouseY)){
				link.onDrawHover(mouseX, mouseY);
			}
			else{
				link.onDraw(mouseX, mouseY);
			}
		}		
		//tooltips
		for(Link link : this.links){
			if(link.isMouseHover(mouseX, mouseY)){
				link.onDrawToolTip(mouseX, mouseY);
			}
		}		
	}
	
	public void onMouseClick(int mouseX, int mouseY){
		for(Link link : this.links){
			if(link.isMouseHover(mouseX, mouseY)){
				this.guiGuideBook.mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
				this.gotoLink(link.link);
				break;
			}
		}
	}
}
