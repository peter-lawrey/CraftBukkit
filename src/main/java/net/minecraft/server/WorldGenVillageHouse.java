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
        a(world, Blocks.GLOWSTONE, 0, 0, 10, 0, box);
        // floor
        a(world, box, 0, 0, 0, 4, 4, 4, Blocks.WOOD, Blocks.COBBLESTONE, false);

        // roof outer
        a(world, box, 0, 4, 0, 4, 4, 4, Blocks.WOOD, Blocks.LOG, false);

        // three walls
        a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 2, 4, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 2, 2, box);

        // around the door.
        a(world, Blocks.AIR, 0, 2, 1, 0, box);
        a(world, Blocks.AIR, 0, 2, 2, 0, box);

        // add stairs the the front.
        for (int s = 0; s < k - 10; s++) {
            if (a(world, 2, 0 - s, -1 - s, box).getMaterial() != Material.AIR) {
                break;
            }
            a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 2, 0 - s, -1 - s, box);
        }
        a(world, box, 1, 1, 1, 3, 3, 3, Blocks.AIR, Blocks.AIR, false);
        // fence around the top.
        a = true;
        if (this.a) {
            for (int x = 0; x <= 4; x++)
                for (int z = 0; z <= 4; z++)
                    if (x == 0 || z == 0 || x == 4 || z == 4)
                        a(world, Blocks.FENCE, 0, x, 5, z, box);
        }
        if (this.a) {
            int i = a(Blocks.LADDER, 3);
            for (int j = 1; j <= 4; j++)
                a(world, Blocks.LADDER, i, 3, j, 3, box);
        }
        a(world, Blocks.TORCH, 0, 2, 3, 1, box);
        a(world, Blocks.TORCH, 0, 1, 3, -1, box);
        a(world, Blocks.TORCH, 0, 3, 3, -1, box);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                b(world, j, 6, i, box);
                b(world, Blocks.COBBLESTONE, 0, j, -1, i, box);
            }
        }
        addStairs(world, box);
        a(world, box, 1, 1, 2, 1);

        return true;
    }
}
