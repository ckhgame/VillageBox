package com.ckhgame.villagebento.villagercomponent;

import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBGuard;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.gui.GuiVillagerAbout;
import com.ckhgame.villagebento.profession.Profession;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.util.data.VBResult;
import com.ckhgame.villagebento.util.helper.HelperDataVB;
import com.ckhgame.villagebento.util.helper.HelperPlayer;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class VillagerCompAbout extends VillagerComponent {

	public VillagerCompAbout(EntityVBVillager entityVillager) {
		super(entityVillager,new GuiVillagerAbout());
	}

	private String currentlyDoing = "";
	
	public void freshCurrentlyDoing(){
		
		if(this.getVillager().isVisiting()){
			DataBuilding db = HelperDataVB.findBuildingByID(DataVillageBento.get(),this.getVillager().getVisitingBuildingID());
			if(db != null){
				Building b = Building.registry.get(db.type);
				this.setCurrentlyDoing("Visiting " + b.getName());
				return;
			}
		}
		
		Profession pro = this.getVillager().getProfession();
		if(pro.getTimeSchedule().isSleepTimeNow()){
			this.setCurrentlyDoing("Going to sleep..");
			return;
		}
		
		if(pro.getTimeSchedule().isWorkTimeNow()){
			this.setCurrentlyDoing("Working...");
			return;
		}
		
		if(this.getVillager() instanceof EntityVBGuard){
			this.setCurrentlyDoing("Patrolling...");
			return;
		}
		
		this.setCurrentlyDoing("Relaxing...");
	}
	
	public String getCurrentlyDoing(){
		return this.currentlyDoing;
	}
	
	private void setCurrentlyDoing(String doing){
		this.currentlyDoing = doing;
	}
	
	@Override
	public void syneWrite(ByteBuf buf) {
		freshCurrentlyDoing();
		ByteBufUtils.writeUTF8String(buf, currentlyDoing);
	}

	@Override
	public void syneRead(ByteBuf buf) {
		currentlyDoing = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound) {	
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
	}

	@Override
	public void firstTimeInit() {
		
	}

	@Override
	public void update(int time) {
		
	}

	@Override
	public boolean enabled() {
		//about component should always be enabled...
		return true;
	}
	
	
	//-------------------------------------------------------
	//--------------------Methods----------------------------
	//-------------------------------------------------------
	
	public VBCompResult upgradeLevel(EntityPlayer player){
		
		//get requirements of next level
		ItemStack[] requirements = this.getVillager().getProfession().getNextLevelRequirements(this.getVillager().getLevel());
		if(requirements == null){
			return VBCompResult.getDefaultFailed();
		}
		
		for(ItemStack itemStack : requirements){
			if(!HelperPlayer.playerHasItemStack(player, itemStack))
				return new VBCompResult(VBResult.FAILED_NOITEM, "Can't meet all requirements :(");
		}
		
		for(ItemStack itemStack : requirements){
			HelperPlayer.playerRemoveItemStack(player, itemStack);
		}
		this.getVillager().upgradeLevel();
		
		return new VBCompResult(VBResult.SUCCESS,"Leveling up!!!");
	}
	
	
}
