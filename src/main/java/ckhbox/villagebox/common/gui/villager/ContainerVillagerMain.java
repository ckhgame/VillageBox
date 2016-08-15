package ckhbox.villagebox.common.gui.villager;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerVillagerMain extends Container
{
    public ContainerVillagerMain()
    {
    }

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}

   
}