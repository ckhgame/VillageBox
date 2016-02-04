package ckhbox.villagebento.client.gui.villager;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.common.GuiTrading;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class GuiVillagerTrading extends GuiTrading{

    protected int villagerNameOffsetY = 6;
	private EntityVillager villager;
    
	public GuiVillagerTrading(InventoryPlayer playerInventory, EntityVillager villager, World worldIn) {
		super(playerInventory, villager, worldIn);
		this.villager = villager;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
		
        GuiHelper.drawNameAndProfession(this.mc.fontRendererObj, villager, this.width / 2, y + villagerNameOffsetY);
		
	}

}
