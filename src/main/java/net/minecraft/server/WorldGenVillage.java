package net.minecraft.server;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class WorldGenVillage
        extends StructureGenerator {
    public static final List<BiomeBase> e = Arrays.asList(
            BiomeBase.PLAINS, BiomeBase.DESERT, BiomeBase.SAVANNA,
            BiomeBase.FOREST, BiomeBase.BIRCH_FOREST,
            BiomeBase.SWAMPLAND, BiomeBase.JUNGLE_EDGE,
            BiomeBase.EXTREME_HILLS, BiomeBase.BEACH, BiomeBase.TAIGA
          /*BiomeBase.BIRCH_FOREST,
          BiomeBase.BIRCH_FOREST_HILLS,
          BiomeBase.DESERT_HILLS,
          BiomeBase.EXTREME_HILLS,
          BiomeBase.FOREST,
          BiomeBase.FOREST_HILLS,
          BiomeBase.JUNGLE,
          BiomeBase.JUNGLE_EDGE,
          BiomeBase.SAVANNA_PLATEAU,
BiomeBase.DESERT_HILLS,
          BiomeBase.DESERT,
          BiomeBase.SAVANNA*/);
    private int f;
    private int g = 32;
    private int h = 8;

    public WorldGenVillage() {
        f = 2;
    }

    public WorldGenVillage(Map<String, ?> paramMap) {
        this();
        for (Map.Entry localEntry : paramMap.entrySet()) {
            if (((String) localEntry.getKey()).equals("size")) {
                this.f = MathHelper.a((String) localEntry.getValue(), this.f, 0);
            } else if (((String) localEntry.getKey()).equals("distance")) {
                this.g = MathHelper.a((String) localEntry.getValue(), this.g, this.h + 1);
            }
        }
    }

    public String a() {
        return "Village";
    }

    protected boolean a(int paramInt1, int paramInt2) {
        int i = paramInt1;
        int j = paramInt2;
        if (paramInt1 < 0) {
            paramInt1 -= this.g - 1;
        }
        if (paramInt2 < 0) {
            paramInt2 -= this.g - 1;
        }
        int k = paramInt1 / this.g;
        int m = paramInt2 / this.g;
        Random localRandom = this.c.A(k, m, 10387312);
        k *= this.g;
        m *= this.g;
        k += localRandom.nextInt(this.g - this.h);
        m += localRandom.nextInt(this.g - this.h);
        paramInt1 = i;
        paramInt2 = j;
        if ((paramInt1 == k) && (paramInt2 == m)) {
            boolean bool = this.c.getWorldChunkManager().a(paramInt1 * 16 + 8, paramInt2 * 16 + 8, 0, e);
            if (bool) {
                return true;
            }
        }
        return false;
    }

    protected StructureStart b(int paramInt1, int paramInt2) {
        System.out.println("Village " + paramInt1 + "," + paramInt2);
        return new WorldGenVillageStart(this.c, this.b, paramInt1, paramInt2, this.f);
    }
}
