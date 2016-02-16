package ckhbox.villagebento.common.event;

import ckhbox.villagebento.common.item.ModItems;
import ckhbox.villagebento.common.util.math.Rand;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventCoinsFound {
	
	private void dropCoins(int num, World world, double x, double y, double z){
		
		while(num > 0){
			int count = num > 64? 64:num;
			num -= count;
			EntityItem entityitem = new EntityItem(world, x, y + 0.5F, z, new ItemStack(ModItems.bronzeCoin,count));
			entityitem.setDefaultPickupDelay();
			world.spawnEntityInWorld(entityitem);
		}
	}
	
	@SubscribeEvent
	public void onLivingDeath(LivingDeathEvent event)
	{
		if(!event.entityLiving.worldObj.isRemote){
			if(Rand.get().nextInt(3) == 0 && event.source.getSourceOfDamage() instanceof EntityPlayer){
				dropCoins(Rand.get().nextInt(5),event.entityLiving.worldObj, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ);
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockBreak(BlockEvent.BreakEvent event)
	{
		if(!event.world.isRemote){
			if(Rand.get().nextInt(10) == 0){
				dropCoins(Rand.get().nextInt(3),event.world, event.pos.getX() + 0.5D, event.pos.getY() + 0.5D, event.pos.getZ() + 0.5D);
			}
		}
	}
	
	@SubscribeEvent
	public void onBlockHarvest(BlockEvent.HarvestDropsEvent event)
	{
		if(!event.world.isRemote){
			if(Rand.get().nextInt(5) == 0){
				dropCoins(Rand.get().nextInt(3),event.world, event.pos.getX() + 0.5D, event.pos.getY() + 0.5D, event.pos.getZ() + 0.5D);
			}
		}
	}
}
