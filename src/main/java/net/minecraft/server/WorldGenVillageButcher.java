package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageButcher
        extends WorldGenVillagePiece {
    public WorldGenVillageButcher() {
    }

    public WorldGenVillageButcher(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
    }

    public static WorldGenVillageButcher a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 9, 7, 11, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageButcher(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    public boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        if (this.k < 0) {
            this.k = b(paramWorld, paramStructureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 7 - 1, 0);
        }
        a(paramWorld, Blocks.DIAMOND_BLOCK, 0, 0, 10, 0, paramStructureBoundingBox);

        a(paramWorld, paramStructureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.AIR, Blocks.AIR, false);
        a(paramWorld, paramStructureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.AIR, Blocks.AIR, false);


        a(paramWorld, paramStructureBoundingBox, 2, 0, 6, 8, 0, 10, Blocks.DIRT, Blocks.DIRT, false);
        a(paramWorld, Blocks.COBBLESTONE, 0, 6, 0, 6, paramStructureBoundingBox);

        a(paramWorld, paramStructureBoundingBox, 2, 1, 6, 2, 1, 10, Blocks.FENCE, Blocks.FENCE, false);
        a(paramWorld, paramStructureBoundingBox, 8, 1, 6, 8, 1, 10, Blocks.FENCE, Blocks.FENCE, false);
        a(paramWorld, paramStructureBoundingBox, 3, 1, 10, 7, 1, 10, Blocks.FENCE, Blocks.FENCE, false);


        a(paramWorld, paramStructureBoundingBox, 1, 0, 1, 7, 0, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 0, 0, 0, 3, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 8, 0, 0, 8, 3, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 0, 7, 1, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 5, 7, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);


        a(paramWorld, paramStructureBoundingBox, 1, 2, 0, 7, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 2, 5, 7, 3, 5, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 4, 1, 8, 4, 1, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 4, 4, 8, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 0, 5, 2, 8, 5, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, Blocks.WOOD, 0, 0, 4, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 0, 4, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 8, 4, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 8, 4, 3, paramStructureBoundingBox);

        int i = a(Blocks.WOOD_STAIRS, 3);
        int j = a(Blocks.WOOD_STAIRS, 2);
        int m;
        for (int k = -1; k <= 2; k++) {
            for (m = 0; m <= 8; m++) {
                a(paramWorld, Blocks.WOOD_STAIRS, i, m, 4 + k, k, paramStructureBoundingBox);
                a(paramWorld, Blocks.WOOD_STAIRS, j, m, 4 + k, 5 - k, paramStructureBoundingBox);
            }
        }
        a(paramWorld, Blocks.LOG, 0, 0, 2, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 0, 2, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 8, 2, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.LOG, 0, 8, 2, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 2, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 2, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 3, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 5, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 6, 2, 5, paramStructureBoundingBox);


        a(paramWorld, Blocks.FENCE, 0, 2, 1, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_PLATE, 0, 2, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD, 0, 1, 1, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, a(Blocks.WOOD_STAIRS, 3), 2, 1, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, a(Blocks.WOOD_STAIRS, 1), 1, 1, 3, paramStructureBoundingBox);


        a(paramWorld, paramStructureBoundingBox, 5, 0, 1, 7, 0, 3, Blocks.DOUBLE_STEP, Blocks.DOUBLE_STEP, false);
        a(paramWorld, Blocks.DOUBLE_STEP, 0, 6, 1, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.DOUBLE_STEP, 0, 6, 1, 2, paramStructureBoundingBox);


        a(paramWorld, Blocks.AIR, 0, 2, 1, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 2, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.TORCH, 0, 2, 3, 1, paramStructureBoundingBox);
        a(paramWorld, paramStructureBoundingBox, paramRandom, 2, 1, 0, a(Blocks.WOODEN_DOOR, 1));
        if ((a(paramWorld, 2, 0, -1, paramStructureBoundingBox).getMaterial() == Material.AIR) && (a(paramWorld, 2, -1, -1, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
            a(paramWorld, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0, -1, paramStructureBoundingBox);
        }
        a(paramWorld, Blocks.AIR, 0, 6, 1, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 6, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.TORCH, 0, 6, 3, 4, paramStructureBoundingBox);
        a(paramWorld, paramStructureBoundingBox, paramRandom, 6, 1, 5, a(Blocks.WOODEN_DOOR, 1));
        for (k = 0; k < 5; k++) {
            for (m = 0; m < 9; m++) {
                b(paramWorld, m, 7, k, paramStructureBoundingBox);
                b(paramWorld, Blocks.COBBLESTONE, 0, m, -1, k, paramStructureBoundingBox);
            }
        }
        a(paramWorld, paramStructureBoundingBox, 4, 1, 2, 2);

        return true;
    }

    protected int b(int paramInt) {
        if (paramInt == 0) {
            return 4;
        }
        return 0;
    }
}
