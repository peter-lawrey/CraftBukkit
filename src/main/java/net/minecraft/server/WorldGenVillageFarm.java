package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageFarm
        extends WorldGenVillagePiece {
    private Block a;
    private Block b;

    public WorldGenVillageFarm() {
    }

    public WorldGenVillageFarm(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;

        this.a = a(paramRandom);
        this.b = a(paramRandom);
    }

    public static WorldGenVillageFarm a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 7, 4, 9, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageFarm(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    protected void a(NBTTagCompound paramNBTTagCompound) {
        super.a(paramNBTTagCompound);
        paramNBTTagCompound.setInt("CA", Block.REGISTRY.b(this.a));
        paramNBTTagCompound.setInt("CB", Block.REGISTRY.b(this.b));
    }

    protected void b(NBTTagCompound paramNBTTagCompound) {
        super.b(paramNBTTagCompound);
        this.a = Block.e(paramNBTTagCompound.getInt("CA"));
        this.b = Block.e(paramNBTTagCompound.getInt("CB"));
    }

    private Block a(Random paramRandom) {
        switch (paramRandom.nextInt(5)) {
            case 0:
                return Blocks.CARROTS;
            case 1:
                return Blocks.POTATOES;
        }
        return Blocks.CROPS;
    }

    public boolean a(World paramWorld, Random paramRandom, StructureBoundingBox paramStructureBoundingBox) {
        if (this.k < 0) {
            this.k = b(paramWorld, paramStructureBoundingBox);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 4 - 1, 0);
        }
        a(paramWorld, paramStructureBoundingBox, 0, 1, 0, 6, 4, 8, Blocks.AIR, Blocks.AIR, false);


        a(paramWorld, paramStructureBoundingBox, 1, 0, 1, 2, 0, 7, Blocks.SOIL, Blocks.SOIL, false);
        a(paramWorld, paramStructureBoundingBox, 4, 0, 1, 5, 0, 7, Blocks.SOIL, Blocks.SOIL, false);

        a(paramWorld, paramStructureBoundingBox, 0, 0, 0, 0, 0, 8, Blocks.LOG, Blocks.LOG, false);
        a(paramWorld, paramStructureBoundingBox, 6, 0, 0, 6, 0, 8, Blocks.LOG, Blocks.LOG, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 0, 5, 0, 0, Blocks.LOG, Blocks.LOG, false);
        a(paramWorld, paramStructureBoundingBox, 1, 0, 8, 5, 0, 8, Blocks.LOG, Blocks.LOG, false);

        a(paramWorld, paramStructureBoundingBox, 3, 0, 1, 3, 0, 7, Blocks.STATIONARY_WATER, Blocks.STATIONARY_WATER, false);
        for (int i = 1; i <= 7; i++) {
            a(paramWorld, this.a, MathHelper.nextInt(paramRandom, 2, 7), 1, 1, i, paramStructureBoundingBox);
            a(paramWorld, this.a, MathHelper.nextInt(paramRandom, 2, 7), 2, 1, i, paramStructureBoundingBox);
            a(paramWorld, this.b, MathHelper.nextInt(paramRandom, 2, 7), 4, 1, i, paramStructureBoundingBox);
            a(paramWorld, this.b, MathHelper.nextInt(paramRandom, 2, 7), 5, 1, i, paramStructureBoundingBox);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 7; j++) {
                b(paramWorld, j, 4, i, paramStructureBoundingBox);
                b(paramWorld, Blocks.DIRT, 0, j, -1, i, paramStructureBoundingBox);
            }
        }
        return true;
    }
}
