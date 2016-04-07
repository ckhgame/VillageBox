package ckhbox.villagebox.client.gui.guidebook.page;

import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.client.gui.guidebook.GuiGuideBook;
import ckhbox.villagebox.client.gui.guidebook.page.link.Link;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public abstract class Page {
	
	public GuiGuideBook guiGuideBook;
	private ArrayList<Link> links = new ArrayList<Link>();
	
	//flow layout (not a real flow layout =P)
	private int flowLeft;
	private int flowTop;
	private int flowBot;
	private String title;
	
	public Page(GuiGuideBook guiGuideBook,String title){
		this.guiGuideBook = guiGuideBook;
		this.flowLeft = this.guiGuideBook.getContentLeft();
		this.flowTop = this.guiGuideBook.getContentTop();
		this.flowBot = this.flowTop;
		if(title != null){
			this.title = title;
			this.setFlowTop(this.guiGuideBook.getContentTop() + 16);
		}
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
		this.flowBot = this.flowTop + link.height;
		
		this.links.add(link);
	}
	
	/**
	 * @param link
	 * @param align 0=force left, 1= force middle, 2=force right
	 */
	public void addLink(Link link, int top, int align){
		
		if(align == 2){
			link.left = this.guiGuideBook.getContentRight() - link.width;
		}
		else if(align == 1){
			link.left = this.guiGuideBook.getContentLeft() + (this.guiGuideBook.getContentWidth() - link.width)/2;
		}
		else{
			link.left = this.guiGuideBook.getContentLeft();
		}
	
		link.top = top;
		
		this.links.add(link);
	}
	
	private void gotoLink(String link){
		//reslove links
		//format: PAGETYPE=PARAMS, examples: 1. item=staff   2.  pro=cook   3. home=
		String[] arr = link.split("=");
		Page newPage = null;
		if(arr[0].equals("home")){
			newPage = new PageHome(this.guiGuideBook);
		}
		else if(arr[0].equals("itemlist")){
			int pageIdx = Integer.valueOf(arr[1]);
			newPage = new PageItemList(this.guiGuideBook,pageIdx);
		}
		
		if(newPage!=null){
			this.guiGuideBook.openPage(newPage);
		}
		
	}
	
	public abstract void onInit();
	
	public void setFlowTop(int top){
		this.flowTop = top;
		this.flowBot = this.flowTop;
		this.flowLeft = this.guiGuideBook.getContentLeft();
	}
	
	public void onDrawScreen(int mouseX, int mouseY){		
		//title
		if(this.title != null){
			GlStateManager.disableLighting();
			int top = this.guiGuideBook.getContentTop();
			int left = this.guiGuideBook.getContentLeft() + (this.guiGuideBook.getContentWidth() - this.guiGuideBook.mc.fontRendererObj.getStringWidth(this.title))/2;
			this.guiGuideBook.mc.fontRendererObj.drawString(this.title, left, top, 0xFF555500, false);
			GlStateManager.enableLighting();
		}
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
