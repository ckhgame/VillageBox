package ckhbox.villagebox.client.renderer.villager;

import org.lwjgl.opengl.GL11;

import ckhbox.villagebox.client.model.villager.ModelVillager;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderVillager extends RenderBiped<EntityVillager>{
	
	private AxisAlignedBB questMarkBoundBot = new AxisAlignedBB(-0.05D,2.3D,-0.05D,0.05D,2.4D,0.05D);
	private AxisAlignedBB questMarkBoundTop = new AxisAlignedBB(-0.05D,2.5D,-0.05D,0.05D,2.8D,0.05D);
	
	public RenderVillager(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelVillager(), 0.5F, 1.0F);
		this.addLayer(new LayerVillagerHeldItem(this));
	}

	@Override
	protected boolean canRenderName(EntityVillager entity) {
		if(entity.previewProfession != null)
			return false;
		else
			return super.canRenderName(entity);
	}

	@Override
	public void doRender(EntityVillager entity, double x, double y, double z, float entityYaw, float partialTicks) {
		super.doRender(entity, x, y, z, entityYaw, partialTicks);
		
		if(entity.previewProfession == null && entity.getCurrentQuest() != null && entity.hasHome()){
			this.renderQuestMark(x,y,z,-entityYaw);
		}
	}
	
	private void renderQuestMark(double x, double y, double z, float rotY){
		
        renderColorBox(this.questMarkBoundTop,x,y,z,rotY,1.0F,1.0F,0.0F,1.0F,0.6F,0.0F);
        renderColorBox(this.questMarkBoundBot,x,y,z,rotY,1.0F,1.0F,0.0F,1.0F,0.6F,0.0F);      
	}
	
	private void renderColorBox(AxisAlignedBB boundingBox, double x, double y, double z,float rotY, float r0,float g0, float b0, float r1, float g1, float b1){
		GlStateManager.pushMatrix();
		GlStateManager.disableTexture2D();
        Tessellator tessellator = Tessellator.getInstance();     
        WorldRenderer worldrenderer = tessellator.getWorldRenderer();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.disableLighting();
        GlStateManager.translate(x, y, z);
        GlStateManager.rotate(rotY, 0, 1, 0);
        GlStateManager.shadeModel(GL11.GL_SMOOTH);
        worldrenderer.begin(7, DefaultVertexFormats.POSITION_COLOR);
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.maxZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.maxZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.maxY, boundingBox.minZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.minX, boundingBox.minY, boundingBox.minZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.minZ).color(r1, g1, b1, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.minZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ).color(r0, g0, b0, 1.0F).endVertex();
        worldrenderer.pos(boundingBox.maxX, boundingBox.minY, boundingBox.maxZ).color(r1, g1, b1, 1.0F).endVertex();
        tessellator.draw();
        GlStateManager.shadeModel(GL11.GL_FLAT);
        GlStateManager.enableTexture2D();
        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityVillager entity) {
		if(entity.previewProfession != null)
			return entity.previewProfession.getTexture(entity.isMale());
		else
			return entity.getProfession().getTexture(entity.isMale());
	}

	@Override
	protected void preRenderCallback(EntityVillager entitylivingbaseIn, float partialTickTime) {
		float f = 0.9375F;
        GlStateManager.scale(f, f, f);	
	}
	
	
	

}
