package ckhbox.villagebox.client.gui.quest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.common.config.VBConfig;
import ckhbox.villagebox.common.gui.common.ContainerEmpty;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.item.common.ItemMail;
import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.villager.MessageSpawnNewVillagerThroughMail;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.IQuestProvider;
import ckhbox.villagebox.common.village.quest.Quest;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.resources.I18n;

public abstract class GuiQuest extends GuiContainer{
	
	private static final ResourceLocation questGuiTextures = new ResourceLocation(PathHelper.full("textures/gui/quest/quest.png"));
    
	private EntityPlayer player;
	private IQuestProvider provider;
	private Quest quest;
	private GuiButton btnComplate;
	
	private String text;
	private ItemStack[] required;
	private ItemStack[] rewards;
	
	private ItemStack cacheProgressItem;
	private List<String> cacheProgressString = new ArrayList<String>();
	
	public GuiQuest(EntityPlayer player, IQuestProvider provider) {
		super(new ContainerEmpty());
		this.player = player;
		this.provider = provider;
		this.quest = this.provider.getCurrentQuest();
	}

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        
        if(this.quest != null){
            this.btnComplate = new GuiButton(100,x + this.xSize/2 - 50, y + 136, 100,20,I18n.format(PathHelper.full("gui.quest.complete")));
            this.buttonList.add(this.btnComplate);
            
            text = this.quest.getText(player);
            required = this.quest.getRequirements();
            rewards = this.quest.getRewards();
            
            this.btnComplate.enabled = this.quest.canComplete(this.player);
        }
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(questGuiTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
	
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	
		super.drawScreen(mouseX, mouseY, partialTicks);
		
        if(this.quest == null) return;
		
		int x = (this.width - this.xSize) / 2 + 10;
        int y = (this.height - this.ySize) / 2 + 30;
        
		GlStateManager.disableLighting();
		
		//quest text
		int wrapWidth = 156;
		this.fontRendererObj.drawSplitString(text, x, y, wrapWidth, 0xFFFFFFFF);
		y += this.fontRendererObj.splitStringWidth(text, wrapWidth) + 8;
		
		//ticks left
		String tt;
		int left = this.provider.getCurrentQuestTicksLeft();
		if(left > 6000) tt = "long";
		else tt = "short";
		String tickstext = I18n.format(PathHelper.full("gui.quest.timeleft." + tt), left / 1000 + 1);
		if(VBConfig.displayExtraInfo) tickstext += "(" + left + ")";
		this.fontRendererObj.drawString(tickstext, x, y, 0xFFFFFFFF,false);
		y += 16;
		
		GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
		
		//quest requirements
        GlStateManager.disableLighting();
		this.fontRendererObj.drawString(I18n.format(PathHelper.full("gui.quest.requirements")), x, y, 0xFFFFFFFF);
        GlStateManager.enableLighting();
		y+= 12;
		int y1 = y - this.guiTop;
		for(int i =0;i<this.required.length;i++){
			this.itemRender.renderItemAndEffectIntoGUI(this.required[i], x + i * 20, y);
			this.itemRender.renderItemOverlays(this.fontRendererObj, this.required[i], x + i * 20, y);
		}
		y+=24;
		
		//quest rewards
		GlStateManager.disableLighting();
		this.fontRendererObj.drawString(I18n.format(PathHelper.full("gui.quest.rewards")), x, y, 0xFFFFFFFF);
		GlStateManager.enableLighting();
		y+= 12;
		int y2 = y - this.guiTop;
		for(int i =0;i<this.rewards.length;i++){
			this.itemRender.renderItemAndEffectIntoGUI(this.rewards[i], x + i * 20, y);
			this.itemRender.renderItemOverlays(this.fontRendererObj, this.rewards[i], x + i * 20, y);
		}
		
		GlStateManager.disableLighting();
		
        GlStateManager.popMatrix();
		
		//hover texts     
        x -= this.guiLeft;
		for(int i =0;i<this.required.length;i++){
			if (this.isPointInRegion(x + i * 20, y1, 16, 16, mouseX, mouseY) && required[i] != null){
				this.renderToolTip(this.required[i], mouseX, mouseY);
				this.renderProgress(this.required[i], mouseX, mouseY - 16);
	        }
		}
		
		for(int i =0;i<this.rewards.length;i++){
			if (this.isPointInRegion(x + i * 20, y2, 16, 16, mouseX, mouseY) && rewards[i] != null){
				this.renderToolTip(this.rewards[i], mouseX, mouseY);
	        }
		}
	}
	
	private void renderProgress(ItemStack itemstack, int mouseX, int mouseY){
		if(itemstack == null) return;
		if(this.cacheProgressItem != itemstack){
			this.cacheProgressItem = itemstack;
			int num = this.quest.getItemNum(this.cacheProgressItem, this.player);
			String state = num >= itemstack.stackSize?"meet":"unmeet";
			this.cacheProgressString.clear();
			this.cacheProgressString.add(I18n.format(PathHelper.full("gui.quest.progress." + state),num,itemstack.stackSize));
		}
		this.drawHoveringText(this.cacheProgressString, mouseX, mouseY);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		
		if(button == this.btnComplate){
			this.onButtonCompleteClicked();
			this.mc.thePlayer.closeScreen();
		}
	}
	
	protected abstract void onButtonCompleteClicked();
}
