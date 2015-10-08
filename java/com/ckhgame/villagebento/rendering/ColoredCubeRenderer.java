package com.ckhgame.villagebento.rendering;

import java.nio.FloatBuffer;
import java.util.ArrayList;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class ColoredCubeRenderer {

	private static ColoredCubeRenderer instance = null;
	public static ColoredCubeRenderer getInstance(){
		if(instance == null)
			instance = new ColoredCubeRenderer();
		return instance;
	}
	
	private ArrayList<ColoredCube> cubelist = new ArrayList<ColoredCube>();
	
	public void AddCube(ColoredCube cube){
		cubelist.add(cube);
	}
	
	public void ClearCubes(){
		cubelist.clear();
	}
	
	private FloatBuffer coordsBuffer = null;
	private FloatBuffer colorsBuffer = null;
	private float[] vertexCoords;
	private float[] vertexColors;
	
	//must be called if you want to refresh the things actually display in the scene
	public void RefreshBuffer(){
		
		vertexCoords = new float[cubelist.size() * 36 * 3];
		vertexColors = new float[cubelist.size() * 36 * 4];
		
		int coordIdx = 0;
		float x1,x2,y1,y2,z1,z2;
		for(ColoredCube cube : cubelist){
			
			//create bube colors array
			for(int i = coordIdx;i< coordIdx + 144;i+=4){
				vertexColors[i + 0] = cube.color[0];
				vertexColors[i + 1] = cube.color[1];
				vertexColors[i + 2] = cube.color[2];
				vertexColors[i + 3] = cube.color[3];
			}
			
			//create cube vertex array
			x1 = cube.x;	x2 = x1 + cube.width;
			y1 = cube.y;	y2 = y1 + cube.height;
			z1 = cube.z;	z2 = z1 + cube.depth;
			//t1
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			//t2
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			//t3
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			//t4
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			//t5		
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			//t6		
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			//t7	
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			//t8			
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			//t9			
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			//t10			
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			//t11			
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z1;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			//t12			
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x1;vertexCoords[coordIdx++] = y2;vertexCoords[coordIdx++] = z2;
			vertexCoords[coordIdx++] = x2;vertexCoords[coordIdx++] = y1;vertexCoords[coordIdx++] = z2;
			
		}
		
		
		coordsBuffer = BufferUtils.createFloatBuffer(vertexCoords.length);
		coordsBuffer.put(vertexCoords);
		coordsBuffer.flip();
		
		colorsBuffer = BufferUtils.createFloatBuffer(vertexColors.length);
		colorsBuffer.put(vertexColors);
		coordsBuffer.flip();
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void render(RenderWorldLastEvent event)
	{
		if(coordsBuffer != null && colorsBuffer != null)
		{
			GL11.glPushMatrix();
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_DEPTH_TEST);
		
			GL11.glEnableClientState( GL11.GL_VERTEX_ARRAY );  // Enable use of arrays.
			GL11.glEnableClientState( GL11.GL_COLOR_ARRAY);
			
			GL11.glVertexPointer( 3, 0, coordsBuffer );  // Set data type and location.
			GL11.glColorPointer( 4, 0, colorsBuffer );
		
			GL11.glDrawArrays( GL11.GL_TRIANGLES, 0, cubelist.size() * 12 * 3  );

			GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
			GL11.glDisableClientState( GL11.GL_COLOR_ARRAY);
			
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glEnable(GL11.GL_DEPTH_TEST);
			GL11.glPopMatrix();
		}
	}
	
}


