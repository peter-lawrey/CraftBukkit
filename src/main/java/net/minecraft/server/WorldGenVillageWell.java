package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageWell
        extends WorldGenVillagePiece {
    public WorldGenVillageWell() {
    }

    public WorldGenVillageWell(WorldGenVillageStartPiece sp, int paramInt1, Random rand, int x, int z) {
        super(sp, paramInt1);

        this.g = rand.nextInt(4);
        switch (this.g) {
            case 0:
            case 2:
                this.f = new StructureBoundingBox(x, 64, z, x + 6 - 1, 78, z + 6 - 1);
                break;
            default:
                this.f = new StructureBoundingBox(x, 64, z, x + 6 - 1, 78, z + 6 - 1);
        }
    }

    public void a(StructurePiece sp, List paramList, Random random) {
        WorldGenVillagePieces.b((WorldGenVillageStartPiece) sp, paramList, random, this.f.a - 1, this.f.e - 4, this.f.c + 1, 1, d());
        WorldGenVillagePieces.b((WorldGenVillageStartPiece) sp, paramList, random, this.f.d + 1, this.f.e - 4, this.f.c + 1, 3, d());
        WorldGenVillagePieces.b((WorldGenVillageStartPiece) sp, paramList, random, this.f.a + 1, this.f.e - 4, this.f.c - 1, 2, d());
        WorldGenVillagePieces.b((WorldGenVillageStartPiece) sp, paramList, random, this.f.a + 1, this.f.e - 4, this.f.f + 1, 0, d());
    }

    public boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        if (this.k < 0) {
            this.k = b(paramWorld, paramStructureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 3, 0);
        }
        a(paramWorld, paramStructureBoundingBox, 1, 0, 1, 4, 12, 4, Blocks.COBBLESTONE, Blocks.WATER, false);
        a(paramWorld, Blocks.AIR, 0, 2, 12, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 3, 12, 2, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 2, 12, 3, paramStructureBoundingBox);
        a(paramWorld, Blocks.AIR, 0, 3, 12, 3, paramStructureBoundingBox);

        a(paramWorld, Blocks.FENCE, 0, 1, 13, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 1, 14, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 4, 13, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 4, 14, 1, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 1, 13, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 1, 14, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 4, 13, 4, paramStructureBoundingBox);
        a(paramWorld, Blocks.FENCE, 0, 4, 14, 4, paramStructureBoundingBox);
        a(paramWorld, paramStructureBoundingBox, 1, 15, 1, 4, 15, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        for (int x = 0; x <= 5; x++) {
            for (int z = 0; z <= 5; z++) {
                if ((z == 0) || (z == 5) || (x == 0) || (x == 5)) {
                    a(paramWorld, Blocks.GRAVEL, 0, z, 11, x, paramStructureBoundingBox);
                    b(paramWorld, z, 12, x, paramStructureBoundingBox);
                }
            }
        }
        return true;
    }
}
