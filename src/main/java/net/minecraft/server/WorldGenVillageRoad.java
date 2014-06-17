package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageRoad
        extends WorldGenVillageRoadPiece {
    private int a;

    public WorldGenVillageRoad() {
    }

    public WorldGenVillageRoad(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
        this.a = Math.max(paramStructureBoundingBox.b(), paramStructureBoundingBox.d());
    }

    public static StructureBoundingBox a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        int i = 7 * MathHelper.nextInt(paramRandom, 3, 5);
        while (i >= 7) {
            StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 3, 3, i, paramInt4);
            if (StructurePiece.a(paramList, localStructureBoundingBox) == null) {
                return localStructureBoundingBox;
            }
            i -= 7;
        }
        return null;
    }

    protected void a(NBTTagCompound paramNBTTagCompound) {
        super.a(paramNBTTagCompound);
        paramNBTTagCompound.setInt("Length", this.a);
    }

    protected void b(NBTTagCompound paramNBTTagCompound) {
        super.b(paramNBTTagCompound);
        this.a = paramNBTTagCompound.getInt("Length");
    }

    public void a(StructurePiece paramStructurePiece, List paramList, Random paramRandom) {
        int i = 0;


        int j = paramRandom.nextInt(5);
        StructurePiece localStructurePiece;
        while (j < this.a - 8) {
            localStructurePiece = a((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, 0, j);
            if (localStructurePiece != null) {
                j += Math.max(localStructurePiece.f.b(), localStructurePiece.f.d());
                i = 1;
            }
            j += 2 + paramRandom.nextInt(5);
        }
        j = paramRandom.nextInt(5);
        while (j < this.a - 8) {
            localStructurePiece = b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, 0, j);
            if (localStructurePiece != null) {
                j += Math.max(localStructurePiece.f.b(), localStructurePiece.f.d());
                i = 1;
            }
            j += 2 + paramRandom.nextInt(5);
        }
        if ((i != 0) && (paramRandom.nextInt(3) > 0)) {
            switch (this.g) {
                case 2:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.a - 1, this.f.b, this.f.c, 1, d());
                    break;
                case 0:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.a - 1, this.f.b, this.f.f - 2, 1, d());
                    break;
                case 3:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.d - 2, this.f.b, this.f.c - 1, 2, d());
                    break;
                case 1:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.a, this.f.b, this.f.c - 1, 2, d());
            }
        }
        if ((i != 0) && (paramRandom.nextInt(3) > 0)) {
            switch (this.g) {
                case 2:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.d + 1, this.f.b, this.f.c, 3, d());
                    break;
                case 0:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.d + 1, this.f.b, this.f.f - 2, 3, d());
                    break;
                case 3:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.d - 2, this.f.b, this.f.f + 1, 0, d());
                    break;
                case 1:
                    WorldGenVillagePieces.b((WorldGenVillageStartPiece) paramStructurePiece, paramList, paramRandom, this.f.a, this.f.b, this.f.f + 1, 0, d());
            }
        }
    }

    public boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        Block localBlock = b(Blocks.GRAVEL, 0);
        for (int i = this.f.a; i <= this.f.d; i++) {
            for (int j = this.f.c; j <= this.f.f; j++) {
                if (paramStructureBoundingBox.b(i, 64, j)) {
                    int k = paramWorld.i(i, j) - 1;
                    paramWorld.setTypeAndData(i, k, j, localBlock, 0, 2);
                }
            }
        }
        return true;
    }
}
