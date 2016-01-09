package com.ckhgame.villagebento.entity.animal;

import com.ckhgame.villagebento.item.ModItems;
import com.ckhgame.villagebento.util.data.VBParticles;
import com.ckhgame.villagebento.util.village.PlayerMsg;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVBChicken extends EntityVBAnimal
{
    public float field_70886_e;
    public float destPos;
    public float field_70884_g;
    public float field_70888_h;
    public float field_70889_i = 1.0F;

    public EntityVBChicken(World p_i1682_1_)
    {
        super(p_i1682_1_);
        this.setSize(0.3F, 0.7F);
        this.renderDistanceWeight = 2.0D;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.0D, ModItems.itemChickenFood, false));
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
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
        this.field_70888_h = this.field_70886_e;
        this.field_70884_g = this.destPos;
        this.destPos = (float)((double)this.destPos + (double)(this.onGround ? -1 : 4) * 0.3D);

        if (this.destPos < 0.0F)
        {
            this.destPos = 0.0F;
        }

        if (this.destPos > 1.0F)
        {
            this.destPos = 1.0F;
        }

        if (!this.onGround && this.field_70889_i < 1.0F)
        {
            this.field_70889_i = 1.0F;
        }

        this.field_70889_i = (float)((double)this.field_70889_i * 0.9D);

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        this.field_70886_e += this.field_70889_i * 2.0F;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float p_70069_1_) {}

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return "mob.chicken.say";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.chicken.hurt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.chicken.hurt";
    }

    protected void func_145780_a(int p_145780_1_, int p_145780_2_, int p_145780_3_, Block p_145780_4_)
    {
        this.playSound("mob.chicken.step", 0.15F, 1.0F);
    }
    
	@Override
	public boolean breed(ItemStack food,EntityPlayer player) {
		if(food == null)
			return false;
		
		if(food.getItem() == ModItems.itemChickenFood){
			int s = this.getAnimState();
			if(s == AnimStateSick){
				PlayerMsg.send(player, this.getCommandSenderName() + " is sick and doesn't like to eat anything!");
			}
			else if(!this.needFeed()){
				PlayerMsg.send(player, this.getCommandSenderName() + " is not feeling hungry!");
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
		else if(food.getItem() == ModItems.itemChickenPotion){
			int s = this.getAnimState();
			if(s != AnimStateSick){
				PlayerMsg.send(player, this.getCommandSenderName() + " is not sick!");
			}
			else{
				VBParticles.spawnParticleFromServer(this, VBParticles.Fx_Happy, this.posX, this.posY, this.posZ);
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
		if(tool == null || tool.getItem() == ModItems.itemChickenGloves){ // hands
			
			if(this.hasProduct()){
				this.harvestProdcut();
				
				if(tool == null)
					this.dropItem(ModItems.itemVillageEgg, 1);
				else{
					int r = this.getRNG().nextInt(100);
					if(r < 80){
						this.dropItem(ModItems.itemVillageHeartEgg, 1);
					}
					else if(r < 90){
						this.dropItem(ModItems.itemVillageSilverEgg, 1);
					}
					else if(r < 95){
						this.dropItem(ModItems.itemVillageGoldenEgg, 1);
					}
					else if(r < 100){
						this.dropItem(ModItems.itemVillageEasterEgg, 1);
					}
				}
			}
		}
		return false;
	}
	
}