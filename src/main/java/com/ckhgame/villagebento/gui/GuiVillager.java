package com.ckhgame.villagebento.gui;

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;

public abstract class GuiVillager extends GuiScreen {

	public static boolean isWaitingForActionResult = true; 
	public static void ActionStart(){
		isWaitingForActionResult = true;
	}
	public static void ActionCompleted(){
		isWaitingForActionResult = false;
	}
	
	protected VillagerComponent villagerComponent;
	protected EntityVBVillager entityVBVillager;
	protected int buttonID;
	protected String chatContent = "......";
	protected String chatContentDisplay = "";
	
	//filed locations
	protected int fieldVillagerHeadLeft;
	protected int fieldVillagerHeadTop;
	protected int fieldChatLeft;
	protected int fieldChatTop;
	protected int fieldCompLeft;
	protected int fieldCompTop;
	
	//mouse
	protected int mouseX,mouseY;
	
	protected int fieldVillagerHeadTopOffset = 0;
	
	//component button id start
	protected int compStartButtonID = 100;
	
	protected void setChatContent(String chatContent){
		this.chatContent = chatContent;
		chatContentDisplay = "";
		fieldVillagerHeadTopOffset = -4;
	}
	
	public void setVillageComponent(VillagerComponent villagerComponent){
		this.villagerComponent = villagerComponent;
		this.entityVBVillager = this.villagerComponent.getVillager();
	}
	
	protected void drawWrappedString(FontRenderer renderer, String drawing, int x, int y, int color, int wrap)
    {
        List<String> lines = renderer.listFormattedStringToWidth(drawing, wrap);
        for (int i = 0; i < lines.size(); i++)
            renderer.drawString(lines.get(i), x, y + (i * 9), color, false);
    }
	
	protected void drawRightedString(FontRenderer font, String text, int left, int top, int c)
    {
		font.drawStringWithShadow(text, left - font.getStringWidth(text), top, c);
    }
	
	protected boolean isMouseIn(int left, int top, int width, int height){
		if(	this.mouseX < left || 
			this.mouseX > left + width ||
			this.mouseY < top || 
			this.mouseY >= top + height){
			return false;
		}
		return true;
	}
	
	protected void drawItem(int left, int top, ItemStack itemStack){
		//item icon
		drawRect(left - 2, top - 2, left + 18, top + 18, 0xFF888888);
		drawRect(left - 1, top - 1, left + 17, top + 17, 0xFFCCCCCC);
		drawRect(left, top, left + 16, top + 16, 0xFFAAAAAA);	
		
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		RenderHelper.enableGUIStandardItemLighting();
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left, top);
		if(itemStack.getItem() == ModItems.itemVillageCurrency){
			String num = "x" + itemStack.getItemDamage();
			fontRendererObj.drawString(num, left + 16, top + 6, 0xFFFFFFFF);
		}
		else{
			String num = String.valueOf(itemStack.stackSize);
			itemRender.renderItemOverlayIntoGUI(fontRendererObj, this.mc.getTextureManager(), itemStack, left, top, num);
		}
		
		RenderHelper.disableStandardItemLighting();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);

		if(isMouseIn(left,top,16,16)){
			this.renderToolTip(itemStack, this.mouseX, this.mouseY);
		}
			
		GL11.glDisable(GL11.GL_LIGHTING);
	}
	
	private void drawFieldBackground(int left,int top,int width,int height){
		
		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF333333);
		drawRect(left - 1, top - 1, left + width + 1, top + height + 1, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFF555555);
	}
	
	private void drawVillagerHead(int left, int top, int width, int height){
		this.mc.getTextureManager().bindTexture(this.entityVBVillager.getProfession().getSkin());
		
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		double u = 0.125D;
		double uw = 0.125D;
		double v = 0.25D;
		double vh = 0.25D;
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((double)(left), (double)(top + height), (double)this.zLevel, u, v + vh);
        tessellator.addVertexWithUV((double)(left + width), (double)(top + height), (double)this.zLevel, u + uw, v + vh);
        tessellator.addVertexWithUV((double)(left + width), (double)(top), (double)this.zLevel, u + uw, v);
        tessellator.addVertexWithUV((double)(left), (double)(top), (double)this.zLevel, u, v);
        tessellator.draw();
        
        //mouth
        
        if(chatContent != null && chatContentDisplay != null){
        	int lc = chatContent.length();
            int lcd = chatContentDisplay.length();
            if(lcd < lc - 5){
            	int d = lcd % 10;
            	if(d < 5){
                    GL11.glColor4f(0.5F, 0.2F, 0.2F, 1.0F);
                    double mx = left + 0.375D * width;
                    double my = top + 0.875D * height;
                    double mw = 0.25D * width;
                    double mh = 0.125D * height;
                    double z = (double)this.zLevel + 0.0001D;
                    
                    GL11.glEnable(GL11.GL_BLEND);
                    GL11.glDisable(GL11.GL_TEXTURE_2D);        
                    tessellator.startDrawingQuads();
                    tessellator.addVertex(mx, my + mh, z);
                    tessellator.addVertex(mx + mw, my + mh, z);
                    tessellator.addVertex(mx + mw, my, z);
                    tessellator.addVertex(mx, my, z);
                    tessellator.draw();
                    GL11.glEnable(GL11.GL_TEXTURE_2D);
                    GL11.glDisable(GL11.GL_BLEND);
            	}
            }
        }
	}
	
	@Override
	public void drawScreen(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
		
		this.mouseX = p_73863_1_;
		this.mouseY = p_73863_2_;
		
		this.drawDefaultBackground();
		
		//GUI LAYOUT: Right Top Villager Head Field
		//head jump
		if(fieldVillagerHeadTopOffset < 0){
			fieldVillagerHeadTopOffset++;
		}
		drawFieldBackground(fieldVillagerHeadLeft,fieldVillagerHeadTop + fieldVillagerHeadTopOffset,30,30);
		drawVillagerHead(fieldVillagerHeadLeft + 3, fieldVillagerHeadTop + fieldVillagerHeadTopOffset + 3, 24, 24);
		
		//GUI LAYOUT: Right Top Chat Field
		
		drawFieldBackground(fieldChatLeft,fieldChatTop,166,30);
		//display name and chat content
		String name = this.entityVBVillager.getName() + ":";

		this.fontRendererObj.drawString(name, fieldChatLeft + 1,fieldChatTop + 1, 0xFFFFFF00,true);
		
		//chat anim
		if(chatContentDisplay.length() < chatContent.length()){
			chatContentDisplay = chatContent.substring(0, chatContentDisplay.length() + 1);
		}
		this.fontRendererObj.drawString(chatContentDisplay, fieldChatLeft + 6,fieldChatTop + 13, 0xFFFFFFEE,true);
		
		//GUI LAYOUT: Right Top Component Field
		drawFieldBackground(fieldCompLeft,fieldCompTop,200,100);
		
		onDrawScreen();
		
		GL11.glDisable(GL11.GL_LIGHTING);
		super.drawScreen(p_73863_1_, p_73863_2_, p_73863_3_);	
        GL11.glEnable(GL11.GL_LIGHTING);
	}

	@Override
	protected void actionPerformed(GuiButton button) {

		//leave
		if(button.id == 99999){
			this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
            return;
		}
		
		int compSize = this.entityVBVillager.getVillagerComponentsSize();
		VillagerComponent comp;
		for(int i =0;i<compSize;i++){
			comp = this.entityVBVillager.getVillagerComponent(i);
			if(comp.getGui().buttonID == button.id){
				if(comp.enabled()){
					this.mc.displayGuiScreen(comp.getGui());
				}
				else{
					this.mc.displayGuiScreen(this.entityVBVillager.getVillagerComponent(0).getGui());
				}
				return;
			}
		}
		
        onActionPerformed(button);
        
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
		
		//GUI LAYOUT
		//left buttons field
		int compSize = this.entityVBVillager.getVillagerComponentsSize();
		VillagerComponent comp;
		for(int i =0;i<compSize;i++){
			comp = this.entityVBVillager.getVillagerComponent(i);	
			if(comp.enabled()){
				comp.getGui().buttonID = id++;
				btn = new GuiButton(comp.getGui().buttonID, 
						this.width /2 - 130,this.height /2 - 50 + 20 * (count++),
						46,20,	
						comp.getGui().getButtonText());
				if(comp == villagerComponent)
					btn.enabled = false;
				this.buttonList.add(btn);
			}			
		}

		//leave button
		this.buttonList.add(new GuiButton(99999, this.width /2 - 130,this.height /2 + 64,46,20,"Leave"));
		
		fieldVillagerHeadLeft = this.width / 2 - 80;
		fieldVillagerHeadTop = this.height / 2 - 60;
		fieldChatLeft = this.width / 2 - 46;
		fieldChatTop = this.height /2 - 60;
		fieldCompLeft = this.width / 2 - 80;
		fieldCompTop = this.height /2 - 20;
		
		int compIdx = this.entityVBVillager.findVillagerComponentIdx(this.villagerComponent);
		if(compIdx < 0)
			System.out.println("Can not find the village component! idx < 0");
		else
			Action.send(ActionSyncVillagerComp.class, new Object[]{this.entityVBVillager.getEntityId(),compIdx, Minecraft.getMinecraft().thePlayer.getEntityId(),null});
		
		onInitGui();
		
		super.initGui();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
	
	@Override
	public void updateScreen() {
		super.updateScreen();
		
		//auto close gui screen when villager is far away from the player
		if(	this.entityVBVillager == null ||
			this.entityVBVillager.isSleeping() ||
			this.entityVBVillager.getDistanceSqToEntity(Minecraft.getMinecraft().thePlayer) > ConfigVillager.MaxInteractDistanceSq){
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
		
	}
	
	public void updateWithVBCompResult(VBCompResult vbCompResult){
		if(vbCompResult.chatContent != null && vbCompResult.chatContent != ""){
			setChatContent(vbCompResult.chatContent);
		}
	}
	
	public abstract String getButtonText();
	public abstract void onDrawScreen();
	public abstract void onInitGui();
	public abstract void onActionPerformed(GuiButton button);
	
	public abstract void onSyncCompleted();
	
}
