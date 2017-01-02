package ckhbox.villagebox.common.village.quest;

import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.resources.I18n;

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
	
	@SideOnly(Side.CLIENT)
	public String getText(EntityPlayer player){
		return I18n.format(PathHelper.full("quest.text"),player.getName());
	}
	
	public boolean canComplete(EntityPlayer player){
		if(required == null) return true;
		for(int i = 0;i<required.length;i++){
			if(this.getItemNum(required[i], player) < required[i].func_190916_E()){
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
					player.dropItem(reward, false);
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
		NonNullList<ItemStack> stacks = player.inventory.mainInventory;
		int count = 0;
		for (int i = 0; i < stacks.size(); ++i)
        {
            if (stacks.get(i) != null && stacks.get(i).isItemEqual(itemstack))
            {
                count += stacks.get(i).func_190916_E();
            }
        }
		return count;
	}
	
	private void consumeItems(ItemStack itemstack, EntityPlayer player){
		NonNullList<ItemStack> stacks = player.inventory.mainInventory;
		for (int i = 0; i < stacks.size(); ++i)
        {
            if (stacks.get(i) != null && stacks.get(i).isItemEqual(itemstack))
            {
            	if(stacks.get(i).func_190916_E() >= itemstack.func_190916_E()){
            		stacks.get(i).func_190920_e(stacks.get(i).func_190916_E() - itemstack.func_190916_E());
            		if(stacks.get(i).func_190916_E() == 0) stacks.set(i, ItemStack.field_190927_a);
            		break;
            	}
            	else{
            		itemstack.func_190920_e(itemstack.func_190916_E() - stacks.get(i).func_190916_E());
            		stacks.set(i, ItemStack.field_190927_a);
            	}
            }
        }
	}
}
