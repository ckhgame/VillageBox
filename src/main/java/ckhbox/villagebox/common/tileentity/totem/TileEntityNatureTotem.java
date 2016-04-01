package ckhbox.villagebox.common.tileentity.totem;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityNatureTotem extends TileEntityTotem{

	@Override
	protected void updateTotonEffect() {
		List<EntityLivingBase> list = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.getEffectField(16, 10));
		if(list != null){
			for(EntityLivingBase l : list){
				if(l instanceof EntityMob)
					continue;
				l.addPotionEffect(new PotionEffect(Potion.regeneration.id,100,0));
			}
		}
	}
}
