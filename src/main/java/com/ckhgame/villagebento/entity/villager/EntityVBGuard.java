package com.ckhgame.villagebento.entity.villager;

import com.ckhgame.villagebento.ai.villager.VillageAINearestAttackableTarget;
import com.ckhgame.villagebento.ai.villager.VillagerAIAttackOnCollide;
import com.ckhgame.villagebento.ai.villager.VillagerAIPatrolling;
import com.ckhgame.villagebento.ai.villager.VillagerAISleeping;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchClosest;
import com.ckhgame.villagebento.ai.villager.VillagerAIWatchInteractTarget;
import com.ckhgame.villagebento.config.ConfigVillager;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityVBGuard extends EntityVBVillager {

	public EntityVBGuard(World p_i1578_1_) {
		super(p_i1578_1_);
	}

	@Override
	public void initAITasks() {		
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new VillagerAIAttackOnCollide(this, EntityMob.class, 0.5D, false));
		this.tasks.addTask(2, new EntityAIOpenDoor(this, true));

		this.tasks.addTask(3, new VillagerAIWatchInteractTarget(this, ConfigVillager.MaxInteractDistance));
		this.tasks.addTask(3, new VillagerAIWatchClosest(this, EntityPlayer.class, ConfigVillager.MaxInteractDistance, 1.0F));
		this.tasks.addTask(3, new VillagerAIWatchClosest(this, EntityVBVillager.class, 5.0F, 0.02F));
		this.tasks.addTask(3, new VillagerAIWatchClosest(this, EntityLiving.class, 8.0F, 0.02F));
		
		this.tasks.addTask(4, new VillagerAISleeping(this));
		this.tasks.addTask(5, new VillagerAIPatrolling(this));
		
		this.targetTasks.addTask(0, new VillageAINearestAttackableTarget(this, EntityMob.class, 0, false));	
	}
	
	@Override
	public void setSleeping(boolean sleeping) {
		super.setSleeping(sleeping);
		equipWeaponAndArmors(!sleeping);
	}
	
	@Override
	public void onLevelUpgraded(){
		super.onLevelUpgraded();
		if(!this.isSleeping()){
			equipWeaponAndArmors(true);
		}
	}
	
    @Override
	protected void onFirstTimeLivingUpdate() {
		super.onFirstTimeLivingUpdate();
		this.equipWeaponAndArmors(!this.isSleeping());
	}

	protected void equipWeaponAndArmors(boolean equip){
    	
    	Item[] armorSets = new Item[]{null,null,null,null,null};
    	
    	if(equip){
    		if(this.getLevel() == 0){
    			armorSets[0] = Items.wooden_sword;
    			armorSets[1] = null;
    			armorSets[2] = null;
    			armorSets[3] = null;
    			armorSets[4] = null;
    		}
    		else if(this.getLevel() == 1){
    			armorSets[0] = Items.stone_sword;
    			armorSets[1] = Items.leather_boots;
    			armorSets[2] = Items.leather_chestplate;
    			armorSets[3] = Items.leather_helmet;
    			armorSets[4] = Items.leather_leggings;
    		}
    		else if(this.getLevel() == 2){
    			armorSets[0] = Items.iron_sword;
    			armorSets[1] = Items.iron_boots;
    			armorSets[2] = Items.iron_chestplate;
    			armorSets[3] = Items.iron_helmet;
    			armorSets[4] = Items.iron_leggings;
    		}
    	}
    	
    	for(int i =0;i<5;i++){
    		this.setCurrentItemOrArmor(i, armorSets[i]==null?null:new ItemStack(armorSets[i]));
    	}

    }
	
	
}
