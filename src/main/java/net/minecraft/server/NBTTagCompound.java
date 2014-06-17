package net.minecraft.server;

import org.apache.logging.log4j.Logger;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NBTTagCompound
        extends NBTBase {
    private static final Logger b = MinecraftServer.getLogger();
    private Map<String, NBTBase> map = new HashMap();

    public NBTTagCompound() {
    }

    private static void a(String paramString, NBTBase paramNBTBase, DataOutput paramDataOutput) throws IOException {
        paramDataOutput.writeByte(paramNBTBase.getTypeId());
        if (paramNBTBase.getTypeId() == 0) {
            return;
        }
        paramDataOutput.writeUTF(paramString);

        paramNBTBase.write(paramDataOutput);
    }

    private static byte a(DataInput paramDataInput, NBTReadLimiter paramNBTReadLimiter) throws IOException {
        return paramDataInput.readByte();
    }

    private static String b(DataInput paramDataInput, NBTReadLimiter paramNBTReadLimiter) throws IOException {
        return paramDataInput.readUTF();
    }

    static NBTBase a(byte paramByte, String paramString, DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) {
        NBTBase localNBTBase = NBTBase.createTag(paramByte);
        try {
            localNBTBase.load(paramDataInput, paramInt, paramNBTReadLimiter);
        } catch (IOException localIOException) {
            CrashReport localCrashReport = CrashReport.a(localIOException, "Loading NBT data");
            CrashReportSystemDetails localCrashReportSystemDetails = localCrashReport.a("NBT Tag");
            localCrashReportSystemDetails.a("Tag name", paramString);
            localCrashReportSystemDetails.a("Tag type", Byte.valueOf(paramByte));
            throw new ReportedException(localCrashReport);
        }
        return localNBTBase;
    }

    void write(DataOutput paramDataOutput) throws IOException {
        for (String str : this.map.keySet()) {
            NBTBase localNBTBase = (NBTBase) this.map.get(str);
            a(str, localNBTBase, paramDataOutput);
        }
        paramDataOutput.writeByte(0);
    }

    void load(DataInput paramDataInput, int paramInt, NBTReadLimiter paramNBTReadLimiter) throws IOException {
        if (paramInt > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.map.clear();
        byte b1;
        while ((b1 = a(paramDataInput, paramNBTReadLimiter)) != 0) {
            String str = b(paramDataInput, paramNBTReadLimiter);

            paramNBTReadLimiter.a(16 * str.length());
            NBTBase localNBTBase = a(b1, str, paramDataInput, paramInt + 1, paramNBTReadLimiter);
            this.map.put(str, localNBTBase);
        }
    }

    public Set c() {
        return this.map.keySet();
    }

    public byte getTypeId() {
        return 10;
    }

    public void set(String paramString, NBTBase paramNBTBase) {
        this.map.put(paramString, paramNBTBase);
    }

    public void setByte(String paramString, byte paramByte) {
        this.map.put(paramString, new NBTTagByte(paramByte));
    }

    public void setShort(String paramString, short paramShort) {
        this.map.put(paramString, new NBTTagShort(paramShort));
    }

    public void setInt(String paramString, int paramInt) {
        this.map.put(paramString, new NBTTagInt(paramInt));
    }

    public void setLong(String paramString, long paramLong) {
        this.map.put(paramString, new NBTTagLong(paramLong));
    }

    public void setFloat(String paramString, float paramFloat) {
        this.map.put(paramString, new NBTTagFloat(paramFloat));
    }

    public void setDouble(String paramString, double paramDouble) {
        this.map.put(paramString, new NBTTagDouble(paramDouble));
    }

    public void setString(String paramString1, String paramString2) {
        this.map.put(paramString1, new NBTTagString(paramString2));
    }

    public void setByteArray(String paramString, byte[] paramArrayOfByte) {
        this.map.put(paramString, new NBTTagByteArray(paramArrayOfByte));
    }

    public void setIntArray(String paramString, int[] paramArrayOfInt) {
        this.map.put(paramString, new NBTTagIntArray(paramArrayOfInt));
    }

    public void setBoolean(String paramString, boolean paramBoolean) {
        setByte(paramString, (byte) (paramBoolean ? 1 : 0));
    }

    public NBTBase get(String paramString) {
        return (NBTBase) this.map.get(paramString);
    }

    public byte b(String paramString) {
        NBTBase localNBTBase = (NBTBase) this.map.get(paramString);
        if (localNBTBase != null) {
            return localNBTBase.getTypeId();
        }
        return 0;
    }

    public boolean hasKey(String paramString) {
        return this.map.containsKey(paramString);
    }

    public boolean hasKeyOfType(String paramString, int paramInt) {
        int i = b(paramString);
        if (i == paramInt) {
            return true;
        }
        if (paramInt == 99) {
            return (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5) || (i == 6);
        }
        return false;
    }

    public byte getByte(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return 0;
            }
            return ((NBTNumber) this.map.get(paramString)).f();
        } catch (ClassCastException localClassCastException) {
        }
        return 0;
    }

    public short getShort(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return 0;
            }
            return ((NBTNumber) this.map.get(paramString)).e();
        } catch (ClassCastException localClassCastException) {
        }
        return 0;
    }

    public int getInt(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return 0;
            }
            return ((NBTNumber) this.map.get(paramString)).d();
        } catch (ClassCastException localClassCastException) {
        }
        return 0;
    }

    public long getLong(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return 0L;
            }
            return ((NBTNumber) this.map.get(paramString)).c();
        } catch (ClassCastException localClassCastException) {
        }
        return 0L;
    }

    public float getFloat(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return 0.0F;
            }
            return ((NBTNumber) this.map.get(paramString)).h();
        } catch (ClassCastException localClassCastException) {
        }
        return 0.0F;
    }

    public double getDouble(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return 0.0D;
            }
            return ((NBTNumber) this.map.get(paramString)).g();
        } catch (ClassCastException localClassCastException) {
        }
        return 0.0D;
    }

    public String getString(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return "";
            }
            return ((NBTBase) this.map.get(paramString)).a_();
        } catch (ClassCastException localClassCastException) {
        }
        return "";
    }

    public byte[] getByteArray(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return new byte[0];
            }
            return ((NBTTagByteArray) this.map.get(paramString)).c();
        } catch (ClassCastException localClassCastException) {
            throw new ReportedException(a(paramString, 7, localClassCastException));
        }
    }

    public int[] getIntArray(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return new int[0];
            }
            return ((NBTTagIntArray) this.map.get(paramString)).c();
        } catch (ClassCastException localClassCastException) {
            throw new ReportedException(a(paramString, 11, localClassCastException));
        }
    }

    public NBTTagCompound getCompound(String paramString) {
        try {
            if (!this.map.containsKey(paramString)) {
                return new NBTTagCompound();
            }
            return (NBTTagCompound) this.map.get(paramString);
        } catch (ClassCastException localClassCastException) {
            throw new ReportedException(a(paramString, 10, localClassCastException));
        }
    }

    public NBTTagList getList(String paramString, int paramInt) {
        try {
            if (b(paramString) != 9) {
                return new NBTTagList();
            }
            NBTTagList localNBTTagList = (NBTTagList) this.map.get(paramString);
            if ((localNBTTagList.size() > 0) && (localNBTTagList.d() != paramInt)) {
                return new NBTTagList();
            }
            return localNBTTagList;
        } catch (ClassCastException localClassCastException) {
            throw new ReportedException(a(paramString, 9, localClassCastException));
        }
    }

    public boolean getBoolean(String paramString) {
        return getByte(paramString) != 0;
    }

    public void remove(String paramString) {
        this.map.remove(paramString);
    }

    public String toString() {
        String str1 = "{";
        for (String str2 : this.map.keySet()) {
            str1 = str1 + str2 + ':' + this.map.get(str2) + ',';
        }
        return str1 + "}";
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    private CrashReport a(String paramString, int paramInt, ClassCastException paramClassCastException) {
        CrashReport localCrashReport = CrashReport.a(paramClassCastException, "Reading NBT data");
        CrashReportSystemDetails localCrashReportSystemDetails = localCrashReport.a("Corrupt NBT tag", 1);

        localCrashReportSystemDetails.a("Tag type found", new CrashReportCorruptNBTTag(this, paramString));


        localCrashReportSystemDetails.a("Tag type expected", new CrashReportCorruptNBTTag2(this, paramInt));


        localCrashReportSystemDetails.a("Tag name", paramString);

        return localCrashReport;
    }

    public NBTBase clone() {
        NBTTagCompound localNBTTagCompound = new NBTTagCompound();
        for (String str : this.map.keySet()) {
            localNBTTagCompound.set(str, ((NBTBase) this.map.get(str)).clone());
        }
        return localNBTTagCompound;
    }

    public boolean equals(Object paramObject) {
        if (super.equals(paramObject)) {
            NBTTagCompound localNBTTagCompound = (NBTTagCompound) paramObject;
            return this.map.entrySet().equals(localNBTTagCompound.map.entrySet());
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode() ^ this.map.hashCode();
    }
}
