package com.ckhgame.villagebento.util.data;

import cpw.mods.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.StatCollector;

public class VBCompResult {
	public int vbResult;
	public String chatContent;
	
	public VBCompResult(int vbResult, String chatContent){
		this.vbResult = vbResult;
		this.chatContent = chatContent;
	}
	
	public static void writeByteBuf(ByteBuf buf, VBCompResult result){
		buf.writeInt(result.vbResult);
		boolean hasChatContent = result.chatContent != null && result.chatContent != "";
		buf.writeBoolean(hasChatContent);
		if(hasChatContent){
			ByteBufUtils.writeUTF8String(buf, result.chatContent);
		}
	}
	
	public static VBCompResult readByteBuf(ByteBuf buf){
		int r = buf.readInt();
		boolean hasChatContent = buf.readBoolean();
		String c = null;
		if(hasChatContent){
			c = ByteBufUtils.readUTF8String(buf);
		}
		return new VBCompResult(r,c);
	}
	
	public static VBCompResult getDefaultSuccess(){
		return new VBCompResult(VBResult.SUCCESS,StatCollector.translateToLocal("vcomp.default.success") );
	}
	
	public static VBCompResult getDefaultFailed(){
		return new VBCompResult(VBResult.FAILED,StatCollector.translateToLocal("vcomp.default.failed") );
	}
	
	public static VBCompResult getDefaultSuccessNoChat(){
		return new VBCompResult(VBResult.SUCCESS,null);
	}
	
	public static VBCompResult getDefaultFailedNoChat(){
		return new VBCompResult(VBResult.FAILED,null);
	}
}

