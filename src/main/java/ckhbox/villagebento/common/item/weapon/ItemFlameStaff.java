package ckhbox.villagebento.common.item.weapon;

import ckhbox.villagebento.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebento.common.util.helper.PathHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemFlameStaff extends Item
{
	public ItemFlameStaff()
    {
		this.setUnlocalizedName(PathHelper.full("flameStaff"));
        this.maxStackSize = 1;
        this.setMaxDamage(8);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if (!playerIn.capabilities.isCreativeMode)
        {
        	itemStackIn.damageItem(3, playerIn);
        }

        playerIn.swingItem();
        
        worldIn.playSoundAtEntity(playerIn, "mob.ghast.fireball", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        if (!worldIn.isRemote)
        {
            worldIn.spawnEntityInWorld(new EntityFlameBall(worldIn, playerIn));
        }

        playerIn.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
        return itemStackIn;
    }
}