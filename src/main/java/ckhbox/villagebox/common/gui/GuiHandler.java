package ckhbox.villagebox.common.gui;

import ckhbox.villagebox.client.gui.mail.GuiMail;
import ckhbox.villagebox.client.gui.villagebook.GuiVillageBook;
import ckhbox.villagebox.client.gui.villager.GuiVillagerMain;
import ckhbox.villagebox.client.gui.villager.GuiVillagerQuest;
import ckhbox.villagebox.client.gui.villager.GuiVillagerTrading;
import ckhbox.villagebox.client.gui.villager.GuiVillagerUpgrading;
import ckhbox.villagebox.common.entity.villager.EntityVillager;
import ckhbox.villagebox.common.gui.common.ContainerEmpty;
import ckhbox.villagebox.common.gui.common.ContainerTrading;
import ckhbox.villagebox.common.gui.villager.ContainerVillagerMain;
import ckhbox.villagebox.common.gui.villager.ContainerVillagerUpgrading;
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
					case GuiIDs.VillagerTrading: return new ContainerTrading(player.inventory, villager ,world);
					case GuiIDs.VillagerUpgrading: return new ContainerVillagerUpgrading(player.inventory, villager ,world);
					case GuiIDs.VillagerQuest: return new ContainerEmpty();
					default:break;
					}
				}
			}				
		}
		else{
			switch(ID){
			case GuiIDs.Mail: return new ContainerEmpty();
			case GuiIDs.VillageBook: return new ContainerEmpty();
			default:break;
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
					case GuiIDs.VillagerTrading: return new GuiVillagerTrading(player.inventory, villager ,world);
					case GuiIDs.VillagerUpgrading: return new GuiVillagerUpgrading(player.inventory, villager ,world);
					case GuiIDs.VillagerQuest: return new GuiVillagerQuest(player,villager);
					default:break;
					}
				}
			}		
		}
		else{
			switch(ID){
			case GuiIDs.Mail: return new GuiMail(player);
			case GuiIDs.VillageBook: return new GuiVillageBook();
			default:break;
			}
		}
		
		return null;
	}

}
