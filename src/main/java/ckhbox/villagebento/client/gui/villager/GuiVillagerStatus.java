package ckhbox.villagebento.client.gui.villager;

import java.io.IOException;
import java.util.ArrayList;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.MessageGuiVillagerOpen;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.attribute.VillagerAttribute;
import ckhbox.villagebento.common.village.profession.Profession;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiVillagerStatus extends GuiScreen{
	
	private static final ResourceLocation VillagerAttributeGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/status.png"));
	private static final ResourceLocation VillagerAttributeIconsTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/attributes.png"));
    protected int xSize = 176;
    protected int ySize = 166;
    protected int villagerAttributesOffsetY = 30;
    protected int villagerNameOffsetY = 6;
    protected int offsetX = 20;
    
    private ImageButton buttonGift;
    private ImageButton buttonUpgrade;
    
    private EntityPlayer player;
    private EntityVillager villager;
    
	public GuiVillagerStatus(EntityPlayer player, EntityVillager villager)
    {
        super();
        this.player = player;
        this.villager = villager;
    }

    public void initGui()
    {
        super.initGui();
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.buttonGift = new ImageButton(0, x + 44, y + 106, 32);
        this.buttonUpgrade = new ImageButton(1, x + 100, y + 106, 0);
        
        this.buttonList.add(this.buttonGift);
        this.buttonList.add(this.buttonUpgrade);
        
        Profession[] upgradeOptions = this.villager.getProfession().getUpgradeToNextOptions();
        this.buttonUpgrade.enabled = (upgradeOptions != null && upgradeOptions.length > 0);
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(VillagerAttributeGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
		super.drawScreen(mouseX, mouseY, partialTicks);
        
        GuiHelper.drawNameAndProfession(this.mc.fontRendererObj, villager, this.width / 2, y + villagerNameOffsetY);
        
        for(int i =0;i<3;i++){
        	this.drawAttribute(x + offsetX, y + villagerAttributesOffsetY + 22 * i, (VillagerAttribute)this.villager.getAttributes().get(i));
        }
        
        for(int i =0;i<3;i++){
        	this.drawAttributeHoverText(x + offsetX, y + villagerAttributesOffsetY + 22 * i, mouseX, mouseY, (VillagerAttribute)this.villager.getAttributes().get(i));
        }
        
        String strGiftTitle = StatCollector.translateToLocal(PathHelper.full("gui.villagerstatus.buttongift.title"));
        String strGiftDesc = StatCollector.translateToLocal(PathHelper.full("gui.villagerstatus.buttongift.desc"));
        String strUpgradeTitle = StatCollector.translateToLocal(PathHelper.full("gui.villagerstatus.buttonupgrade.title"));
        String strUpgradeDesc = this.buttonUpgrade.enabled?	StatCollector.translateToLocal(PathHelper.full("gui.villagerstatus.buttonupgrade.desc")):
        													StatCollector.translateToLocal(PathHelper.full("gui.villagerstatus.buttonupgrade.desc.disable"));
        
        this.drawButtonHoverText(this.buttonGift, mouseX, mouseY, strGiftTitle, strGiftDesc);
        this.drawButtonHoverText(this.buttonUpgrade, mouseX, mouseY, strUpgradeTitle, strUpgradeDesc);
	}
	
	private void drawAttribute(int x, int y, VillagerAttribute attribute){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(VillagerAttributeIconsTexture);
		this.drawTexturedModalRect(x, y, attribute.getIconIdx() * 16, 0, 16, 16);
		String text = String.format("§e%d §f(§a%d§f) / §e%d", attribute.getValue(), attribute.getValueGrowing(), attribute.getMaxValue()); 
		this.drawString(this.fontRendererObj, text, x + 20, y + 4, 0);
	}
	
	private void drawAttributeHoverText(int x, int y, int mouseX, int mouseY, VillagerAttribute attribute){	
		if(GuiHelper.isPointInRegion(x, y, 16, 16, mouseX, mouseY)){
			ArrayList<String> list = new ArrayList<String>();
			list.add("§f" + attribute.getDisplayName());
			this.drawHoveringText(list, mouseX, mouseY, this.fontRendererObj);
		}
	}

	private void drawButtonHoverText(GuiButton button, int mouseX, int mouseY, String title, String desc){	
		if(GuiHelper.isPointInRegion(button.xPosition, button.yPosition, button.width, button.height, mouseX, mouseY)){
			ArrayList<String> list = new ArrayList<String>();
			list.add("§e" + title);
			list.add("§f" + desc);
			this.drawHoveringText(list, mouseX, mouseY, this.fontRendererObj);
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		if(button.id == buttonGift.id){//gift
			//ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerTrading,villager.dimension,villager.getEntityId()));
		}
		else if(button.id == buttonUpgrade.id){//upgrade
			ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerUpgrading,villager.dimension,villager.getEntityId()));
		}
		
		
		super.actionPerformed(button);
	}
    
	
	@SideOnly(Side.CLIENT)
    static class ImageButton extends GuiButton
    {
        private final int u;

        public ImageButton(int buttonID, int x, int y, int u)
        {
            super(buttonID, x, y, 32, 32, "");
            this.u = u;
        }

        /**
         * Draws this button to the screen.
         */
        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if (this.visible)
            {
                mc.getTextureManager().bindTexture(VillagerAttributeGuiTexture);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
                int i = 0;
                int j = 176 + this.u;

                if(!this.enabled){
                	i += 64;
                }
                else if(flag){
                	i += 32;
                }

                this.drawTexturedModalRect(this.xPosition, this.yPosition, j, i, this.width, this.height);
            }
        }
    }
	
	
}
