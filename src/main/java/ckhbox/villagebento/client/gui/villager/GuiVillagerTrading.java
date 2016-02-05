package ckhbox.villagebento.client.gui.villager;

import java.io.IOException;

import ckhbox.villagebento.client.gui.GuiHelper;
import ckhbox.villagebento.client.gui.common.GuiTrading;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetInteracting;
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
	
	@Override
	public void onGuiClosed() {
		super.onGuiClosed();
		
		ModNetwork.getInstance().sendToServer(new MessageGuiSetInteracting(this.villager.getEntityId(), this.villager.dimension, false));
	}
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException {
		super.keyTyped(typedChar, keyCode);
		
		if (keyCode == 1){
			ModNetwork.getInstance().sendToServer(new MessageGuiSetInteracting(this.villager.getEntityId(), this.villager.dimension, false));
		}
	}

}
