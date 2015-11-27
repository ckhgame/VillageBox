package com.ckhgame.villagebento.network.message;

import java.util.ArrayList;

import com.ckhgame.villagebento.util.data.BoxWithColor;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class MessageVillageOutlinesChanged implements IMessage {

	public ArrayList<BoxWithColor> listOutlines = new ArrayList<BoxWithColor>();
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
		listOutlines.clear();
				
		int size = buf.readInt();
		
		for(int i =0;i<size;i++){
			listOutlines.add(new BoxWithColor(
						buf.readInt(),//minx
						buf.readInt(),//miny
						buf.readInt(),//minz
						buf.readInt(),//maxx
						buf.readInt(),//maxy
						buf.readInt(),//maxz
						buf.readInt(),//r
						buf.readInt(),//g
						buf.readInt(),//b
						buf.readInt() //a
					));
		}
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		//size
		buf.writeInt(listOutlines.size());
		//list
		for(BoxWithColor bc: listOutlines){
			buf.writeInt(bc.minX);
			buf.writeInt(bc.minY);
			buf.writeInt(bc.minZ);
			buf.writeInt(bc.maxX);
			buf.writeInt(bc.maxY);
			buf.writeInt(bc.maxZ);
			buf.writeInt(bc.R);	//*waiting for optimization ( should only use 1 byte for the color)*
			buf.writeInt(bc.G);
			buf.writeInt(bc.B);
			buf.writeInt(bc.A);
		}
	}

}
