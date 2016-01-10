package com.ckhgame.villagebento.renderer;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.animal.EntityVBCow;
import com.ckhgame.villagebento.entity.misc.EntityBuildingIndicator;
import com.ckhgame.villagebento.renderer.gui.RenderGuiAnimal;
import com.ckhgame.villagebento.util.data.BoxWithColor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;

@SideOnly(Side.CLIENT)
public class RenderVBBuildingIndicator extends RenderEntity
{
	@Override
	public void doRender(Entity p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_,
			float p_76986_9_) {
		doRender((EntityBuildingIndicator)p_76986_1_,p_76986_2_,p_76986_4_,p_76986_6_,p_76986_8_,p_76986_9_);
	}
	
	public void doRender(EntityBuildingIndicator indicator, double x, double y, double z, float p_76986_8_,
			float p_76986_9_) {
		
		double sx = indicator.getBuildingSizeX();
		double sz = indicator.getBuildingSizeZ();
		
		GL11.glPushMatrix();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_CULL_FACE);        
		
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
        
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
        Vec3 lv = Vec3.createVectorHelper(indicator.posX - player.posX, indicator.posY - player.posY, indicator.posZ - player.posZ);
		if(Math.abs(lv.xCoord) >= Math.abs(lv.zCoord)){
			if(lv.xCoord < 0) 
				renderPlan(indicator.posX - sx * 2 - 0.5D, indicator.posX + 0.5D, indicator.posZ - sz - 0.5D, indicator.posZ + sx + 0.5D,indicator.posY,x - indicator.lastTickPosX, y - indicator.lastTickPosY, z - indicator.lastTickPosZ);
			else
				renderPlan(indicator.posX - 0.5D, indicator.posX + sx * 2 + 0.5D, indicator.posZ - sz - 0.5D, indicator.posZ + sx + 0.5D,indicator.posY,x - indicator.lastTickPosX, y - indicator.lastTickPosY, z - indicator.lastTickPosZ);
		}
		else{
			if(lv.zCoord < 0)
				renderPlan(indicator.posX - sz - 0.5D, indicator.posX + sz + 0.5D, indicator.posZ - sx * 2- 0.5D, indicator.posZ + 0.5D,indicator.posY,x - indicator.lastTickPosX, y - indicator.lastTickPosY, z - indicator.lastTickPosZ);
			else
				 renderPlan(indicator.posX - sz - 0.5D, indicator.posX + sz + 0.5D, indicator.posZ - 0.5D, indicator.posZ + sx * 2 + 0.5D,indicator.posY,x - indicator.lastTickPosX, y - indicator.lastTickPosY, z - indicator.lastTickPosZ);
		}
		
        GL11.glEnable(GL11.GL_CULL_FACE);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
        
	}
	
	 public static void renderPlan(double minX,double maxX, double minZ, double maxZ, double h, double x, double y, double z)
	    {
		 	double dy = -0.95D;
	        GL11.glDisable(GL11.GL_TEXTURE_2D);
	      //  GL11.glEnable(GL11.GL_BLEND);
	        Tessellator tessellator = Tessellator.instance;
	        tessellator.setTranslation(x, y + dy, z);
	        //plan
	        tessellator.startDrawingQuads();
	        GL11.glColor4f(0.6F, 0.9F, 0.9F, 0.5F);
	        tessellator.addVertex(minX, h, minZ);
	        tessellator.addVertex(maxX, h, minZ);
	        tessellator.addVertex(maxX, h, maxZ);
	        tessellator.addVertex(minX, h, maxZ);
	        tessellator.draw();
	        //center
	        double cx = minX + (maxX - minX) * 0.5D;
	        double cz = minZ + (maxZ - minZ) * 0.5D;
	        tessellator.startDrawingQuads();
	        GL11.glColor4f(0.8F, 0.95F, 0.95F, 0.5F);
	        tessellator.addVertex(cx - 0.5D, h + 0.01D, cz - 0.5D);
	        tessellator.addVertex(cx + 0.5D, h + 0.01D, cz - 0.5D);
	        tessellator.addVertex(cx + 0.5D, h + 0.01D, cz + 0.5D);
	        tessellator.addVertex(cx - 0.5D, h + 0.01D, cz + 0.5D);
	        tessellator.draw();
	        tessellator.setTranslation(0.0D, 0.0D, 0.0D);
	        //GL11.glDisable(GL11.GL_BLEND);
	        GL11.glEnable(GL11.GL_TEXTURE_2D);
	    }
	
}