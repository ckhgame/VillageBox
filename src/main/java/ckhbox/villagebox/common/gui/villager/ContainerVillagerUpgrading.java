package ckhbox.villagebox.common.gui.villager;

import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.util.helper.ItemStackHelper;
import ckhbox.villagebox.common.village.trading.ITrading;
import ckhbox.villagebox.common.village.trading.InventoryTrading;
import ckhbox.villagebox.common.village.trading.SlotTradingOutput;
import ckhbox.villagebox.common.village.villager.InventoryUpgrading;
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

public class ContainerVillagerUpgrading extends Container
{
    private EntityVillager villager;
    private InventoryUpgrading upgradingInventory;	
    /** Instance of World. */
    private final World world;

    public ContainerVillagerUpgrading(InventoryPlayer playerInventory, EntityVillager villager, World world)
    {
        this.villager = villager;
        this.world = world;
        this.upgradingInventory = new InventoryUpgrading(playerInventory.player, villager);
        this.addSlotToContainer(new Slot(this.upgradingInventory, 0, 20, 49));
        this.addSlotToContainer(new Slot(this.upgradingInventory, 1, 38, 49));
        this.addSlotToContainer(new Slot(this.upgradingInventory, 2, 56, 49));

        for (int i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k)
        {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }
    }

    public InventoryUpgrading getUpgradingInventory()
    {
        return this.upgradingInventory;
    }

    public void onCraftGuiOpened(ICrafting listener)
    {
        super.onCraftGuiOpened(listener);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        this.upgradingInventory.resetUpgradeOptionAndSlots();
        super.onCraftMatrixChanged(inventoryIn);
    }

    public void setCurrentUpgradeOptionIndex(int currentUpgradeOptionIndex)
    {
       this.upgradingInventory.setCurrentUpgradeOptionIndex(currentUpgradeOptionIndex);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.upgradingInventory.isUseableByPlayer(playerIn);
    }

    public void upgrade(){
    	this.upgradingInventory.upgrade();
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
    	//NEED CHANGES
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            
            if (index >= 3)
            {
                if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);
    
        if (!this.world.isRemote)
        {
        	playerIn.inventoryContainer.detectAndSendChanges();
        	for(int i =0;i<3;i++){
        		if (this.upgradingInventory.getStackInSlot(i) != null)
                {
        			if(!playerIn.inventory.addItemStackToInventory(this.upgradingInventory.getStackInSlot(i)))
        				playerIn.dropPlayerItemWithRandomChoice(this.upgradingInventory.getStackInSlot(i), false);
                }
        	}
        	playerIn.inventoryContainer.detectAndSendChanges();
        }
    }
}