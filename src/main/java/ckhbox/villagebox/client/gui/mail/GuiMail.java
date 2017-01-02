package ckhbox.villagebox.client.gui.mail;

import java.io.IOException;

import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.common.gui.common.ContainerEmpty;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.item.common.ItemMail;
import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.villager.MessageSpawnNewVillagerThroughMail;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiMail extends GuiContainer{

	private static final ResourceLocation mailGuiTextures = new ResourceLocation(PathHelper.full("textures/gui/mail/mail.png"));
	
	protected int xSize = 143;
    protected int ySize = 150; 
    
	private EntityPlayer player;
	
	private GuiTextButton buttonApprove;
	
	public GuiMail(EntityPlayer player) {
		super(new ContainerEmpty());
		this.player = player;
	}

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        
        this.buttonList.add(this.buttonApprove = new GuiTextButton(this.mc, 0, 0,y + 130, I18n.format(PathHelper.full("gui.mail.button.approve"))));
        this.buttonApprove.xPosition = this.width / 2 - this.buttonApprove.width / 2;
        this.buttonApprove.setColors(0xFF006400, 0xFF32CD32);
        this.buttonApprove.setShadow(false);
        
        ItemStack hold = this.player.getHeldItemMainhand();
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
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(mailGuiTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
	
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
	
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;

		GlStateManager.disableLighting();
        ItemStack hold = this.player.getHeldItemMainhand();
        if(hold.getItem() == ModItems.mail){
        	String content = I18n.format(ItemMail.getMailContent(hold));
        	String sender = I18n.format(PathHelper.full("gui.mail.from"), ItemMail.getMailSender(hold));
        	String hi = I18n.format(PathHelper.full("gui.mail.hi"), this.player.getName(),false);
    		this.fontRendererObj.drawString(hi, x + 20, y + 12, 0);
    		this.fontRendererObj.drawSplitString(content, x + 20, y + 28, this.xSize - 40, 0);
    		int h = this.fontRendererObj.splitStringWidth(content, this.xSize - 40);
    		this.fontRendererObj.drawString(sender, x + this.xSize - 20 - this.fontRendererObj.getStringWidth(sender), y + 36 + h, 0, false);
        }
        
		
		
		
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
