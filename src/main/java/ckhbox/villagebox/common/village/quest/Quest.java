package ckhbox.villagebox.common.village.quest;

import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

public class Quest {
	private ItemStack[] required;
	private ItemStack[] rewards;
	
	public Quest(ItemStack[] required, ItemStack[] rewards){
		this.required = required;
		this.rewards = rewards;
	}
	
	public ItemStack[] getRequirements(){
		return this.required;
	}
	
	public ItemStack[] getRewards(){
		return this.rewards;
	}
	
	public String getText(EntityPlayer player){
		return StatCollector.translateToLocalFormatted(PathHelper.full("quest.text" + Rand.get().nextInt(5)),player.getName());
	}
	
	public boolean canComplete(EntityPlayer player){
		if(required == null) return true;
		for(int i = 0;i<required.length;i++){
			if(this.getItemNum(required[i], player) < required[i].stackSize){
				return false;
			}
		}
		return true;
	}
	
	public boolean complete(EntityPlayer player){
		
		if(!canComplete(player)) return false;
		
		for(int i = 0;i<required.length;i++){
			this.consumeItems(required[i], player);
		}
		
		if(rewards != null){
			for(int i =0;i<rewards.length;i++){
				ItemStack reward = rewards[i].copy();
				if(!player.inventory.addItemStackToInventory(reward)){
					player.dropPlayerItemWithRandomChoice(reward, false);
				}
			}	
		}
		
		//exp
		int exp = 15;
		
		while (exp > 0)
        {
            int i = EntityXPOrb.getXPSplit(exp);
            exp -= i;
            player.worldObj.spawnEntityInWorld(new EntityXPOrb(player.worldObj, player.posX, player.posY + 0.5D, player.posZ, i));
        }

		
		return true;
	}
	
	public int getItemNum(ItemStack itemstack, EntityPlayer player){
		ItemStack[] stacks = player.inventory.mainInventory;
		int count = 0;
		for (int i = 0; i < stacks.length; ++i)
        {
            if (stacks[i] != null && stacks[i].isItemEqual(itemstack))
            {
                count += stacks[i].stackSize;
            }
        }
		return count;
	}
	
	private void consumeItems(ItemStack itemstack, EntityPlayer player){
		ItemStack[] stacks = player.inventory.mainInventory;

		for (int i = 0; i < stacks.length; ++i)
        {
            if (stacks[i] != null && stacks[i].isItemEqual(itemstack))
            {
            	if(stacks[i].stackSize >= itemstack.stackSize){
            		stacks[i].stackSize -= itemstack.stackSize;
            		if(stacks[i].stackSize == 0) stacks[i] = null;
            		break;
            	}
            	else{
            		itemstack.stackSize -= stacks[i].stackSize;
            		stacks[i] = null;
            	}
            }
        }
	}
}
