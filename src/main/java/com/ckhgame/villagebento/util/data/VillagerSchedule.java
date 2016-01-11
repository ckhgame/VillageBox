package com.ckhgame.villagebento.util.data;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.util.village.VBDateTime;

public class VillagerSchedule {
	
	public static final int No= 0;
	public static final int YesYesterday = 1;
	public static final int YesToday = 2;
	
	private RangeInt[] worktimes = new RangeInt[7];
	private RangeInt sleeptime;
	
	//works
	public void setWorkTime(int dayOfWeek, RangeInt range){
		if(dayOfWeek >= 0 || dayOfWeek < 7){
			worktimes[dayOfWeek] = range;
		}
	}
	
	//sleeping
	public void setSleeptime(RangeInt range){
		sleeptime = range;
	}
	
	//-------
	
	public boolean isWorkTimeNow(){
		return (isWorkTimeNowResult() != No);
	}
	
	public int isWorkTimeNowResult(){
		int h = VBDateTime.getHourOfDay();
		int day = VBDateTime.getDayInWeek();
		int prev = day > 0?day - 1:6;
		
		//check yesterday
		RangeInt prevRange = worktimes[prev];
		if(prevRange != null && prevRange.to >= 24 && h <  prevRange.to % 24){
			return YesYesterday;
		}
		
		RangeInt todayRange = worktimes[day];
		if(todayRange != null && todayRange.inRange(h)){
			return YesToday;
		}
		
		return No;
	}
	public boolean isSleepTimeNow(){
		int h = VBDateTime.getHourOfDay();
		if(sleeptime != null){
			if(sleeptime.inRange(h)){
				return true;
			}
			else if(sleeptime.to >= 24 && h < sleeptime.to % 24){
				return true;
			}
		}
		return false;
	}
	
	//----- text
	
	public String[] getWorkTimeText(){
		String[] arr = new String[7];
		for(int i =0;i<7;i++){
			arr[i] = getRangeText(worktimes[i]);
		}
		
		return arr;
	}
	
	public String getSleepTimetext(){
		return "Sleep " + getRangeText(sleeptime);
	}
	
	private String getRangeText(RangeInt range){
		if(range == null){
			return "---";
		}
		else{
			return getHourText(range.from) + " - "  + getHourText(range.to % 24) ;
		}
	}
	
	private String getHourText(int hour){
		int h = hour % 12;
		if(h == 0) h = 12;
		return h + (hour < 12?" am":" pm");
	}
}
