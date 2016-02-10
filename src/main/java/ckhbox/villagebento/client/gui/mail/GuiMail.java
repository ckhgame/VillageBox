package ckhbox.villagebento.client.gui.mail;

import java.io.IOException;

import ckhbox.villagebento.client.gui.GuiTextButton;
import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.item.mail.ItemMail;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetFollowing;
import ckhbox.villagebento.common.network.message.villager.MessageSpawnNewVillagerThroughMail;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiMail extends GuiScreen{

	private static final ResourceLocation mailGuiTextures = new ResourceLocation(PathHelper.full("textures/gui/mail/mail.png"));
	
	protected int xSize = 140;
    protected int ySize = 180; 
    
	private EntityPlayer player;
	
	private GuiTextButton buttonApprove;
	
	public GuiMail(EntityPlayer player) {
		this.player = player;
	}

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        
        this.buttonList.add(this.buttonApprove = new GuiTextButton(this.mc, 0, this.width / 2,y + 180, StatCollector.translateToLocal(PathHelper.full("gui.mail.button.approve"))));
        
        ItemStack hold = this.player.getHeldItem();
        if(hold.getItem() == ModItems.mail){
        	this.buttonApprove.visible = ItemMail.isNewVillager(hold);
        }
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(mailGuiTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
			
        ItemStack hold = this.player.getHeldItem();
        if(hold.getItem() == ModItems.mail){
        	String content = StatCollector.translateToLocal(ItemMail.getMailContent(hold));
        	String sender = ItemMail.getMailSender(hold);
        	String hi = StatCollector.translateToLocalFormatted(PathHelper.full("gui.mail.hi"), this.player.getName(),false);
    		this.fontRendererObj.drawString(hi, x + 12, y + 4, 0);
    		this.fontRendererObj.drawSplitString(content, x + 12, y + 16, this.xSize - 24, 0);
    		int h = this.fontRendererObj.splitStringWidth(content, this.xSize - 24);
    		this.fontRendererObj.drawString(sender, x + this.xSize - 24 - this.fontRendererObj.getStringWidth(sender), y + 20 + h, 0, false);
        }
        
		
		
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		super.actionPerformed(button);
		
		if(button == buttonApprove){
			ModNetwork.getInstance().sendToServer(new MessageSpawnNewVillagerThroughMail());
			this.mc.thePlayer.closeScreen();
		}
	}
	
}
