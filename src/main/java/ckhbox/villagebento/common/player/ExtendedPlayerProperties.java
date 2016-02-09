package ckhbox.villagebento.common.player;

import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.player.MessageSyncExtendedPlayerProperties;
import ckhbox.villagebento.common.network.message.villager.MessageGuiSetHome;
import ckhbox.villagebento.common.util.math.Rand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties{
	
	private static final String identifier = "villagebento.playerex";
	
	public static final int NewVillagerTimerTotal = 1000;
	
	public static void register(EntityPlayer player){
		if(get(player) == null){
			ExtendedPlayerProperties properties = new ExtendedPlayerProperties(player);
			player.registerExtendedProperties(identifier, properties);
		}
	}
	
	public static ExtendedPlayerProperties get(EntityPlayer player){
		return (ExtendedPlayerProperties)player.getExtendedProperties(identifier);
	}
	
	//-------------------------------------------------
	
	public EntityPlayer player;
	
	public int newVillagerTimer;
	
	private ExtendedPlayerProperties(EntityPlayer player){
		this.player = player;
	}
	
	public void SyncToClient(){
		if(player instanceof EntityPlayerMP){
			ModNetwork.getInstance().sendTo(new MessageSyncExtendedPlayerProperties(this), (EntityPlayerMP)player);
		}
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setInteger("nvtimer", newVillagerTimer);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		newVillagerTimer = compound.getInteger("nvtimer");
	}

	@Override
	public void init(Entity entity, World world) {
		newVillagerTimer = (int)(ExtendedPlayerProperties.NewVillagerTimerTotal * (Rand.get().nextFloat() * 0.3F + 0.7F));
	}
	
}
