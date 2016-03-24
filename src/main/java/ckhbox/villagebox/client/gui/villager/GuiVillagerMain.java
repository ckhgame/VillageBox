package ckhbox.villagebox.client.gui.villager;

import java.io.IOException;
import java.util.ArrayList;

import ckhbox.villagebox.client.gui.GuiHelper;
import ckhbox.villagebox.client.gui.GuiTextButton;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.gui.GuiIDs;
import ckhbox.villagebox.common.gui.villager.ContainerVillagerMain;
import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSetFollowing;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSetHome;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSetInteracting;
import ckhbox.villagebox.common.network.message.villager.MessageGuiVillagerOpen;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
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
    
    private String chatContent;
    private String chatContentDisplay;
    private int chatDisplayInterval; // ms
    private int chatDisplayDurationTotal = 1000; // ms
    
    private boolean isFollowingLast;
    private boolean hasHomeLast;
    
    private EntityPlayer player;
    private EntityVillager villager;
    
    private long lastNanotime;
    private long chatTimer;
    
	public GuiVillagerMain(EntityPlayer player, EntityVillager villager)
    {
        super(new ContainerVillagerMain());
        this.player = player;
        this.villager = villager;
        
        this.isFollowingLast = this.villager.isFollowing();
        this.hasHomeLast = this.villager.hasHome();
        
        this.lastNanotime = System.nanoTime();
        
        refreshChatContent();
        
        ModNetwork.getInstance().sendToServer(new MessageGuiSetInteracting(this.villager.getEntityId(), this.villager.dimension, true));
    }

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;  
        
        String strUpgrade = I18n.format(PathHelper.full("gui.villagermain.menu.upgrade"));
        String strTrade = I18n.format(PathHelper.full("gui.villagermain.menu.trade"));
        
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
    	buttonFollow.setText(I18n.format(PathHelper.full("gui.villagermain.menu.follow." + f)));
    	
    	f = this.villager.hasHome()?"moveout":"movein";
    	buttonHome.setText(I18n.format(PathHelper.full("gui.villagermain.menu.home." + f)));
    	
    	Profession[] upgradeOptions = this.villager.getProfession().getUpgradeToNextOptions();
    	buttonUpgrade.enabled = this.villager.hasHome() && (upgradeOptions != null && upgradeOptions.length > 0);
    	buttonTrade.enabled = this.villager.hasHome();
    }
    
    private void calculateChatSpeed(){
    	int l = this.chatContent.length();
    	this.chatDisplayInterval = this.chatDisplayDurationTotal / l;
    }
    
    private void refreshChatContent(){
    	ArrayList<String> list = new ArrayList<String>();
    	//common
    	for(int i =0;i<3;i++){
    		list.add(I18n.format(PathHelper.full("gui.villagermain.menu.chat.common" + i), player.getName()));
    	}
    	String home = villager.hasHome()?"hashome":"nohome";
    	for(int i =0;i<2;i++){
    		list.add(I18n.format(PathHelper.full("gui.villagermain.menu.chat."+ home + i)));
    	}
    	
    	this.chatContent = list.get(Rand.get().nextInt(list.size()));
    	this.chatContentDisplay = "";
    	
    	this.calculateChatSpeed();
    }
    
    private void setChatContent(String type){
    	this.chatContent = I18n.format(PathHelper.full("gui.villagermain.menu.chat." + type));
    	this.chatContentDisplay = "";
    	
    	this.calculateChatSpeed();
    }
    
    private void updateChatContent(){
    	boolean isFollowing = this.villager.isFollowing();
    	boolean hasHome = this.villager.hasHome();
    	if(!this.isFollowingLast && isFollowing) setChatContent("followstart");
    	else if(this.isFollowingLast && !isFollowing) setChatContent("followstop");
    	
    	if(!this.hasHomeLast && hasHome) setChatContent("movein");
    	else if(this.hasHomeLast && !hasHome) setChatContent("moveout");
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
        
        long currentNanotime = System.nanoTime();
        
        
        //chat text animation
        if(this.chatContent.length() > this.chatContentDisplay.length()){
        	chatTimer += (currentNanotime - this.lastNanotime) / 1000000;
        	if(chatTimer >= this.chatDisplayInterval){
        		chatTimer -= this.chatDisplayInterval;
        		this.chatContentDisplay = this.chatContent.substring(0, this.chatContentDisplay.length() + 1);
        	}
        }
        
        this.lastNanotime = currentNanotime;
        
        this.fontRendererObj.drawSplitString(this.chatContentDisplay,x + offsetX, y + villagerTextOffsetY, this.xSize - offsetX * 2, 0xFFFF55);
        
        if(!this.buttonTrade.enabled){
    		this.drawButtonHoverText(this.buttonTrade, mouseX, mouseY, 
    			I18n.format(PathHelper.full("gui.villagermain.button.lock.title")), 
    			I18n.format(PathHelper.full("gui.villagermain.button.lock.desc")));
        }
        
        if(!this.buttonUpgrade.enabled){
        	if(!this.villager.hasHome())
        		this.drawButtonHoverText(this.buttonUpgrade, mouseX, mouseY, 
        			I18n.format(PathHelper.full("gui.villagermain.button.lock.title")), 
        			I18n.format(PathHelper.full("gui.villagermain.button.lock.desc")));
        	else
        		this.drawButtonHoverText(this.buttonUpgrade, mouseX, mouseY, 
            			I18n.format(PathHelper.full("gui.villagermain.button.maxupgrade.title")), 
            			I18n.format(PathHelper.full("gui.villagermain.button.maxupgrade.desc")));
        }

	}

	private void drawButtonHoverText(GuiButton button, int mouseX, int mouseY, String title, String desc){	
		if(GuiHelper.isPointInRegion(button.xPosition, button.yPosition, button.width, button.height, mouseX, mouseY)){
			ArrayList<String> list = new ArrayList<String>();
			list.add(title);
			list.add(desc);
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
		
		this.updateChatContent();
		this.refreshButtons(); 
		
		this.isFollowingLast = this.villager.isFollowing();
        this.hasHomeLast = this.villager.hasHome();
	}	
	
}
