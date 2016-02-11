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
	
	protected int xSize = 143;
    protected int ySize = 150; 
    
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
        
        this.buttonList.add(this.buttonApprove = new GuiTextButton(this.mc, 0, 0,y + 130, StatCollector.translateToLocal(PathHelper.full("gui.mail.button.approve"))));
        this.buttonApprove.xPosition = this.width / 2 - this.buttonApprove.width / 2;
        this.buttonApprove.setColors(0xFF006400, 0xFF32CD32);
        
        ItemStack hold = this.player.getHeldItem();
        if(hold.getItem() == ModItems.mail){
        	int mailType = ItemMail.getMailType(hold);
        	this.buttonApprove.visible = (mailType == ItemMail.MailType_NewVillagerFemale || mailType == ItemMail.MailType_NewVillagerMale);
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
        	String sender = "§o" + ItemMail.getMailSender(hold);
        	String hi = StatCollector.translateToLocalFormatted(PathHelper.full("gui.mail.hi"), this.player.getName(),false);
    		this.fontRendererObj.drawString(hi, x + 20, y + 12, 0);
    		this.fontRendererObj.drawSplitString(content, x + 20, y + 28, this.xSize - 40, 0);
    		int h = this.fontRendererObj.splitStringWidth(content, this.xSize - 40);
    		this.fontRendererObj.drawString(sender, x + this.xSize - 20 - this.fontRendererObj.getStringWidth(sender), y + 36 + h, 0, false);
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
