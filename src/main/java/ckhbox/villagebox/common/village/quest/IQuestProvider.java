package ckhbox.villagebox.common.village.quest;

import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.entity.player.EntityPlayer;

public interface IQuestProvider {
	
	void createNewQuest();
	
	Quest getCurrentQuest();
	
	void removeCurrentQuest();
	
	void completeCurrentQuest(EntityPlayer player);
}
