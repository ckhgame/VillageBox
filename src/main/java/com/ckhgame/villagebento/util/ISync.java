package com.ckhgame.villagebento.util;

import io.netty.buffer.ByteBuf;

public interface ISync {
	
	/**
	 * the source object writes data to the buffer
	 */
	void syneWrite(ByteBuf buf);
	
	/**
	 * the target object reads data from the buffer to override its old data
	 */
	void syneRead(ByteBuf buf);

}
