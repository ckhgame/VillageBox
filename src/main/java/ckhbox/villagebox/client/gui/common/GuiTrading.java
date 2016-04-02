package ckhbox.villagebox.client.gui.common;

import java.io.IOException;

import ckhbox.villagebox.client.gui.GuiHelper;
import ckhbox.villagebox.common.gui.common.ContainerTrading;
import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.common.MessageGuiSelectTradeRecipeIndex;
import ckhbox.villagebox.common.network.message.villager.MessageGuiVillagerOpen;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.trading.ITrading;
import ckhbox.villagebox.common.village.trading.TradingRecipe;
import ckhbox.villagebox.common.village.trading.TradingRecipeList;
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
import net.minecraft.util.StatCollector;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiTrading extends GuiContainer{
	
	private static final ResourceLocation TradeGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/trade.png"));
	private static final ResourceLocation TradeAllRecipesGuiTexture = new ResourceLocation(PathHelper.full("textures/gui/villager/trade_allrecipes.png"));
	
	private ITrading trader;
    private TradeButton nextButton;
    private TradeButton previousButton;
    private AllRecipesButton allRecipesButton;
    private int selectedTradingRecipeIdx;
    private int widthAllRecpiesPanel = 104;
    private int heightAllRecpiesPanel = 166;
    private int allRecipesColumns = 5;
    
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
        
        this.buttonList.add(this.allRecipesButton = new AllRecipesButton(3, x + 155, y + 3, false));
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(TradeGuiTexture);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);	
        
        //draw all recpie panel
        if(this.allRecipesButton.isDisplayingAllRecipes){
        	this.mc.getTextureManager().bindTexture(TradeAllRecipesGuiTexture);
            x = (this.width + this.xSize) / 2;
            y = (this.height - this.ySize) / 2;
            this.drawTexturedModalRect(x, y, 0, 0, this.widthAllRecpiesPanel, this.heightAllRecpiesPanel);	
            
        	int rx,ry;
        	//selected indicator
        	rx = (this.width + this.xSize) / 2 + 7 + 1 + (this.selectedTradingRecipeIdx % allRecipesColumns) * 18;
        	ry = (this.height - this.heightAllRecpiesPanel) / 2 + 15 + 1 + (this.selectedTradingRecipeIdx / allRecipesColumns) * 18;
            this.drawTexturedModalRect(rx, ry, this.widthAllRecpiesPanel, 0, 16, 16);	
        }
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
            
            //all recipes panel
            if(this.allRecipesButton.isDisplayingAllRecipes){
            	
            	int px = (this.width + this.xSize) / 2;
            	int py = (this.height - this.heightAllRecpiesPanel) / 2;  
            	
            	//title
            	GuiHelper.drawCenteredStringNoshadow(this.fontRendererObj, StatCollector.translateToLocal(PathHelper.full("gui.trading.allrecipes")), px + this.widthAllRecpiesPanel / 2, py + 6, 6316128);       	

            	int rx,ry;
            	//recipes
            	for(int recipeIdx = 0;recipeIdx<tradingRecipeList.size();recipeIdx++){
                	itemstack = tradingRecipeList.get(recipeIdx).getItemOutput();
                	rx = px + 7 + (recipeIdx % allRecipesColumns) * 18;
                	ry = py + 15 + (recipeIdx / allRecipesColumns) * 18;
                	this.itemRender.renderItemAndEffectIntoGUI(itemstack, rx + 1, ry + 1);
                    //this.itemRender.renderItemOverlays(this.fontRendererObj, itemstack, rx, ry);
                }
            }
            
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
                       
            //all recipes panel tooltips
            if(this.allRecipesButton.isDisplayingAllRecipes){
            	int px = (this.width + this.xSize) / 2;
            	int py = (this.height - this.heightAllRecpiesPanel) / 2;             	
            	int rx,ry;
            	//tooltips
            	for(int recipeIdx = 0;recipeIdx<tradingRecipeList.size();recipeIdx++){
                	itemstack = tradingRecipeList.get(recipeIdx).getItemOutput();
                	rx = this.xSize + 7 + (recipeIdx % allRecipesColumns) * 18;
                	ry = 15 + (recipeIdx / allRecipesColumns) * 18;
    		    	if (this.isPointInRegion(rx + 1, ry + 1, 16, 16, mouseX, mouseY) && itemstack != null)
    		        {
    		            this.renderToolTip(itemstack, mouseX, mouseY);
    		        }
                }          	
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
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
			 
		//all recipes panel
		if(this.allRecipesButton.isDisplayingAllRecipes){
			TradingRecipeList tradingRecipeList = this.trader.getTradingRecipeList();
			int mx = mouseX - (this.width + this.xSize) / 2 - 7;
	    	int my = mouseY - (this.height - this.heightAllRecpiesPanel) / 2 - 15; 
			if(tradingRecipeList != null && mx >= 0 && mx < this.allRecipesColumns * 18 && my >= 0){
				int idx = (mx / 18) + (my / 18) * this.allRecipesColumns;
				if(idx >= 0 && idx < tradingRecipeList.size()){
					this.selectedTradingRecipeIdx = idx;
					((ContainerTrading)this.inventorySlots).setCurrentRecipeIndex(this.selectedTradingRecipeIdx);
		            ModNetwork.getInstance().sendToServer(new MessageGuiSelectTradeRecipeIndex(this.selectedTradingRecipeIdx));
				}
			}
		}
		//if(mouseX > this.)
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
    {
		//prev and next button
		
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
        
        //all recipes button
        if(button == this.allRecipesButton){
        	this.allRecipesButton.isDisplayingAllRecipes = !this.allRecipesButton.isDisplayingAllRecipes;
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
	
	@SideOnly(Side.CLIENT)
    static class AllRecipesButton extends GuiButton
    {

		public boolean isDisplayingAllRecipes;
		
        public AllRecipesButton(int buttonID, int x, int y, boolean isDisplayingAllRecipes)
        {
            super(buttonID, x, y, 18, 18, "");
            this.isDisplayingAllRecipes = isDisplayingAllRecipes;
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
                int x = 176;
                int y = 38;

                if (flag || this.isDisplayingAllRecipes)
                {
                    x += this.width;
                }
                
                this.drawTexturedModalRect(this.xPosition, this.yPosition, x, y, this.width, this.height);
            }
        }
    }
	
}
