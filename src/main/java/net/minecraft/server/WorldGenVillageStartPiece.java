package net.minecraft.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenVillageStartPiece
        extends WorldGenVillageWell {
    public WorldChunkManager a;
    public boolean b;
    public int c;
    public WorldGenVillagePieceWeight d;
    public List e;
    public List<StructurePiece> i = new ArrayList();
    public List<StructurePiece> j = new ArrayList();

    public WorldGenVillageStartPiece() {
    }

    public WorldGenVillageStartPiece(WorldChunkManager paramWorldChunkManager, int paramInt1, Random paramRandom, int paramInt2, int paramInt3, List paramList, int paramInt4) {
        super(null, 0, paramRandom, paramInt2, paramInt3);
        this.a = paramWorldChunkManager;
        this.e = paramList;
        this.c = paramInt4;

        BiomeBase localBiomeBase = paramWorldChunkManager.getBiome(paramInt2, paramInt3);
        this.b = ((localBiomeBase == BiomeBase.DESERT) || (localBiomeBase == BiomeBase.DESERT_HILLS));
    }

    public WorldChunkManager e() {
        return this.a;
    }
}
