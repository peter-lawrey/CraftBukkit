package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageLibrary
        extends WorldGenVillagePiece {
    public WorldGenVillageLibrary() {
    }

    public WorldGenVillageLibrary(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
    }

    public static WorldGenVillageLibrary a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 9, 9, 6, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageLibrary(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    public boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        if (this.k < 0) {
            this.k = b(paramWorld, paramStructureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 9 - 1, 0);
        }
        a(paramWorld, paramStructureBoundingBox, 1, 1, 1, 7, 5, 4, Blocks.AIR, Blocks.AIR, false);


        a(paramWorld, paramStructureBoundingBox, 0, 0, 0, 8, 0, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(paramWorld, paramStructureBoundingBox, 0, 5, 0, 8, 5, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 0, 6, 1, 8, 6, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 0, 7, 2, 8, 7, 3, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        int i = a(Blocks.WOOD_STAIRS, 3);
        int j = a(Blocks.WOOD_STAIRS, 2);
        for (int k = -1; k <= 2; k++) {
            for (int m = 0; m <= 8; m++) {
                a(paramWorld, Blocks.WOOD_STAIRS, i, m, 6 + k, k, paramStructureBoundingBox);
                a(paramWorld, Blocks.WOOD_STAIRS, j, m, 6 + k, 5 - k, paramStructureBoundingBox);
            }
        }
        a(paramWorld, paramStructureBoundingBox, 0, 1, 0, 0, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 1, 1, 5, 8, 1, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 8, 1, 0, 8, 1, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 2, 1, 0, 7, 1, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 0, 2, 0, 0, 4, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 0, 2, 5, 0, 4, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 8, 2, 5, 8, 4, 5, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(paramWorld, paramStructureBoundingBox, 8, 2, 0, 8, 4, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);


        a(paramWorld, paramStructureBoundingBox, 0, 2, 1, 0, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 2, 5, 7, 4, 5, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 8, 2, 1, 8, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 2, 0, 7, 4, 0, Blocks.WOOD, Blocks.WOOD, false);


        a(paramWorld, Blocks.THIN_GLASS, 0, 4, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 5, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 6, 2, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 4, 3, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 5, 3, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 6, 3, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 2, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 3, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 0, 3, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 3, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 8, 3, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 2, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 3, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 5, 2, 5, paramStructureBoundingBox);
        a(paramWorld, Blocks.THIN_GLASS, 0, 6, 2, 5, paramStructureBoundingBox);


        a(paramWorld, paramStructureBoundingBox, 1, 4, 1, 7, 4, 1, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 4, 4, 7, 4, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(paramWorld, paramStructureBoundingBox, 1, 3, 4, 7, 3, 4, Blocks.BOOKSHELF, Blocks.BOOKSHELF, false);


        a(paramWorld, Blocks.WOOD, 0, 7, 1, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, a(Blocks.WOOD_STAIRS, 0), 7, 1, 3, paramStructureBoundingBox);
        k = a(Blocks.WOOD_STAIRS, 3);
        a(paramWorld, Blocks.WOOD_STAIRS, k, 6, 1, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, k, 5, 1, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, k, 4, 1, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_STAIRS, k, 3, 1, 4, paramStructureBoundingBox);


        a(paramWorld, Blocks.FENCE, 0, 6, 1, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_PLATE, 0, 6, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 4, 1, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WOOD_PLATE, 0, 4, 2, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.WORKBENCH, 0, 7, 1, 1, paramStructureBoundingBox);


        a(paramWorld, Blocks.AIR, 0, 1, 1, 0, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 1, 2, 0, paramStructureBoundingBox);
        a(paramWorld, paramStructureBoundingBox, paramRandom, 1, 1, 0, a(Blocks.WOODEN_DOOR, 1));
        if ((a(paramWorld, 1, 0, -1, paramStructureBoundingBox).getMaterial() == Material.AIR) && (a(paramWorld, 1, -1, -1, paramStructureBoundingBox).getMaterial() != Material.AIR)) {
            a(paramWorld, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 1, 0, -1, paramStructureBoundingBox);
        }
        for (int m = 0; m < 6; m++) {
            for (int n = 0; n < 9; n++) {
                b(paramWorld, n, 9, m, paramStructureBoundingBox);
                b(paramWorld, Blocks.COBBLESTONE, 0, n, -1, m, paramStructureBoundingBox);
            }
        }
        a(paramWorld, paramStructureBoundingBox, 2, 1, 2, 1);

        return true;
    }

    protected int b(int paramInt) {
        return 1;
    }
}
