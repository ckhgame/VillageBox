package ckhbox.villagebox.client.gui.guidebook;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import ckhbox.villagebox.client.gui.guidebook.page.Page;
import ckhbox.villagebox.client.gui.guidebook.page.PageHome;
import ckhbox.villagebox.common.gui.common.ContainerEmpty;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiGuideBook extends GuiContainer{

	protected static final ResourceLocation guiBookGuiTextures = new ResourceLocation(PathHelper.full("textures/gui/guidebook/page.png"));
	
	public GuideBookData guidebookData = null;
	protected Page currentPage;
	
	protected int xSize = 176;
    protected int ySize = 180; 
    protected int offsetx = 18;
    protected int offsety = 18;
	
	public GuiGuideBook() {
		super(new ContainerEmpty());
		if(guidebookData == null){
			guidebookData = new GuideBookData();
		}
	}

	public int getContentLeft(){
		return (this.width - this.xSize) / 2 + offsetx;
	}
	
	public int getContentRight(){
		return (this.width + this.xSize) / 2 - offsetx;
	}
	
	public int getContentTop(){
		return (this.height - this.ySize) / 2 + offsety;
	} 
	public int getContentWidth(){
		return this.xSize - offsetx * 2;
	}
	
	public int getContentHeight(){
		return this.ySize - offsety * 2;
	}
	
	public void addButton(GuiButton button){
		this.buttonList.add(button);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiBookGuiTextures);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		super.drawScreen(mouseX, mouseY, partialTicks);
		if(this.currentPage != null)
			this.currentPage.onDrawScreen(mouseX, mouseY);
	}

	@Override
	public void initGui() {
		super.initGui();
		openPage(new PageHome(this));
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		if(this.currentPage != null){
			this.currentPage.onMouseClick(mouseX, mouseY);
		}
	}

	public void drawTexture(int x, int y,int coordx, int coordy, int width, int height){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiBookGuiTextures);
        this.drawTexturedModalRect(x, y, coordx, coordy, width, height);
	}
	
	public void openPage(Page page){
		this.buttonList.clear();
		this.currentPage = page;
		if(this.currentPage != null){
			this.currentPage.onInit();
		}
	}

	public void drawHoveringText(List<String> textLines, int x, int y){
		super.drawHoveringText(textLines, x, y);
	}
	
	public void renderToolTip(ItemStack stack, int x, int y){
		super.renderToolTip(stack, x, y);
	}
	
	public void drawItem(ItemStack itemstack, int x, int y){
		GlStateManager.pushMatrix();
        RenderHelper.enableGUIStandardItemLighting();
        GlStateManager.enableRescaleNormal();
        GlStateManager.enableColorMaterial();
        GlStateManager.enableLighting();
        this.itemRender.zLevel = 100.0F;		
		this.itemRender.renderItemAndEffectIntoGUI(itemstack, x, y);
        this.itemRender.renderItemOverlays(this.fontRendererObj, itemstack, x, y);
        GlStateManager.popMatrix();
	}

	public static class GuideBookData{
		public HashMap<String,Item> mapItems = new HashMap<String,Item>();
		public HashMap<String,Profession> mapPros = new HashMap<String,Profession>();
		
		public GuideBookData(){
			this.generate();
		}
		
		public void generate(){
			//items
			this.mapItems.clear();
			for (Item item : Item.itemRegistry){
	            if (item == null){
	                continue;
	            }
	            for (CreativeTabs tab : item.getCreativeTabs()){
	                if (tab == ModItems.tabVB){
	                    this.mapItems.put(item.getUnlocalizedName(), item);
	                }
	            }
	        }
			//professions
		}
	}
	
}
