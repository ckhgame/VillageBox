package ckhbox.villagebento.common.village.attribute;

import net.minecraft.util.StatCollector;

public abstract class Attribute<T> {
	private String unlocalizedName;
	private int iconIdx;
	
	public Attribute(String unlocalizedName, int iconIdx){
		this.unlocalizedName = unlocalizedName;
		this.iconIdx = iconIdx;
	}
	
	public String getDisplayName(){
		return StatCollector.translateToLocal(unlocalizedName);
	}
	
	public abstract T getValue();
	
	public abstract void setValue(T value);
	
	public abstract T getMaxValue();
	
	public abstract void setMaxValue(T maxValue);
	
	public abstract T getValueGrowing();
	
	public abstract void setValueGrowing(T valueGrowing);
	
	public abstract void update();
	
	
}
