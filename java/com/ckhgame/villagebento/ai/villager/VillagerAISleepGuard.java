package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.VillageTime;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;

public class VillagerAISleepGuard extends VillagerAISleepNightbird
{

	public VillagerAISleepGuard(EntityVBVillager entity) {
		super(entity);
	}
    
	
	
	@Override
	protected void onSleep(){
		super.onSleep();
		equipWeaponAndArmors(false);
	}



	@Override
	public void resetTask() {
		// TODO Auto-generated method stub
		super.resetTask();
		equipWeaponAndArmors(true);
	}



	private void equipWeaponAndArmors(boolean equip){
    	if(equip){
    		if(this.entity.getEquipmentInSlot(0) == null){
        		this.entity.setCurrentItemOrArmor(0, new ItemStack(Items.iron_sword));
            	this.entity.setCurrentItemOrArmor(1, new ItemStack(Items.iron_boots));
            	this.entity.setCurrentItemOrArmor(2, new ItemStack(Items.iron_chestplate));
            	this.entity.setCurrentItemOrArmor(3, new ItemStack(Items.iron_helmet));
            	this.entity.setCurrentItemOrArmor(4, new ItemStack(Items.iron_leggings));
    		}
    	}
    	else{
    		if(this.entity.getEquipmentInSlot(0) != null){
    			this.entity.setCurrentItemOrArmor(0, null);
        		this.entity.setCurrentItemOrArmor(1, null);
        		this.entity.setCurrentItemOrArmor(2, null);
        		this.entity.setCurrentItemOrArmor(3, null);
        		this.entity.setCurrentItemOrArmor(4, null);
    		}
    	}
    }
}