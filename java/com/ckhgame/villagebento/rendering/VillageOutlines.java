package com.ckhgame.villagebento.rendering;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.data.BuildingData;
import com.ckhgame.villagebento.data.VillageBentoData;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class VillageOutlines {
	
	private static VillageOutlines instance = null;
	public static VillageOutlines getInstance(){
		if(instance == null)
			instance = new VillageOutlines();
		return instance;
	}
	
	private double px,py,pz;
	private VillageBentoData villageBentoData = null;
	
	public void setVillageBentoData(VillageBentoData vbData){ //if set vbData to null, no outlines will be display
		villageBentoData = vbData;
	}
	
	@SubscribeEvent
	public void renderWorldLastEvent(RenderWorldLastEvent event) {
		
		if(villageBentoData != null){
			EntityPlayer p = Minecraft.getMinecraft().thePlayer;
			px = p.lastTickPosX + (p.posX - p.lastTickPosX) * (double) event.partialTicks;
			py = p.lastTickPosY + (p.posY - p.lastTickPosY) * (double) event.partialTicks;
			pz = p.lastTickPosZ + (p.posZ - p.lastTickPosZ) * (double) event.partialTicks;
			
			renderOutlines();
		}
    }
	
private void renderOutlines() {
        

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(3.0f);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_CULL_FACE);
        
        //render
        //outlines of buildings
        for(BuildingData bd: villageBentoData.buildings){
        	renderOutline(AxisAlignedBB.getBoundingBox(bd.x - bd.sizeX, bd.y, bd.z - bd.sizeZ, bd.x + bd.sizeX + 1, bd.y + 10, bd.z + bd.sizeZ + 1)
        								.expand(0.1, 0.1, 0.1)
        								.getOffsetBoundingBox(-px, -py, -pz),0.2f,0.7f,0.2f,0.7f);
        }
        //outlines of the village
        if(villageBentoData.villageBoundary != null)
        	renderOutline(villageBentoData.villageBoundary.getOffsetBoundingBox(-px, -py, -pz),0.7f,0.7f,0.1f,0.7f);

        GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, GL11.GL_FILL);
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }

    private void renderOutline(AxisAlignedBB bb,float colorR,float colorG,float colorB,float colorA) {
        
    	Tessellator tessellator = Tessellator.instance;
        
        /*
        tessellator.startDrawing(GL11.GL_QUADS);
        tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
        tessellator.addVertex(bb.minX, bb.minY, bb.minZ);
        tessellator.addVertex(bb.maxX, bb.minY, bb.minZ);
        tessellator.addVertex(bb.maxX, bb.minY, bb.maxZ);
        tessellator.addVertex(bb.minX, bb.minY, bb.maxZ);
        tessellator.draw();
        
        tessellator.startDrawing(GL11.GL_QUADS);
        tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
        tessellator.addVertex(bb.minX, bb.maxY, bb.minZ);
        tessellator.addVertex(bb.maxX, bb.maxY, bb.minZ);
        tessellator.addVertex(bb.maxX, bb.maxY, bb.maxZ);
        tessellator.addVertex(bb.minX, bb.maxY, bb.maxZ);
        tessellator.draw();
     	*/
        
        tessellator.startDrawing(GL11.GL_LINE_LOOP);
        tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
        tessellator.addVertex(bb.minX, bb.maxY, bb.maxZ);
        tessellator.addVertex(bb.maxX, bb.maxY, bb.maxZ);
        tessellator.addVertex(bb.maxX, bb.minY, bb.maxZ);
        tessellator.addVertex(bb.minX, bb.minY, bb.maxZ);
        tessellator.draw();
        
        tessellator.startDrawing(GL11.GL_LINE_LOOP);
        tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
        tessellator.addVertex(bb.minX, bb.minY, bb.minZ);
        tessellator.addVertex(bb.minX, bb.maxY, bb.minZ);
        tessellator.addVertex(bb.maxX, bb.maxY, bb.minZ);
        tessellator.addVertex(bb.maxX, bb.minY, bb.minZ);
        tessellator.draw();
        
        tessellator.startDrawing(GL11.GL_LINE_LOOP);
        tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
        tessellator.addVertex(bb.minX,bb.minY, bb.minZ);
        tessellator.addVertex(bb.minX,bb.minY, bb.maxZ);
        tessellator.addVertex(bb.minX,bb.maxY, bb.maxZ);
        tessellator.addVertex(bb.minX,bb.maxY, bb.minZ);
        tessellator.draw();
        
        tessellator.startDrawing(GL11.GL_LINE_LOOP);
        tessellator.setColorRGBA_F(colorR, colorG, colorB, colorA);
        tessellator.addVertex(bb.maxX,bb.minY, bb.minZ);
        tessellator.addVertex(bb.maxX,bb.minY, bb.maxZ);
        tessellator.addVertex(bb.maxX,bb.maxY, bb.maxZ);
        tessellator.addVertex(bb.maxX,bb.maxY, bb.minZ);
        tessellator.draw();
    }
}
