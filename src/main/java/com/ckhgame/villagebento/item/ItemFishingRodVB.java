package com.ckhgame.villagebento.item;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.entity.misc.EntityFishHookVB;
import com.ckhgame.villagebento.util.data.PlayerFishHookVB;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ItemFishingRodVB extends Item
{	
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;
    private static final String __OBFID = "CL_00000034";

    public ItemFishingRodVB(String name)
    {
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setUnlocalizedName(name);
		this.setTextureName(Main.MODID + ":" + name);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    @SideOnly(Side.CLIENT)
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
    	EntityFishHookVB entityFishHook = PlayerFishHookVB.get(p_77659_3_);
        if (entityFishHook != null)
        {
            int i = entityFishHook.func_146034_e();
            p_77659_1_.damageItem(i, p_77659_3_);
            p_77659_3_.swingItem();
        }
        else
        {
            p_77659_2_.playSoundAtEntity(p_77659_3_, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!p_77659_2_.isRemote)
            {
                p_77659_2_.spawnEntityInWorld(new EntityFishHookVB(p_77659_2_, p_77659_3_));
            }

            p_77659_3_.swingItem();
        }

        return p_77659_1_;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister p_94581_1_)
    {
        this.itemIcon = p_94581_1_.registerIcon(this.getIconString() + "_uncast");
        this.theIcon = p_94581_1_.registerIcon(this.getIconString() + "_cast");
    }

    
    
    @Override
	public IIcon getIconFromDamage(int p_77617_1_) {
    		return this.theIcon;
	}

    /**
     * Checks isDamagable and if it cannot be stacked
     */
    public boolean isItemTool(ItemStack p_77616_1_)
    {
        return super.isItemTool(p_77616_1_);
    }

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}