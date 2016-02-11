package ckhbox.villagebento.common.player;

import ckhbox.villagebento.common.network.ModNetwork;
import ckhbox.villagebento.common.network.message.player.MessageSyncExtendedPlayerProperties;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.util.math.Rand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties{
	
	private static final String identifier = "villagebento.playerex";
	
	public static final int NewMailTimerTotal = 16000;
	
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
	
	public int newMailTimer;//how much time left to receive a new mail
	public int mailCount;//how many mails the player has
	public int treasureHuntLevel;//high level will bring more gems
	
	public void resetMailTimer(){
		this.newMailTimer = (int)(ExtendedPlayerProperties.NewMailTimerTotal * (Rand.get().nextFloat() * 0.3F + 0.7F));
	}
	
	public boolean upgradeTreasureHuntLevelTo(int level){
		if(level > treasureHuntLevel){
			treasureHuntLevel = level;
			return true;
		}
		else{
			return false;
		}
	}
	
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
		compound.setInteger("nmtimer", this.newMailTimer);
		compound.setInteger("mailcount", this.mailCount);
		compound.setInteger("treasurelvl", this.treasureHuntLevel);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		this.newMailTimer = compound.getInteger("nmtimer");
		this.mailCount = compound.getInteger("mailcount");
		this.treasureHuntLevel = compound.getInteger("treasurelvl");
	}

	@Override
	public void init(Entity entity, World world) {
		this.resetMailTimer();
		this.mailCount = 0;
		this.treasureHuntLevel = 0;
	}
	
}
