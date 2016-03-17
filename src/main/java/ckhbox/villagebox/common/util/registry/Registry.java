package ckhbox.villagebox.common.util.registry;

import java.util.HashMap;

public class Registry <T extends IRegistrable> {
	private HashMap<Integer,T> mapIntData = new HashMap<Integer,T>();
	private HashMap<Class<? extends T>,T> mapClassData = new HashMap<Class<? extends T>,T>();
	
	public void register(int regID, T data ){
		if(mapIntData.containsKey(regID) || mapClassData.containsKey(data.getClass())){
			System.out.println("Can not register the Building, type/class is existed!");
		}
		else{
			mapIntData.put(regID, data);
			mapClassData.put((Class<? extends T>) data.getClass(), data);
			data.setRegID(regID);
		}
	}
	
	public T get(int regID){
		if(mapIntData.containsKey(regID)){
			return mapIntData.get(regID);
		}
		else{
			System.out.println("Can not fint registed item where id =" + regID);
			return null;
		}
	}
	
	public T get(Class<? extends T> c){
		if(mapClassData.containsKey(c)){
			return mapClassData.get(c);
		}
		else{
			System.out.println("Can not fint registed item where class=" + c.getName());
			return null;
		}
	}
}
