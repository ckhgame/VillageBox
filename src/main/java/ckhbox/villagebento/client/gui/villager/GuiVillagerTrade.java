package ckhbox.villagebento.client.gui.villager;

import java.util.List;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.GuiTextButton;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerTrading;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiVillagerTrade extends GuiContainer{
	
	private static final ResourceLocation VillagerTradeGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/trade.png"));

	 private IMerchant merchant;
    private TradeButton nextButton;
    private TradeButton previousButton;
    private int selectedMerchantRecipe;
    private IChatComponent chatComponent;
	
    protected int villagerTextOffsetY = 30;
    protected int villagerNameOffsetY = 6;
    protected int playerChatOptionsOffsetY = 88;
    protected int playerChatOptionHeight = 18;
    protected int offsetX = 12;
    
	public GuiVillagerTrade(InventoryPlayer p_i45500_1_, World worldIn)
    {
        super(new ContainerVillagerTrading(p_i45500_1_, worldIn));
        //this.merchant = p_i45500_2_;
        //this.chatComponent = p_i45500_2_.getDisplayName();
    }

    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;  
        
        this.buttonList.add(this.nextButton = new TradeButton(1, x + 120 + 27, y + 24 - 1, true));
        this.buttonList.add(this.previousButton = new TradeButton(2, x + 36 - 19, y + 24 - 1, false));
        this.nextButton.enabled = false;
        this.previousButton.enabled = false;
        
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(VillagerTradeGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
		
        String name = "Mike";
        String profession = "Novice Builder";
        GuiHelper.drawNameAndProfession(this.mc.fontRendererObj, name, profession, this.width / 2, y + villagerNameOffsetY);
		
	}
    
	protected void drawWrappedString(FontRenderer renderer, String drawing, int x, int y, int color, int wrap)
    {
        List<String> lines = renderer.listFormattedStringToWidth(drawing, wrap);
        for (int i = 0; i < lines.size(); i++)
            renderer.drawString(lines.get(i), x, y + (i * 9), color, false);
    }
	
	@SideOnly(Side.CLIENT)
    static class TradeButton extends GuiButton
    {
        private final boolean left;

        public TradeButton(int buttonID, int x, int y, boolean left)
        {
            super(buttonID, x, y, 12, 19, "");
            this.left = left;
        }

        /**
         * Draws this button to the screen.
         */
        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if (this.visible)
            {
                mc.getTextureManager().bindTexture(VillagerTradeGuiTexture);
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                boolean flag = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
                int i = 0;
                int j = 176;

                if (!this.enabled)
                {
                    j += this.width * 2;
                }
                else if (flag)
                {
                    j += this.width;
                }

                if (!this.left)
                {
                    i += this.height;
                }

                this.drawTexturedModalRect(this.xPosition, this.yPosition, j, i, this.width, this.height);
            }
        }
    }
	
}
