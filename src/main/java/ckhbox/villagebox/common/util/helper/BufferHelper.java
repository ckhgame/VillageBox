package ckhbox.villagebox.common.util.helper;

import java.util.UUID;

import io.netty.buffer.ByteBuf;
import net.minecraft.network.PacketBuffer;

public class BufferHelper {
	public static void writeUuid(ByteBuf buf, UUID uuid)
    {
        buf.writeLong(uuid.getMostSignificantBits());
        buf.writeLong(uuid.getLeastSignificantBits());
    }

    public static UUID readUuid(ByteBuf buf)
    {
        return new UUID(buf.readLong(), buf.readLong());
    }
}
