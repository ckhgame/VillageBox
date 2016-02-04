package ckhbox.villagebento.client.gui.villager;

import java.io.IOException;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.GuiTextButton;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.MessageGuiVillagerOpen;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiVillagerMain extends GuiScreen{
	
	private static final ResourceLocation VillagerMainGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/main.png"));
    protected int xSize = 176;
    protected int ySize = 166;
    protected int villagerTextOffsetY = 30;
    protected int villagerNameOffsetY = 6;
    protected int playerChatOptionsOffsetY = 88;
    protected int playerChatOptionHeight = 18;
    protected int offsetX = 12;
    
    private EntityPlayer player;
    private EntityVillager villager;
    
	public GuiVillagerMain(EntityPlayer player, EntityVillager villager)
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
        
        String[] strOptions = new String[]{"> View Status","> Trading","> Option 3","> Option 4"};
        
        for(int i =0;i<4;i++){
        	this.buttonList.add(new GuiTextButton(this.mc, i, x + offsetX, y + playerChatOptionsOffsetY + i * playerChatOptionHeight, strOptions[i]));
        }
        
    }
    
    public boolean doesGuiPauseGame()
    {
        return false;
    }

    
    
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(VillagerMainGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
        GuiHelper.drawNameAndProfession(this.mc.fontRendererObj, villager, this.width / 2, y + villagerNameOffsetY);
        
        String text = "Hello! welcome to villageb bento, I'm a villager in your village!";
        //this.drawWrappedString(this.mc.fontRendererObj, "test text....",x + offsetX, y + villagerTextOffsetY, 16777120, this.xSize - offsetX * 2);
        this.fontRendererObj.drawSplitString(text,x + offsetX, y + villagerTextOffsetY, this.xSize - offsetX * 2, 16777120);
        
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException {

		if(button.id == 0){//trade
			FMLCommonHandler.instance().showGuiScreen(new GuiVillagerStatus(this.player, this.villager));
		}
		else if(button.id == 1){
			ModNetwork.getInstance().sendToServer(new MessageGuiVillagerOpen(GuiIDs.VillagerTrading,villager.dimension,villager.getEntityId()));
		}
		
		
		super.actionPerformed(button);
	}
    
	
	
	
	
}
