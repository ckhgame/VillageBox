package com.ckhgame.villagebento.building.builder;

import java.util.List;

import com.ckhgame.villagebento.building.fixdirection.FixDirection;
import com.ckhgame.villagebento.config.ConfigBuilding;
import com.ckhgame.villagebento.data.DataBuilding;
import com.ckhgame.villagebento.data.DataVillageBento;
import com.ckhgame.villagebento.data.helper.HelperDataVB;
import com.ckhgame.villagebento.util.Vec3Int;
import com.ckhgame.villagebento.villager.Villager;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.item.EntityPainting;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntityFlowerPot;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BuildingBuilder {
	
	private static BuildingBuilder instance = null;
	public static BuildingBuilder getInstance(){
		if(instance == null)
			instance = new BuildingBuilder();
		return instance;
	}

	private World world;
	private EntityPlayer player;
	private int cx, cy, cz;
	private DataBuilding data;
	private int facing;
	
	private BuildingBuilder(){
		
	}
	
	public void reset(World w,EntityPlayer p, int x,int y,int z){
		this.world = w;
		this.player = p;
		this.cx = x;
		this.cy = y;
		this.cz = z;
	}
	
	public boolean generateData(int type,int sizeType){
		DataVillageBento villageBentoData = DataVillageBento.get(world);		

		data = null;
		
		//check if there is a building exists on the current location
		DataBuilding db = HelperDataVB.createDataBuilding(cx,cy,cz,type,sizeType);
		if(HelperDataVB.addBuildingData(villageBentoData, db)){
			
			data = db;
			villageBentoData.markDirty();
						
			return true;
		}	
		return false;
	}
	
	public void calculateFacing(){
		int l = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		facing = (l + 1 + 2)%4;//this is building face(where the entry faces to), NOT player facing
	}
	
	public void buildBlock(int dx,int dy,int dz,Block block,int metadata){
		int fx = dx;
		int fy = dy;
		int fz = dz;
		
		switch(facing){
		case 1://South
			fx = -dz;
			fz = dx;
			break;
		case 2://West
			fx = -dx;
			fz = -dz;
			break;
		case 3://North
			fx = dz;
			fz = -dx;
		case 0://East
			break;
			default://East
				break;
		}
					
		world.setBlock(	data.x+fx,
						data.y+fy,
						data.z+fz,
						block,0,2);
		
		world.setBlockMetadataWithNotify(	data.x+fx,
											data.y+fy,
											data.z+fz,
											FixDirection.fix(block, metadata, facing),
											2);
	}
	
	private Vec3Int getFinalPos(int dx, int dy, int dz){
		Vec3Int fVec = new Vec3Int();
		fVec.x = dx;
		fVec.y = dy;
		fVec.z = dz;
		
		switch(facing){
		case 1://South
			fVec.x = -dz;
			fVec.z = dx;
			break;
		case 2://West
			fVec.x = -dx;
			fVec.z = -dz;
			break;
		case 3://North
			fVec.x = dz;
			fVec.z = -dx;
		case 0://East
			break;
			default://East
				break;
		}
		
		return fVec;
	}
	
	public void addTileEntityPot(int dx, int dy, int dz,int itemID, int itemData){
		Vec3Int fv = getFinalPos(dx,dy,dz);
		TileEntityFlowerPot tePot = new TileEntityFlowerPot(Item.getItemById(itemID),itemData);
		//dir
		world.setTileEntity(data.x + fv.x, data.y + fv.y, data.z + fv.z, tePot);
	}
	
	public void addTileEntitySign(int dx, int dy, int dz,String l1,String l2,String l3,String l4){
		Vec3Int fv = getFinalPos(dx,dy,dz);
		TileEntitySign teSign = new TileEntitySign();
		teSign.signText = new String[]{l1,l2,l3,l4};
		world.setTileEntity(data.x + fv.x, data.y + fv.y, data.z + fv.z, teSign);
	}
	
	public void addEntityPainting(int dx, int dy,int dz,int dir,String artName){
		Vec3Int fv = getFinalPos(dx,dy,dz);
		EntityPainting ePainting = new EntityPainting(world,data.x + fv.x, data.y + fv.y, data.z + fv.z,
				FixDirection.fix(EntityPainting.class, dir, facing),artName);
		world.spawnEntityInWorld(ePainting);
	}
	
	public void addEntityItemFrame(int dx, int dy, int dz, int dir, int itemID){
		Vec3Int fv = getFinalPos(dx,dy,dz);
		EntityItemFrame eItemFrame = new EntityItemFrame(world,data.x + fv.x, data.y + fv.y, data.z + fv.z,
														FixDirection.fix(EntityItemFrame.class, dir, facing));
		eItemFrame.setDisplayedItem(new ItemStack(Item.getItemById(itemID)));
		world.spawnEntityInWorld(eItemFrame);
	}

	public void removeBuildingEntities(){
		Class[] entityClasses = BuildingEntityList.get();
		
		AxisAlignedBB aabb = HelperDataVB.getBuildingAABB(data);
		for(Class c : entityClasses){
			List<Entity> es = world.getEntitiesWithinAABB(c, aabb);
			for(Entity e : es){
				world.removeEntity(e);
			}
		}
	}
	
	/**
	 * used on removing buildings
	 */
	public void setData(DataBuilding db){
		data = db;
	}
	
	//groundworks
	public void buildGroundwork(){

		//basic sets of village
		int xfrom = data.x - data.sizeX;
		int xto = data.x + data.sizeX;
		int zfrom = data.z - data.sizeZ;
		int zto = data.z + data.sizeZ;
		int y = data.y;
		int depth = ConfigBuilding.BuildingGroundWorkDepth;
		int height = ConfigBuilding.BuildingMaxHeight; // building center includes in height
		
		for(int x = xfrom;x <= xto;x++){
			for(int z = zfrom;z<= zto;z++){	
				buildGroundworkPerColumn(x, z, y, depth, height);
			}
		}
		
	}

	private void buildGroundworkPerColumn(int x, int z, int y, int depth, int height ){
		
		for(int dy = -depth; dy < 0;dy++){
			world.setBlock(x, y + dy, z, ConfigBuilding.GroundWorkBlock,0,2);
		}
		
		for(int dy = 0;dy<height;dy++){
			if (world.getBlock(x, dy+y, z).getMaterial() != Material.air){
				buildGroundworkRemoveBlock(world,x,dy+y,z);
			}
		}
		
	}
	
	private boolean buildGroundworkRemoveBlock(World w,int x, int y, int z){
		Block block = w.getBlock(x, y, z);
        if (block.getMaterial() == Material.air)
        {
            return false;
        }
        else
        {
            int l = w.getBlockMetadata(x, y, z);
            w.playAuxSFX(2001, x, y, z, Block.getIdFromBlock(block) + (l << 12));

            int flag = 2;
            if(block.getLightValue() > 0)
            	flag = 3;
            return w.setBlock(x, y, z, Blocks.air, 0, flag);
        }
	}
	
	//villagers
	public void addBuildingVillager(Class<? extends Villager> c, String name, int dx, int dz){
		
		int fx = dx;
		int fz = dz;
		
		switch(facing){
		case 1://South
			fx = -dz;
			fz = dx;
			break;
		case 2://West
			fx = -dx;
			fz = -dz;
			break;
		case 3://North
			fx = dz;
			fz = -dx;
		case 0://East
			break;
			default://East
				break;
		}
		
		Villager.spawn(	world,
						data.x + fx, data.y, data.z + fz, 
						c, name, data.id);
	}
}
