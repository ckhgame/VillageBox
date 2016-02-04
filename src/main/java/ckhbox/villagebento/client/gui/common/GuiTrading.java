package ckhbox.villagebento.client.gui.common;

import java.io.IOException;

import ckhbox.villagebento.common.gui.common.ContainerTrading;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.MessageGuiVillagerOpen;
import ckhbox.villagebento.common.network.message.MessageGuiSelectTradeRecipeIndex;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.trading.ITrading;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.C17PacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTrading extends GuiContainer{
	
	private static final ResourceLocation TradeGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/trade.png"));

	private ITrading trader;
    private TradeButton nextButton;
    private TradeButton previousButton;
    private int selectedTradingRecipeIdx;
    
	public GuiTrading(InventoryPlayer playerInventory, ITrading trader, World worldIn)
    {
        super(new ContainerTrading(playerInventory, trader, worldIn));
        this.trader = trader;
    }
	
	@Override
    public void initGui()
    {
        super.initGui();
        
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;  
        
        this.buttonList.add(this.nextButton = new TradeButton(1, x + 120 + 35, y + 24 - 1, true));
        this.buttonList.add(this.previousButton = new TradeButton(2, x + 36 - 27, y + 24 - 1, false));
        this.nextButton.enabled = false;
        this.previousButton.enabled = false;
        
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TradeGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);		
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        TradingRecipeList tradingRecipeList = this.trader.getTradingRecipeList();

        if (tradingRecipeList != null && !tradingRecipeList.isEmpty())
        {
            int i = (this.width - this.xSize) / 2;
            int j = (this.height - this.ySize) / 2;
            int k = this.selectedTradingRecipeIdx;
            TradingRecipe tradingRecipe = tradingRecipeList.get(k);
            ItemStack itemstack = null;
            GlStateManager.pushMatrix();
            RenderHelper.enableGUIStandardItemLighting();
            GlStateManager.disableLighting();
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableColorMaterial();
            GlStateManager.enableLighting();
            this.itemRender.zLevel = 100.0F;
            
            int x;
            for(int itemIdx = 0;itemIdx<tradingRecipe.getItemsInput().length;itemIdx++){
            	itemstack = tradingRecipe.getItemsInput()[itemIdx];
            	x = i + 23 + (4 - tradingRecipe.getItemsInput().length + itemIdx) * 18;
            	this.itemRender.renderItemAndEffectIntoGUI(itemstack, x, j + 24);
                this.itemRender.renderItemOverlays(this.fontRendererObj, itemstack, x, j + 24);
            }

            itemstack = tradingRecipe.getItemOutput();
            this.itemRender.renderItemAndEffectIntoGUI(itemstack, i + 132, j + 24);
            this.itemRender.renderItemOverlays(this.fontRendererObj, itemstack, i + 132, j + 24);
            this.itemRender.zLevel = 0.0F;
            GlStateManager.disableLighting();

            //tooltips
            for(int itemIdx = 0;itemIdx<tradingRecipe.getItemsInput().length;itemIdx++){
            	itemstack = tradingRecipe.getItemsInput()[itemIdx];
            	x = 23 + (4 - tradingRecipe.getItemsInput().length + itemIdx) * 18;
		    	if (this.isPointInRegion(x, 24, 16, 16, mouseX, mouseY) && itemstack != null)
		        {
		            this.renderToolTip(itemstack, mouseX, mouseY);
		        }
            }
            
            itemstack = tradingRecipe.getItemOutput();
            if (this.isPointInRegion(132, 24, 16, 16, mouseX, mouseY) && itemstack != null)
            {
                this.renderToolTip(itemstack, mouseX, mouseY);
            }

            GlStateManager.popMatrix();
            GlStateManager.enableLighting();
            GlStateManager.enableDepth();
            RenderHelper.enableStandardItemLighting();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        TradingRecipeList tradingRecipeList = this.trader.getTradingRecipeList();

        if (tradingRecipeList != null)
        {
            this.nextButton.enabled = this.selectedTradingRecipeIdx < tradingRecipeList.size() - 1;
            this.previousButton.enabled = this.selectedTradingRecipeIdx > 0;
        }
    }

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
    {
        boolean flag = false;

        if (button == this.nextButton)
        {
            ++this.selectedTradingRecipeIdx;
            TradingRecipeList tradingRecipeList = this.trader.getTradingRecipeList();

            if (tradingRecipeList != null && this.selectedTradingRecipeIdx >= tradingRecipeList.size())
            {
                this.selectedTradingRecipeIdx = tradingRecipeList.size() - 1;
            }

            flag = true;
        }
        else if (button == this.previousButton)
        {
            --this.selectedTradingRecipeIdx;

            if (this.selectedTradingRecipeIdx < 0)
            {
                this.selectedTradingRecipeIdx = 0;
            }

            flag = true;
        }

        if (flag)
        {
            ((ContainerTrading)this.inventorySlots).setCurrentRecipeIndex(this.selectedTradingRecipeIdx);
            ModNetwork.getInstance().sendToServer(new MessageGuiSelectTradeRecipeIndex(this.selectedTradingRecipeIdx));
        }
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
                mc.getTextureManager().bindTexture(TradeGuiTexture);
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
