package ckhbox.villagebox.common.tileentity.totem;

import java.util.List;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityNatureTotem extends TileEntityTotem{

	@Override
	protected void updateTotonEffect() {
		List<EntityCreature> list = this.worldObj.getEntitiesWithinAABB(EntityCreature.class, this.getEffectField(16, 10));
		if(list != null){
			for(EntityCreature c : list){
				if(c instanceof EntityMob)
					continue;
				c.addPotionEffect(new PotionEffect(Potion.regeneration.id,100,0));
			}
		}
	}
}
