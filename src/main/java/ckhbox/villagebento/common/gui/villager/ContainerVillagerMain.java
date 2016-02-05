package ckhbox.villagebento.common.gui.villager;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.util.helper.ItemStackHelper;
import ckhbox.villagebento.common.village.trading.ITrading;
import ckhbox.villagebento.common.village.trading.InventoryTrading;
import ckhbox.villagebento.common.village.trading.SlotTradingOutput;
import ckhbox.villagebento.common.village.villager.InventoryUpgrading;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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