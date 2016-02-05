package ckhbox.villagebento.common.gui;

import ckhbox.villagebento.client.gui.villager.GuiVillagerMain;
import ckhbox.villagebento.client.gui.villager.GuiVillagerStatus;
import ckhbox.villagebento.client.gui.villager.GuiVillagerTrading;
import ckhbox.villagebento.client.gui.villager.GuiVillagerUpgrading;
import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.gui.common.ContainerTrading;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerMain;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerStatus;
import ckhbox.villagebento.common.gui.villager.ContainerVillagerUpgrading;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		//villager gui
		if(ID >= 100 && ID <200){
			int dimension = x;
			int entityID = y;
			if(world.provider.getDimensionId() == dimension){
				EntityVillager villager = (EntityVillager)world.getEntityByID(entityID);
				if(villager != null){
					switch(ID){
					case GuiIDs.VillagerMain: return new ContainerVillagerMain();
					case GuiIDs.VillagerStatus: return new ContainerVillagerStatus();
					case GuiIDs.VillagerTrading: return new ContainerTrading(player.inventory, villager ,world);
					case GuiIDs.VillagerUpgrading: return new ContainerVillagerUpgrading(player.inventory, villager ,world);
					default:break;
					}
				}
			}	
			
		}
		
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		//villager gui
		if(ID >= 100 && ID <200){
			int dimension = x;
			int entityID = y;
			if(world.provider.getDimensionId() == dimension){
				EntityVillager villager = (EntityVillager)world.getEntityByID(entityID);
				if(villager != null){
					switch(ID){
					case GuiIDs.VillagerMain: return new GuiVillagerMain(player, villager);
					case GuiIDs.VillagerStatus: return new GuiVillagerStatus(player, villager);
					case GuiIDs.VillagerTrading: return new GuiVillagerTrading(player.inventory, villager ,world);
					case GuiIDs.VillagerUpgrading: return new GuiVillagerUpgrading(player.inventory, villager ,world);
					default:break;
					}
				}
			}	
			
		}
		
		return null;
	}

}
