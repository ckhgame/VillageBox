package ckhbox.villagebox.common.gui.common;

import ckhbox.villagebox.common.village.trading.ITrading;
import ckhbox.villagebox.common.village.trading.InventoryTrading;
import ckhbox.villagebox.common.village.trading.SlotTradingOutput;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerTrading extends Container
{
    private ITrading trader;
    private InventoryTrading tradingInventory;
    /** Instance of World. */
    private final World world;

    public ContainerTrading(InventoryPlayer playerInventory, ITrading trader, World world)
    {
        this.trader = trader;
        this.world = world;
        this.tradingInventory = new InventoryTrading(playerInventory.player, trader);
        this.addSlotToContainer(new Slot(this.tradingInventory, 0, 23, 53));
        this.addSlotToContainer(new Slot(this.tradingInventory, 1, 41, 53));
        this.addSlotToContainer(new Slot(this.tradingInventory, 2, 59, 53));
        this.addSlotToContainer(new Slot(this.tradingInventory, 3, 77, 53));
        this.addSlotToContainer(new SlotTradingOutput(playerInventory.player, trader, this.tradingInventory, 4, 132, 53));

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

    public InventoryTrading getTradingInventory()
    {
        return this.tradingInventory;
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
        this.tradingInventory.resetRecipeAndSlots();
        super.onCraftMatrixChanged(inventoryIn);
    }

    public void setCurrentRecipeIndex(int currentRecipeIndex)
    {
       this.tradingInventory.setCurrentRecipeIndex(currentRecipeIndex);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
    }

    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tradingInventory.isUseableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);
        
        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 4)
            {
                if (!this.mergeItemStack(itemstack1, 5, 41, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index >= 4)
            {
                if (index >= 5 && index < 32)
                {
                    if (!this.mergeItemStack(itemstack1, 32, 41, false))
                    {
                        return null;
                    }
                }
                else if (index >= 32 && index < 41 && !this.mergeItemStack(itemstack1, 5, 32, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 5, 41, false))
            {
                return null;
            }

            if (itemstack1.func_190916_E() == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.func_190916_E() == itemstack.func_190916_E())
            {
                return null;
            }

            slot.func_190901_a(playerIn, itemstack1);
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
        	for(int i =0;i<4;i++){
        		if (this.tradingInventory.getStackInSlot(i) != null)
                {
        			if(!playerIn.inventory.addItemStackToInventory(this.tradingInventory.getStackInSlot(i)))
        				playerIn.dropItem(this.tradingInventory.getStackInSlot(i), false);
                }
        	}
        	playerIn.inventoryContainer.detectAndSendChanges();
        }
    }
}