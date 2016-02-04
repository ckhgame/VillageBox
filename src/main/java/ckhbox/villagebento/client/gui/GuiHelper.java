package ckhbox.villagebento.client.gui;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHelper {
	public static void drawNameAndProfession(FontRenderer fontRendererIn, EntityVillager villager, int x, int y){
		drawCenteredStringNoshadow(fontRendererIn, villager.getName(), x, y, 6316128);
        drawCenteredStringNoshadow(fontRendererIn, villager.getProfession().getDisplayName(), x, y + 10, 8421504);
	}
	
	public static void drawCenteredStringNoshadow(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.drawString(text, x - fontRendererIn.getStringWidth(text) / 2, y, color);
    }
	
	public static boolean isPointInRegion(int x, int y, int w, int h, int mouseX, int mouseY)
    {
        return mouseX >= x - 1 && mouseX < x + w + 1 && mouseY >= y - 1 && mouseY < y + h + 1;
    }
}
