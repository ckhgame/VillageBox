package ckhbox.villagebento.client.gui.villager;

import java.io.IOException;

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
    
    GuiTextButton buttonViewStatus;
    GuiTextButton buttonTrade;
    GuiTextButton buttonFollow;
    GuiTextButton buttonSetHome;
    
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
        
        String[] strOptions = new String[]{
        		StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.viewstatus")),
        		StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.trade")),
        		StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.sethome"))
        		};
        
        this.buttonList.add(buttonViewStatus = new GuiTextButton(this.mc, 0, x + offsetX, y + playerChatOptionsOffsetY + 0 * playerChatOptionHeight, strOptions[0]));
        this.buttonList.add(buttonTrade = new GuiTextButton(this.mc, 1, x + offsetX, y + playerChatOptionsOffsetY + 1 * playerChatOptionHeight, strOptions[1]));
        this.buttonList.add(buttonFollow = new GuiTextButton(this.mc, 2, x + offsetX, y + playerChatOptionsOffsetY + 2 * playerChatOptionHeight, ""));
        this.buttonList.add(buttonSetHome = new GuiTextButton(this.mc, 3, x + offsetX, y + playerChatOptionsOffsetY + 3 * playerChatOptionHeight, strOptions[2]));
        
        this.refreshFollowButton(); 		
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    private void refreshFollowButton(){
    	String f = this.villager.isFollowing()?"stop":"start";
    	buttonFollow.setText(StatCollector.translateToLocal(PathHelper.full("gui.villagermain.menu.follow." + f)));
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

	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		if(button.id == 0){//view status
			ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerStatus,villager.dimension,villager.getEntityId()));
		}
		else if(button.id == 1){//trade
			ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerTrading,villager.dimension,villager.getEntityId()));
		}
		else if(button.id == 2){//follow
			boolean enable = !this.villager.isFollowing();
			ModNetwork.getInstance().sendToServer(new MessageGuiSetFollowing(this.villager.getEntityId(), this.villager.dimension, enable));
			this.refreshFollowButton();
		}
		else if(button.id == 3){//set home
			ModNetwork.getInstance().sendToServer(new MessageGuiSetHome(this.villager.getEntityId(), this.villager.dimension));
		}
		
		super.actionPerformed(button);
	}

	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		
		if (keyCode == 1){
			ModNetwork.getInstance().sendToServer(new MessageGuiSetInteracting(this.villager.getEntityId(), this.villager.dimension, false));
		}
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		
		this.refreshFollowButton(); 
	}	
	
}
