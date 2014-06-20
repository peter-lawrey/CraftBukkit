package net.minecraft.server;

import java.util.List;
import java.util.Random;

public class WorldGenVillageBlacksmith
        extends WorldGenVillagePiece {
    private static final StructurePieceTreasure[] a = {
            new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 3),
            new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10),
            new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 5),
            new StructurePieceTreasure(Items.BREAD, 0, 1, 3, 15),
            new StructurePieceTreasure(Items.APPLE, 0, 1, 3, 15),
            new StructurePieceTreasure(Items.IRON_PICKAXE, 0, 1, 1, 5),
            new StructurePieceTreasure(Items.IRON_SWORD, 0, 1, 1, 5),
            new StructurePieceTreasure(Items.IRON_CHESTPLATE, 0, 1, 1, 5),
            new StructurePieceTreasure(Items.IRON_HELMET, 0, 1, 1, 5),
            new StructurePieceTreasure(Items.IRON_LEGGINGS, 0, 1, 1, 5),
            new StructurePieceTreasure(Items.IRON_BOOTS, 0, 1, 1, 5),
            new StructurePieceTreasure(Item.getItemOf(Blocks.OBSIDIAN), 0, 3, 7, 5),
            new StructurePieceTreasure(Item.getItemOf(Blocks.SAPLING), 0, 3, 7, 5),
            new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3),
            new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 1),
            new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 1),
            new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 1)};
    private boolean b;

    public WorldGenVillageBlacksmith() {
    }

    public WorldGenVillageBlacksmith(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, int paramInt1, Random paramRandom, StructureBoundingBox paramStructureBoundingBox, int paramInt2) {
        super(paramWorldGenVillageStartPiece, paramInt1);

        this.g = paramInt2;
        this.f = paramStructureBoundingBox;
    }

    public static WorldGenVillageBlacksmith a(WorldGenVillageStartPiece paramWorldGenVillageStartPiece, List paramList, Random paramRandom, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
        StructureBoundingBox localStructureBoundingBox = StructureBoundingBox.a(paramInt1, paramInt2, paramInt3, 0, 0, 0, 10, 6, 7, paramInt4);
        if ((!a(localStructureBoundingBox)) || (StructurePiece.a(paramList, localStructureBoundingBox) != null)) {
            return null;
        }
        return new WorldGenVillageBlacksmith(paramWorldGenVillageStartPiece, paramInt5, paramRandom, localStructureBoundingBox, paramInt4);
    }

    protected void a(NBTTagCompound paramNBTTagCompound) {
        super.a(paramNBTTagCompound);
        paramNBTTagCompound.setBoolean("Chest", this.b);
    }

    protected void b(NBTTagCompound paramNBTTagCompound) {
        super.b(paramNBTTagCompound);
        this.b = paramNBTTagCompound.getBoolean("Chest");
    }

    public boolean a(World world, Random paramRandom, StructureBoundingBox box) {
        if (this.k < 0) {
            this.k = b(world, box);
            if (this.k < 0) {
                return true;
            }
            this.f.a(0, this.k - this.f.e + 6 - 1, 0);
        }
        a(world, box, 0, 1, 0, 9, 4, 6, Blocks.AIR, Blocks.AIR, false);


        a(world, box, 0, 0, 0, 9, 0, 6, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);


        a(world, box, 0, 4, 0, 9, 4, 6, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(world, box, 0, 5, 0, 9, 5, 6, Blocks.STEP, Blocks.STEP, false);
        a(world, box, 1, 5, 1, 8, 5, 5, Blocks.AIR, Blocks.AIR, false);


        a(world, box, 1, 1, 0, 2, 3, 0, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 0, 1, 0, 0, 4, 0, Blocks.LOG, Blocks.LOG, false);
        a(world, box, 3, 1, 0, 3, 4, 0, Blocks.LOG, Blocks.LOG, false);
        a(world, box, 0, 1, 6, 0, 4, 6, Blocks.LOG, Blocks.LOG, false);
        a(world, Blocks.WOOD, 0, 3, 3, 1, box);
        a(world, box, 3, 1, 2, 3, 3, 2, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 4, 1, 3, 5, 3, 3, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 0, 1, 1, 0, 3, 5, Blocks.WOOD, Blocks.WOOD, false);
        a(world, box, 1, 1, 6, 5, 3, 6, Blocks.WOOD, Blocks.WOOD, false);


        a(world, box, 5, 1, 0, 5, 3, 0, Blocks.FENCE, Blocks.FENCE, false);
        a(world, box, 9, 1, 0, 9, 3, 0, Blocks.FENCE, Blocks.FENCE, false);


        a(world, box, 6, 1, 4, 9, 4, 6, Blocks.COBBLESTONE, Blocks.COBBLESTONE, false);
        a(world, Blocks.LAVA, 0, 7, 1, 5, box);
        a(world, Blocks.LAVA, 0, 8, 1, 5, box);
        a(world, Blocks.IRON_FENCE, 0, 9, 2, 5, box);
        a(world, Blocks.IRON_FENCE, 0, 9, 2, 4, box);
        a(world, box, 7, 2, 4, 8, 2, 5, Blocks.AIR, Blocks.AIR, false);
        a(world, Blocks.COBBLESTONE, 0, 6, 1, 3, box);
        a(world, Blocks.FURNACE, 0, 6, 2, 3, box);
        a(world, Blocks.FURNACE, 0, 6, 3, 3, box);
        a(world, Blocks.DOUBLE_STEP, 0, 8, 1, 1, box);


        a(world, Blocks.THIN_GLASS, 0, 0, 2, 2, box);
        a(world, Blocks.THIN_GLASS, 0, 0, 2, 4, box);
        a(world, Blocks.THIN_GLASS, 0, 2, 2, 6, box);
        a(world, Blocks.THIN_GLASS, 0, 4, 2, 6, box);

        a(world, Blocks.TORCH, 0, 0, 3, 2, box);
        a(world, Blocks.TORCH, 0, 0, 3, 4, box);
        a(world, Blocks.TORCH, 0, 2, 3, 6, box);
        a(world, Blocks.TORCH, 0, 4, 3, 6, box);


        a(world, Blocks.FENCE, 0, 2, 1, 4, box);
        a(world, Blocks.WOOD_PLATE, 0, 2, 2, 4, box);
        a(world, Blocks.WOOD, 0, 1, 1, 5, box);
        a(world, Blocks.WOOD_STAIRS, a(Blocks.WOOD_STAIRS, 3), 2, 1, 5, box);
        a(world, Blocks.WOOD_STAIRS, a(Blocks.WOOD_STAIRS, 1), 1, 1, 4, box);
        int j;
        if (!this.b) {
            int i = a(1);
            j = a(5, 5);
            int k = b(5, 5);
            if (box.b(j, i, k)) {
                this.b = true;
                a(world, box, paramRandom, 5, 1, 5, a, 3 + paramRandom.nextInt(6));
            }
        }
        for (int i = 6; i <= 8; i++) {
            if ((a(world, i, 0, -1, box).getMaterial() == Material.AIR) && (a(world, i, -1, -1, box).getMaterial() != Material.AIR)) {
                a(world, Blocks.COBBLESTONE_STAIRS, a(Blocks.COBBLESTONE_STAIRS, 3), i, 0, -1, box);
            }
        }
        for (int i = 0; i < 7; i++) {
            for (j = 0; j < 10; j++) {
                b(world, j, 6, i, box);
                b(world, Blocks.COBBLESTONE, 0, j, -1, i, box);
            }
        }
        a(world, box, 7, 1, 1, 1);

        return true;
    }

    protected int b(int paramInt) {
        return 3;
    }
}
