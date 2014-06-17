package net.minecraft.server;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class NBTTagByteArray
        extends NBTBase {
    private byte[] data;

    NBTTagByteArray() {
    }

    public NBTTagByteArray(byte[] paramArrayOfByte) {
        this.data = paramArrayOfByte;
    }

    void write(DataOutput paramDataOutput) throws IOException {
        paramDataOutput.writeInt(this.data.length);
        paramDataOutput.write(this.data);
    }

    void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) throws IOException {
        int i = paramDataInput.readInt();
        paramNBTReadLimiter.a(8 * i);
        this.data = new byte[i];
        paramDataInput.readFully(this.data);

    }

    public byte getTypeId() {
        return 7;
    }

    public String toString() {
        return "[" + this.data.length + " bytes]";
    }

    public NBTBase clone() {
        byte[] arrayOfByte = new byte[this.data.length];
        System.arraycopy(this.data, 0, arrayOfByte, 0, this.data.length);
        return new NBTTagByteArray(arrayOfByte);
    }

    public boolean equals(Object paramObject) {
        if (super.equals(paramObject)) {
            return Arrays.equals(this.data, ((NBTTagByteArray) paramObject).data);
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode() ^ Arrays.hashCode(this.data);
    }

    public byte[] c() {
        return this.data;
    }
}
