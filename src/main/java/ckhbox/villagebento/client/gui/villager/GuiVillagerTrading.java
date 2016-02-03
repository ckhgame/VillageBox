package ckhbox.villagebento.client.gui.villager;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.common.GuiTrading;
import ckhbox.villagebento.common.village.trading.ITrading;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class GuiVillagerTrading extends GuiTrading{

    protected int villagerNameOffsetY = 6;
	
	public GuiVillagerTrading(InventoryPlayer playerInventory, ITrading trader, World worldIn) {
		super(playerInventory, trader, worldIn);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
		
        String name = "Mike";
        String profession = "Novice Builder";
        GuiHelper.drawNameAndProfession(this.mc.fontRendererObj, name, profession, this.width / 2, y + villagerNameOffsetY);
		
	}

}
