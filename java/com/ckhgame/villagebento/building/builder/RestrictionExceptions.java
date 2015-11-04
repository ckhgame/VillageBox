package com.ckhgame.villagebento.building.builder;

import java.util.ArrayList;

public class RestrictionExceptions {
	private static ArrayList<Integer> exceptionBuildingIDs = new ArrayList<Integer>();
	public static void setBuildingException(int buildingID){
		if(!hasBuildingException(buildingID))
			exceptionBuildingIDs.add(buildingID);
	}
	public static void unsetBuildingException(int buildingID){
		for(int i =0;i<exceptionBuildingIDs.size();i++){
			if(exceptionBuildingIDs.get(i) == buildingID){
				exceptionBuildingIDs.remove(i);
			}
		}
	}
	public static boolean hasBuildingException(int buildingID){
		for(int i =0;i<exceptionBuildingIDs.size();i++){
			if(exceptionBuildingIDs.get(i) == buildingID){
				return true;
			}
		}
		return false;
	}
}
