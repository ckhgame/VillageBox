package ckhbox.villagebento.common.entity.villager;

import ckhbox.villagebento.VillageBentoMod;
import ckhbox.villagebento.client.gui.villager.GuiVillagerMain;
import ckhbox.villagebento.common.gui.GuiIDs;
import ckhbox.villagebento.common.util.helper.PathHelper;
import ckhbox.villagebento.common.village.attribute.VillagerAttribute;
import ckhbox.villagebento.common.village.attribute.AttributeList;
import ckhbox.villagebento.common.village.profession.ProVillager;
import ckhbox.villagebento.common.village.profession.Profession;
import ckhbox.villagebento.common.village.trading.ITrading;
import ckhbox.villagebento.common.village.trading.TradingRecipe;
import ckhbox.villagebento.common.village.trading.TradingRecipeList;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class EntityVillager extends EntityCreature implements ITrading{

	private Profession profession;
	private AttributeList attributeList;
	private String name;
	
	public EntityVillager(World worldIn) {
		super(worldIn);		
		this.attributeList = new AttributeList();
		this.attributeList.add(new VillagerAttribute(PathHelper.full("villager.attribute.strength"),0,this,17,0));
		this.attributeList.add(new VillagerAttribute(PathHelper.full("villager.attribute.intelligence"),1,this,18,1));
		this.attributeList.add(new VillagerAttribute(PathHelper.full("villager.attribute.crafting"),2,this,19,2));
		
		this.refreshProfession();
		
		//temp
		this.name = "TOM";
	}

	@Override
	protected void entityInit() {
		super.entityInit();
		//profession id
		this.getDataWatcher().addObject(16, 0);
		//attributes
		this.getDataWatcher().addObject(17, 0);
		this.getDataWatcher().addObject(18, 0);
		this.getDataWatcher().addObject(19, 0);
	}

	@Override
	protected boolean interact(EntityPlayer player) {
		
		if(player.worldObj.isRemote){
			FMLCommonHandler.instance().showGuiScreen(new GuiVillagerMain(player, this));
		}
		
		return super.interact(player);
	}

	@Override
	public TradingRecipeList getTradingRecipeList() {
		return this.profession.getTradingRecipeList();
	}
	
	public Profession getProfession(){
		if(this.worldObj.isRemote && (this.profession == null || this.getDataWatcher().getWatchableObjectInt(16) != this.profession.getRegID())){
			this.profession = Profession.registry.get(this.getDataWatcher().getWatchableObjectInt(16));
		}
		return this.profession;
	}
	
	public void setProfession(int proid){
		this.getDataWatcher().updateObject(16, proid);
		this.profession = Profession.registry.get(proid);
	}
	
	public AttributeList getAttributes(){
		return this.attributeList;
	}

	public String getName(){
		return this.name;
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		//update profession
		if(this.worldObj.isRemote && (this.profession == null || this.getDataWatcher().getWatchableObjectInt(16) != this.profession.getRegID())){
			this.profession = Profession.registry.get(this.getDataWatcher().getWatchableObjectInt(16));
		}
		//update attributes
		this.attributeList.update();
	}

	public void refreshProfession(){
		int proid = this.getDataWatcher().getWatchableObjectInt(16);
		this.profession = Profession.registry.get(proid);
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setInteger("proid", this.getDataWatcher().getWatchableObjectInt(16));
		tagCompound.setInteger("attr_str", (Integer)this.attributeList.get(0).getValue());
		tagCompound.setInteger("attr_int", (Integer)this.attributeList.get(1).getValue());
		tagCompound.setInteger("attr_cra", (Integer)this.attributeList.get(2).getValue());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		int proID = tagCompund.getInteger("proid");
		this.getDataWatcher().updateObject(16, proID);
		refreshProfession();
		this.attributeList.get(0).setValue(tagCompund.getInteger("attr_str"));
		this.attributeList.get(1).setValue(tagCompund.getInteger("attr_int"));
		this.attributeList.get(2).setValue(tagCompund.getInteger("attr_cra"));
	}
	
	



	
}
