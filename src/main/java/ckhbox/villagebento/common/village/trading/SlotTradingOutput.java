package ckhbox.villagebento.common.village.trading;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotTradingOutput extends Slot
{

    private final InventoryTrading tradingInventory;

    private EntityPlayer player;
    private ITrading trader;
    
    private int field_75231_g;

    public SlotTradingOutput(EntityPlayer player, ITrading trader, InventoryTrading tradingInventory, int slotIndex, int xPosition, int yPosition)
    {
        super(tradingInventory, slotIndex, xPosition, yPosition);
        this.player = player;
        this.trader = trader;
        this.tradingInventory = tradingInventory;
    }

    /**
     * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
     */
    public boolean isItemValid(ItemStack stack)
    {
        return false;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int amount)
    {
        if (this.getHasStack()){
            this.field_75231_g += Math.min(amount, this.getStack().stackSize);
        }

        return super.decrStackSize(amount);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood. Typically increases an
     * internal count then calls onCrafting(item).
     */
    protected void onCrafting(ItemStack stack, int amount)
    {
        this.field_75231_g += amount;
        this.onCrafting(stack);
    }

    /**
     * the itemStack passed in is the output - ie, iron ingots, and pickaxes, not ore and wood.
     */
    protected void onCrafting(ItemStack stack)
    {
        stack.onCrafting(this.player.worldObj, this.player, this.field_75231_g);
        this.field_75231_g = 0;
    }

    public void onPickupFromSlot(EntityPlayer playerIn, ItemStack stack)
    {
        this.onCrafting(stack);
        
        if(this.tradingInventory.tradeCurrentRecipe()){
        	this.trader.onTrade();
        }
        this.tradingInventory.resetRecipeAndSlots();
    }
}