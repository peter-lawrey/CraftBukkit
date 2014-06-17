package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldChunkManager {
    private GenLayer c;
    private GenLayer d;
    private BiomeCache e = new BiomeCache(this);
    private List f;

    protected WorldChunkManager() {
        this.f = new ArrayList();
        this.f.add(BiomeBase.FOREST);
        this.f.add(BiomeBase.PLAINS);
        this.f.add(BiomeBase.TAIGA);
        this.f.add(BiomeBase.TAIGA_HILLS);
        this.f.add(BiomeBase.FOREST_HILLS);
        this.f.add(BiomeBase.JUNGLE);
        this.f.add(BiomeBase.JUNGLE_HILLS);
    }

    public WorldChunkManager(long paramLong, WorldType paramWorldType) {
        this();

        GenLayer[] arrayOfGenLayer = GenLayer.a(paramLong, paramWorldType);
        this.c = arrayOfGenLayer[0];
        this.d = arrayOfGenLayer[1];
    }

    public WorldChunkManager(World paramWorld) {
        this(paramWorld.getSeed(), paramWorld.getWorldData().getType());
    }

    public List a() {
        return this.f;
    }

    public BiomeBase getBiome(int paramInt1, int paramInt2) {
        return this.e.b(paramInt1, paramInt2);
    }

    public float[] getWetness(float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {

        if ((paramArrayOfFloat == null) || (paramArrayOfFloat.length < paramInt3 * paramInt4)) {
            paramArrayOfFloat = new float[paramInt3 * paramInt4];
        }
        int[] arrayOfInt = this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
        for (int i = 0; i < paramInt3 * paramInt4; i++) {
            try {
                float f1 = BiomeBase.getBiome(arrayOfInt[i]).h() / 65536.0F;
                if (f1 > 1.0F) {
                    f1 = 1.0F;
                }
                paramArrayOfFloat[i] = f1;
            } catch (Throwable localThrowable) {
                CrashReport localCrashReport = CrashReport.a(localThrowable, "Invalid Biome id");
                CrashReportSystemDetails localCrashReportSystemDetails = localCrashReport.a("DownfallBlock");
                localCrashReportSystemDetails.a("biome id", Integer.valueOf(i));
                localCrashReportSystemDetails.a("downfalls[] size", Integer.valueOf(paramArrayOfFloat.length));
                localCrashReportSystemDetails.a("x", Integer.valueOf(paramInt1));
                localCrashReportSystemDetails.a("z", Integer.valueOf(paramInt2));
                localCrashReportSystemDetails.a("w", Integer.valueOf(paramInt3));
                localCrashReportSystemDetails.a("h", Integer.valueOf(paramInt4));

                throw new ReportedException(localCrashReport);
            }
        }
        return paramArrayOfFloat;
    }

    public BiomeBase[] getBiomes(BiomeBase[] paramArrayOfBiomeBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {

        if ((paramArrayOfBiomeBase == null) || (paramArrayOfBiomeBase.length < paramInt3 * paramInt4)) {
            paramArrayOfBiomeBase = new BiomeBase[paramInt3 * paramInt4];
        }
        int[] arrayOfInt = this.c.a(paramInt1, paramInt2, paramInt3, paramInt4);
        try {
            for (int i = 0; i < paramInt3 * paramInt4; i++) {
                paramArrayOfBiomeBase[i] = BiomeBase.getBiome(arrayOfInt[i]);
            }
        } catch (Throwable localThrowable) {
            CrashReport localCrashReport = CrashReport.a(localThrowable, "Invalid Biome id");
            CrashReportSystemDetails localCrashReportSystemDetails = localCrashReport.a("RawBiomeBlock");
            localCrashReportSystemDetails.a("biomes[] size", Integer.valueOf(paramArrayOfBiomeBase.length));
            localCrashReportSystemDetails.a("x", Integer.valueOf(paramInt1));
            localCrashReportSystemDetails.a("z", Integer.valueOf(paramInt2));
            localCrashReportSystemDetails.a("w", Integer.valueOf(paramInt3));
            localCrashReportSystemDetails.a("h", Integer.valueOf(paramInt4));

            throw new ReportedException(localCrashReport);
        }
        return paramArrayOfBiomeBase;
    }

    public BiomeBase[] getBiomeBlock(BiomeBase[] paramArrayOfBiomeBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        return a(paramArrayOfBiomeBase, paramInt1, paramInt2, paramInt3, paramInt4, true);
    }

    public BiomeBase[] a(BiomeBase[] paramArrayOfBiomeBase, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean) {

        if ((paramArrayOfBiomeBase == null) || (paramArrayOfBiomeBase.length < paramInt3 * paramInt4)) {
            paramArrayOfBiomeBase = new BiomeBase[paramInt3 * paramInt4];
        }
        if ((paramBoolean) && (paramInt3 == 16) && (paramInt4 == 16) && ((paramInt1 & 0xF) == 0) && ((paramInt2 & 0xF) == 0)) {
            BiomeBase[] localObject = this.e.d(paramInt1, paramInt2);
            System.arraycopy(localObject, 0, paramArrayOfBiomeBase, 0, paramInt3 * paramInt4);
            return paramArrayOfBiomeBase;
        }
        int[] localObject = this.d.a(paramInt1, paramInt2, paramInt3, paramInt4);
        for (int i = 0; i < paramInt3 * paramInt4; i++) {
            paramArrayOfBiomeBase[i] = BiomeBase.getBiome(localObject[i]);
        }
        return paramArrayOfBiomeBase;
    }

    public boolean a(int paramInt1, int paramInt2, int paramInt3, List paramList) {
        IntCache.a();
        int i = paramInt1 - paramInt3 >> 2;
        int j = paramInt2 - paramInt3 >> 2;
        int k = paramInt1 + paramInt3 >> 2;
        int m = paramInt2 + paramInt3 >> 2;

        int n = k - i + 1;
        int i1 = m - j + 1;

        int[] arrayOfInt = this.c.a(i, j, n, i1);
        try {
            for (int i2 = 0; i2 < n * i1; i2++) {
                BiomeBase localObject = BiomeBase.getBiome(arrayOfInt[i2]);
                if (!paramList.contains(localObject)) {
                    return false;
                }
            }
        } catch (Throwable localThrowable) {
            Object localObject = CrashReport.a(localThrowable, "Invalid Biome id");
            CrashReportSystemDetails localCrashReportSystemDetails = ((CrashReport) localObject).a("Layer");
            localCrashReportSystemDetails.a("Layer", this.c.toString());
            localCrashReportSystemDetails.a("x", Integer.valueOf(paramInt1));
            localCrashReportSystemDetails.a("z", Integer.valueOf(paramInt2));
            localCrashReportSystemDetails.a("radius", Integer.valueOf(paramInt3));
            localCrashReportSystemDetails.a("allowed", paramList);

            throw new ReportedException((CrashReport) localObject);
        }
        return true;
    }

    public ChunkPosition a(int paramInt1, int paramInt2, int paramInt3, List paramList, Random paramRandom) {
        IntCache.a();
        int i = paramInt1 - paramInt3 >> 2;
        int j = paramInt2 - paramInt3 >> 2;
        int k = paramInt1 + paramInt3 >> 2;
        int m = paramInt2 + paramInt3 >> 2;

        int n = k - i + 1;
        int i1 = m - j + 1;
        int[] arrayOfInt = this.c.a(i, j, n, i1);
        ChunkPosition localChunkPosition = null;
        int i2 = 0;
        for (int i3 = 0; i3 < n * i1; i3++) {
            int i4 = i + i3 % n << 2;
            int i5 = j + i3 / n << 2;
            BiomeBase localBiomeBase = BiomeBase.getBiome(arrayOfInt[i3]);
            if ((paramList.contains(localBiomeBase)) && (
                    (localChunkPosition == null) || (paramRandom.nextInt(i2 + 1) == 0))) {
                localChunkPosition = new ChunkPosition(i4, 0, i5);
                i2++;
            }
        }
        return localChunkPosition;
    }

    public void b() {
        this.e.a();
    }
}
