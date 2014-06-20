package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageHouse2
        extends WorldGenVillagePiece {
    public WorldGenVillageHouse2() {
    }

    public WorldGenVillageHouse2(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
    }

    public static WorldGenVillageHouse2 a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 9, 7, 12, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageHouse2(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    public boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        if (this.k < 0) {
            this.k = b(paramWorld, paramStructureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 7 - 1, 0);
        }
        a(paramWorld, Blocks.EMERALD_BLOCK, 0, 0, 10, 0, paramStructureBoundingBox);
        a(paramWorld, paramStructureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.AIR, Blocks.AIR, false);
        a(paramWorld, paramStructureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.AIR, Blocks.AIR, false);


        a(paramWorld, paramStructureBoundingBox, 2, 0, 5, 8, 0, 10, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 1, 7, 0, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 8, 0, 0, 8, 3, 10, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 0, 7, 2, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 5, 2, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 2, 0, 6, 2, 3, 10, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 3, 0, 10, 7, 3, 10, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);


        a(paramWorld, paramStructureBoundingBox, 1, 2, 0, 7, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 2, 5, 2, 3, 5, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 4, 1, 8, 4, 1, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 4, 4, 3, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 5, 2, 8, 5, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, Blocks.WOOD, 0, 0, 4, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 0, 4, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 8, 4, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 8, 4, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 8, 4, 4, paramStructureBoundingBox);

        int i = a(Blocks.WOOD_STAIRS, 3);
        int j = a(Blocks.WOOD_STAIRS, 2);
        for (int k = -1; k <= 2; k++) {
            for (int m = 0; m <= 8; m++) {
                a(paramWorld, Blocks.WOOD_STAIRS, i, m, 4 + k, k, paramStructureBoundingBox);
                if (((k > -1) || (m <= 1)) && ((k > 0) || (m <= 3)) && ((k > 1) || (m <= 4) || (m >= 6))) {
                    a(paramWorld, Blocks.WOOD_STAIRS, j, m, 4 + k, 5 - k, paramStructureBoundingBox);
                }
            }
        }
        a(paramWorld, paramStructureBoundingBox, 3, 4, 5, 3, 4, 10, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 7, 4, 2, 7, 4, 10, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 4, 5, 4, 4, 5, 10, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 6, 5, 4, 6, 5, 10, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 5, 6, 3, 5, 6, 10, Blocks.WOOD, Blocks.WOOD, false);
        k = a(Blocks.WOOD_STAIRS, 0);
        for (int m = 4; m >= 1; m--) {
            a(paramWorld, Blocks.WOOD, 0, m, 2 + m, 7 - m, paramStructureBoundingBox);
            for (int n = 8 - m; n <= 10; n++) {
                a(paramWorld, Blocks.WOOD_STAIRS, k, m, 2 + m, n, paramStructureBoundingBox);
            }
        }
        int m = a(Blocks.WOOD_STAIRS, 1);
        a(paramWorld, Blocks.WOOD, 0, 6, 6, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 7, 5, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, m, 6, 6, 4, paramStructureBoundingBox);
        int i1;
        for (int n = 6; n <= 8; n++) {
            for (i1 = 5; i1 <= 10; i1++) {
                a(paramWorld, Blocks.WOOD_STAIRS, m, n, 12 - n, i1, paramStructureBoundingBox);
            }
        }
        a(paramWorld, Blocks.LOG, 0, 0, 2, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 0, 2, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 2, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 2, 3, paramStructureBoundingBox);

        a(paramWorld, Blocks.LOG, 0, 4, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 5, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 6, 2, 0, paramStructureBoundingBox);

        a(paramWorld, Blocks.LOG, 0, 8, 2, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 8, 2, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 8, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 8, 2, 6, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 7, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 8, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 8, 2, 9, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 2, 2, 6, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 2, 2, 7, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 2, 2, 8, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 2, 2, 9, paramStructureBoundingBox);

        a(paramWorld, Blocks.LOG, 0, 4, 4, 10, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 5, 4, 10, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 6, 4, 10, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 5, 5, 10, paramStructureBoundingBox);


        a(paramWorld, Blocks.AIR, 0, 2, 1, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 2, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.TORCH, 0, 2, 3, 1, paramStructureBoundingBox);
        a(paramWorld, paramStructureBoundingBox, paramRandom, 2, 1, 0, a(Blocks.WOODEN_DOOR, 1));
        a(paramWorld, paramStructureBoundingBox, 1, 0, -1, 3, 2, -1, Blocks.AIR, Blocks.AIR, false);
        if ((a(paramWorld, 2, 0, -1, paramStructureBoundingBox).getMaterial() == Material.AIR) && (a(paramWorld, 2, -1, -1, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
            a(paramWorld, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0, -1, paramStructureBoundingBox);
        }
        for (int n = 0; n < 5; n++) {
            for (i1 = 0; i1 < 9; i1++) {
                b(paramWorld, i1, 7, n, paramStructureBoundingBox);
                b(paramWorld, Blocks.COBBLESTONE, 0, i1, -1, n, paramStructureBoundingBox);
            }
        }
        for (int n = 5; n < 11; n++) {
            for (i1 = 2; i1 < 9; i1++) {
                b(paramWorld, i1, 7, n, paramStructureBoundingBox);
                b(paramWorld, Blocks.COBBLESTONE, 0, i1, -1, n, paramStructureBoundingBox);
            }
        }
        a(paramWorld, paramStructureBoundingBox, 4, 1, 2, 2);

        return true;
    }
}
