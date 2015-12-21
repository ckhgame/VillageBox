package com.ckhgame.villagebento.gui2;

import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.network.action.Action;
import com.ckhgame.villagebento.network.action.ActionSyncVillagerComp;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerComponent;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;

public class GuiTextButton extends GuiButton {

	public GuiTextButton(Minecraft mc,int id, int x, int y, String text) {
		super(id, x, y,mc.fontRenderer.getStringWidth(text),mc.fontRenderer.FONT_HEIGHT,text);
	}

	@Override
	public void drawButton(Minecraft mc, int p_146112_2_, int p_146112_3_) {
		 if (this.visible)
	        {
	            FontRenderer fontrenderer = mc.fontRenderer;
	            this.field_146123_n = p_146112_2_ >= this.xPosition && p_146112_3_ >= this.yPosition && p_146112_2_ < this.xPosition + this.width && p_146112_3_ < this.yPosition + this.height;
	            int k = this.getHoverState(this.field_146123_n);
	            this.mouseDragged(mc, p_146112_2_, p_146112_3_);
	            int l = 0xFFFFFFAA;

	            if (packedFGColour != 0)
	            {
	                l = packedFGColour;
	            }
	            else if (!this.enabled)
	            {
	                l = 0xFF777777;
	            }
	            else if (this.field_146123_n)
	            {
	                l = 0xFFFFCC00;
	            }

	            this.drawString(fontrenderer, this.displayString, this.xPosition,  this.yPosition, l);
	        }
	}
	
	
}
