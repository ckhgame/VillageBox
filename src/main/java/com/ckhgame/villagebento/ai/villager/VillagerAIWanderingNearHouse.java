package com.ckhgame.villagebento.ai.villager;

import java.util.Random;

import com.ckhgame.villagebento.block.BlockMountable;
import com.ckhgame.villagebento.config.ConfigVillager;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.village.HelperVisiting;
import com.ckhgame.villagebento.util.village.VBDateTime;
import com.ckhgame.villagebento.util.village.VBRandomPositionGenerator;
import com.ckhgame.villagebento.util.village.VillagerEmoji;
import com.ckhgame.villagebento.util.village.VillagerNavigator;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class VillagerAIWanderingNearHouse extends VillagerAIMoving
{
	
	private static byte[] emojis = {
			VillagerEmoji.EmojiHappy,
			VillagerEmoji.EmojiMusic,
			VillagerEmoji.EmojiLove,
			VillagerEmoji.EmojiLonely,
			VillagerEmoji.EmojiThinking,
	};
	
    public VillagerAIWanderingNearHouse(EntityVBVillager entity)
    {
    	super(entity);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
    	if(this.entity.getRNG().nextInt(30) == 0){
    		
    		if(this.entity.getProfession().getTimeSchedule().isWorkTimeNow())
    			return false;
    		
    		if(this.entity.getProfession().getTimeSchedule().isSleepTimeNow())
    			return false;
    		
    		if(VBDateTime.isDayTime() && !this.entity.worldObj.isRaining()){
    			this.targetPos = VBRandomPositionGenerator.findRandomTargetNearBuildingFast(this.entity);
    			if(this.entity.isVisiting()) this.entity.cancelVisiting();
        		return true;
    		}
    	}
    	return false;
    }
    
    @Override
	public void startExecuting() {
		this.entity.setDebugText("Wandering(Near House)...");
	}
    
    @Override
	public void updateTask() {
    	
    	if(this.entity.getRNG().nextInt(200) == 0){
    		this.entity.playEmoji(emojis[this.entity.getRNG().nextInt(emojis.length)], 100);
    	}
    }
    
}