package ckhbox.villagebento.client.gui.villager;

import java.io.IOException;
import java.util.ArrayList;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.GuiTextButton;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerMain;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetFollowing;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetHome;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetInteracting;
import ckhbox.villagebento.common.network.message.villager.MessageGuiVillagerOpen;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.profession.Profession;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiVillagerMain extends GuiContainer{
	
	private static final ResourceLocation VillagerMainGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/main.png"));
    protected int xSize = 176;
    protected int ySize = 166;
    protected int villagerTextOffsetY = 30;
    protected int villagerNameOffsetY = 6;
    protected int playerChatOptionsOffsetY = 88;
    protected int playerChatOptionHeight = 18;
    protected int offsetX = 12;
    
    GuiTextButton buttonUpgrade;
    GuiTextButton buttonTrade;
    GuiTextButton buttonFollow;
    GuiTextButton buttonHome;
    
    private EntityPlayer player;
    private EntityVillager villager;
    
	public GuiVillagerMain(EntityPlayer player, EntityVillager villager)
    {
        super(new ContainerVillagerMain());
        this.player = player;
        this.villager = villager;
        
        ModNetwork.getInstance().sendToServer(new MessageGuiSetInteracting(this.villager.getEntityId(), this.villager.dimension, true));
    }

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;  
        
        String strUpgrade = StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.upgrade"));
        String strTrade = StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.trade"));
        
        this.buttonList.add(buttonTrade = new GuiTextButton(this.mc, 0, x + offsetX, y + playerChatOptionsOffsetY + 0 * playerChatOptionHeight, strTrade));
        this.buttonList.add(buttonUpgrade = new GuiTextButton(this.mc, 1, x + offsetX, y + playerChatOptionsOffsetY + 1 * playerChatOptionHeight, strUpgrade));
        this.buttonList.add(buttonFollow = new GuiTextButton(this.mc, 2, x + offsetX, y + playerChatOptionsOffsetY + 2 * playerChatOptionHeight, ""));
        this.buttonList.add(buttonHome = new GuiTextButton(this.mc, 3, x + offsetX, y + playerChatOptionsOffsetY + 3 * playerChatOptionHeight, ""));

        this.refreshButtons(); 		
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    private void refreshButtons(){
    	String f = this.villager.isFollowing()?"stop":"start";
    	buttonFollow.setText(StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.follow." + f)));
    	
    	f = this.villager.hasHome()?"moveout":"movein";
    	buttonHome.setText(StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.home." + f)));
    	
    	Profession[] upgradeOptions = this.villager.getProfession().getUpgradeToNextOptions();
    	buttonUpgrade.enabled = this.villager.hasHome() && (upgradeOptions != null && upgradeOptions.length > 0);
    	buttonTrade.enabled = this.villager.hasHome();
    }
    
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(VillagerMainGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
        GuiHelper.drawNameAndProfession(this.mc.fontRendererObj, villager, this.width / 2, y + villagerNameOffsetY);
	}
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		super.drawScreen(mouseX, mouseY, partialTicks);

		GlStateManager.disableLighting();
		
		int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        
        String text = "Hello! welcome to villageb bento, I'm a villager in your village!";
        //this.drawWrappedString(this.mc.fontRendererObj, "test text....",x + offsetX, y + villagerTextOffsetY, 16777120, this.xSize - offsetX * 2);
        this.fontRendererObj.drawSplitString(text,x + offsetX, y + villagerTextOffsetY, this.xSize - offsetX * 2, 16777120);
        
        if(!this.buttonTrade.enabled){
    		this.drawButtonHoverText(this.buttonTrade, mouseX, mouseY, 
    			StatCollector.translateToLocal(PathHelper.full("gui.villagermain.button.lock.title")), 
    			StatCollector.translateToLocal(PathHelper.full("gui.villagermain.button.lock.desc")));
        }
        
        if(!this.buttonUpgrade.enabled){
        	if(!this.villager.hasHome())
        		this.drawButtonHoverText(this.buttonUpgrade, mouseX, mouseY, 
        			StatCollector.translateToLocal(PathHelper.full("gui.villagermain.button.lock.title")), 
        			StatCollector.translateToLocal(PathHelper.full("gui.villagermain.button.lock.desc")));
        	else
        		this.drawButtonHoverText(this.buttonUpgrade, mouseX, mouseY, 
            			StatCollector.translateToLocal(PathHelper.full("gui.villagermain.button.maxupgrade.title")), 
            			StatCollector.translateToLocal(PathHelper.full("gui.villagermain.button.maxupgrade.desc")));
        }

	}

	private void drawButtonHoverText(GuiButton button, int mouseX, int mouseY, String title, String desc){	
		if(GuiHelper.isPointInRegion(button.xPosition, button.yPosition, button.width, button.height, mouseX, mouseY)){
			ArrayList<String> list = new ArrayList<String>();
			list.add("§c" + title);
			list.add("§7" + desc);
			this.drawHoveringText(list, mouseX, mouseY, this.fontRendererObj);
		}
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		if(button == buttonUpgrade){
			ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerUpgrading,villager.dimension,villager.getEntityId()));
		}
		else if(button == buttonTrade){
			ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerTrading,villager.dimension,villager.getEntityId()));
		}
		else if(button == buttonFollow){
			boolean enable = !this.villager.isFollowing();
			ModNetwork.getInstance().sendToServer(new MessageGuiSetFollowing(this.villager.getEntityId(), this.villager.dimension, enable));
		}
		else if(button == buttonHome){
			ModNetwork.getInstance().sendToServer(new MessageGuiSetHome(this.villager.getEntityId(), this.villager.dimension,!this.villager.hasHome()));
		}
		
		super.actionPerformed(button);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		
		if (keyCode == 1 || keyCode == this.mc.gameSettings.keyBindInventory.getKeyCode()){
			ModNetwork.getInstance().sendToServer(new MessageGuiSetInteracting(this.villager.getEntityId(), this.villager.dimension, false));
		}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		
		this.refreshButtons(); 
	}	
	
}
