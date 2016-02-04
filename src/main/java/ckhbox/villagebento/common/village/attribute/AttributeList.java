package ckhbox.villagebento.common.village.attribute;

import java.util.ArrayList;

public class AttributeList extends ArrayList<Attribute>{
	public void update(){
		for(Attribute attribute : this){
			attribute.update();
		}
	}
}
