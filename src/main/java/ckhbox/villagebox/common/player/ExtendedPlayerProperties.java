package ckhbox.villagebox.common.player;

import ckhbox.villagebox.common.network.ModNetwork;
import ckhbox.villagebox.common.network.message.player.MessageSyncExtendedPlayerProperties;
import ckhbox.villagebox.common.util.helper.PathHelper;
import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayerProperties implements IExtendedEntityProperties{
	
	private static final String identifier = "villagebox.playerex";
	
	public static final int NewMailTimerTotal = 2000;
	
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
	
	public boolean hasSentInvitation;//if the player has sent the invivation
	public int newMailTimer;//how much time left to receive a new mail

	public int treasureHuntLevel;//high level will bring more gems
	
	public boolean receivedGuidebook = false; // if the player has recived the guidebook
	
	public void sendNewVillagerInvitation(){
		if(!this.hasSentInvitation){
			this.hasSentInvitation = true;
			this.resetMailTimer();
		}
	}
	
	public boolean hasNewVillagerMail(){
		return this.hasSentInvitation && this.newMailTimer <= 0;
	}
	
	public void receiveNewVillagerMail(){
		this.hasSentInvitation = false;
	}
	
	public void resetMailTimer(){
		this.newMailTimer = (int)(ExtendedPlayerProperties.NewMailTimerTotal * (Rand.get().nextFloat() * 0.5F + 0.5F));
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
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		compound.setBoolean("invited", this.hasSentInvitation);
		compound.setInteger("nmtimer", this.newMailTimer);
		compound.setInteger("treasurelvl", this.treasureHuntLevel);
		compound.setBoolean("receiveddgb", this.receivedGuidebook);
	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		this.hasSentInvitation = compound.getBoolean("invited");
		this.newMailTimer = compound.getInteger("nmtimer");
		this.treasureHuntLevel = compound.getInteger("treasurelvl");
		this.receivedGuidebook = compound.getBoolean("receiveddgb");
	}

	@Override
	public void init(Entity entity, World world) {
		this.resetMailTimer();
		this.hasSentInvitation = false;
		this.treasureHuntLevel = 0;
	}
	
}
