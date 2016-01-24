package ckhbox.villagebento.client.gui.villager;

import java.util.List;

import ckhbox.villagebento.client.gui.GuiTextButton;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiVillagerMain extends GuiScreen{
	
	private static final ResourceLocation VillagerMainGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/main.png"));
    protected int xSize = 176;
    protected int ySize = 166;
    protected int villagerTextOffsetY = 30;
    protected int villagerNameOffsetY = 6;
    protected int playerChatOptionsOffsetY = 88;
    protected int playerChatOptionHeight = 18;
    protected int offsetX = 12;
    
	public GuiVillagerMain()
    {
        super();
    }

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;  
        
        for(int i =0;i<4;i++){
        	this.buttonList.add(new GuiTextButton(this.mc, 1, x + offsetX, y + playerChatOptionsOffsetY + i * playerChatOptionHeight, "> chat option " + i));
        }
        
    }

    
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(VillagerMainGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
        String name = "Mike";
        String job = "Novice Builder";
        this.drawCenteredStringNoshadow(this.mc.fontRendererObj, name, this.width / 2, y + villagerNameOffsetY, 6316128);
        this.drawCenteredStringNoshadow(this.mc.fontRendererObj, job, this.width / 2, y + villagerNameOffsetY + 10, 8421504);
        
        String text = "Hello! welcome to villageb bento, I'm a villager in your village!";
        //this.drawWrappedString(this.mc.fontRendererObj, "test text....",x + offsetX, y + villagerTextOffsetY, 16777120, this.xSize - offsetX * 2);
        this.fontRendererObj.drawSplitString(text,x + offsetX, y + villagerTextOffsetY, this.xSize - offsetX * 2, 16777120);
        
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
    
	protected void drawWrappedString(FontRenderer renderer, String drawing, int x, int y, int color, int wrap)
    {
        List<String> lines = renderer.listFormattedStringToWidth(drawing, wrap);
        for (int i = 0; i < lines.size(); i++)
            renderer.drawString(lines.get(i), x, y + (i * 9), color, false);
    }
	
	public void drawCenteredStringNoshadow(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.drawString(text, x - fontRendererIn.getStringWidth(text) / 2, y, color);
    }
	
}
