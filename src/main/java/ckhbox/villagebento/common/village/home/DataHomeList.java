package ckhbox.villagebento.common.village.home;

import java.util.ArrayList;

import ckhbox.villagebento.common.util.math.IntBoundary;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class DataHomeList extends WorldSavedData{

	private static final String key = "villagebento.homelist";
	private static DataHomeList data = null;
	public static DataHomeList get(World world){
		//only for server
		if(world.isRemote)
			return null;
		
		if(data == null){
			data = (DataHomeList)world.getPerWorldStorage().loadData(DataHomeList.class, key);
			if(data == null){
				//first time creating...
				data = new DataHomeList(key);
				world.getPerWorldStorage().setData(key, data);
			}
		}
		
		return data;
	}
	
	//----------------------------
	
	private ArrayList<IntBoundary> homeList = new ArrayList<IntBoundary>();
	
	public DataHomeList(String name) {
		super(name);
	}

	public boolean remove(IntBoundary bound){
		if(bound == null)
			return false;
		
		for(int i =0;i<homeList.size();i++){
			if(homeList.get(i).equalTo(bound)){
				homeList.remove(i);
				this.markDirty();
				return true;
			}
		}
		return false;
	}
	
	public boolean add(IntBoundary bound){
		if(bound == null)
			return false;
		
		for(int i =0;i<homeList.size();i++){
			if(homeList.get(i).contact(bound)){
				return false;
			}
		}
		homeList.add(bound);
		this.markDirty();
		return true;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		int[] dataArr = nbt.getIntArray("homelist");
		if(dataArr != null && dataArr.length > 0){
			homeList.clear();
			int size = dataArr.length / 6;
			int start;
			for(int i =0;i<size;i++){
				start = i * 6;
				homeList.add(new IntBoundary(
						dataArr[start + 0],
						dataArr[start + 1],
						dataArr[start + 2],
						dataArr[start + 3],
						dataArr[start + 4],
						dataArr[start + 5]
						));
			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		
		if(homeList.size() > 0){
			int[] dataArr = new int[homeList.size() * 6];
			int start;
			IntBoundary current;
			for(int i = 0;i<homeList.size();i++){
				start = i * 6;
				current = homeList.get(i);
				dataArr[start + 0] = current.minx;
				dataArr[start + 1] = current.miny;
				dataArr[start + 2] = current.minz;
				dataArr[start + 3] = current.maxx;
				dataArr[start + 4] = current.maxy;
				dataArr[start + 5] = current.maxz;
			}
			nbt.setIntArray("homelist", dataArr);
		}
		else{
			nbt.removeTag(key);
		}
		
	}

}
