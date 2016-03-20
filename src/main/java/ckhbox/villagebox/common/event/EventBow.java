package ckhbox.villagebox.common.event;

import ckhbox.villagebox.common.item.ModItems;
import ckhbox.villagebox.common.player.ExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.MathHelper;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class EventBow {
	
	@SubscribeEvent
	public void onArrowLoose(ArrowLooseEvent event)
	{
		if(!event.entityPlayer.worldObj.isRemote && event.bow.getItem() == ModItems.efficientBow){
            int i = event.charge;
            float f = (float)i / 20.0F;
            f = (f * f + f * 2.0F) / 3.0F;
            
            event.bow.setItemDamage(2);
            
            if ((double)f < 0.1D)
            {
                return;
            }

            if (f > 1.0F)
            {
                f = 1.0F;
            }

            EntityArrow[] entityarrows = new EntityArrow[4];
            float oldYaw = event.entityPlayer.rotationYaw;
            float[] yawChanges = new float[]{10.0F, -10.0F,20.0F,-20.0F};
            for(int c=0;c<entityarrows.length;c++){
            	event.entityPlayer.rotationYaw = oldYaw + yawChanges[c];
            	entityarrows[c] = new EntityArrow(event.entityPlayer.worldObj, event.entityPlayer, f * 2.0F);
            }   
            event.entityPlayer.rotationYaw = oldYaw;

            if (f == 1.0F)
            {
            	for(EntityArrow entityarrow : entityarrows)
            		entityarrow.setIsCritical(true);
                
            }

            int j = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, event.bow);

            if (j > 0)
            {
            	for(EntityArrow entityarrow : entityarrows)
            		entityarrow.setDamage(entityarrow.getDamage() + (double)j * 0.5D + 0.5D);
            }

            int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, event.bow);

            if (k > 0)
            {
            	for(EntityArrow entityarrow : entityarrows)
            		entityarrow.setKnockbackStrength(k);
            }

            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, event.bow) > 0)
            {
            	for(EntityArrow entityarrow : entityarrows)
            		entityarrow.setFire(100);
            }

            event.entityPlayer.worldObj.playSoundAtEntity(event.entityPlayer, "random.bow", 1.0F, 1.0F / (Rand.get().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            
            if(event.entityPlayer.capabilities.isCreativeMode){
            	for(EntityArrow entityarrow : entityarrows){   
                		event.entityPlayer.worldObj.spawnEntityInWorld(entityarrow);
                	}
            }
            else{
                event.entityPlayer.inventory.consumeInventoryItem(Items.arrow);
                
                for(EntityArrow entityarrow : entityarrows){   
                	if(event.entityPlayer.inventory.consumeInventoryItem(Items.arrow)){
                		event.entityPlayer.worldObj.spawnEntityInWorld(entityarrow);
                	}
                    
                }
                
                event.entityPlayer.inventory.addItemStackToInventory(new ItemStack(Items.arrow));
            }
		}
	}
}
