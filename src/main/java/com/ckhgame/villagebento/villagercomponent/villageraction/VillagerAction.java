package com.ckhgame.villagebento.villagercomponent.villageraction;

import java.util.Arrays;

import com.ckhgame.villagebento.entity.villager.EntityVBVillager;
import com.ckhgame.villagebento.util.data.VBCompResult;
import com.ckhgame.villagebento.villagercomponent.VillagerCompAction;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;

/**
 * only a int argument and a string argument are provided
 */
public abstract class VillagerAction {
	
	public VillagerAction(String text, String info, int minLevel, Object[] vaParams){
		this.text = text;
		this.info = info;
		this.minLevel = minLevel;
		this.vaParams = vaParams;
	}
	
	public String text;
	public String info;
	public Object[] vaParams;
	public int minLevel;
	
	protected static final String SepMark = ";";
	protected static String format(String unlocalized, String...params){
		String format = unlocalized;
		if(params != null){
			for(String param : params){
				format += SepMark + param;
			}
		}
		return format;
	}
	
	public static String translateFormatted(String format){
		String[] texts = format.split(SepMark);
		if(texts.length == 1){
			return StatCollector.translateToLocal(texts[0]);
		}
		else{
			return String.format(StatCollector.translateToLocal(texts[0]), (Object[])Arrays.copyOfRange(texts, 1, texts.length));
		}
	}
	
	public abstract VBCompResult doAction(EntityPlayer player, EntityVBVillager villager, VillagerCompAction component, Object[] vaParams);
}
