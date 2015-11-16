package com.ckhgame.villagebento.entity.animal;

import com.ckhgame.villagebento.config.ConfigData;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityVBAnimal extends EntityAgeable
{
	//>= 12k full, >= 0 && < 12k little hungry, >= -12k && 
	public int getAnimHunger(){return this.dataWatcher.getWatchableObjectInt(17);}
    protected void setAnimHunber(int h){this.dataWatcher.updateObject(17, h);}
    
    //> 60 very good, >=0 && < 60 good, < 0 && >= -40 sick, >=-100 && < 40 deadly, <-100 I'm dead :( 
    public int getAnimState(){return this.dataWatcher.getWatchableObjectInt(18);}
    protected void setAnimState(int s){this.dataWatcher.updateObject(18, s);}
    
    //1-n means how many products you can get from me! this will refresh everyday, and the number is depends on animState and animLove
    public int getAnimProducts(){return this.dataWatcher.getWatchableObjectInt(19);}
    protected void setAnimProducts(int p){this.dataWatcher.updateObject(19, p);}
    
    public int getAnimLoveLvl(){return this.dataWatcher.getWatchableObjectInt(20);}
    protected void setAnimLoveLvl(int l){this.dataWatcher.updateObject(20, l);}
    
    public int getAnimLoveExp(){return this.dataWatcher.getWatchableObjectInt(21);}
    protected void setAnimLoveExp(int e){this.dataWatcher.updateObject(21, e);}
    
    private long lastWorldTime = 0;
    private int productTimer = 0;
    
    private int productTime = 12000;
    protected void setProductTime(int t){
    	this.productTime = t;
    }

    public EntityVBAnimal(World w)
    {
        super(w);
        
        if(!w.isRemote)
        	lastWorldTime = w.getWorldTime();
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(17, new Integer(100));
        this.dataWatcher.addObject(18, new Integer(100));
        this.dataWatcher.addObject(19, new Integer(0));
        this.dataWatcher.addObject(20, new Integer(0));
        this.dataWatcher.addObject(21, new Integer(0));
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    { 
    	int age = this.getGrowingAge();
    	super.onLivingUpdate();
    	
        if(!this.worldObj.isRemote){
        	long currentTime = this.worldObj.getWorldTime();
        	long deltaTime = Math.max(0, currentTime - this.lastWorldTime);
        	this.lastWorldTime = currentTime;
        	
        	//update animal products
        	this.productTimer += deltaTime;
        	if(this.productTimer > this.productTime){
        		this.productTimer -= this.productTime;
        		int products = this.getAnimProducts();
        		this.setAnimProducts(products + 1);
        	}
        	
        	//update child animal ages
        	if(this.isChild()){
        		age += deltaTime;
        		this.setGrowingAge(age);
        	}
        }
        
       

    }
    
    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource p_70097_1_, float p_70097_2_)
    {
        if (this.isEntityInvulnerable())
        {
            return false;
        }
        else
        {
            this.fleeingTick = 60;

            if (!this.isAIEnabled())
            {
                IAttributeInstance iattributeinstance = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed);

                if (iattributeinstance.getModifier(field_110179_h) == null)
                {
                    iattributeinstance.applyModifier(field_110181_i);
                }
            }

            this.entityToAttack = null;
            return super.attackEntityFrom(p_70097_1_, p_70097_2_);
        }
    }

    /**
     * Takes a coordinate in and returns a weight to determine how likely this creature will try to path to the block.
     * Args: x, y, z
     */
    public float getBlockPathWeight(int p_70783_1_, int p_70783_2_, int p_70783_3_)
    {
        return this.worldObj.getBlock(p_70783_1_, p_70783_2_ - 1, p_70783_3_) == Blocks.grass ? 10.0F : this.worldObj.getLightBrightness(p_70783_1_, p_70783_2_, p_70783_3_) - 0.5F;
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound p_70014_1_)
    {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setInteger(ConfigData.KeyAnimalHunger, this.getAnimHunger());
        p_70014_1_.setInteger(ConfigData.KeyAnimalState, this.getAnimState());
        p_70014_1_.setInteger(ConfigData.KeyAnimalProducts, this.getAnimProducts());
        p_70014_1_.setInteger(ConfigData.KeyAnimalProductTimer, this.productTimer);
        p_70014_1_.setInteger(ConfigData.KeyAnimalLoveLvl, this.getAnimLoveLvl());
        p_70014_1_.setInteger(ConfigData.KeyAnimalLoveExp, this.getAnimLoveExp());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
       	this.setAnimHunber(p_70037_1_.getInteger(ConfigData.KeyAnimalHunger));
    	this.setAnimState(p_70037_1_.getInteger(ConfigData.KeyAnimalState));
    	this.setAnimProducts(p_70037_1_.getInteger(ConfigData.KeyAnimalProducts));
    	this.productTimer = p_70037_1_.getInteger(ConfigData.KeyAnimalProductTimer);
        this.setAnimLoveLvl( p_70037_1_.getInteger(ConfigData.KeyAnimalLoveLvl));
    	this.setAnimLoveExp(p_70037_1_.getInteger(ConfigData.KeyAnimalLoveExp));
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        int i = MathHelper.floor_double(this.posX);
        int j = MathHelper.floor_double(this.boundingBox.minY);
        int k = MathHelper.floor_double(this.posZ);
        return this.worldObj.getBlock(i, j - 1, k) == Blocks.grass && this.worldObj.getFullBlockLightValue(i, j, k) > 8 && super.getCanSpawnHere();
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 120;
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer p_70085_1_)
    {
    	if(!this.worldObj.isRemote){
    		ItemStack hold = p_70085_1_.inventory.getCurrentItem();

    		if(!breed(hold)){
    			if(dropProduct(hold));
    		}
    		return true;
    	}

    	return super.interact(p_70085_1_);
    }
    
    @Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return null;
	}
    
    public abstract boolean breed(ItemStack food);
    public abstract boolean dropProduct(ItemStack tool);
}