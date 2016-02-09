package ckhbox.villagebento.client.gui.player;

import java.io.IOException;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.GuiTextButton;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.gui.player.ContainerVillageBook;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetFollowing;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetHome;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetInteracting;
import ckhbox.villagebento.common.network.message.villager.MessageGuiVillagerOpen;
import ckhbox.villagebento.common.player.ExtendedPlayerProperties;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiVillageBook extends GuiContainer{

	private static final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");
	
	
	protected int xSize = 192;
    protected int ySize = 192; 
    GuiTextButton buttonHireNewVillager;  
    private EntityVillager villager;
	private EntityPlayer player;
	private ExtendedPlayerProperties properties;
	
	public GuiVillageBook(EntityPlayer player) {
		super(new ContainerVillageBook(player));
		this.player = player;
		this.properties = ExtendedPlayerProperties.get(player);
	}

    public void initGui()
    {
        super.initGui();
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }
    
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bookGuiTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		
        String text = "New Villager:" + this.properties.hasNewVillager;
        this.drawCenteredString(this.fontRendererObj, text, this.width/2, this.height / 2, 0xFFFF0000);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		
		super.actionPerformed(button);
	}
}
