package ckhbox.villagebento.common.village.attribute;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.util.math.Rand;

public class VillagerAttribute extends Attribute<Integer>{

	private EntityVillager villager;
	private int dataId;
	private int attributeIdx;
	private int iconIdx;
	
	public VillagerAttribute(String unlocalizedName, int iconIdx, EntityVillager villager, int dataId, int attributeIdx) {
		super(unlocalizedName, iconIdx);
		this.villager = villager;
		this.iconIdx = iconIdx;
		this.dataId = dataId;
		this.attributeIdx = attributeIdx;
	}

	public int getIconIdx(){
		return this.iconIdx;
	}
	
	@Override
	public void update() {
		if(!villager.worldObj.isRemote && Rand.get().nextInt(100) == 0){
			this.setValue(this.getValue() + this.getValueGrowing());
		}
	}

	@Override
	public Integer getValue() {
		return villager.getDataWatcher().getWatchableObjectInt(dataId);
	}

	@Override
	public void setValue(Integer value) {
		villager.getDataWatcher().updateObject(dataId, value);
	}

	@Override
	public Integer getValueGrowing() {
		return this.villager.getProfession().getAttributesGrowing()[this.attributeIdx];
	}

	@Override
	public void setValueGrowing(Integer valueGrowing) {		
		//doesn't do anything
	}

}
