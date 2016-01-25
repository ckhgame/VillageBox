package ckhbox.villagebento.client.gui;

import java.util.List;

import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHelper {
	public static void drawNameAndProfession(FontRenderer fontRendererIn, String name, String profession, int x, int y){
		drawCenteredStringNoshadow(fontRendererIn, name, x, y, 6316128);
        drawCenteredStringNoshadow(fontRendererIn, profession, x, y + 10, 8421504);
	}
	
	public static void drawCenteredStringNoshadow(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.drawString(text, x - fontRendererIn.getStringWidth(text) / 2, y, color);
    }
}
