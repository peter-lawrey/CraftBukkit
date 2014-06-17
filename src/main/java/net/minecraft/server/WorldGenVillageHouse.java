package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageHouse
        extends WorldGenVillagePiece {
    private boolean a;

    public WorldGenVillageHouse() {
    }

    public WorldGenVillageHouse(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
        this.a = paramRandom.nextBoolean();
    }

    public static WorldGenVillageHouse a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 5, 6, 5, paramInt4);
        if (StructurePiece.a(paramList, localStructureBoundingBox) != null) {
            return null;
        }
        return new WorldGenVillageHouse(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    protected void a(NBTTagCompound paramNBTTagCompound) {
        super.a(paramNBTTagCompound);
        paramNBTTagCompound.setBoolean("Terrace", this.a);
    }

    protected void b(NBTTagCompound paramNBTTagCompound) {
        super.b(paramNBTTagCompound);
        this.a = paramNBTTagCompound.getBoolean("Terrace");
    }

    public boolean a(World world, Random paramRandom, StructureBoundingBox box) {
        if (this.k < 0) {
            this.k = b(world, box);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 6 - 1, 0);
        }
        a(world, box, 0, 0, 0, 4, 0, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);

        a(world, box, 0, 4, 0, 4, 4, 4, Blocks.LOG, Blocks.LOG, false);
        a(world, box, 1, 4, 1, 3, 4, 3, Blocks.WOOD, Blocks.WOOD, false);


        a(world, Blocks.COBBLESTONE, 0, 0, 1, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 0, 2, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 0, 3, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 1, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 2, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 3, 0, box);
        a(world, Blocks.COBBLESTONE, 0, 0, 1, 4, box);
        a(world, Blocks.COBBLESTONE, 0, 0, 2, 4, box);
        a(world, Blocks.COBBLESTONE, 0, 0, 3, 4, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 1, 4, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 2, 4, box);
        a(world, Blocks.COBBLESTONE, 0, 4, 3, 4, box);
        a(world, box, 0, 1, 1, 0, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 4, 1, 1, 4, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 1, 1, 4, 3, 3, 4, Blocks.WOOD, Blocks.WOOD, false);
        a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 2, 4, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 2, 2, box);


        a(world, Blocks.WOOD, 0, 1, 1, 0, box);
        a(world, Blocks.WOOD, 0, 1, 2, 0, box);
        a(world, Blocks.WOOD, 0, 1, 3, 0, box);
        a(world, Blocks.WOOD, 0, 2, 3, 0, box);
        a(world, Blocks.WOOD, 0, 3, 3, 0, box);
        a(world, Blocks.WOOD, 0, 3, 2, 0, box);
        a(world, Blocks.WOOD, 0, 3, 1, 0, box);
        if ((a(world, 2, 0, -1, box).getMaterial() == Material.AIR) && (a(world, 2, -1, -1, box).getMaterial() != Material.AIR)) {
            a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0, -1, box);
        }
        a(world, box, 1, 1, 1, 3, 3, 3, Blocks.AIR, Blocks.AIR, false);
        if (this.a) {
            a(world, Blocks.FENCE, 0, 0, 5, 0, box);
            a(world, Blocks.FENCE, 0, 1, 5, 0, box);
            a(world, Blocks.FENCE, 0, 2, 5, 0, box);
            a(world, Blocks.FENCE, 0, 3, 5, 0, box);
            a(world, Blocks.FENCE, 0, 4, 5, 0, box);
            a(world, Blocks.FENCE, 0, 0, 5, 4, box);
            a(world, Blocks.FENCE, 0, 1, 5, 4, box);
            a(world, Blocks.FENCE, 0, 2, 5, 4, box);
            a(world, Blocks.FENCE, 0, 3, 5, 4, box);
            a(world, Blocks.FENCE, 0, 4, 5, 4, box);
            a(world, Blocks.FENCE, 0, 4, 5, 1, box);
            a(world, Blocks.FENCE, 0, 4, 5, 2, box);
            a(world, Blocks.FENCE, 0, 4, 5, 3, box);
            a(world, Blocks.FENCE, 0, 0, 5, 1, box);
            a(world, Blocks.FENCE, 0, 0, 5, 2, box);
            a(world, Blocks.FENCE, 0, 0, 5, 3, box);
        }
        if (this.a) {
            int i = a(Blocks.LADDER, 3);
            a(world, Blocks.LADDER, i, 3, 1, 3, box);
            a(world, Blocks.LADDER, i, 3, 2, 3, box);
            a(world, Blocks.LADDER, i, 3, 3, 3, box);
            a(world, Blocks.LADDER, i, 3, 4, 3, box);
        }
        a(world, Blocks.TORCH, 0, 2, 3, 1, box);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                b(world, j, 6, i, box);
                b(world, Blocks.COBBLESTONE, 0, j, -1, i, box);
            }
        }
        a(world, box, 1, 1, 2, 1);

        return true;
    }
}
