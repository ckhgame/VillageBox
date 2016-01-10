package com.ckhgame.villagebento.entity.animal;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VBParticles;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVBCow extends EntityVBAnimal
{

    public EntityVBCow(World p_i1683_1_)
    {
        super(p_i1683_1_);
        this.setSize(0.9F, 1.3F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, ModItems.itemCowFood, false));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        
        this.setAlwaysRenderNameTag(true);
        
        this.setGrowingAge(-24000 * 7);
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20000000298023224D);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.cow.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cow.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cow.hurt";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.cow.step", 0.15F, 1.0F);
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    @Override
	public boolean breed(ItemStack food,EntityPlayer player) {
		if(food == null)
			return false;
		
		if(food.getItem() == ModItems.itemCowFood){
			int s = this.getAnimState();
			if(s == AnimStateSick){
				PlayerMsg.sendTranslation(player, "villagebento.msg.animalFeedWhenSick", this.getCommandSenderName());
			}
			else if(!this.needFeed()){
				PlayerMsg.sendTranslation(player, "villagebento.msg.animalFeedNotHungery", this.getCommandSenderName());
			}
			else{
				VBParticles.spawnParticleFromServer(this, VBParticles.Fx_Heart, this.posX, this.posY, this.posZ);
				this.feedAnimal(24000);
				--food.stackSize;
                if (food.stackSize <= 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                }
			}		
			return true;
		}
		else if(food.getItem() == ModItems.itemCowPotion){
			int s = this.getAnimState();
			if(s != AnimStateSick){
				PlayerMsg.sendTranslation(player, "villagebento.msg.animalIsntSick", this.getCommandSenderName());
			}
			else{
				VBParticles.spawnParticleFromServer(this, VBParticles.Fx_Happy, this.posX, this.posY, this.posZ);
				PlayerMsg.sendTranslation(player, "villagebento.msg.animalRecoved", this.getCommandSenderName());
				this.setAnimStateValue(-12000);
				--food.stackSize;
                if (food.stackSize <= 0)
                {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                }
			}
		}
		
		
		return false;
	}

	@Override
	public boolean dropProduct(ItemStack tool,EntityPlayer player) {
		if(tool == null)
			return false;
		
		if(tool.getItem() == ModItems.itemMilkBottle){ // hands
			
			if(this.hasProduct()){
				this.harvestProdcut();
				
				int n = 1;
				int r = this.rand.nextInt(this.getAnimLoveLevel() * 10);
				if(r < 15) n = 1;
				else if(r < 30) n = 2;
				else n = 3;
				
				for(int i =0;i<n;i++)
					this.dropItem(ModItems.itemVillageMilk, 1);
				
				--tool.stackSize;
			}
		}
		return false;
	}
}