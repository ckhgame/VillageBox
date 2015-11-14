package com.ckhgame.villagebento.villager;

import java.util.ArrayList;
import java.util.HashMap;

import com.ckhgame.villagebento.Main;
import com.ckhgame.villagebento.building.Building;
import com.ckhgame.villagebento.building.builder.BuildingBuilder;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.DataVillager;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.registry.IRegistrable;
import com.ckhgame.villagebento.util.registry.Registry;
import com.ckhgame.villagebento.villager.chat.VillagerChat;
import com.ckhgame.villagebento.villager.component.VillagerComponent;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract class Villager implements IRegistrable {
	
	private int profession;
	public int getProfession(){
		return profession;
	}
	
	public int getRegID() {
		// TODO Auto-generated method stub
		return profession;
	}

	public void setRegID(int regID) {
		profession = regID;
	}
	
	//components
	private ArrayList<VillagerComponent> components = new ArrayList<VillagerComponent>();
	
	public ArrayList<VillagerComponent> getVillagerComponents(){
		return this.components;
	}
	
	public VillagerComponent findVillagerComponentByClass(Class<? extends VillagerComponent> vcc){
		for(VillagerComponent c : this.components){
			if(c.getClass() == vcc)
				return c;
		}
		return null;
	}
	
	//skin
	private ResourceLocation skinTexture;
	private void setSkin(String skin){
		skinTexture = new ResourceLocation(Main.MODID + ":" + "textures/entity/villager/"+skin+".png");
	}
	public ResourceLocation getSkin(){
		return skinTexture;
	}
	
	
	//level & exp
	protected int expBase;
	protected int expE;
	
	protected void setExpBase(){
		expBase = 10;
		expE = 2;
	}
	
	public int getNextLevelExp(int currentLevel){
		return (int)(expBase * Math.pow(expE, currentLevel));
	}
	
	//villager chat
	private VillagerChat villagerChat = new VillagerChat();
	public VillagerChat getVillagerChat(){
		return villagerChat;
	}
	
	public abstract String getProfessionName();
	public abstract String getProfessionDescription();
	public abstract String getSkinName();
	public abstract boolean canSpawn();
	protected abstract void createComponents(ArrayList<VillagerComponent> components);
	protected abstract void initVillagerChat(VillagerChat villagerChat);
	
	public Villager(){
		initVillagerChat(villagerChat);
		setExpBase();
		setSkin(this.getSkinName());
		createComponents(components);
	}
	
	
	//---------------------------------
	public static Registry<Villager> registry = new Registry<Villager>();
				
	/**
	 * spawn villager and create villager data
	 */
	public static boolean spawn(World w,int x, int y,int z, Class<? extends Villager> c,String name, int buildingID){
				
		Villager v = registry.get(c);

		if(v != null && v.canSpawn()){
			//generate villager data
			DataVillager dv = HelperDataVB.createDataVillager(v.profession, name, buildingID,x,z);
			if(HelperDataVB.addVillagerData(DataVillageBento.get(w), dv)){
				return spawn(w,x,y,z,dv,v);
			}
		}
		
		return false;
	}
	
	/**
	 * spawn villager with an existed villager data
	 */
	public static boolean spawn(World w,int x, int y,int z,DataVillager dv){
		
		Villager v = registry.get(dv.profession);

		if(v != null && v.canSpawn()){
			return spawn(w,x,y,z,dv,v);
		}
		
		return false;
	}

	/**
	 * the real spawn function
	 */
	private static boolean spawn(World w,int x, int y,int z,DataVillager dv, Villager v){
		
		//create entity
		EntityVBVillager entityvbvillager = new EntityVBVillager(w);	
		entityvbvillager.dataVillagerID = dv.id;
		entityvbvillager.setLocationAndAngles((double)x + 0.5,(double)y + 0.1,(double)z + 0.5, 0.0F, 0.0F);
		
		//add to world
        return w.spawnEntityInWorld(entityvbvillager);
	}
}


