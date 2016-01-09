package com.ckhgame.villagebento.event;

import org.lwjgl.opengl.GL11;

import com.ckhgame.villagebento.util.village.VBDataTime;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

public class EventOverlay {
	
	@SubscribeEvent
    public void overlayEventPost(RenderGameOverlayEvent.Post event) {
		if(event.type == ElementType.ALL){
			Minecraft mc = Minecraft.getMinecraft();
			int w = event.resolution.getScaledWidth();
			int h = event.resolution.getScaledHeight();
			String text = VBDataTime.getDataTimeString();
			int tw = mc.fontRenderer.getStringWidth(text);
			drawFieldBackground(w / 2 - tw / 2 - 2,2,tw + 4,10);
			mc.fontRenderer.drawString(text, w / 2 - tw / 2, 3, 0xFFFFFFFF);
		}
    }
	
	private void drawFieldBackground(int left,int top,int width,int height){
		
		drawRect(left - 2, top - 2, left + width + 2, top + height + 2, 0xFF333333);
		drawRect(left - 1, top - 1, left + width + 1, top + height + 1, 0xFF111111);
		drawRect(left, top, left + width, top + height, 0xFF555555);
	}
	
	private static void drawRect(int p_73734_0_, int p_73734_1_, int p_73734_2_, int p_73734_3_, int p_73734_4_)
    {
        int j1;

        if (p_73734_0_ < p_73734_2_)
        {
            j1 = p_73734_0_;
            p_73734_0_ = p_73734_2_;
            p_73734_2_ = j1;
        }

        if (p_73734_1_ < p_73734_3_)
        {
            j1 = p_73734_1_;
            p_73734_1_ = p_73734_3_;
            p_73734_3_ = j1;
        }

        float f3 = (float)(p_73734_4_ >> 24 & 255) / 255.0F;
        float f = (float)(p_73734_4_ >> 16 & 255) / 255.0F;
        float f1 = (float)(p_73734_4_ >> 8 & 255) / 255.0F;
        float f2 = (float)(p_73734_4_ & 255) / 255.0F;
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.glBlendFunc(770, 771, 1, 0);
        GL11.glColor4f(f, f1, f2, f3);
        tessellator.startDrawingQuads();
        tessellator.addVertex((double)p_73734_0_, (double)p_73734_3_, 0.0D);
        tessellator.addVertex((double)p_73734_2_, (double)p_73734_3_, 0.0D);
        tessellator.addVertex((double)p_73734_2_, (double)p_73734_1_, 0.0D);
        tessellator.addVertex((double)p_73734_0_, (double)p_73734_1_, 0.0D);
        tessellator.draw();
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
    }
}
