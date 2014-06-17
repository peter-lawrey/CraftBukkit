package net.minecraft.server;

import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class PacketPlayOutMapChunk
        extends Packet {
    private static byte[] buildBuffer = new byte[196864];
    private int a;
    private int b;
    private int c;
    private int d;
    private byte[] e;
    private byte[] buffer;
    private boolean inflatedBuffer;
    private int size;

    public PacketPlayOutMapChunk() {
    }

    public PacketPlayOutMapChunk(Chunk paramChunk, boolean paramBoolean, int paramInt) {
        this.a = paramChunk.locX;
        this.b = paramChunk.locZ;
        this.inflatedBuffer = paramBoolean;

        ChunkMap localChunkMap = a(paramChunk, paramBoolean, paramInt);
        Deflater localDeflater = new Deflater(-1);
        this.d = localChunkMap.c;
        this.c = localChunkMap.b;
        try {
            this.buffer = localChunkMap.a;
            localDeflater.setInput(localChunkMap.a, 0, localChunkMap.a.length);
            localDeflater.finish();
            this.e = new byte[localChunkMap.a.length];
            this.size = localDeflater.deflate(this.e);
        } finally {
            localDeflater.end();
        }
    }

    public static int c() {
        return 196864;
    }

    public static ChunkMap a(Chunk paramChunk, boolean paramBoolean, int paramInt) {
        int i = 0;
        ChunkSection[] arrayOfChunkSection = paramChunk.i();
        int j = 0;
        ChunkMap localChunkMap = new ChunkMap();
        byte[] arrayOfByte1 = buildBuffer;
        if (paramBoolean) {
            paramChunk.q = true;
        }
        for (int k = 0; k < arrayOfChunkSection.length; k++) {
            if ((arrayOfChunkSection[k] != null) && ((!paramBoolean) || (!arrayOfChunkSection[k].isEmpty())) && ((paramInt & 1 << k) != 0)) {
                localChunkMap.b |= 1 << k;
                if (arrayOfChunkSection[k].getExtendedIdArray() != null) {
                    localChunkMap.c |= 1 << k;
                    j++;
                }
            }
        }
        for (int k = 0; k < arrayOfChunkSection.length; k++) {
            if ((arrayOfChunkSection[k] != null) && ((!paramBoolean) || (!arrayOfChunkSection[k].isEmpty())) && ((paramInt & 1 << k) != 0)) {
                byte[] localObject = arrayOfChunkSection[k].getIdArray();
                System.arraycopy(localObject, 0, arrayOfByte1, i, localObject.length);
                i += localObject.length;
            }
        }

        for (int k = 0; k < arrayOfChunkSection.length; k++) {
            if ((arrayOfChunkSection[k] != null) && ((!paramBoolean) || (!arrayOfChunkSection[k].isEmpty())) && ((paramInt & 1 << k) != 0)) {
                NibbleArray localObject = arrayOfChunkSection[k].getDataArray();
                System.arraycopy(((NibbleArray) localObject).a, 0, arrayOfByte1, i, ((NibbleArray) localObject).a.length);
                i += ((NibbleArray) localObject).a.length;
            }
        }
        for (int k = 0; k < arrayOfChunkSection.length; k++) {
            if ((arrayOfChunkSection[k] != null) && ((!paramBoolean) || (!arrayOfChunkSection[k].isEmpty())) && ((paramInt & 1 << k) != 0)) {
                NibbleArray localObject = arrayOfChunkSection[k].getEmittedLightArray();
                System.arraycopy(((NibbleArray) localObject).a, 0, arrayOfByte1, i, ((NibbleArray) localObject).a.length);
                i += ((NibbleArray) localObject).a.length;
            }
        }
        if (!paramChunk.world.worldProvider.g) {
            for (int k = 0; k < arrayOfChunkSection.length; k++) {
                if ((arrayOfChunkSection[k] != null) && ((!paramBoolean) || (!arrayOfChunkSection[k].isEmpty())) && ((paramInt & 1 << k) != 0)) {
                    NibbleArray localObject = arrayOfChunkSection[k].getSkyLightArray();
                    System.arraycopy(((NibbleArray) localObject).a, 0, arrayOfByte1, i, ((NibbleArray) localObject).a.length);
                    i += ((NibbleArray) localObject).a.length;
                }
            }
        }
        if (j > 0) {
            for (int k = 0; k < arrayOfChunkSection.length; k++) {
                if ((arrayOfChunkSection[k] != null) && ((!paramBoolean) || (!arrayOfChunkSection[k].isEmpty())) && (arrayOfChunkSection[k].getExtendedIdArray() != null) && ((paramInt & 1 << k) != 0)) {
                    NibbleArray localObject = arrayOfChunkSection[k].getExtendedIdArray();
                    System.arraycopy(((NibbleArray) localObject).a, 0, arrayOfByte1, i, ((NibbleArray) localObject).a.length);
                    i += ((NibbleArray) localObject).a.length;
                }
            }
        }
        if (paramBoolean) {
            byte[] arrayOfByte2 = paramChunk.m();
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
            i += arrayOfByte2.length;
        }
        localChunkMap.a = new byte[i];
        System.arraycopy(arrayOfByte1, 0, localChunkMap.a, 0, i);

        return localChunkMap;
    }

    public void a(PacketDataSerializer paramPacketDataSerializer) throws IOException {
        this.a = paramPacketDataSerializer.readInt();
        this.b = paramPacketDataSerializer.readInt();
        this.inflatedBuffer = paramPacketDataSerializer.readBoolean();
        this.c = paramPacketDataSerializer.readShort();
        this.d = paramPacketDataSerializer.readShort();

        this.size = paramPacketDataSerializer.readInt();
        if (buildBuffer.length < this.size) {
            buildBuffer = new byte[this.size];
        }
        paramPacketDataSerializer.readBytes(buildBuffer, 0, this.size);

        int i = 0;
        for (int j = 0; j < 16; j++) {
            i += (this.c >> j & 0x1);
        }
        int j = 12288 * i;
        if (this.inflatedBuffer) {
            j += 256;
        }
        this.buffer = new byte[j];

        Inflater localInflater = new Inflater();
        localInflater.setInput(buildBuffer, 0, this.size);
        try {
            localInflater.inflate(this.buffer);
        } catch (DataFormatException localDataFormatException) {
            throw new IOException("Bad compressed data format");
        } finally {
            localInflater.end();
        }
    }

    public void b(PacketDataSerializer paramPacketDataSerializer) {
        paramPacketDataSerializer.writeInt(this.a);
        paramPacketDataSerializer.writeInt(this.b);
        paramPacketDataSerializer.writeBoolean(this.inflatedBuffer);
        paramPacketDataSerializer.writeShort((short) (this.c & 0xFFFF));
        paramPacketDataSerializer.writeShort((short) (this.d & 0xFFFF));

        paramPacketDataSerializer.writeInt(this.size);
        paramPacketDataSerializer.writeBytes(this.e, 0, this.size);
    }

    public void a(PacketPlayOutListener paramPacketPlayOutListener) {
        paramPacketPlayOutListener.a(this);
    }

    public String b() {
        return String.format("x=%d, z=%d, full=%b, sects=%d, add=%d, size=%d", new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Boolean.valueOf(this.inflatedBuffer), Integer.valueOf(this.c), Integer.valueOf(this.d), Integer.valueOf(this.size)});
    }

    public void handle(PacketListener packetlistener) {
        this.a((PacketPlayOutListener) packetlistener);
    }
}
