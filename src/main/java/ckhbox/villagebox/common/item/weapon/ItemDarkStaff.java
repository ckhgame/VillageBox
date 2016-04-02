package ckhbox.villagebox.common.item.weapon;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import ckhbox.villagebox.common.entity.throwable.EntityFlameBall;
import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.util.helper.PathHelper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityWitherSkull;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
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
    
    public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target)
    {
    	if(strengthen(stack,playerIn, target, EntityZombie.class, EntityPigZombie.class,1)){
    		return true;
    	}
    	
    	if(strengthen(stack,playerIn, target, EntitySkeleton.class, EntityBlaze.class,1)){
    		return true;
    	}
    	
    	if(strengthen(stack,playerIn, target, EntitySpider.class, EntityCaveSpider.class,2)){
    		return true;
    	}
    	
    	return false;
    	
    }
    
    private boolean strengthen(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, Class<? extends EntityMob> mobfind, Class<? extends EntityMob> mobto, int num){
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
    			this.damageStaff(playerIn, stack);
    			return true;
    		}
    	}    	
    	return false;
    }
	
	 public void damageStaff(EntityPlayer player, ItemStack stack){
         if (!player.capabilities.isCreativeMode)
         {
         	stack.damageItem(1, player);
         	if(stack.getItemDamage() == 0){
         		player.setCurrentItemOrArmor(0, new ItemStack(ModItems.staff));
         	}
         }
	 }
    
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		String info = I18n.format(PathHelper.full("info.item.darkStaff"));
		String info1 = I18n.format(PathHelper.full("info.item.darkStaff_1"));
		tooltip.add(info);
		tooltip.add(info1);
	}
    
    
}