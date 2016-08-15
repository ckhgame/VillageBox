package ckhbox.villagebox.common.tileentity.totem;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;

public class TileEntityNatureTotem extends TileEntityTotem{

	@Override
	protected void updateTotonEffect() {
		List<EntityLivingBase> list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.getEffectField(16, 10));
		if(list != null){
			for(EntityLivingBase l : list){
				if(l instanceof EntityMob)
					continue;
				l.addPotionEffect(new PotionEffect(MobEffects.regeneration,100,0));
			}
		}
	}
}
