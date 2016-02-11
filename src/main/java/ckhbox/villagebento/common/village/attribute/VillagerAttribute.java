package ckhbox.villagebento.common.village.attribute;

import ckhbox.villagebento.common.entity.villager.EntityVillager;
import ckhbox.villagebento.common.util.math.Rand;

public class VillagerAttribute extends Attribute<Integer>{

	private EntityVillager villager;
	private int dataId;
	private int attributeIdx;
	private int iconIdx;
	private int maxValue;
	private int valueGrowing;
	
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
		if(!villager.worldObj.isRemote && Rand.get().nextInt(1000) == 0){
			this.setValue(this.getValue() + this.getValueGrowing());
		}
	}

	@Override
	public Integer getValue() {
		return villager.getDataWatcher().getWatchableObjectInt(dataId);
	}

	@Override
	public void setValue(Integer value) {
		villager.getDataWatcher().updateObject(dataId, Math.min(value,this.getMaxValue()));
	}

	@Override
	public Integer getValueGrowing() {
		return this.valueGrowing;
	}

	@Override
	public void setValueGrowing(Integer valueGrowing) {		
		this.valueGrowing = valueGrowing;
	}

	@Override
	public Integer getMaxValue() {
		return this.maxValue;
	}

	@Override
	public void setMaxValue(Integer maxValue) {
		this.maxValue = maxValue;
		if(this.getValue() > this.maxValue){
			this.setValue(this.maxValue);
		}
	}

}
