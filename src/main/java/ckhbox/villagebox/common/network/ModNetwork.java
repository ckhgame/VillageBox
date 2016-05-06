package ckhbox.villagebox.common.network;

import ckhbox.villagebox.common.network.message.common.MessageGuiSelectTradeRecipeIndex;
import ckhbox.villagebox.common.network.message.player.MessageSyncCollections;
import ckhbox.villagebox.common.network.message.player.MessageSyncExtendedPlayerProperties;
import ckhbox.villagebox.common.network.message.villager.MessageGuiCompleteQuest;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSelectUpgradeOptionIndex;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSetFollowing;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSetHome;
import ckhbox.villagebox.common.network.message.villager.MessageGuiSetInteracting;
import ckhbox.villagebox.common.network.message.villager.MessageGuiVillagerOpen;
import ckhbox.villagebox.common.network.message.villager.MessageGuiVillagerUpgrade;
import ckhbox.villagebox.common.network.message.villager.MessageSpawnNewVillagerThroughMail;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class ModNetwork {
	
	//singleton
	private static SimpleNetworkWrapper instance;
	public static SimpleNetworkWrapper getInstance(){
		return instance;
	}
	
	public static void init(){
		instance = NetworkRegistry.INSTANCE.newSimpleChannel("netvlgbto");
		initMessages();
	}
	
	private static void initMessages(){
		int id = 0;
		instance.registerMessage(MessageGuiVillagerOpen.Handler.class, MessageGuiVillagerOpen.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiSelectTradeRecipeIndex.Handler.class, MessageGuiSelectTradeRecipeIndex.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiSelectUpgradeOptionIndex.Handler.class, MessageGuiSelectUpgradeOptionIndex.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiVillagerUpgrade.Handler.class, MessageGuiVillagerUpgrade.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiSetInteracting.Handler.class, MessageGuiSetInteracting.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiSetFollowing.Handler.class, MessageGuiSetFollowing.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiSetHome.Handler.class, MessageGuiSetHome.class, id++, Side.SERVER);
		instance.registerMessage(MessageSpawnNewVillagerThroughMail.Handler.class, MessageSpawnNewVillagerThroughMail.class, id++, Side.SERVER);
		instance.registerMessage(MessageGuiCompleteQuest.Handler.class, MessageGuiCompleteQuest.class, id++, Side.SERVER);
		
		id = 100;
		instance.registerMessage(MessageSyncCollections.Handler.class, MessageSyncCollections.class, id++, Side.CLIENT);
		//instance.registerMessage(MessageSyncExtendedPlayerProperties.Handler.class, MessageSyncExtendedPlayerProperties.class, id++, Side.CLIENT);
	}
}
