package com.ckhgame.villagebento.event;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillage;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.util.BoxWithColor;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class EventRenderVillageOutlines {
	
	private static EventRenderVillageOutlines instance = null;
	public static EventRenderVillageOutlines getInstance(){
		if(instance == null)
			instance = new EventRenderVillageOutlines();
		return instance;
	}
	
	private boolean enabled = false;
	
	public boolean getEnabled(){
		return enabled;
	}
	
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}
	
	private double px,py,pz;
	private ArrayList<BoxWithColor> villageOutlines = null;
	
	private static ResourceLocation outlineTexture = new ResourceLocation(Main.MODID + ":" + "textures/effects/village/outlinefill.png");
	
	private double coordOffet = 0;
	
	public void setVillageOutlines(ArrayList<BoxWithColor> villageOutlines){ //if set vbData to null, no outlines will be display
		this.villageOutlines = villageOutlines;
	}
	
	int count = 0;
	
	@SubscribeEvent
	public void renderWorldLastEvent(RenderWorldLastEvent event) {
				
		/*count++;
		if(count > 300){
			count = 0;
			System.out.println(Minecraft.getMinecraft().thePlayer.getDisplayName() + ": <==");
			if(villageBentoData == null)
				System.out.println("dataVB is null!");
			System.out.println(Minecraft.getMinecraft().thePlayer.getDisplayName() + ": ==>");
		}*/

		if(enabled && this.villageOutlines != null){
			EntityPlayer p = Minecraft.getMinecraft().thePlayer;
			
			px = p.lastTickPosX + (p.posX - p.lastTickPosX) * (double) event.partialTicks;
			py = p.lastTickPosY + (p.posY - p.lastTickPosY) * (double) event.partialTicks;
			pz = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * (double) event.partialTicks;
			
			coordOffet += event.partialTicks * 0.01D;
			if(coordOffet > 1.0D)
				coordOffet -= 1.0D; 
			
			renderOutlines();
		}
    }
	
private void renderOutlines() {
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(3.0f);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        //render
        for(BoxWithColor b:villageOutlines)
        	renderOutline(b);
        
        GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        
        //----
        
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        for(BoxWithColor b:villageOutlines)
        	renderOutlineFill(b);
        
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
    }

private void renderOutlineFill(BoxWithColor b){
	 
	Tessellator tessellator = Tessellator.instance;
    
	double minx = b.minX - px - 0.1D;
	double miny = b.minY - py;
	double minz = b.minZ - pz - 0.1D;
	double maxx = b.maxX - px + 0.1D;
	double maxy = b.maxY - py;
	double maxz = b.maxZ - pz + 0.1D;
	double co = coordOffet;//= maxx == minx ? 0:coordOffet * 10.0D /(maxx - minx);
	
	Minecraft.getMinecraft().renderEngine.bindTexture(outlineTexture);
	
	
	tessellator.startDrawingQuads();
	tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
	tessellator.addVertexWithUV(minx, miny, minz, 1 + co, 1); //Bottom left texture
	tessellator.addVertexWithUV(minx, maxy, minz, 1 + co, 0); //Top left
	tessellator.addVertexWithUV(maxx, maxy, minz, 0 + co, 0); //Top right
	tessellator.addVertexWithUV(maxx, miny, minz, 0 + co, 1); //Bottom right
	tessellator.draw();
	
	tessellator.startDrawingQuads();
	tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
	tessellator.addVertexWithUV(minx, miny, maxz, 0 + co, 1); //Bottom left texture
	tessellator.addVertexWithUV(minx, maxy, maxz, 0 + co, 0); //Top left
	tessellator.addVertexWithUV(maxx, maxy, maxz, 1 + co, 0); //Top right
	tessellator.addVertexWithUV(maxx, miny, maxz, 1 + co, 1); //Bottom right
	tessellator.draw();
	
	tessellator.startDrawingQuads();
	tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
	tessellator.addVertexWithUV(minx, miny, minz, 0 + co, 1); //Bottom left texture
	tessellator.addVertexWithUV(minx, maxy, minz, 0 + co, 0); //Top left
	tessellator.addVertexWithUV(minx, maxy, maxz, 1 + co, 0); //Top right
	tessellator.addVertexWithUV(minx, miny, maxz, 1 + co, 1); //Bottom right
	tessellator.draw();
	
	tessellator.startDrawingQuads();
	tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
	tessellator.addVertexWithUV(maxx, miny, minz, 1 + co, 1); //Bottom left texture
	tessellator.addVertexWithUV(maxx, maxy, minz, 1 + co, 0); //Top left
	tessellator.addVertexWithUV(maxx, maxy, maxz, 0 + co, 0); //Top right
	tessellator.addVertexWithUV(maxx, miny, maxz, 0 + co, 1); //Bottom right
	tessellator.draw();
}

private void renderOutline(BoxWithColor b) {
    
	Tessellator tessellator = Tessellator.instance;
    
	double minx = b.minX - px;
	double miny = b.minY - py;
	double minz = b.minZ - pz;
	double maxx = b.maxX - px;
	double maxy = b.maxY - py;
	double maxz = b.maxZ - pz;
	
    /*
    tessellator.startDrawing(GL11.GL_QUADS);
    tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
    tessellator.addVertex(b.minX, b.minY, b.minZ);
    tessellator.addVertex(b.maxX, b.minY, b.minZ);
    tessellator.addVertex(b.maxX, b.minY, b.maxZ);
    tessellator.addVertex(b.minX, b.minY, b.maxZ);
    tessellator.draw();
    
    tessellator.startDrawing(GL11.GL_QUADS);
    tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
    tessellator.addVertex(b.minX, b.maxY, b.minZ);
    tessellator.addVertex(b.maxX, b.maxY, b.minZ);
    tessellator.addVertex(b.maxX, b.maxY, b.maxZ);
    tessellator.addVertex(b.minX, b.maxY, b.maxZ);
    tessellator.draw();
 	*/
	
	tessellator.startDrawing(GL11.GL_LINE_LOOP);
    tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
    tessellator.addVertex(minx, maxy, maxz);
    tessellator.addVertex(maxx, maxy, maxz);
    tessellator.addVertex(maxx, miny, maxz);
    tessellator.addVertex(minx, miny, maxz);
    tessellator.draw();
    
    tessellator.startDrawing(GL11.GL_LINE_LOOP);
    tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
    tessellator.addVertex(minx, miny, minz);
    tessellator.addVertex(minx, maxy, minz);
    tessellator.addVertex(maxx, maxy, minz);
    tessellator.addVertex(maxx, miny, minz);
    tessellator.draw();
    
    tessellator.startDrawing(GL11.GL_LINE_LOOP);
    tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
    tessellator.addVertex(minx,miny, minz);
    tessellator.addVertex(minx,miny, maxz);
    tessellator.addVertex(minx,maxy, maxz);
    tessellator.addVertex(minx,maxy, minz);
    tessellator.draw();
    
    tessellator.startDrawing(GL11.GL_LINE_LOOP);
    tessellator.setColorRGBA(b.R, b.G, b.B, b.A);
    tessellator.addVertex(maxx,miny, minz);
    tessellator.addVertex(maxx,miny, maxz);
    tessellator.addVertex(maxx,maxy, maxz);
    tessellator.addVertex(maxx,maxy, minz);
    tessellator.draw();
}
}
