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
	public static final int AnimStateSad = 1;
	public static final int AnimStateSick = 2;
    
    //-max - 24k, >0 = happy, <0 sad(when it's < -24k, it's very easy to be sick..), -max = sick 
    public int getAnimStateValue(){return this.dataWatcher.getWatchableObjectInt(17);}
    protected void setAnimStateValue(int s){this.dataWatcher.updateObject(17,s);}  
    /**
     * returns the state , not the exact value..
     */
    public int getAnimState(){
    	int s = this.dataWatcher.getWatchableObjectInt(17);
    	if(s > 0) return AnimStateHappy;
    	else if(s > -999999) return AnimStateSad;
    	else return AnimStateSick;
    }
    
    public boolean needFeed(){
    	return (this.getAnimStateValue() < 20000);
    }
    
    public void feedAnimal(int foodValue){
    	if(foodValue < 0){
    		System.out.println("food value can not be < 0");
    	}
    	else{
    		this.setAnimStateValue(Math.min(24000,foodValue));
    	}
    }
    
    //animal hearts...
    public int getAnimLove(){return this.dataWatcher.getWatchableObjectInt(18);}
    protected void setAnimLove(int l){
    	this.dataWatcher.updateObject(18, l);
    }
    private static int[] loveToLevels = new int[]{24000*7, 24000 * 18, 24000 * 36, 24000 * 72};
    public int getAnimLoveLevel(){
    	int love = this.dataWatcher.getWatchableObjectInt(18);
    	int lvl = 0;
    	for(;lvl<loveToLevels.length;lvl++){
    		if(love < loveToLevels[lvl])
    			break;
    	}
    	return lvl;
    }
    
    //product
    public boolean hasProduct(){
    	int p = this.dataWatcher.getWatchableObjectInt(19);
    	return (p > 0);
    }
    
    public void generateProduct(){
    	this.dataWatcher.updateObject(19, 1);
    }
    
    public void harvestProdcut(){
    	this.dataWatcher.updateObject(19, 0);
    }   
    //------------------------------------------------------------
    
    private long lastWorldTime = 0;
    private int productTimer = 0;
    private static final int productTimeTotal = 24000;
    

    public EntityVBAnimal(World w)
    {
        super(w);
        
        if(!w.isRemote)
        	lastWorldTime = w.getWorldTime();
    }
    
    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(17, new Integer(24000)); // state
        this.dataWatcher.addObject(18, new Integer(0)); // love
        this.dataWatcher.addObject(19, new Integer(0)); // product
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
        	int sv = this.getAnimStateValue();
        	
        	if(this.isChild()){
        		//update child animal ages
        		age += deltaTime;
        		this.setGrowingAge(age);
        	}
        	else if(s == this.AnimStateHappy && !this.hasProduct()){
        		//update animal product
        		this.productTimer += deltaTime;
        		if(this.productTimer >= productTimeTotal){
        			this.productTimer -= productTimeTotal;
        			this.generateProduct();
        		}
        	}       	
	
        	//love
        	if(s == AnimStateHappy){
        		int love = this.getAnimLove();
        		love += deltaTime;
        		this.setAnimLove(love);
        	}
        	
        	//hp
        	if(s == AnimStateHappy&& this.getHealth() < this.getMaxHealth() && this.ticksExisted % 40 * 12 == 0){
        		this.heal(1.0F);
            }
        	
        	if(s == AnimStateSick && this.ticksExisted % 500 * 12 == 0){
                this.attackEntityFrom(DamageSource.starve, 1.0F);
        	}
        	
        	//sad -> sick
        	if(s == AnimStateSad && sv < -24000 && this.ticksExisted % 500 * 12 == 0){
        		//set sick
        		sv = -9999999;
        	}
        	
        	//update state
        	sv -= deltaTime;
        	this.setAnimStateValue(sv);
        }
        else{
        	//effect
        	if(this.getAnimState() == AnimStateSick){
        		this.worldObj.spawnParticle("mobSpell", this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, 0.699999988079071D, 0.699999988079071D, 0.6999999761581421D);
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
            
            //animal will drop state value when hit
            int sv = this.getAnimStateValue();
        	sv -= 24000;
        	this.setAnimStateValue(sv);
            
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
        p_70014_1_.setInteger(ConfigData.KeyAnimalState, this.getAnimStateValue());
        p_70014_1_.setBoolean(ConfigData.KeyAnimalProducts, this.hasProduct());
        p_70014_1_.setInteger(ConfigData.KeyAnimalProductTimer, this.productTimer);
        p_70014_1_.setInteger(ConfigData.KeyAnimalLove, this.getAnimLove());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound p_70037_1_)
    {
        super.readEntityFromNBT(p_70037_1_);
    	this.setAnimStateValue(p_70037_1_.getInteger(ConfigData.KeyAnimalState));
    	if(p_70037_1_.getBoolean(ConfigData.KeyAnimalProducts)) this.generateProduct();
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

    	return true;
    	
    	//return super.interact(p_70085_1_);
    }
    
    @Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) {
		// TODO Auto-generated method stub
		return null;
	}
    
    public abstract boolean breed(ItemStack food,EntityPlayer player);
    public abstract boolean dropProduct(ItemStack tool,EntityPlayer player);
}