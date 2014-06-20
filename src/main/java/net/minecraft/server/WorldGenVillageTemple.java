package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageTemple
        extends WorldGenVillagePiece {
    public WorldGenVillageTemple() {
    }

    public WorldGenVillageTemple(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
    }

    public static WorldGenVillageTemple a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 5, 12, 9, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageTemple(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    public boolean a(World world, Random rand, StructureBoundingBox box) {
        if (this.k < 0) {
            this.k = b(world, box);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 12 - 1, 0);
        }
        // basement
        a(world, box, 1, -5, 1, 3, -1, 7, Blocks.AIR, Blocks.AIR, false);

        a(world, box, 1, 1, 1, 3, 3, 7, Blocks.AIR, Blocks.AIR, false);
        a(world, box, 1, 5, 1, 3, 9, 3, Blocks.AIR, Blocks.AIR, false);


        a(world, box, 1, 0, 0, 3, 0, 8, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);


        a(world, box, 1, 1, 0, 3, 10, 0, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 0, 1, 1, 0, 10, 3, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 4, 1, 1, 4, 10, 3, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 0, 0, 4, 0, 4, 7, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 4, 0, 4, 4, 4, 7, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 1, 1, 8, 3, 4, 8, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 1, 5, 4, 3, 10, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);


        a(world, box, 1, 5, 5, 3, 5, 7, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 0, 9, 0, 4, 9, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 0, 4, 0, 4, 4, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(world, Blocks.COBBLESTONE, 0, 0, 11, 2, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 11, 2, box);
        a(world, Blocks.COBBLESTONE, 0, 2, 11, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 2, 11, 4, box);
        a(world, Blocks.TORCH, 0, 0, 12, 2, box);
        a(world, Blocks.TORCH, 0, 4, 12, 2, box);
        a(world, Blocks.TORCH, 0, 2, 12, 0, box);
        a(world, Blocks.TORCH, 0, 2, 12, 4, box);

        a(world, Blocks.COBBLESTONE, 0, 1, 1, 6, box);
        a(world, Blocks.COBBLESTONE, 0, 1, 1, 7, box);
        a(world, Blocks.COBBLESTONE, 0, 2, 1, 7, box);
        a(world, Blocks.COBBLESTONE, 0, 3, 1, 6, box);
        a(world, Blocks.COBBLESTONE, 0, 3, 1, 7, box);
        a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 1, 1, 5, box);
        a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 2, 1, 6, box);
        a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 3, 1, 5, box);
        a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 1), 1, 2, 7, box);
        a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 0), 3, 2, 7, box);

        a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 0, 3, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 2, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 3, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 0, 6, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 0, 7, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 6, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 7, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 6, 0, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 7, 0, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 6, 4, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 7, 4, box);
        a(world, Blocks.THIN_GLASS, 0, 0, 3, 6, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 3, 6, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 3, 8, box);

        a(world, Blocks.TORCH, 0, 2, 4, 7, box);
        a(world, Blocks.TORCH, 0, 1, 4, 6, box);
        a(world, Blocks.TORCH, 0, 3, 4, 6, box);
        a(world, Blocks.TORCH, 0, 2, 4, 5, box);


        int o = a(Blocks.LADDER, 4);
        for (int y = -5; y <= 9; y++) {
            a(world, Blocks.LADDER, o, 3, y, 3, box);
        }
        a(world, Blocks.AIR, 0, 2, 1, 0, box);
        a(world, Blocks.AIR, 0, 2, 2, 0, box);
        a(world, box, rand, 2, 1, 0, a(Blocks.WOODEN_DOOR, 1));

        for (int j = 0; j < 9; j++) {
            for (int k = 0; k < 5; k++) {
                b(world, k, 12, j, box);
                b(world, Blocks.COBBLESTONE, 0, k, -1, j, box);
            }
        }
        addStairs(world, box);

        a(world, box, 2, 1, 2, 1);

        return true;
    }

    protected int b(int paramInt) {
        return 2;
    }
}
