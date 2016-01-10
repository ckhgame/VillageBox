package com.ckhgame.villagebento.villagercomponent;

import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.entity.villager.EntityVBGuard;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
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
import net.minecraft.util.StatCollector;

public class VillagerCompAbout extends VillagerComponent {

	public VillagerCompAbout(EntityVBVillager entityVillager) {
		super(entityVillager);
	}

	
	
	@Override
	public void syneWrite(ByteBuf buf) {
	}

	@Override
	public void syneRead(ByteBuf buf) {
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
				return new VBCompResult(VBResult.FAILED_NOITEM,"vcomp.about.noitem");
		}
		
		for(ItemStack itemStack : requirements){
			HelperPlayer.playerRemoveItemStack(player, itemStack);
		}
		this.getVillager().upgradeLevel();
		
		return new VBCompResult(VBResult.SUCCESS,"vcomp.about.success");
	}
	
	
}
