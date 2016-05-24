package ckhbox.villagebox.common.player;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class CapExPlayerPropertiesProvider implements ICapabilitySerializable<NBTTagCompound>{

	private ExtendedPlayerProperties properties;
	
	public CapExPlayerPropertiesProvider(EntityPlayer player){
		properties = new ExtendedPlayerProperties(player);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return (capability == CapExPlayerProperties.EXTENDED_PLAYER_PROPERTIES_CAPABILITY);
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapExPlayerProperties.EXTENDED_PLAYER_PROPERTIES_CAPABILITY) return (T) properties;
		else return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {
		NBTTagCompound tag = new NBTTagCompound();
		properties.saveNBTData(tag);
        return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {
		properties.loadNBTData(nbt);
	}

}
