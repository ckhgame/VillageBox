package ckhbox.villagebox.common.tileentity.totem;

import java.util.List;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

public class TileEntityFireTotem extends TileEntityTotem{

	@Override
	protected void updateTotonEffect() {				
		List<EntityMob> list = this.worldObj.getEntitiesWithinAABB(EntityMob.class, this.getEffectField(16, 10));
		if(list != null){
			for(EntityMob mob : list){
				mob.setFire(3);
			}
		}
	}
}
