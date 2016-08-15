package ckhbox.villagebox.common.player;

import java.util.concurrent.Callable;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public class CapExPlayerProperties {
	@CapabilityInject(ExtendedPlayerProperties.class)
    public static Capability<ExtendedPlayerProperties> EXTENDED_PLAYER_PROPERTIES_CAPABILITY = null;
	
	public static void register(){
		CapabilityManager.INSTANCE.register(ExtendedPlayerProperties.class, new Capability.IStorage<ExtendedPlayerProperties>()
        {
            @Override
            public NBTBase writeNBT(Capability<ExtendedPlayerProperties> capability, ExtendedPlayerProperties instance, EnumFacing side)
            {
            	return null;
            }

            @Override
            public void readNBT(Capability<ExtendedPlayerProperties> capability, ExtendedPlayerProperties instance, EnumFacing side, NBTBase base)
            {
            }
        }, new Callable<ExtendedPlayerProperties>()
        {
            @Override
            public ExtendedPlayerProperties call() throws Exception
            {
                return null;
            }
        });
	}
}
