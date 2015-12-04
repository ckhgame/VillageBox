package com.ckhgame.villagebento.util.data;

import java.util.ArrayList;
import java.util.Random;

import com.ckhgame.villagebento.util.village.VBDataTime;

public class VillagerSchedule {
	private Hour24[][] worktimes = new Hour24[7][];
	private Hour24[] sleeptime;
	
	//works
	public void setWorkTime(int dayOfWeek, Hour24[] ranges){
		if(dayOfWeek >= 0 || dayOfWeek < 7){
			worktimes[dayOfWeek] = ranges;
		}
	}
	
	public void setWorkTime(int dayOfWeek, int[] arr){
		if(arr == null || arr.length == 0 || arr.length % 2 == 1){
			System.out.println("unvalid work time int array");
			return;
		}
		
		Hour24[] ranges = new Hour24[arr.length / 2];
		for(int i=0;i<ranges.length;i++){
			ranges[i] = new Hour24(arr[i * 2],arr[i * 2 + 1]);
		}
		
		this.setWorkTime(dayOfWeek, ranges);
	}
	
	//sleeping
	public void setSleeptime(Hour24[] ranges){
		sleeptime = ranges;
	}
	
	public void setSleeptime(int[] arr){
		if(arr == null || arr.length == 0 || arr.length % 2 == 1){
			System.out.println("unvalid work time int array");
			return;
		}
		
		Hour24[] ranges = new Hour24[arr.length / 2];
		for(int i=0;i<ranges.length;i++){
			ranges[i] = new Hour24(arr[i * 2],arr[i * 2 + 1]);
		}
		
		setSleeptime(ranges);
	}
	
	//-------
	
	public boolean isWorkTimeNow(){
		int h = VBDataTime.getHourOfDay();
		Hour24[] ranges = worktimes[VBDataTime.getDayInWeek()];
		if(ranges != null){
			for(Hour24 range : ranges){
				if(range.inRange(h)){
					return true;
				}
			}
		}
		return false;
	}
	public boolean isSleepTimeNow(){
		int h = VBDataTime.getHourOfDay();
		if(sleeptime != null){
			for(Hour24 range : sleeptime){
				if(range.inRange(h)){
					return true;
				}
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
	
	private String getRangeText(Hour24[] ranges){
		if(ranges == null)
			return "---";
		String text = "";
		for(int i =0;i<ranges.length;i++){
			text += getHour24Text(ranges[i].from) + " - "  + getHour24Text(ranges[i].to) + (i < ranges.length - 1?", ":"");
		}
		return text;
	}
	
	private String getHour24Text(int hour){
		int h = hour % 12;
		if(h == 0) h = 12;
		return h + (hour < 12?" am":" pm");
	}
}
