package com.ckhgame.villagebento.factory;

import java.util.HashMap;

public class FactoryRegistry<FactoryClass extends Factory>{
	
	private HashMap<Integer,FactoryClass> mapFactiory = new HashMap<Integer,FactoryClass>();
	
	public void register(FactoryClass factory){
		int pt = factory.getProductType();
		if(this.mapFactiory.containsKey(pt)){
			System.out.println("Can not add " + factory + ", because the factory type is already existed");
		}
		else{
			this.mapFactiory.put(pt, factory);
		}
	}
}
