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
	public static final int AnimStateHappy = 0;
	public static final int AnimStateNormal = 1;
	public static final int AnimStateSick = 2;
	public static final int AnimStateDeadly = 3;
	
	
	
	//0 - 24k, < 6k hungry
	public int getAnimHunger(){return this.dataWatcher.getWatchableObjectInt(17);}
    protected void setAnimHunger(int h){this.dataWatcher.updateObject(17, Math.max(0, Math.min(24000, h)));}
    public float getAnimHungerPercent(){
    	int h = this.dataWatcher.getWatchableObjectInt(17);
    	return Math.max(0.0F, h * 1.0F / 24000.0F);
    }
    public void addAnimHunger(int food){
    	int h = this.dataWatcher.getWatchableObjectInt(17);
    	h = Math.min(24000, Math.max(0, this.isChild()?food * 2: food) + h);
    	this.dataWatcher.updateObject(17, h);
    }
    
    //0 - 24k,>18k happy >12k normal 0-12k sick <=2k deadly(will keep reducing hp)
    public int getAnimStateValue(){return this.dataWatcher.getWatchableObjectInt(18);}
    protected void setAnimStateValue(int s){this.dataWatcher.updateObject(18, Math.max(0, Math.min(24000, s)));}  
    /**
     * returns the state , not the exact value..
     */
    public int getAnimState(){
    	int s = this.dataWatcher.getWatchableObjectInt(18);
    	if(s > 18000) return AnimStateHappy;
    	else if(s > 12000) return AnimStateNormal;
    	else if(s > 2000) return AnimStateSick;
    	else return AnimStateDeadly;
    }
    
    //1-n means how many products you can get from me! this will refresh everyday, and the number is depends on animState and animLove
    public int getAnimProducts(){return this.dataWatcher.getWatchableObjectInt(19);}
    protected void setAnimProducts(int p){this.dataWatcher.updateObject(19, p);}
    public int getAnimProductsMax(){
    	return getAnimLoveLvl() + 1;
    }
    
    public int getAnimLove(){return this.dataWatcher.getWatchableObjectInt(20);}
    protected void setAnimLove(int l){
    	this.dataWatcher.updateObject(20, Math.max(0, Math.min(loveEachLevel * 4, l)));
    }
    private int loveEachLevel = 24000 * 7;
    public int getAnimLoveLvl(){
    	int l = this.dataWatcher.getWatchableObjectInt(20);
    	return Math.min(4,l / loveEachLevel);
    }
    
    private long lastWorldTime = 0;
    private int productTimer = 0;
    
    private int oriProductTime = 12000;
    public int getProductTime(){
    	return this.oriProductTime - this.getAnimLoveLvl() * 1000;
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
        this.dataWatcher.addObject(17, new Integer(24000));
        this.dataWatcher.addObject(18, new Integer(24000));
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
        	
        	int s = this.getAnimState();
        	
        	if(this.isChild()){
        		//update child animal ages
        		age += deltaTime;
        		this.setGrowingAge(age);
        	}
        	else{
        		//update animal products
        		if(this.getAnimProducts() < this.getAnimProductsMax()){
        			if(s == this.AnimStateNormal)
            			this.productTimer += this.getRNG().nextInt((int)deltaTime + 1);
            		else if(s == this.AnimStateHappy)
            			this.productTimer += deltaTime;
        			
                	int pt = this.getProductTime();
                	if(this.productTimer > pt){
                		this.productTimer -= pt;
                		int products = this.getAnimProducts();
                		this.setAnimProducts(products + 1);
                	}
        		}
        		else{
        			this.productTimer = 0;
        		}
        	}
        	

        	int h =  this.getAnimHunger();
	
        	//update state
        	int sv = this.getAnimStateValue();
        	if(h < 1000 || s == AnimStateSick || s == AnimStateDeadly){
        		sv -= this.getRNG().nextInt((int)deltaTime + 1);
        	}
        	else{
        		sv += deltaTime;
        	}      	
        	this.setAnimStateValue(sv);
        	
        	//update hunger
        	if(h > 0){
        		h = Math.max(0,h - (int)deltaTime);
        	}
        	this.setAnimHunger(h);
        	
        	//update love
        	int l = this.getAnimLove();
        	if(s == AnimStateHappy)
        		l += deltaTime;
        	else if(s == AnimStateNormal)
        		l += this.getRNG().nextInt((int)deltaTime + 1);
        	
        	this.setAnimLove(l);
        	
        	//hp
        	if(s == AnimStateHappy && this.getHealth() < this.getMaxHealth() && this.ticksExisted % 40 * 12 == 0){
        		this.heal(1.0F);
            }
        	else if(s == AnimStateDeadly && this.ticksExisted % 300 * 12 == 0){
                this.attackEntityFrom(DamageSource.starve, 1.0F);
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
        p_70014_1_.setInteger(ConfigData.KeyAnimalState, this.getAnimStateValue());
        p_70014_1_.setInteger(ConfigData.KeyAnimalProducts, this.getAnimProducts());
        p_70014_1_.setInteger(ConfigData.KeyAnimalProductTimer, this.productTimer);
        p_70014_1_.setInteger(ConfigData.KeyAnimalLove, this.getAnimLove());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
       	this.setAnimHunger(p_70037_1_.getInteger(ConfigData.KeyAnimalHunger));
    	this.setAnimStateValue(p_70037_1_.getInteger(ConfigData.KeyAnimalState));
    	this.setAnimProducts(p_70037_1_.getInteger(ConfigData.KeyAnimalProducts));
    	this.productTimer = p_70037_1_.getInteger(ConfigData.KeyAnimalProductTimer);
        this.setAnimLove( p_70037_1_.getInteger(ConfigData.KeyAnimalLove));
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

    		if(!breed(hold,p_70085_1_)){
    			if(dropProduct(hold,p_70085_1_));
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
    
    public abstract boolean breed(ItemStack food,EntityPlayer player);
    public abstract boolean dropProduct(ItemStack tool,EntityPlayer player);
}