package com.ckhgame.villagebento.data_old;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class VillageBentoData extends WorldSavedData{
	
	public int testInfo = 0;
	public ArrayList<BuildingData> buildings = new ArrayList<BuildingData>();
	public AxisAlignedBB villageBoundary;
	
	public VillageBentoData(String tagName) {
		super(tagName);
		// TODO Auto-generated constructor stub
	}
	
	public boolean addBuildingData(BuildingData db){
		//if the village has already existed, the player can not put the next building very far from the original village (should be in the village boundary)
		if(buildings.size() > 0 && !villageBoundary.isVecInside(Vec3.createVectorHelper(db.x, db.y, db.z))){
			return false;
		}
		
		//make sure the new building will not overlap on the existed buildings.
		//in addition, there must be a 1 tile gap between two buildings
		int gap = 1;
		for(BuildingData bdexisted:this.buildings){
			if(db.x + db.sizeX < bdexisted.x - bdexisted.sizeX - gap||
			   db.x - db.sizeX > bdexisted.x + bdexisted.sizeX + gap||
			   db.z + db.sizeZ < bdexisted.z - bdexisted.sizeZ - gap||
			   db.z - db.sizeZ > bdexisted.z + bdexisted.sizeZ + gap){
				continue;
			}
			else{
				return false;
			}
		}
		
		buildings.add(db);
		refreshVillageBoundary();
		return true;
	}
	
	public void refreshVillageBoundary(){
		
		villageBoundary = null;
		
		if(buildings.size() > 0){
			int minx,miny,minz,maxx,maxy,maxz;
			minx = miny = minz = Integer.MAX_VALUE;
			maxx = maxy = maxz = Integer.MIN_VALUE;
			int d;
			for(BuildingData bd:this.buildings){
				d = bd.x - bd.sizeX;		if(d < minx) minx = d;
				d = bd.x + bd.sizeX + 1;	if(d > maxx) maxx = d;
				d = bd.z - bd.sizeZ;		if(d < minz) minz = d;
				d = bd.z + bd.sizeZ + 1;	if(d > maxz) maxz = d;
				d = bd.y;					if(d < miny) miny = d;
				d = bd.y;					if(d > maxy) maxy = d;
			}
			villageBoundary = AxisAlignedBB.getBoundingBox(minx, miny, minz, maxx, maxy, maxz);
			
			//expand boundary to have space for new buildings
			villageBoundary = villageBoundary.expand(10, 3, 10);
		}
	}
	
	public BuildingData findBuildingData(int x, int y, int z){
		if(villageBoundary == null || !villageBoundary.isVecInside(Vec3.createVectorHelper(x,y,z)))
			return null;
		
		for(BuildingData bd:this.buildings){
			if(x < bd.x - bd.sizeX || x > bd.x + bd.sizeX ||
			   z < bd.z - bd.sizeZ || z > bd.z + bd.sizeZ ){
				continue;
			}
			else{
				return bd;
			}
		}
		
		return null;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		if(compound.hasKey("TestInfo"))
			this.testInfo = compound.getInteger("TestInfo");
		
		//load buildings
		int[] buildingDataArray = compound.getIntArray("BuildingData");
		int bdNum = buildingDataArray.length / 6;
		this.buildings.clear();
		for(int i = 0;i<bdNum;i++){
			this.buildings.add(new BuildingData(
					buildingDataArray[i * 6 + 0],	//x
					buildingDataArray[i * 6 + 1],	//z
					buildingDataArray[i * 6 + 2],	//sizeX
					buildingDataArray[i * 6 + 3],	//sizeZ
					buildingDataArray[i * 6 + 4],	//y
					buildingDataArray[i * 6 + 5]	//type
					));
		}
		refreshVillageBoundary(); // refesh boundary after loading buildings
	}

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		compound.setInteger("TestInfo", this.testInfo);
		
		//save buildings
		int[] buildingDataArray = new int[this.buildings.size()*6];
		int bdIterator = 0;
		for(BuildingData bd:this.buildings){
			buildingDataArray[bdIterator++] = bd.x;
			buildingDataArray[bdIterator++] = bd.z;
			buildingDataArray[bdIterator++] = bd.sizeX;
			buildingDataArray[bdIterator++] = bd.sizeZ;
			buildingDataArray[bdIterator++] = bd.y;
			buildingDataArray[bdIterator++] = bd.type;
		}
		compound.setIntArray("BuildingData", buildingDataArray);
	}
	
	public static VillageBentoData get(World world){

		if(world.mapStorage == null)
			return null;
		
		VillageBentoData data = (VillageBentoData)world.mapStorage.loadData(VillageBentoData.class, "VillageBentoData");
		
		if(data == null){
			data = new VillageBentoData("VillageBentoData");
			data.markDirty();
			world.mapStorage.setData("VillageBentoData", data);
		}
		
		return data;
	}

}
