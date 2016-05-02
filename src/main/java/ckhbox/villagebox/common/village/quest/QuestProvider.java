package ckhbox.villagebox.common.village.quest;

import java.util.ArrayList;
import java.util.List;

import ckhbox.villagebox.common.util.math.Rand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

public class QuestProvider {
	
	private int current = -1;
	private List<Quest> pool = new ArrayList<Quest>();
	
	public void addQuestToPool(Quest quest){
		this.pool.add(quest);
	}
	
	public void createCurrentQuest(){
		this.current = pool.size() > 0?Rand.get().nextInt(pool.size()):-1;
	}
	
	public Quest getCurrentQuest(){
		if(this.current < 0 || this.current >= this.pool.size())
			return null;
		return this.pool.get(this.current);
	}
	
	public void removeCurrentQuest(){
		this.current = -1;
	}
	
	public void completeCurrentQuest(EntityPlayer player){
		Quest q = this.getCurrentQuest();
		if(q != null && q.complete(player)){
			this.removeCurrentQuest();
		}
	}
	
	public void wirteToNBT(NBTTagCompound nbt){
		nbt.setInteger("currentquest", this.current);
	}
	
	public void readFromNBT(NBTTagCompound nbt){
		this.current = nbt.getInteger("currentquest");
	}
}
