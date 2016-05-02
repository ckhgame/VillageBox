package ckhbox.villagebox.client.gui.quest;

import java.io.IOException;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.common.gui.common.ContainerEmpty;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.item.common.ItemMail;
import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.villager.MessageSpawnNewVillagerThroughMail;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.quest.Quest;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public abstract class GuiQuest extends GuiContainer{
	
	private static final ResourceLocation questGuiTextures = new ResourceLocation(PathHelper.full("textures/gui/quest/quest.png"));
    
	private EntityPlayer player;
	private Quest quest;
	private GuiButton btnComplate;
	
	private String text;
	private ItemStack[] required;
	private ItemStack[] rewards;
	
	public GuiQuest(EntityPlayer player, Quest quest) {
		super(new ContainerEmpty());
		this.player = player;
		this.quest = quest;
	}

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        
        if(this.quest != null){
            this.btnComplate = new GuiButton(100,x + this.xSize/2 - 50, y + 136, 100,20,"Complete");
            this.buttonList.add(this.btnComplate);
            
            text = this.quest.getText(player);
            required = this.quest.getRequirements();
            rewards = this.quest.getRewards();
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
		
		int x = (this.width - this.xSize) / 2 + 8;
        int y = (this.height - this.ySize) / 2 + 30;
        
		GlStateManager.disableLighting();
		
		//quest text
		int wrapWidth = 160;
		this.fontRendererObj.drawSplitString(text, x, y, wrapWidth, 0xFFFFFFFF);
		y += this.fontRendererObj.splitStringWidth(text, wrapWidth) + 8;
		
		GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
		
		//quest requirements
        GlStateManager.disableLighting();
		this.fontRendererObj.drawString("Requirements", x, y, 0xFFFFFFFF);
        GlStateManager.enableLighting();
		y+= 12;
		for(int i =0;i<this.required.length;i++){
			this.itemRender.renderItemAndEffectIntoGUI(this.required[i], x + i * 20, y);
			this.itemRender.renderItemOverlays(this.fontRendererObj, this.required[i], x + i * 20, y);
		}
		y+=24;
		
		//quest rewards
		GlStateManager.disableLighting();
		this.fontRendererObj.drawString("Rewards", x, y, 0xFFFFFFFF);
		GlStateManager.enableLighting();
		y+= 12;
		for(int i =0;i<this.rewards.length;i++){
			this.itemRender.renderItemAndEffectIntoGUI(this.rewards[i], x + i * 20, y);
			this.itemRender.renderItemOverlays(this.fontRendererObj, this.rewards[i], x + i * 20, y);
		}
		
		GlStateManager.disableLighting();
		
        GlStateManager.popMatrix();
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
