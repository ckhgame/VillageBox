package com.ckhgame.villagebento.factory;

public abstract class Factory {
	
	protected int productType;
	
	public Factory(int productType){
		 this.productType = productType;
	}
	
	public int getProductType(){
		return this.productType;
	}
	
	public abstract int build();
}
