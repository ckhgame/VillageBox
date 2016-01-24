package ckhbox.villagebento.common.entity.villager;

import ckhbox.villagebento.client.gui.villager.GuiVillagerMain;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityVillager extends EntityCreature{

	public EntityVillager(World worldIn) {
		super(worldIn);
	}

	@Override
	protected boolean interact(EntityPlayer player) {
		
		if(player.worldObj.isRemote){
			Minecraft.getMinecraft().displayGuiScreen(new GuiVillagerMain());
		}
		
		return super.interact(player);
	}



	
}
