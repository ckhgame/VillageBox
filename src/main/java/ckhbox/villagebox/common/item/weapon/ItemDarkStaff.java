package ckhbox.villagebox.common.item.weapon;

import java.util.List;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class ItemDarkStaff extends Item
{	
	public ItemDarkStaff()
    {
		this.setUnlocalizedName(PathHelper.full("darkStaff"));
        this.maxStackSize = 1;
        this.setMaxDamage(10);
        this.setCreativeTab(ModItems.tabVB);
    }

    @Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target,
			EnumHand hand) {

    	if(strengthen(stack,playerIn, target, EntityZombie.class, EntityPigZombie.class,1, hand)){
    		return true;
    	}
    	
    	if(strengthen(stack,playerIn, target, EntitySkeleton.class, EntityBlaze.class,1, hand)){
    		return true;
    	}
    	
    	if(strengthen(stack,playerIn, target, EntitySpider.class, EntityCaveSpider.class,2, hand)){
    		return true;
    	}
    	
    	return false;
	}

    
    private boolean strengthen(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, Class<? extends EntityMob> mobfind, Class<? extends EntityMob> mobto, int num, EnumHand hand){
    	if(mobfind.isInstance(target)){    		
    		if(!target.worldObj.isRemote){
    			for(int i =0;i<num;i++){
        			EntityMob newmob = null;
    				try {
    					newmob = mobto.getDeclaredConstructor(World.class).newInstance(target.worldObj);
    				} catch (Exception e) {}
    				
    				if(newmob != null){
    	    			newmob.setPositionAndRotation(target.posX, target.posY, target.posZ, target.rotationYaw, target.rotationPitch);
    	    			target.worldObj.spawnEntityInWorld(newmob);
    				}
    			}
    			target.worldObj.removeEntity(target);
    			this.damageStaff(playerIn, stack, hand);
    			return true;
    		}
    	}    	
    	return false;
    }
	
	public void damageStaff(EntityPlayer player, ItemStack stack, EnumHand hand){
        if (!player.capabilities.isCreativeMode)
        {
        	stack.damageItem(1, player);
        	if(stack.getItemDamage() == 0){
        		player.setItemStackToSlot(hand == EnumHand.MAIN_HAND? EntityEquipmentSlot.MAINHAND : EntityEquipmentSlot.OFFHAND, new ItemStack(ModItems.staff));
        	}
        }
	 }   
    
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.translateToLocal(PathHelper.full("info.item.darkStaff"));
		String info1 = I18n.translateToLocal(PathHelper.full("info.item.darkStaff_1"));
		tooltip.add(info);
		tooltip.add(info1);
	}
    
    
}