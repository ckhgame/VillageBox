package ckhbox.villagebox.client.gui.guidebook;

import java.io.IOException;
import java.util.List;
import java.util.Stack;

import ckhbox.villagebox.client.gui.guidebook.page.Page;
import ckhbox.villagebox.client.gui.guidebook.page.PageHome;
import ckhbox.villagebox.client.gui.guidebook.page.PageItem;
import ckhbox.villagebox.client.gui.guidebook.page.PageItemList;
import ckhbox.villagebox.client.gui.guidebook.page.PagePro;
import ckhbox.villagebox.client.gui.guidebook.page.PageProList;
import ckhbox.villagebox.client.gui.guidebook.page.PageTrading;
import ckhbox.villagebox.client.gui.guidebook.page.data.GuideBookData;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.gui.common.ContainerEmpty;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.village.profession.Profession;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiGuideBook extends GuiContainer{

	protected static final ResourceLocation guiBookGuiTextures = new ResourceLocation(PathHelper.full("textures/gui/guidebook/page.png"));
	
	public GuideBookData guidebookData = null;
	protected Page currentPage;
	private EntityVillager tempVillager = new EntityVillager(Minecraft.getMinecraft().thePlayer.getEntityWorld());
	
	public Stack<String> linkStack = new Stack<String>();
	
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
		this.gotoLink("home=");
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
	
	public void drawProHead(int x, int y, Profession pro, boolean isMale){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(pro.getTexture(isMale));
        this.drawModalRectWithCustomSizedTexture(x, y, 8, 8, 8, 8, 64, 32);
	}
	
	public void drawProEntity(int x, int y, Profession pro, boolean isMale){
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
    	this.tempVillager.previewProfession = pro;
    	this.tempVillager.setGender(isMale);
    	this.drawEntityOnScreen(x, y, 20,-0.8F, this.tempVillager);
    	this.tempVillager.previewProfession = null;
	}

	private void drawEntityOnScreen(int posX, int posY, int scale,float r, EntityLivingBase ent)
	{
	    GlStateManager.enableColorMaterial();
	    GlStateManager.pushMatrix();
	    GlStateManager.translate((float)posX, (float)posY, 50.0F);
	    GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
	    GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	    float f = ent.renderYawOffset;
	    float f1 = ent.rotationYaw;
	    float f2 = ent.rotationPitch;
	    float f3 = ent.prevRotationYawHead;
	    float f4 = ent.rotationYawHead;
	    GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
	    RenderHelper.enableStandardItemLighting();
	    GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
	    //ent.renderYawOffset = -30.0F * r;
	    //ent.rotationYaw = -75.0F * r;
	    ent.renderYawOffset = 45.0F;
	    ent.rotationYaw = 45.0F;
	    ent.rotationPitch = 0;
	    ent.rotationYawHead = ent.rotationYaw;
	    ent.prevRotationYawHead = ent.rotationYaw;
	    GlStateManager.translate(0.0F, 0.0F, 0.0F);
	    RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	    rendermanager.setPlayerViewY(180.0F);
	    rendermanager.setRenderShadow(false);
	    rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
	    rendermanager.setRenderShadow(true);
	    ent.renderYawOffset = f;
	    ent.rotationYaw = f1;
	    ent.rotationPitch = f2;
	    ent.prevRotationYawHead = f3;
	    ent.rotationYawHead = f4;
	    GlStateManager.popMatrix();
	    RenderHelper.disableStandardItemLighting();
	    GlStateManager.disableRescaleNormal();
	    GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
	    GlStateManager.disableTexture2D();
	    GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
	}
	
	public void gotoLink(String link){
		if(link == null)
			return;
		boolean pushPrevLink = false;
		if(link.startsWith(">")){ // start with > means pushing old link
			link = link.substring(1,link.length());
			pushPrevLink = true;
		}
		
		//reslove links
		//format: PAGETYPE=PARAMS, examples: 1. item=staff   2.  pro=cook   3. home=
		String[] arr = link.split("=");
		Page newPage = null;
		if(arr[0].equals("home")){
			newPage = new PageHome(this);
		}
		else if(arr[0].equals("itemlist")){
			int pageIdx = Integer.valueOf(arr[1]);
			newPage = new PageItemList(this,pageIdx);
		}
		else if(arr[0].equals("prolist")){
			int pageIdx = Integer.valueOf(arr[1]);
			newPage = new PageProList(this,pageIdx);
		}
		else if(arr[0].equals("item")){
			ItemStack itemstack = this.guidebookData.mapNamesToItemStacks.get(arr[1]);
			newPage = new PageItem(this,itemstack);
		}
		else if(arr[0].equals("pro")){
			int proid = Integer.valueOf(arr[1]);
			Profession pro = Profession.registry.get(proid);
			newPage = new PagePro(this,pro);
		}
		else if(arr[0].equals("trading")){
			String[] ps = arr[1].split(",");
			int proid = Integer.valueOf(ps[0]);
			int pageIdx = Integer.valueOf(ps[1]);
			Profession pro = Profession.registry.get(proid);
			newPage = new PageTrading(this,pro,pageIdx);
		}
		else if(arr[0].equals("back")){
			this.gotoLink(this.getLastLink());
			return;
		}
		
		if(newPage!=null){
			newPage.currentLink = link;
			this.openPage(newPage,pushPrevLink);
		}
		
	}
	
	public void openPage(Page page, boolean pushPrevLink){
		if(pushPrevLink && this.currentPage != null){
			this.linkStack.push(this.currentPage.currentLink);
		}
		this.currentPage = page;
		if(this.currentPage != null){
			this.currentPage.onInit();
		}
	}

	public String getLastLink(){		
		if(this.linkStack.isEmpty()){
			return null;
		}
		return this.linkStack.pop();
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
	
}
