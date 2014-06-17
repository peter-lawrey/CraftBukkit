package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageHut
        extends WorldGenVillagePiece {
    private boolean a;
    private int b;

    public WorldGenVillageHut() {
    }

    public WorldGenVillageHut(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
        this.a = paramRandom.nextBoolean();
        this.b = paramRandom.nextInt(3);
    }

    public static WorldGenVillageHut a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 4, 6, 5, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageHut(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    protected void a(NBTTagCompound paramNBTTagCompound) {
        super.a(paramNBTTagCompound);
        paramNBTTagCompound.setInt("T", this.b);
        paramNBTTagCompound.setBoolean("C", this.a);
    }

    protected void b(NBTTagCompound paramNBTTagCompound) {
        super.b(paramNBTTagCompound);
        this.b = paramNBTTagCompound.getInt("T");
        this.a = paramNBTTagCompound.getBoolean("C");
    }

    public boolean a(World world, Random rand, StructureBoundingBox box) {
        if (this.k < 0) {
            this.k = b(world, box);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 6 - 1, 0);
        }
        a(world, box, -1, 1, -1, -1, 6, -1, Blocks.ICE, Blocks.ICE, false);

        a(world, box, 1, 1, 1, 3, 5, 4, Blocks.AIR, Blocks.AIR, false);


        a(world, box, 0, 0, 0, 3, 0, 4, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(world, box, 1, 0, 1, 2, 0, 3, Blocks.DIRT, Blocks.DIRT, false);
        if (this.a) {
            a(world, box, 1, 4, 1, 2, 4, 3, Blocks.LOG, Blocks.LOG, false);
        } else {
            a(world, box, 1, 5, 1, 2, 5, 3, Blocks.LOG, Blocks.LOG, false);
        }
        a(world, Blocks.LOG, 0, 1, 4, 0, box);
        a(world, Blocks.LOG, 0, 2, 4, 0, box);
        a(world, Blocks.LOG, 0, 1, 4, 4, box);
        a(world, Blocks.LOG, 0, 2, 4, 4, box);
        a(world, Blocks.LOG, 0, 0, 4, 1, box);
        a(world, Blocks.LOG, 0, 0, 4, 2, box);
        a(world, Blocks.LOG, 0, 0, 4, 3, box);
        a(world, Blocks.LOG, 0, 3, 4, 1, box);
        a(world, Blocks.LOG, 0, 3, 4, 2, box);
        a(world, Blocks.LOG, 0, 3, 4, 3, box);


        a(world, box, 0, 1, 0, 0, 3, 0, Blocks.LOG, Blocks.LOG, false);
        a(world, box, 3, 1, 0, 3, 3, 0, Blocks.LOG, Blocks.LOG, false);
        a(world, box, 0, 1, 4, 0, 3, 4, Blocks.LOG, Blocks.LOG, false);
        a(world, box, 3, 1, 4, 3, 3, 4, Blocks.LOG, Blocks.LOG, false);


        a(world, box, 0, 1, 1, 0, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 3, 1, 1, 3, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 1, 1, 0, 2, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 1, 1, 4, 2, 3, 4, Blocks.WOOD, Blocks.WOOD, false);


        a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 3, 2, 2, box);
        if (this.b > 0) {
            a(world, Blocks.FENCE, 0, this.b, 1, 3, box);
            a(world, Blocks.WOOD_PLATE, 0, this.b, 2, 3, box);
        }
        a(world, Blocks.AIR, 0, 1, 1, 0, box);
        a(world, Blocks.AIR, 0, 1, 2, 0, box);
        a(world, box, rand, 1, 1, 0, a(Blocks.WOODEN_DOOR, 1));
        if ((a(world, 1, 0, -1, box).getMaterial() == Material.AIR) && (a(world, 1, -1, -1, box).getMaterial() != Material.AIR)) {
            a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), 1, 0, -1, box);
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                b(world, j, 6, i, box);
                b(world, Blocks.COBBLESTONE, 0, j, -1, i, box);
            }
        }
        {
            // tunnel
            a(world, box, 2, 14 - k, 2, 2, 0, 2, Blocks.AIR, Blocks.AIR, false);
            // mine room
            a(world, box, 0, 10 - k, 0, 3, 14 - k, 4, Blocks.AIR, Blocks.AIR, false);
            a(world, Blocks.TRAP_DOOR, 0, 2, 1, 2, box);
            int o = a(Blocks.LADDER, 4);
            for (int y = 10 - k; y <= 0; y++)
                a(world, Blocks.LADDER, o, 2, y, 2, box);
            a(world, Blocks.TORCH, o, 0, 12 - k, 0, box);
            a(world, Blocks.TORCH, o, 2, 3, 2, box);
        }
        a(world, Blocks.LOG, 0, 2, 1, 2, box);
        a(world, box, 1, 1, 2, 1);

        return true;
    }
}
